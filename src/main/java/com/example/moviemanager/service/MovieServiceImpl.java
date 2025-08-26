package com.example.moviemanager.service;

import com.example.moviemanager.entity.Movie;
import com.example.moviemanager.exception.ResourceNotFoundException;
import com.example.moviemanager.repository.MovieRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository repository;

	@Override
	public List<Movie> getAllMovies() {
		return repository.findAll();
	}

	@Override
	public Page<Movie> getMoviesPaged(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Movie getMovieById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id.toString()));
	}

	@Override
	public Movie createMovie(Movie movie) {
		return repository.save(movie);
	}

	@Override
	public Movie updateMovie(UUID id, Movie movie) {
		Movie existing = getMovieById(id);
		existing.setTitle(movie.getTitle());
		existing.setDirector(movie.getDirector());
		existing.setReleaseYear(movie.getReleaseYear());
		existing.setGenre(movie.getGenre());
		existing.setRating(movie.getRating());
		return repository.save(existing);
	}

	@Override
	public void deleteMovie(UUID id) {
		Movie existing = getMovieById(id);
		repository.delete(existing);
	}

}
