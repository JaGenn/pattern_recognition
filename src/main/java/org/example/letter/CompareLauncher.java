package org.example.letter;

import java.util.*;

public class CompareLauncher {

    private final LetterComporator comporator = new LetterComporator();

    public void init() {

        String[] consoleInputWords = getWordFromConsole();
        List<String> sentence = new ArrayList<>();

        for (String word : consoleInputWords) {
            Letter[] wordArr = new Letter[word.length()];
            for (int i = 0; i < word.length(); i++) {
                wordArr[i] = new Letter(String.valueOf(word.charAt(i)));
            }
            String collectedWord = collectAnswerWord(wordArr);
            sentence.add(collectedWord);
        }

        System.out.print("Вы написали: ");
        for (String s : sentence) {
            System.out.print(s + " ");
        }
    }

    // Метод принимает символы с консоли и обоспечивает валидацию
    private String[] getWordFromConsole() {
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

    // Метод собирает слова из массива букв и возвращает слово в виде строки
    private String collectAnswerWord(Letter[] word) {
        StringBuilder stringWord = new StringBuilder();
        for (Letter let : word) {
            Letter finalLetter = comporator.compareLetterWithAlphabet(let);
            stringWord.append(finalLetter.getFile().getName());
        }
        return stringWord.toString();
    }

}
