package test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Graphic {
    //Класс Graphic содержит методы для вывода графических элементов игры
    public static void updateWordDisplay(char[] guessedWord) {
        //Обновляет отображение слова на экране, показывая угаданные буквы
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void updateAlphabetDisplay(List<Character> alphabet) {
        //Обновляет отображение алфавита, отмечая уже использованные буквы.
        System.out.print("Алфавит: ");
        for (Character character : alphabet) {
            System.out.print(character + " "); // Вывод 'x' для замены
        }
        System.out.println(" ");
    }

    public static void indent() {
        //Выводит отступы для начала новой итерации игры
        System.out.println("\n".repeat(10));
    }

    public static void displayHangman(int lives) {
        //Отображает виселицу на основе текущего количества жизней
        if (lives == 7)
            System.out.println("\n".repeat(8));
        else {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + "/src/test1/hangman/hangman_" + lives;
            File file = new File(filePath);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Файл не найден: " + e.getMessage());
            }
        }
    }
}

