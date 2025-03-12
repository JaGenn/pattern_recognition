import java.util.*;

public class CompareLauncher {


    private static final Alphabet alphabet = new Alphabet();
    private static Map<Integer, Letter> result = new HashMap<>();


    public void compareTwoLetters(Letter firstLetter, Letter secondLetter) {


        Character[][] firstArr = firstLetter.getArrayFromFile(firstLetter.getFile());
        Character[][] secondArr = secondLetter.getArrayFromFile(secondLetter.getFile());

        int percent = 0;

//        int h = (firstLetter.getHeight() < secondLetter.getHeight()) ? firstLetter.getHeight() : secondLetter.getHeight();
//        int w = (firstLetter.getWidth() < secondLetter.getWidth()) ? firstLetter.getWidth() : secondLetter.getWidth();

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                if (firstArr[i][j] == secondArr[i][j]) {
                    percent++;
                }
            }
        }
        result.put(percent, secondLetter);
//        System.out.println("Буквы " + firstLetter.getFile().getName() + " и " + secondLetter.getFile().getName() + " совпали на " + percent + "%");
    }

    public Letter compareLetterWithAlphabet(Letter letter) {

        for (Letter let : alphabet.getAlphabet()) {
            compareTwoLetters(letter, let);
        }

        int max = 0;
        for (Integer key : result.keySet()) {
            if (key>max) {
                max = key;
            }
        }
        return result.get(max);
    }

    public String findWord(Letter[] word) {
        Letter l;
        StringBuilder stringWord = new StringBuilder();
        for (Letter let : word) {
            l = compareLetterWithAlphabet(let);
            stringWord.append(l.getFile().getName());
            result.clear();
        }
        return stringWord.toString();
    }

    private String[] getWord() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово на английском языке");
        String word = in.nextLine();
        if (!word.matches("[ a-zA-Z]+")) {
            do {
                System.out.println("Введите слово на английском языке");
                word = in.nextLine();
            } while (!word.matches("[ a-zA-Z]+"));
        }
        String[] words = word.split(" ");
        in.close();
        return words;
    }

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

}
