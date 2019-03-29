import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;


import java.io.IOException;

public class XmlCall {

    public static String downloadXml() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/10/?format=xml")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                String xml = response.body().string();
                System.out.println(xml);
//                Serializer serializer = new Persister();
//                serializer.read(C)

            }
        });

            return "lala";
    }
}
