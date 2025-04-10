import java.util.*;

public class CompareLauncher {

    private final LetterComporator comporator = new LetterComporator();

    public void init() {

        String[] words = getWord();
        Letter[] wordArr;
        String myWord;
        List<String> sentence = new ArrayList<>();

        for (String word : words) {
            wordArr = new Letter[word.length()];
            for (int i = 0; i < word.length(); i++) {
                wordArr[i] = new Letter(String.valueOf(word.charAt(i)));
            }
            myWord = findWord(wordArr);
            sentence.add(myWord);
        }


        System.out.print("Вы написали: ");
        for (String s : sentence) {
            System.out.print(s + " ");
        }
    }

    // Метод принимает символы с консоли и обоспечивает валидацию
    private String[] getWord() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите букву/слово на английском языке");
        String word = in.nextLine();
        if (!word.matches("[a-zA-Z ]+") || word.isBlank()) {
            do {
                System.out.println("Введите букву/слово на английском языке");
                word = in.nextLine();
            } while (!word.matches("[a-zA-Z ]+") || word.isBlank());
        }
        String[] words = word.split(" ");
        in.close();
        return words;
    }


    private String findWord(Letter[] word) {
        Letter l;
        StringBuilder stringWord = new StringBuilder();
        for (Letter let : word) {
            l = comporator.compareLetterWithAlphabet(let);
            stringWord.append(l.getFile().getName());
        }
        return stringWord.toString();
    }

}
