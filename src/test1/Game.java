package test1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    //Класс Game управляет игрой

    public static String word;
    public static char[] guessedWord;
    public static List<Character> alphabet;
    public static byte lives;
    public static Scanner scanner;

    public void createUser() {
        //Инициализирует игру, создает пользователя, устанавливает начальные значения
        Scanner scan = new Scanner(System.in);
        scanner = new Scanner(System.in);
        word = Storage.getWord();
        guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');
        alphabet = Storage.createAlphabet();
        lives = 7;
    }

    public void play() {
        //Запускает игровой цикл
        while (lives > 0) {
            System.out.println("Жизни: " + lives);
            Graphic.displayHangman(lives);
            Graphic.updateWordDisplay(guessedWord);
            Graphic.updateAlphabetDisplay(alphabet);
            char letter = 0;
            while (true) {
                System.out.print("Введите букву: ");
                letter = scanner.next().toLowerCase().charAt(0);
                if (alphabet.contains(letter)) {
                    int index = alphabet.indexOf(letter);
                    alphabet.set(index, 'x');
                    break;
                }
                else
                    System.out.println("Вы уже вводили эту букву, либо её не существует в данном алфавите.\nПопробуйте ещё раз!");
            }

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    guessedWord[i] = letter;
                    found = true;
                }
            }

            if (!found) {
                lives--;
                System.out.println("Неверно! Буквы нет в слове.");
            }

            if (String.valueOf(guessedWord).equals(word)) {
                System.out.println("Вы выиграли!");
                break;
            }
            if (lives == 0) {
                System.out.println("Попытки закончились! Правильное слово: " + word);
                Graphic.displayHangman(lives);
                break;
            }

            Graphic.indent();
        }
    }
}
