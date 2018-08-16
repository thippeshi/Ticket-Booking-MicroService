package com.movieticket.booking.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.movieticket.booking.model.Movie;
import com.movieticket.booking.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Resource
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

}
