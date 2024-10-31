package test3;

import java.util.Scanner;

public class Main {
    //Класс Main запускает генератор
    public static void main(String[] args) {
        //Основной метод, обрабатывает вводимые данные
        Scanner scanner = new Scanner(System.in);
        Generator generator = new Generator();

        System.out.print("Введите желаемую длину пароля (от 8 до 12 символов): ");
        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Длина пароля должна быть от 8 до 12 символов.");
            return;
        }

        String password = generator.generatePassword(length);
        System.out.println("Сгенерированный пароль: " + password);
    }


}
