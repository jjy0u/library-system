import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {

    public static void main(String[] args) throws IOException, CsvException {
        String csvFilePath = "src/main/resources/books_data.csv";
        String jsonFilePath = "src/main/resources/books_data.json";
        List<Map<String, String>> csvData = readCsvFile(csvFilePath);
        String jsonData = convertCsvToJson(csvData);
        writeJsonToFile(jsonData, jsonFilePath);
    }

    private static List<Map<String, String>> readCsvFile(String csvFilePath) throws IOException, CsvException {
        List<Map<String, String>> csvData = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        String[] headers = reader.readNext();
        String[] values;
        while ((values = reader.readNext()) != null) {
            Map<String, String> rowData = new LinkedHashMap<>();
            for (int i = 0; i < headers.length; i++) {
                rowData.put(headers[i], values[i]);
            }
            csvData.add(rowData);
        }
        reader.close();
        return csvData;
    }

    private static String convertCsvToJson(List<Map<String, String>> csvData) {
        JSONArray jsonArray = new JSONArray();
        for (Map<String, String> rowData : csvData) {
            JSONObject jsonObject = new JSONObject();
            for (String key : rowData.keySet()) {
                jsonObject.put(key, rowData.get(key));
            }
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }
    private static void writeJsonToFile(String jsonData, String jsonFilePath) throws IOException {
        FileWriter fileWriter = new FileWriter(jsonFilePath);
        fileWriter.write(jsonData);
        fileWriter.close();
    }
}

