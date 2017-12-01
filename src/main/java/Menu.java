import java.util.List;
import java.util.Scanner;

public class Menu {
    private HttpService httpService = HttpService.getService();
    private Scanner scanner;


    public Menu() {
        scanner = new Scanner(System.in);
    }


    public void start(){
        System.out.print("Podaj zapytanie: ");
        String query = scanner.nextLine();

        makeRequest(query);
    }

    private void makeRequest(String query) {
        List<Place> places = httpService.getPlaces(query);

        Place place = places.get(0);
        for (Place place1 : places) {
            if(place.getRating() <= place1.getRating()){
                place = place1;
            }
        }

        System.out.println("Najlepszy lokal to: ");
        System.out.println(place);
    }

}
