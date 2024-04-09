package com.example.IndivualAssignment4.movie;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author csc340
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    /**
     * Get all movies.
     *
     * @return the list of movies.
     */
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    /**
     * Get all movies that match the keyword.
     *
     * @param keyword the search term.
     * @return the list of movies.
     */
    public List<Movie> getAllMovies(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Get a single movie by ID
     *
     * @param movieId
     * @return the movie
     */
    public Movie getMovie(long movieId) {
        return repo.getReferenceById(movieId);
    }

    /**
     * Delete a single movie by ID
     *
     * @param movieId
     */
    public void deleteMovie(long movieId) {
        repo.deleteById(movieId);
    }

    /**
     * Save a movie entry.
     *
     * @param movie
     */
    void saveMovie(Movie movie) {
        repo.save(movie);
    }

}
