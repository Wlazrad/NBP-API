import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import onstack.Book;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.time.LocalDateTime;

/**
 * Provides a simple heartbeat.
 *
 */
//http://localhost:8080/jaxrs-1.0-SNAPSHOT/rest/v1/heartbeat
@Path("/v1/heartbeat")
public class HeartbeatService {

    @Produces({ MediaType.TEXT_PLAIN })
    @GET
    public static Response getHeartBeat() throws JAXBException {
        double sum = CurrencyAverage.getAverage();
        return Response.ok(sum).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response rateJson(@PathParam("id") String param) throws JAXBException {
        double sum = CurrencyAverage.getAverage();

        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        ExchangeRatesSeries.Rates rates = new ExchangeRatesSeries.Rates();
        ExchangeRatesSeries.Rates.Rate rate = new ExchangeRatesSeries.Rates.Rate();
        rate.setBid((float) sum);
        XMLGregorianCalendar effectiveDate = null;
        rate.setEffectiveDate(effectiveDate);
        rate.setAsk((float) sum);
        rate.setNo("fdsf");


        rates.getRate().add(0,rate);
        exchangeRatesSeries.setTable("C");
        exchangeRatesSeries.setCode("GBP");
        exchangeRatesSeries.setCurrency("funt szterling");
        exchangeRatesSeries.setRates(rates);

        Gson gson = new Gson();
        String json = gson.toJson(exchangeRatesSeries);

        System.out.println(json);

        return Response.ok(json).build();
    }

    @GET
    @Path("/xml/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response rateXML() throws JAXBException {
        double sum = CurrencyAverage.getAverage();

        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        ExchangeRatesSeries.Rates rates = new ExchangeRatesSeries.Rates();
        ExchangeRatesSeries.Rates.Rate rate = new ExchangeRatesSeries.Rates.Rate();
        rate.setBid((float) sum);
        XMLGregorianCalendar effectiveDate = null;
        rate.setEffectiveDate(effectiveDate);
        rate.setAsk((float) sum);
        rate.setNo("fdsf");


        rates.getRate().add(0,rate);
        exchangeRatesSeries.setTable("C");
        exchangeRatesSeries.setCode("GBP");
        exchangeRatesSeries.setCurrency("funt szterling");
        exchangeRatesSeries.setRates(rates);



        JAXBContext context = JAXBContext.newInstance(ExchangeRatesSeries.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        m.marshal(exchangeRatesSeries, sw);

        String result = sw.toString();

        return Response.ok(result).build();
    }

    @GET
    @Path("/html/html")
    @Produces(MediaType.TEXT_HTML)
    public Response rateHTML() throws JAXBException, SerializeException {
        double sum = CurrencyAverage.getAverage();

        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        ExchangeRatesSeries.Rates rates = new ExchangeRatesSeries.Rates();
        ExchangeRatesSeries.Rates.Rate rate = new ExchangeRatesSeries.Rates.Rate();
        rate.setBid((float) sum);
        XMLGregorianCalendar effectiveDate = null;
        rate.setEffectiveDate(effectiveDate);
        rate.setAsk((float) sum);
        rate.setNo("fdsf");


        rates.getRate().add(0,rate);
        exchangeRatesSeries.setTable("C");
        exchangeRatesSeries.setCode("GBP");
        exchangeRatesSeries.setCurrency("funt szterling");
        exchangeRatesSeries.setRates(rates);

        String html = HtmlSerializer.DEFAULT.serialize(exchangeRatesSeries);
        return Response.ok(html).build();
    }


}
