import java.io.*;
import java.util.Scanner;

public class Letter {


    private final String path = "text/";

    private File file;

    private int width;

    private int height;

    private String fileName;

    public Letter(String fileName) {
        this.fileName = fileName;
        findBordersOfLetter(getFile());
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

    public String[] getArrayFromTextFile(File file, int width, int height) {
        String[] array = new String[width];
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            int a = reader.read();
            StringBuilder result = new StringBuilder();
            while (a > 0) {
                result.append((char) a);
                a = reader.read();
            }
            for (int i = 0; i<width; i++) {
                for (int j = 0; j<height; j++) {
                    array = result.toString().split("\n");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return array;
    }


}
