package com.example.IndivualAssignment4.movie;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    public List<Movie> findByName(String name);

    @Query("SELECT m FROM Movie m WHERE CONCAT(m.name, m.genre) LIKE %?1%")
    public List<Movie> search(String keyword);
}

