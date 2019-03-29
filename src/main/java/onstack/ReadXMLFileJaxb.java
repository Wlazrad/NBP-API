package onstack;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;


public class ReadXMLFileJaxb {
    public static void main(String[] args) {
        String file = "<?xml version=\"1.0\"?> <book> <person> <first>Kiran</first> <last>Pai</last> <age>22</age> </person> <person> <first>Bill</first> <last>Gates</last> <age>46</age> </person> <person> <first>Steve</first> <last>Jobs</last> <age>40</age> </person> </book>";

        try {

            JAXBContext context = JAXBContext.newInstance(Book.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Book user = (Book) unmarshaller.unmarshal(new StringReader(file));
            System.out.println(user.getPerson().size());

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}

