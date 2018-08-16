package com.movieticket.booking;

public interface MovieTicketConstants {

	String API_VERSION = "v1";
	String API_PREFIX = "/api/" + API_VERSION;

	// endpoints
	String TEST = API_PREFIX + "/test";
	String MOVIES = API_PREFIX + "/movies";
	String MOVIE_SAVE = API_PREFIX + "/movie/save";

}
