import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        dictionary.setWords(new Word("target", "цель"));
        dictionary.setWords(new Word("house", "дом"));
        dictionary.setWords(new Word("family", "семья"));
        dictionary.setWords(new Word("teacher", "учитель"));
        dictionary.setWords(new Word("school", "школа"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите слово (для выхода напишите 'Exit'): ");

        while (sc.hasNext()) {

            String word = sc.nextLine();
            word = word.toLowerCase().trim();

            if (word.equals("exit")) {
                break;
            }

            Pattern pattern = Pattern.compile("[a-zа-яA-ZА-Я]{0,20}", Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(word);

            if (matcher.matches()) {

                word = word.toLowerCase();

                char c = word.charAt(0);
                if (c >= 97 && c <= 122) {
                    word = dictionary.findWord(word, true);
                } else {
                    word = dictionary.findWord(word, false);
                }

                if (word != null) {
                    System.out.println(word);
                } else {
                    System.out.println("Нет такого слова в словаре.");
                }

                System.out.println("Введите новое слово (для выхода напишите 'Exit'): ");

            } else {
                System.out.println("Вы ввели не строку");
                System.out.println("Введите новое слово (для выхода напишите 'Exit'): ");
            }
        }
    }
}



