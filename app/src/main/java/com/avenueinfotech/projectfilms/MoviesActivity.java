package com.avenueinfotech.projectfilms;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.avenueinfotech.projectfilms.http.MoviesSearchTask;
import com.avenueinfotech.projectfilms.model.Movie;
import com.avenueinfotech.projectfilms.ui.adapter.MoviesAdapter;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Movie>> {

    ListView mListViewMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mListViewMovies = (ListView)findViewById(R.id.list_movies);

        LoaderManager lm = getSupportLoaderManager();
        lm.initLoader(0, null, this);



//        new MovieSearchTask().execute("Batman");
    }

    @Override
    public Loader<List<Movie>> onCreateLoader(int id, Bundle args) {
        return new MoviesSearchTask(this, "Batman");
    }

    @Override
    public void onLoadFinished(Loader<List<Movie>> loader, List<Movie> data) {
        if (data != null) {
            mListViewMovies.setAdapter(new MoviesAdapter(MoviesActivity.this, data));
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Movie>> loader) {

    }

//    class MovieSearchTask extends AsyncTask<String, Void, List<Movie>>{
//
//        @Override
//        protected List<Movie> doInBackground(String... params) {
//            try {
//                List<Movie> movies = MoviesParser.searchByTitle(params[0]);
////                for (Movie movie : movies){
////                    Log.d("NGVL", "movie--->"+movie.title);
////                }
//                return movies;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(List<Movie> movies) {
//            super.onPostExecute(movies);
//            if (movies != null) {
//                mListViewMovies.setAdapter(new MoviesAdapter(MoviesActivity.this, movies));
//            }
//            }
//    }
}
