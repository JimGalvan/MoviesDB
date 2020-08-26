package module5;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {

    private SimpleStringProperty movieID;
    private SimpleStringProperty name;
    private SimpleStringProperty description;
    private SimpleStringProperty rating;

    public Movie(int movieID, String name, String description, int rating) {
        this.movieID = new SimpleStringProperty(String.valueOf(movieID));
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.rating = new SimpleStringProperty(String.valueOf(rating));
    }

    public StringProperty movieIdProperty() {
        return this.movieID;
    }
    public StringProperty movieNameProperty() {
        return this.name;
    }
    public StringProperty movieDescriptionProperty() {
        return this.description;
    }
    public StringProperty movieRatingProperty() {
        return this.rating;
    }

    public String getMovieID() {
        return movieID.get();
    }

    public SimpleStringProperty movieIDProperty() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID.set(movieID);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getRating() {
        return rating.get();
    }

    public SimpleStringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

    @Override
    public String toString(){
        return getName();
    }


}
