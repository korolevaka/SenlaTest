package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Storage {
    //Класс Storage содержит методы для получения случайного слова и создания алфавита.
    public static String getWord() {
        // Возвращает случайное слово из списка.
        List<String> words = new ArrayList<>();
        words.add("сенла");
        words.add("обучение");
        words.add("квадрат");
        words.add("программа");
        words.add("солнце");

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());

        return (words.get(randomIndex));
    }

    public static List<Character> createAlphabet(){
        //Создает список символов русского алфавита.
        List<Character> abc = new ArrayList<>();
        for (char c = 'а'; c <= 'я'; c++) {
            abc.add(c);
        }
        return abc;
    }
}
