import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpService {

    private static HttpService service = new HttpService();
    public static HttpService getService() {
        return service;
    }

    private HttpService(){

    }

    public List<Place> getPlaces(String query){
        String response =  makeHttpCall(
                "https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + query  +"&radius=500&types=food&name=cruise&key=AIzaSyCqBqE4ecsAIlPE-hHXnakh4Ykde3BCs6I");

        List<Place> placeList = new ArrayList<>();

        JSONObject root = new JSONObject(response);
        JSONArray results = root.getJSONArray("results");

        Place place;
        for(int i = 0; i < results.length(); i++){
            JSONObject objectInResult = results.getJSONObject(i);

            place = new Place(objectInResult.getFloat("rating"),
                              objectInResult.getString("name"));
            placeList.add(place);
        }
        return placeList;
    }

    private String makeHttpCall(String url){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection) new URL(url).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int read;
            while ((read = inputStreamReader.read()) != -1){
                stringBuilder.append((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
