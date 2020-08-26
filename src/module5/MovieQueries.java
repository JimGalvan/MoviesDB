package module5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieQueries {
    private static final String DATABASE_URL = "jdbc:derby:MoviesDB";
    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;

    PreparedStatement getAllMovies;
    PreparedStatement addMovie;

    public MovieQueries(){

        try{
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();

            getAllMovies = connection.prepareStatement("SELECT * FROM movies ORDER BY movieID");
            addMovie = connection.prepareStatement("INSERT INTO movies (name, description, rating)" +
                    "VALUES (?,?,?)");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Movie> loadMovies(){
        try (ResultSet resultSet = getAllMovies.executeQuery()){
            List<Movie> results = new ArrayList<>();

            while (resultSet.next()){
                results.add(new Movie(
                        resultSet.getInt("movieID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("rating")
                ));
            }
            return results;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int addMovie(String name, String description, int rating){
        try{
            addMovie.setString(1, name);
            addMovie.setString(2, description);
            addMovie.setInt(3, rating);
            return addMovie.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public void resetDB(){
        try {
            statement.executeUpdate("DELETE FROM movies");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // This method shuts down the DB to avoid Derby ID gap pattern
    public void close() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
            connection.close();
        } catch (SQLException sqlException) {
            System.err.println("Database shutdown");
        }
    }
}
