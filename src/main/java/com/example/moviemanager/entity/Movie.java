package com.example.moviemanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Title is required")
    private String title;

    private String director;

    @PositiveOrZero(message = "Release year must be >= 0")
    private Integer releaseYear;

    private String genre;

    @Min(value = 1, message = "Rating must be >= 1")
    @Max(value = 10, message = "Rating must be <= 10")
    private Integer rating;
}
