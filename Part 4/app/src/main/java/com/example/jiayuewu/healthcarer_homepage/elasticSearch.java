package com.example.jiayuewu.healthcarer_homepage;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;


//Code taken form cmput 301 Lab
public class elasticSearch {
    private static JestDroidClient client;

    // TODO we need a function which adds tweets to elastic search
    public static class AddTweetsTask extends AsyncTask<Problem, Void, Void> {

        @Override
        protected Void doInBackground(Problem... problems) {
            verifySettings();

            for (Problem problem : problems) {
                Index index = new Index.Builder(problem).index("testing").type("tweet").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
//                        problem.setProblemID(result.getId());
                    } else {
                        Log.i("Error", "Elastic search was not able to add the tweet.");
                    }
                }
                catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the tweets");
                }

            }
            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Problem>> {
        @Override
        protected ArrayList<Problem> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<Problem> tweets = new ArrayList<Problem>();

//            String query = "{ \"query\": { \"term\" : { \"message\" : \"love\" } } }";

            String query = "{ \"query\": { \"term\" : { \"message\" : \""+search_parameters[0]+"\" } } }";


            Search search = new Search.Builder(query)
                    .addIndex("testing")
                    .addType("tweet")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Problem> foundTweets = result.getSourceAsObjectList(Problem.class);
                    tweets.addAll(foundTweets);
                    Log.i("DERP", "" + tweets);

                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }




    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }

}
