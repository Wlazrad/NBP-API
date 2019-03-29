import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

public class MakeObject {

    public static ExchangeRatesSeries javaObject() throws JAXBException {

        double averageBid = CurrencyAverage.getAverageBid();
        double averageAsk = CurrencyAverage.getAverageAsk();

        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        ExchangeRatesSeries.Rates rates = new ExchangeRatesSeries.Rates();
        ExchangeRatesSeries.Rates.Rate rate = new ExchangeRatesSeries.Rates.Rate();
        rate.setBid((float) averageBid);
        XMLGregorianCalendar effectiveDate = null;
        rate.setEffectiveDate(effectiveDate);
        rate.setAsk((float) averageAsk);
        rate.setNo("054/C/NBP/2019");


        rates.getRate().add(0, rate);


        exchangeRatesSeries.setTable("C");
        exchangeRatesSeries.setCode("GBP");
        exchangeRatesSeries.setCurrency("funt szterling");
        exchangeRatesSeries.setRates(rates);

        return exchangeRatesSeries;
    }
}
