package com.movie.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.movie.MovieManagerApplication;
import com.movie.controller.MovieController;
import com.movie.model.Movie;
import com.movie.service.MovieService;
import com.movie.utils.Utils;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieManagerApplication.class)
public class MovieControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private MovieService movieService;

	@InjectMocks
	private MovieController movieController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}
	
	@Test
	public void getMovieTest() throws Exception {
		// given
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		List<Movie> moviees = Arrays.asList(new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L),
				new Movie("movie 2","Author 2", "Language 2", "ISBN 2", date, "Publisher 2", 160L));

		// when
		when(movieService.findAllMovies()).thenReturn(moviees);
		mockMvc.perform(get("/api/movie/list")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("movie 1")))
				.andExpect(jsonPath("$[0].genre", is("Author 1")))
				.andExpect(jsonPath("$[0].language", is("Language 1")))
				.andExpect(jsonPath("$[0].yearReleased", is("ISBN 1")))
				.andExpect(jsonPath("$[0].releaseDate", is(sdf.format(date))))
				.andExpect(jsonPath("$[0].rating", is("Publisher 1")))
				.andExpect(jsonPath("$[0].length", is(150)))			
				
				.andExpect(jsonPath("$[1].name", is("movie 2")))
				.andExpect(jsonPath("$[1].genre", is("Author 2")))
				.andExpect(jsonPath("$[1].language", is("Language 2")))
				.andExpect(jsonPath("$[1].yearReleased", is("ISBN 2")))
				.andExpect(jsonPath("$[1].releaseDate", is(sdf.format(date))))
				.andExpect(jsonPath("$[1].rating", is("Publisher 2")))
				.andExpect(jsonPath("$[1].length", is(160)));
		verify(movieService, times(1)).findAllMovies();
		verifyNoMoreInteractions(movieService);
	}

	@Test
	public void getMovieByIdTest() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Movie movie = new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L);
		when(movieService.findMovieById(1)).thenReturn(movie);
		mockMvc.perform(get("/api/movie/{movieId}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.name", is("movie 1")))
				.andExpect(jsonPath("$.genre", is("Author 1")))
				.andExpect(jsonPath("$.language", is("Language 1")))
				.andExpect(jsonPath("$.yearReleased", is("ISBN 1")))
				.andExpect(jsonPath("$.releaseDate", is(sdf.format(date))))
				.andExpect(jsonPath("$.rating", is("Publisher 1")))
				.andExpect(jsonPath("$.length", is(150)));
		verify(movieService, times(1)).findMovieById(1);
		verifyNoMoreInteractions(movieService);
	}

	
	@Test
	public void addMovieTest() throws Exception {
		Date date = new Date();
		Movie movieRequest = new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L);
		Movie movie = new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L);
		when(movieService.addMovie(movieRequest)).thenReturn(movie);
		mockMvc.perform(
				post("/api/movie").contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(movie)))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void updateMovieTest() throws Exception {
		Date date = new Date();
		Movie movieRequest = new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L);
		Movie movie = new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L);
		when(movieService.updateMovie(movie.getId(), movieRequest)).thenReturn(movie);
		mockMvc.perform(put("/api/movie/{movieId}", movie.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(movie))).andExpect(status().isOk());
	}	
	
	@Test
	public void deleteMovieTest() throws Exception {
		Date date = new Date();
		Movie movie = new Movie("movie 1","Author 1", "Language 1", "ISBN 1", date, "Publisher 1", 150L);
		when(movieService.deleteMovie(movie.getId())).thenReturn(true);
		mockMvc.perform(delete("/api/movie/{movieId}", movie.getId())).andExpect(status().isOk());
		verify(movieService, times(1)).deleteMovie(movie.getId());
		verifyNoMoreInteractions(movieService);
	}

	@Test
	public void badRequestGetmovieByIdTest() throws Exception {
		mockMvc.perform(get("/api/movie/{movieId}", "f")).andExpect(status().isBadRequest());
	}

}
