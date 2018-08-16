package com.movieticket.booking.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.movieticket.booking.model.Movie;
import com.movieticket.booking.repository.MovieRepository;

public interface MovieService {
	
	public List<Movie> getAllMovies();
	
	public Movie save(Movie movie);

}
