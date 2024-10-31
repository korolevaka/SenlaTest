package test2;

import java.util.HashMap;

public class Currency {
    //Класс, хранящий курсы обмена валют.

    public static HashMap<String, Double> exchangeRates;

    public Currency() {
        //Инициализирует хэш-таблицу с начальными курсами обмена.
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.9);
        exchangeRates.put("RUB", 75.0);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.8);
    }

    public static HashMap<String, Double> getExchangeRates() {
        //Метод для получения HashMap с курсами обмена.
        return exchangeRates;
    }
}
