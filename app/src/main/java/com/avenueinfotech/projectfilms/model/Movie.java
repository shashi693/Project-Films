package com.avenueinfotech.projectfilms.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by suken on 11-01-2017.
 */

public class Movie {
    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    @SerializedName("imdbID")
    public String imdbId;
    @SerializedName("Poster")
    public String poster;
}
