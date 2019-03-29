import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;

public class Bank {

    public static String getBankXml(){
        Client client = ClientBuilder.newClient();
        URI uri = URI.create("http://api.nbp.pl/api/exchangerates/rates/c/gbp/last/10/?format=xml");
        WebTarget webTarget = client.target(uri);
        String xmlAnswer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
        return xmlAnswer;

    }
}
