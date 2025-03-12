import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        CompareLauncher compareLauncher = new CompareLauncher();
        LetterComporator comporator = new LetterComporator();

        Letter firstLetter = new Letter("E");
        Letter secondLetter = new Letter("F");



        comporator.compareTwoLetters(firstLetter, secondLetter);

    compareLauncher.init();











    }


}
