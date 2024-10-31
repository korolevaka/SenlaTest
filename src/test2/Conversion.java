package test2;

public class Conversion {
    //Класс, отвечающий за конвертацию валют.
    private final Currency currency;

    public Conversion(Currency currency) {
        this.currency = currency; //Объект класса Currency, содержащий курсы обмена.
    }

    public void convertAndPrint(double amount, String fromCurrency) {
        //Метод для конвертации суммы и вывода результатов в консоль.
        for (String toCurrency : currency.getExchangeRates().keySet()) {
            if (!toCurrency.equals(fromCurrency)) {
                double convertedAmount = convert(amount, fromCurrency, currency.getExchangeRates().get(toCurrency));
                System.out.println(fromCurrency + " -> " + toCurrency + ": " + convertedAmount);
            }

        }
    }

    private double convert(double amount, String fromCurrency, double toCurrencyRate) {
        return amount * toCurrencyRate / currency.getExchangeRates().get(fromCurrency);
    }
}
