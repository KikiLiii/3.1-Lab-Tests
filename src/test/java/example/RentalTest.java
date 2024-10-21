package example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalTest {

    @Test
    void testGetDaysRented() {
        Movie movie = new Movie("The Matrix", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 5);
        assertEquals(5, rental.getDaysRented(), "The number of days rented should be 5");
    }

    @Test
    void testGetMovie() {
        Movie movie = new Movie("Avengers: Endgame", Movie.MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);
        assertEquals(movie, rental.getMovie(), "The movie returned should be 'Avengers: Endgame'");
    }

    @Test
    void testRentalWithChildrenMovie() {
        Movie movie = new Movie("Toy Story", Movie.MovieType.CHILDRENS);
        Rental rental = new Rental(movie, 4);
        assertEquals(4, rental.getDaysRented(), "The number of days rented should be 4");
        assertEquals(movie, rental.getMovie(), "The movie returned should be 'Toy Story'");
    }
}
