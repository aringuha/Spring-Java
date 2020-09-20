package com.movie.service;

import java.util.List;
//import java.time.ZoneId;
import java.util.Arrays;
//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.exception.ResourceNotFoundException;
import com.movie.model.Movie;
import com.movie.model.Time;
import com.movie.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	private RestTemplate restTemplate;
	
	public String getTimeOfDay() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		HttpEntity<Time> response = restTemplate.exchange("http://worldtimeapi.org/api/ip", HttpMethod.GET, entity, Time.class);
		return response.getBody().getDatetime();
//		return new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().toString();
	}
	
	public List<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	public Movie findMovieById(Integer movieId) {
		return movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("movie", "ID", movieId));
	}
	
	public Movie addMovie(Movie movieRequest) {	
		return movieRepository.save(movieRequest);
	}
	
	public Movie updateMovie(Integer movieId, Movie movieRequest) {
		return movieRepository.findById(movieId).map(movie -> {
			movie.setName(movieRequest.getName());
			movie.setGenre(movieRequest.getGenre());
			movie.setYearReleased(movieRequest.getYearReleased());
			movie.setLanguage(movieRequest.getLanguage());
			movie.setLength(movieRequest.getLength());
			movie.setRating(movieRequest.getRating());
			movie.setReleaseDate(movieRequest.getReleaseDate());
			return movieRepository.save(movie);
		}).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", movieId));
	}	
	
	public Boolean deleteMovie(Integer movieId) {
		return movieRepository.findById(movieId).map(movie -> {
			movieRepository.delete(movie);
			return true;
		}).orElseThrow(() -> new ResourceNotFoundException("movie", "id", movieId));		
	}

}
