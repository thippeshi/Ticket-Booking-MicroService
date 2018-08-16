package com.movieticket.booking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.booking.MovieTicketConstants;
import com.movieticket.booking.model.Movie;
import com.movieticket.booking.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@Api(value = "movieticketbooking", tags = "Movie Ticket Booking - V1", description = "V1 operations", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
		
	@GetMapping(value=MovieTicketConstants.MOVIES,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(notes="Get all the movies", value="movies", nickname="movies")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "All movies retrieved Successfully", response = String.class),
			@ApiResponse(code = 500, message = "Internal server error")})
	public List<Movie> movies() {
		List<Movie> movies= movieService.getAllMovies();
		log.info("Number of Movies :"+movies.size());
		return movies;
	}

	@PostMapping(value=MovieTicketConstants.MOVIE_SAVE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(notes="Save movie details", value="movies", nickname="movies")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Movie saved successfully", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request"), 
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 500, message = "Internal server error")})
	public Movie save(@RequestBody Movie movie) {
		log.info("Request "+movie.toString());
		return movieService.save(movie);
	}
}
