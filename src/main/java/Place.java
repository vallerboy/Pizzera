public class Place {
    private float rating;
    private String name;

    public Place(float rating, String name) {
        this.rating = rating;
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (Float.compare(place.rating, rating) != 0) return false;
        return name != null ? name.equals(place.name) : place.name == null;
    }

    @Override
    public int hashCode() {
        int result = (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Place{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                '}';
    }
}

