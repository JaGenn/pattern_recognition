package org.example.letter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LetterComporator {

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

        Alphabet alphabet = Alphabet.getInstance(); // Сингелтон

        for (Letter let : alphabet.getAlphabet()) {
            compareTwoLetters(letter, let);
        }

        int max = Collections.max(result.keySet());

        Letter foundLetter = result.get(max);
        result.clear();
        return foundLetter;
    }
}
