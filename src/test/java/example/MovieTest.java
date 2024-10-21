package example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    @Test
    void testGetTitle() {
        Movie movie = new Movie("The Matrix", Movie.MovieType.REGULAR);
        assertEquals("The Matrix", movie.getTitle(), "The title should be 'The Matrix'");
    }

    @Test
    void testGetPriceCodeRegular() {
        Movie movie = new Movie("The Matrix", Movie.MovieType.REGULAR);
        assertEquals(Movie.MovieType.REGULAR, movie.getPriceCode(), "The price code should be REGULAR");
    }

    @Test
    void testGetPriceCodeNewRelease() {
        Movie movie = new Movie("Avengers: Endgame", Movie.MovieType.NEW_RELEASE);
        assertEquals(Movie.MovieType.NEW_RELEASE, movie.getPriceCode(), "The price code should be NEW_RELEASE");
    }

    @Test
    void testGetPriceCodeChildrens() {
        Movie movie = new Movie("Toy Story", Movie.MovieType.CHILDRENS);
        assertEquals(Movie.MovieType.CHILDRENS, movie.getPriceCode(), "The price code should be CHILDRENS");
    }
}
