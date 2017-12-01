import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HttpService {

    private static HttpService service = new HttpService();
    public static HttpService getService() {
        return service;
    }

    private HttpService(){

    }

    public List<String> getNames(String query){
        String response =  makeHttpCall(
                "https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + query  +" &radius=500&types=food&name=cruise&key=AIzaSyCqBqE4ecsAIlPE-hHXnakh4Ykde3BCs6I");



    }

    private String makeHttpCall(String url){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) new URL(url).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            int read;
            while ((read = inputStream.read()) != -1){
                stringBuilder.append((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
