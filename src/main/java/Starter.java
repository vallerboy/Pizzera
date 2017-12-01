import java.net.HttpURLConnection;

public class Starter {


    public static void main(String[] args) {
        HttpService httpService = HttpService.getService();
        httpService.getPlaces("Gdynia+Pizzeria");
    }
}
