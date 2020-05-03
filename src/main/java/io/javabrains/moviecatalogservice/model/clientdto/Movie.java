// Movie.java - (insert one line description here)
// (C) Copyright 2020 Hewlett Packard Enterprise Development LP

package io.javabrains.moviecatalogservice.model.clientdto;

/**
 *
 */
public class Movie
{

    private String name;
    private String movieId;

    Movie(){
    	
    }
    /**
     * @param name
     * @param movieId
     */
    public Movie(final String name, final String movieId)
    {
        super();
        this.name = name;
        this.movieId = movieId;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     * @return the movieId
     */
    public String getMovieId()
    {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(final String movieId)
    {
        this.movieId = movieId;
    }

}
