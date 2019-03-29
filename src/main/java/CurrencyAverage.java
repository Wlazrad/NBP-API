import javax.xml.bind.JAXBException;

public class CurrencyAverage {
    public static Double getAverage() throws JAXBException {
        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        exchangeRatesSeries = Marshaller.getPojoClass(Bank.getBankXml());

        System.out.println(exchangeRatesSeries.getCurrency());
        String result=exchangeRatesSeries.getCurrency();

        double sum =0;

        for(int i = 0; i<=9; i++){
            sum = sum + exchangeRatesSeries.rates.getRate().get(i).bid;

            System.out.println(exchangeRatesSeries.rates.getRate().get(i).bid);
        }
        sum= sum/10;
        return sum;
    }
}
