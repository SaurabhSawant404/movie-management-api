package com.example.moviemanager.controller;

import com.example.moviemanager.entity.Movie;
import com.example.moviemanager.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/movies")
@RequiredArgsConstructor
public class MovieController {

	private final MovieService service;

	@GetMapping
	@Operation(summary = "Get all movies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(service.getAllMovies());
	}

	@GetMapping("/paged")
	@Operation(summary = "List movies with pagination")
	public ResponseEntity<Map<String, Object>> getMoviesPaged(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Movie> moviesPage = service.getMoviesPaged(pageable);

		Map<String, Object> response = new LinkedHashMap();
		response.put("content", moviesPage.getContent());
		response.put("page", moviesPage.getNumber());
		response.put("size", moviesPage.getSize());
		response.put("totalElements", moviesPage.getTotalElements());
		response.put("totalPages", moviesPage.getTotalPages());
		response.put("last", moviesPage.isLast());

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get movie by ID")
	public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
		return ResponseEntity.ok(service.getMovieById(id));
	}

	@PostMapping
	@Operation(summary = "Create a new movie")
	public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {
		return ResponseEntity.status(201).body(service.createMovie(movie));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update existing movie")
	public ResponseEntity<Movie> updateMovie(@PathVariable UUID id, @Valid @RequestBody Movie movie) {
		return ResponseEntity.ok(service.updateMovie(id, movie));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete movie by ID")
	public ResponseEntity<Void> deleteMovie(@PathVariable UUID id) {
		service.deleteMovie(id);
		return ResponseEntity.noContent().build();
	}
}
