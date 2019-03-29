import onstack.Book;
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
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;

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
        Client client = ClientBuilder.newClient();
        URI uri = URI.create("http://api.nbp.pl/api/exchangerates/rates/c/gbp/last/10/?format=xml");
        WebTarget webTarget = client.target(uri);
        String xmlAnswer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);

            JAXBContext context = JAXBContext.newInstance(ExchangeRatesSeries.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            ExchangeRatesSeries exchangeRatesSeries = (ExchangeRatesSeries) unmarshaller.unmarshal(new StringReader(xmlAnswer));
            System.out.println(exchangeRatesSeries.getCurrency());
            String result=exchangeRatesSeries.getCurrency();

            double sum =0;

            for(int i = 0; i<=9; i++){
                sum = sum + exchangeRatesSeries.rates.getRate().get(i).bid;

                System.out.println(exchangeRatesSeries.rates.getRate().get(i).bid);
            }

        return Response.ok(sum/10).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response rateXML(@PathParam("id") String param) {
        if(param == "json"){

            System.out.println("json");
        }
        return Response.ok("json").build();
    }


}
