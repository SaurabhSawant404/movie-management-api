package com.example.moviemanager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.moviemanager.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
