package com.avenueinfotech.projectfilms.http;

import com.avenueinfotech.projectfilms.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by suken on 11-01-2017.
 */

public class MovieSearchResult {
    @SerializedName("Search")
    public List<Movie> movies;
}
