package test2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Класс Main запускает конвертер валют.

    public static void main(String[] args) {
        //Основной метод, обрабатывает вводимые данные
        Scanner scanner = new Scanner(System.in);

        Conversion converter = new Conversion(new Currency());

        System.out.print("Введите валюту для конвертации (USD, EUR, RUB, JPY, GBP): ");
        String fromCurrency = scanner.next().toUpperCase();

        while (!Currency.getExchangeRates().containsKey(fromCurrency)) {
            System.out.println("Неверный код валюты.\nВведите валюту для конвертации (USD, EUR, RUB, JPY, GBP): ");
            System.out.print("");
            fromCurrency = scanner.next().toUpperCase();
        }
        System.out.print("Введите сумму: ");


        double amount = 0;
        while (true) {
            try {
                amount = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода.\nВведите сумму: ");
                scanner.nextLine();
            }
        }

        System.out.println("Результат конвертации:");
        converter.convertAndPrint(amount, fromCurrency);

        System.out.print("Введите '1', чтобы повторить конвертацию, или '0', чтобы выйти: ");
        String continueChoice = scanner.next().toLowerCase();

        if (continueChoice.equals("1")) {
            main(args); // Рекурсивный вызов main для повтора
        } else {
            System.out.println("Пока!");
        }
        scanner.close();
    }
}
