package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        // Đường dẫn tới file input và output
        String inputFilePath = "E://Desktop//ptit//term 7//LTM//CODE//File//input.txt";
        String outputFilePath = "E://Desktop//ptit//term 7//LTM//CODE//File//output.txt";

        // Sử dụng BufferedReader để đọc file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Ghi xuống dòng
            }

            System.out.println("File has been copied successfully!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
