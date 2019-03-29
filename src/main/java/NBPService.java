import com.google.gson.Gson;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.serializer.SerializeException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Provides a simple heartbeat.
 */
//http://localhost:8080/jaxrs-1.0-SNAPSHOT/rest/srednikurs/GBP
@Path("/srednikurs/GBP")
public class NBPService {

    @Produces({MediaType.TEXT_PLAIN})
    @GET
    public static Response getHeartBeat() throws JAXBException {
        double sum = CurrencyAverage.getAverageBid();
        return Response.ok(sum).build();
    }


    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response rateJson() throws JAXBException {
        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        exchangeRatesSeries = MakeObject.javaObject();

        Gson gson = new Gson();
        String json = gson.toJson(exchangeRatesSeries);

        System.out.println(json);

        return Response.ok(json).build();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Response rateXML() throws JAXBException {
        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        exchangeRatesSeries = MakeObject.javaObject();


        JAXBContext context = JAXBContext.newInstance(ExchangeRatesSeries.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        m.marshal(exchangeRatesSeries, sw);

        String result = sw.toString();

        return Response.ok(result).build();
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public Response rateHTML() throws JAXBException, SerializeException {
        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        exchangeRatesSeries = MakeObject.javaObject();

        String html = HtmlSerializer.DEFAULT.serialize(exchangeRatesSeries);
        return Response.ok(html).build();
    }


    @Produces({MediaType.TEXT_PLAIN})
    @GET
    @Path("/text")
    public static Response getText() throws JAXBException {
        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
        exchangeRatesSeries = MakeObject.javaObject();


        String text = exchangeRatesSeries.toString();
        return Response.ok(text).build();
    }


}
