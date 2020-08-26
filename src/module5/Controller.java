package module5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.*;

public class Controller {

    MovieQueries movieQueries;
    ObservableList<Movie> observableList;
    @FXML private AnchorPane rootPane;
    @FXML private TableView<Movie> tableView;;

    @FXML private TextField nameTextField;
    @FXML private TextArea descriptionTextField;
    @FXML private Button saveMovieButton;
    @FXML private ChoiceBox<Integer> choiceBox;

    @FXML private TableColumn<Movie, String> movieIDColumn;
    @FXML private TableColumn<Movie, String> nameColumn;
    @FXML private TableColumn<Movie, String> descriptionColumn;
    @FXML private TableColumn<Movie, String> ratingColumn;

    public void initialize(){
        movieQueries = new MovieQueries();
        choiceBox.setItems(FXCollections.observableArrayList(
                1,2,3,4,5,6,7,8,9,10));
        choiceBox.setValue(1);
        tableViewConfiguration();

    }

    private void tableViewConfiguration() {

        movieIDColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("movieID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("description"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("rating"));

        observableList = FXCollections.observableArrayList();

        loadMoviesIntoTable();
    }

    private void loadMoviesIntoTable() {
        observableList.setAll(movieQueries.loadMovies());
        tableView.setItems(observableList);
    }

    @FXML
    void saveMovie(ActionEvent event) {


        String name = nameTextField.getText();
        String description = descriptionTextField.getText();
        int rating = choiceBox.getValue();

        movieQueries.addMovie(name, description, rating);
        loadMoviesIntoTable();

    }


    private void displayAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}


