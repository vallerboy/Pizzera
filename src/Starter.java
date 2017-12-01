import java.net.HttpURLConnection;

public class Starter {
    public static void main(String[] args) {
        HttpService httpService = HttpService.getService();
        System.out.println(
                httpService.makeHttpCall("https://maps.googleapis.com/maps/api/place/textsearch/json?query=Gdynia+pizzeria&radius=500&types=food&name=cruise&key=AIzaSyCqBqE4ecsAIlPE-hHXnakh4Ykde3BCs6I"));
    }
}
