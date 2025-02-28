import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Letter {


    private final String path = "untitled/text/";

    private File file;

    private int width;

    private int height;

    private String fileName;

    public Letter(String fileName) {
        this.fileName = fileName;
//        findBordersOfLetter(getFile());
    }

    public File getFile() {
        return new File(path, fileName);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void findBordersOfLetter(File letterFile) {

        try (Scanner sc = new Scanner(letterFile)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    this.width = Math.max(this.width, line.length());
                    this.height++;
                }
            }

        } catch (RuntimeException | FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



//    public String[] getArrayFromTextFile(File file) {
//        String[] array = new String[width];
//        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
//            int a = reader.read();
//            StringBuilder result = new StringBuilder();
//            while (a > 0) {
//                result.append((char) a);
//                a = reader.read();
//            }
//            for (int i = 0; i<width; i++) {
//                for (int j = 0; j<height; j++) {
//                    array = result.toString().split("\n");
//                }
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return array;
//    }

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


            String[] rows = result.toString().split("\n"); // Разделяем на строки
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
