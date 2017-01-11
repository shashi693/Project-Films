package com.avenueinfotech.projectfilms;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.avenueinfotech.projectfilms.http.MoviesParser;
import com.avenueinfotech.projectfilms.model.Movie;
import com.avenueinfotech.projectfilms.ui.adapter.MoviesAdapter;

import java.io.IOException;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    ListView mListMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mListMovies = (ListView)findViewById(R.id.list_movies);

        new MovieSearchTask().execute("Batman");
    }

    class MovieSearchTask extends AsyncTask<String, Void, List<Movie>>{

        @Override
        protected List<Movie> doInBackground(String... params) {
            try {
                List<Movie> movies = MoviesParser.searchByTitle(params[0]);
//                for (Movie movie : movies){
//                    Log.d("NGVL", "movie--->"+movie.title);
//                }
                return movies;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            super.onPostExecute(movies);
            if (movies != null) {
                mListMovies.setAdapter(new MoviesAdapter(MoviesActivity.this, movies));
            }
            }
    }
}
