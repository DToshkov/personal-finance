import java.io.FileReader;
import java.util.List;
import com.opencsv.*;

public class Retrieve {
    // Make sure you provide correct CSV file paths here
    private static final String CSV_FILE_PATH = "submissions.csv";
    private static final String CSV_FILE_CUSTOM_SEPARATOR = "/Users/dimitartosh/Documents/Grad School/CS415 Design Database Systems";

    public static void main(String[] args) {
        System.out.println("Read Data Line by Line With Header \n");
        readDataLineByLine(CSV_FILE_PATH);
        System.out.println("_______________________________________________");

        System.out.println("Read All Data at Once and Hide the Header also \n");
        readAllDataAtOnce(CSV_FILE_PATH);
        System.out.println("_______________________________________________");

        System.out.println("Custom Separator here semi-colon\n");
        readDataFromCustomSeparator(CSV_FILE_CUSTOM_SEPARATOR);
        System.out.println("_______________________________________________");
    }

    // Read data line by line with header
    public static void readDataLineByLine(String file) {
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read all data at once, skipping the first line (header)
    public static void readAllDataAtOnce(String file) {
        try {
            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                    .withSkipLines(1) // Skip first line (header)
                                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read data with a custom separator (semicolon)
    public static void readDataFromCustomSeparator(String file) {
        try {
            FileReader filereader = new FileReader(file);

            // Use CSVReaderBuilder with custom separator directly
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                    .withSeparator(';') // Set custom separator
                                    .build();

            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
