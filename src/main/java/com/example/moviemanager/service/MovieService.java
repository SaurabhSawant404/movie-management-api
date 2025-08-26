package com.example.moviemanager.service;

import com.example.moviemanager.entity.Movie;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
	List<Movie> getAllMovies();

	Page<Movie> getMoviesPaged(Pageable pageable);

	Movie getMovieById(UUID id);

	Movie createMovie(Movie movie);

	Movie updateMovie(UUID id, Movie movie);

	void deleteMovie(UUID id);
}
