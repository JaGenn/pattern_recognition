public class CompareLauncher {

    public CompareLauncher() {

    }

    Alphabet alphabet = new Alphabet();


    public void compareTwoLetters(Letter firstLetter, Letter secondLetter) {

        String[] firstArr = firstLetter.getArrayFromTextFile(firstLetter.getFile(), firstLetter.getWidth(), firstLetter.getHeight());
        String[] secondArr = secondLetter.getArrayFromTextFile(secondLetter.getFile(), secondLetter.getWidth(), secondLetter.getHeight());

        int count = 0;

        int h = (firstLetter.getHeight() < secondLetter.getHeight()) ? firstLetter.getHeight() : secondLetter.getHeight();
        int w = (firstLetter.getWidth() < secondLetter.getWidth()) ? firstLetter.getWidth() : secondLetter.getWidth();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (firstArr[i].charAt(j) == secondArr[i].charAt(j)) {
                    count++;
                }
            }
        }

        System.out.println("Буквы " + firstLetter.getFile().getName() + " и " + secondLetter.getFile().getName() + " совпали на " + count + "%");
    }

    public void compareLetterWithAlphabet(Letter letter) {


        for (Letter let : alphabet.getAlphabet()) {
            compareTwoLetters(letter, let);
        }



    }

}
