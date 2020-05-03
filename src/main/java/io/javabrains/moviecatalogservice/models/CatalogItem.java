// CatalogItem.java - (insert one line description here)
// (C) Copyright 2020 Hewlett Packard Enterprise Development LP

package io.javabrains.moviecatalogservice.models;

/**
 *
 */
public class CatalogItem
{

    private String name;
    private String desc;
    private int rating;

    /**
     * @param name
     * @param desc
     * @param rating
     */
    public CatalogItem(final String name, final String desc, final int rating)
    {
        super();
        this.name = name;
        this.desc = desc;
        this.rating = rating;
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
     * @return the desc
     */
    public String getDesc()
    {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(final String desc)
    {
        this.desc = desc;
    }

    /**
     * @return the rating
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(final int rating)
    {
        this.rating = rating;
    }

}
