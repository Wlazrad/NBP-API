import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class Marshaller {
    public static ExchangeRatesSeries getPojoClass(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ExchangeRatesSeries.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ExchangeRatesSeries exchangeRatesSeries = (ExchangeRatesSeries) unmarshaller.unmarshal(new StringReader(xml));
        return exchangeRatesSeries;
    }
}
