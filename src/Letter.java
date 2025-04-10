import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Letter {


    private final String path = "untitled/text/";

    private final File file;


    public Letter(String fileName) {
        this.file = new File(path, fileName);
    }


    public File getFile() {
        return file;
    }



    public Character[][] getArrayFromFile(File file) {
        Character[][] array = new Character[18][18];
        for (int i = 0; i < 18; i++) {
            Arrays.fill(array[i], ' ');
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            int a;
            StringBuilder result = new StringBuilder();
            while ((a = reader.read()) != -1) {
                result.append((char) a);
            }


            String[] rows = result.toString().trim().split("\n"); // Разделяем на строки
            for (int i = 0; i < rows.length && i < 18; i++) {  // Заполняем строки
                String row = rows[i];
                for (int j = 0; j < row.length() && j < 18; j++) {  // Заполняем столбцы
                    array[i][j] = row.charAt(j);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return array;
    }

}
