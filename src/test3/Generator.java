package test3;

import java.util.Random;

public class Generator {
    public String generatePassword(int length) {
        //Метод для генерации пароля
        if (length < 4) {
            throw new IllegalArgumentException("Длина пароля должна быть не менее 4 символов.");
        }

        Random random = new Random();

        //Наборы символов каждого типа
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_+-={}[]|;':\",./<>?";

        StringBuilder password = new StringBuilder();

        //Добавляем один случайный символ каждого типа
        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        //Заполняем оставшуюся часть
        for (int i = 4; i < length; i++) {
            String allChars = uppercaseLetters + lowercaseLetters + digits + specialChars;
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Перемешиваем символы
        char[] charArray = password.toString().toCharArray();
        for (int i = charArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}

