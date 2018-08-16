package com.movieticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticket.booking.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
