
public class Dictionary {

    private Word[] words = new Word[10];

    public void setWords(Word word) {

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                words[i] = word;
                break;
            }
        }
    }

    public String findWord(String word, boolean engWord) {

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                break; // end arrays
            }
            if (engWord) {
                if (words[i].getEngWord().equals(word)) {
                    return words[i].getRusWord();
                }
            } else {
                if (words[i].getRusWord().equals(word)) {
                    return words[i].getEngWord();
                }
            }
        }
        return null;
    }

}
