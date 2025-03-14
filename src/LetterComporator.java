import java.util.HashMap;
import java.util.Map;

public class LetterComporator {

    private final Alphabet alphabet = new Alphabet();
    private final Map<Integer, Letter> result = new HashMap<>();


    public void compareTwoLetters(Letter firstLetter, Letter secondLetter) {


        Character[][] firstArr = firstLetter.getArrayFromFile(firstLetter.getFile());
        Character[][] secondArr = secondLetter.getArrayFromFile(secondLetter.getFile());

        int percent = 0;

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                if (firstArr[i][j] == secondArr[i][j]) {
                    percent++;
                }
            }
        }
        result.put(percent, secondLetter);
//        System.out.println("Буквы " + firstLetter.getFile().getName() + " и " + secondLetter.getFile().getName() + " совпали на " + ((percent > 200) ? 100 : percent) + "%");
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
        Letter foundLetter = result.get(max);
        result.clear();
        return foundLetter;
    }
}
