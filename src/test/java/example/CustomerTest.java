package example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void testStatementForRegularMovieLessThanTwoDays() {
        Movie regularMovie = new Movie("Regular Movie", Movie.MovieType.REGULAR);
        Rental rental = new Rental(regularMovie, 1);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementForRegularMovieMoreThanTwoDays() {
        Movie regularMovie = new Movie("Regular Movie", Movie.MovieType.REGULAR);
        Rental rental = new Rental(regularMovie, 3);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementForNewReleaseMovieMoreThanTwoDays() {
        Movie newReleaseMovie = new Movie("New Release Movie", Movie.MovieType.NEW_RELEASE);
        Rental rental = new Rental(newReleaseMovie, 2);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = "Rental Record for John Doe\n" +
                "\tNew Release Movie\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementForChildrensMovieMoreThanThreeDays() {
        Movie childrensMovie = new Movie("Children's Movie", Movie.MovieType.CHILDRENS);
        Rental rental = new Rental(childrensMovie, 4);
        Customer customer = new Customer("John Doe", List.of(rental));

        String expected = "Rental Record for John Doe\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    void testStatementWithMultipleRentals() {
        Movie regularMovie = new Movie("Regular Movie", Movie.MovieType.REGULAR);
        Movie newReleaseMovie = new Movie("New Release Movie", Movie.MovieType.NEW_RELEASE);
        Movie childrensMovie = new Movie("Children's Movie", Movie.MovieType.CHILDRENS);

        Rental rental1 = new Rental(regularMovie, 3); // 3.5
        Rental rental2 = new Rental(newReleaseMovie, 2); // 6.0
        Rental rental3 = new Rental(childrensMovie, 4); // 3.0

        Customer customer = new Customer("John Doe", List.of(rental1, rental2, rental3));

        String expected = "Rental Record for John Doe\n" +
                "\tRegular Movie\t3.5\n" +
                "\tNew Release Movie\t6.0\n" +
                "\tChildren's Movie\t3.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points";

        assertEquals(expected, customer.statement());
    }

}
