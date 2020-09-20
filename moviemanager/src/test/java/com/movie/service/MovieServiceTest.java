package com.movie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movie.model.Movie;
import com.movie.service.MovieService;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {
	
	@Mock
	private MovieService movieService;
	
	@Before
	public void setup(){
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllMoviesTest(){
		// given
		Date date = new Date();
		List<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie("heat","comedy", "Language 1", "1990", date, "R", 150L));
		movieList.add(new Movie("heat","comedy", "Language 2", "1990", date, "R", 160L));
		movieList.add(new Movie("heat","comedy", "Language 3", "1990", date, "R", 170L));
		
		// when
		when(movieService.findAllMovies()).thenReturn(movieList);
		
		// assert
		List<Movie> result = movieService.findAllMovies();
		assertEquals(3, result.size());
		
		assertThat(result.get(0).getName()).isEqualTo("heat");
		assertThat(result.get(0).getGenre()).isEqualTo("comedy");
        assertThat(result.get(0).getLanguage()).isEqualTo("Language 1");
        assertThat(result.get(0).getYearReleased()).isEqualTo("1990");
        assertThat(result.get(0).getReleaseDate()).isEqualTo(date);
		assertThat(result.get(0).getRating()).isEqualTo("R");
        assertThat(result.get(0).getLength()).isEqualTo(150L);
        
		assertThat(result.get(1).getName()).isEqualTo("heat");
		assertThat(result.get(1).getGenre()).isEqualTo("comedy");
        assertThat(result.get(1).getLanguage()).isEqualTo("Language 2");
        assertThat(result.get(1).getYearReleased()).isEqualTo("1990");
        assertThat(result.get(1).getReleaseDate()).isEqualTo(date);
		assertThat(result.get(1).getRating()).isEqualTo("R");
        assertThat(result.get(1).getLength()).isEqualTo(160L);
        
		assertThat(result.get(2).getName()).isEqualTo("heat");
		assertThat(result.get(2).getGenre()).isEqualTo("comedy");
        assertThat(result.get(2).getLanguage()).isEqualTo("Language 3");
        assertThat(result.get(2).getYearReleased()).isEqualTo("1990");
        assertThat(result.get(2).getReleaseDate()).isEqualTo(date);
		assertThat(result.get(2).getRating()).isEqualTo("R");
        assertThat(result.get(2).getLength()).isEqualTo(170L);
	}
	
	@Test
	public void findMovieByIdTest(){
		// given
		Date date = new Date();
		Movie movie = new Movie("heat","comedy", "Language 1", "1990", date, "R", 150L);
		
		// when
		when(movieService.findMovieById(1)).thenReturn(movie);
		
		// assert
		Movie result = movieService.findMovieById(1);
		assertThat(result.getName()).isEqualTo("heat");
		assertThat(result.getGenre()).isEqualTo("comedy");
        assertThat(result.getLanguage()).isEqualTo("Language 1");
        assertThat(result.getYearReleased()).isEqualTo("1990");
        assertThat(result.getReleaseDate()).isEqualTo(date);
		assertThat(result.getRating()).isEqualTo("R");
        assertThat(result.getLength()).isEqualTo(150L);
	}
	
	@Test
    public void createMovieTest() {
        // given
		Date date = new Date();
		Movie movieRequest = new Movie("heat","comedy", "Language 1", "1990",date, "R", 150L);		
		Movie movie = new Movie("heat","comedy", "Language 1", "1990", date, "R", 150L);
		
        // when
        when(movieService.addMovie(movieRequest)).thenReturn(movie);

        // assert
        Movie result = movieService.addMovie(movieRequest);
        assertThat(result.getName()).isEqualTo("heat");
		assertThat(result.getGenre()).isEqualTo("comedy");
        assertThat(result.getLanguage()).isEqualTo("Language 1");
        assertThat(result.getYearReleased()).isEqualTo("1990");
        assertThat(result.getReleaseDate()).isEqualTo(date);
		assertThat(result.getRating()).isEqualTo("R");
        assertThat(result.getLength()).isEqualTo(150L);
    }
	
	@Test
    public void updateMovieTest() {
        // given
		Date date = new Date();
		Movie movieRequest = new Movie("heat","comedy", "Language 1", "ISBN 1",date, "R", 150L);		
		Movie movie = new Movie("heat","comedy", "Language 1", "1990", date, "R", 150L);
		
        // when
        when(movieService.updateMovie(1, movieRequest)).thenReturn(movie);

        // assert
        Movie result = movieService.updateMovie(1, movieRequest);
        assertThat(result.getName()).isEqualTo("heat");
		assertThat(result.getGenre()).isEqualTo("comedy");
        assertThat(result.getLanguage()).isEqualTo("Language 1");
        assertThat(result.getYearReleased()).isEqualTo("1990");
        assertThat(result.getReleaseDate()).isEqualTo(date);
		assertThat(result.getRating()).isEqualTo("R");
        assertThat(result.getLength()).isEqualTo(150L);
    }	
	
	@Test
    public void deleteMovieTest() {
        // given
		Date date = new Date();
		Movie movie = new Movie("heat","comedy", "Language 1", "1990", date, "R", 150L);
		
        // when
        when(movieService.deleteMovie(movie.getId())).thenReturn(true);

        // assert
        Boolean result = movieService.deleteMovie(movie.getId());
        assertThat(result).isEqualTo(true);
    }

}
