package com.movie.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/timeOfDay")
	public ResponseEntity<String> getTimeOfDay() {
		return new ResponseEntity<>(movieService.getTimeOfDay(), HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Movie>> getMovies() {
		return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {
		return new ResponseEntity<>(movieService.findMovieById(movieId), HttpStatus.OK);		 
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movieRequest) {
		return new ResponseEntity<>(movieService.addMovie(movieRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{movieId}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Integer movieId, @Valid @RequestBody Movie movieRequest) {
		return new ResponseEntity<>(movieService.updateMovie(movieId, movieRequest), HttpStatus.OK);	
	}	
		
	
	@DeleteMapping("/{movieId}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Integer movieId) {
		movieService.deleteMovie(movieId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
