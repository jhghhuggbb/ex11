import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergedFileIO {

    public static void readGroceries() {
        String path = "C:\\Downloads\\Groceries.txt";
        BufferedReader reader = null;
        try {
            FileReader fileread = new FileReader(path);
            reader = new BufferedReader(fileread);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeAFile() {
        String writtenFile = "WriteAFileExample.txt";
        BufferedWriter writer = null;
        try {
            FileWriter filewrite = new FileWriter(writtenFile);
            writer = new BufferedWriter(filewrite);
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is a test.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void diaryWriter() {
        String diaryFile = "Diary.txt";
        BufferedWriter writer = null;
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter filewrite = new FileWriter(diaryFile);
            writer = new BufferedWriter(filewrite);
            while (true) {
                System.out.println("请输入内容（输入END或end结束）：");
                String input = scanner.nextLine();
                if ("END".equals(input) || "end".equals(input)) {
                    break;
                }
                writer.write(input);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }

    public static void formatGroceries() {
        String inputFile = "Groceries.txt";
        String outputFile = "FormattedGroceries.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            FileReader fileread = new FileReader(inputFile);
            reader = new BufferedReader(fileread);
            FileWriter filewrite = new FileWriter(outputFile);
            writer = new BufferedWriter(filewrite);
            writer.write("| ID | Item | Quantity(KG) | Price(€) |\n");
            writer.write("| --- | --- | --- | --- |\n");
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    writer.write(String.format("| %s | %s | %s | %s |\n", parts[0], parts[1], parts[2], parts[3]));
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        // readGroceries();
        // writeAFile();
        // diaryWriter();
        // formatGroceries();
    }
}    