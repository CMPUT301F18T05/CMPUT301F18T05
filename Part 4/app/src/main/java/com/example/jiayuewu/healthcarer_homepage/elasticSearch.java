package com.example.jiayuewu.healthcarer_homepage;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import org.w3c.dom.DocumentType;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.client.JestResult;
import io.searchbox.core.DeleteByQuery;
import io.searchbox.core.Doc;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;


//Code taken form cmput 301 Lab
public class elasticSearch {
    private static JestDroidClient client;

    // TODO we need a function which adds tweets to elastic search
    public static class AddProblemTask extends AsyncTask<Problem, Void, Void> {

        @Override
        protected Void doInBackground(Problem... problems) {
            verifySettings();

            for (Problem problem : problems) {
                Index index = new Index.Builder(problem).index("testing").type("tweet").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        problem.setProblemID(Integer.parseInt(result.getId()));
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
    public static class GetProblemsTask extends AsyncTask<Integer, Void, ArrayList<Problem>> {
        @Override
        protected ArrayList<Problem> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<Problem> problems = new ArrayList<Problem>();

//            String query = "{ \"query\": { \"term\" : { \"message\" : \"love\" } } }";

            String query = "{ \"query\": { \"term\" : { \"message\" : \""+search_parameters[0]+"\" } } }";


            Search search = new Search.Builder(query)
                    .addIndex("testing")
                    .addType("Problem")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Problem> foundTweets = result.getSourceAsObjectList(Problem.class);
                    problems.addAll(foundTweets);
                    Log.i("DERP", "" + problems);

                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return problems;
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

    // TODO we need a function which adds tweets to elastic search
    public static class AddRecordTask extends AsyncTask<Record, Void, Void> {

        @Override
        protected Void doInBackground(Record... records) {
            verifySettings();

            for (Record record : records) {
                Index index = new Index.Builder(record).index("testing").type("tweet").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        record.setRecordID(Integer.parseInt(result.getId()));
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
    public static class GetRecordsTask extends AsyncTask<Integer, Void, ArrayList<Record>> {
        @Override
        protected ArrayList<Record> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<Record> records = new ArrayList<Record>();

//            String query = "{ \"query\": { \"term\" : { \"message\" : \"love\" } } }";

            String query = "{ \"query\": { \"term\" : { \"message\" : \""+search_parameters[0]+"\" } } }";


            Search search = new Search.Builder(query)
                    .addIndex("testing")
                    .addType("Record")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Record> foundTweets = result.getSourceAsObjectList(Record.class);
                    records.addAll(foundTweets);
                    Log.i("DERP", "" + records);

                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return records;
        }
    }


    // TODO we need a function which adds tweets to elastic search
    public static class addDoctorCommentTask extends AsyncTask<Doctor_Comment, Void, Void> {

        @Override
        protected Void doInBackground(Doctor_Comment... doctor_comments) {
            verifySettings();

            for (Doctor_Comment doctor_comment: doctor_comments) {
                Index index = new Index.Builder(doctor_comment).index("testing").type("tweet").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        doctor_comment.setDoctorCommentID(Integer.parseInt(result.getId()));
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
    public static class GetDoctorCommentTask extends AsyncTask<Integer, Void, ArrayList<Doctor_Comment>> {
        @Override
        protected ArrayList<Doctor_Comment> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<Doctor_Comment> doctor_comments = new ArrayList<Doctor_Comment>();

//            String query = "{ \"query\": { \"term\" : { \"message\" : \"love\" } } }";

            String query = "{ \"query\": { \"term\" : { \"message\" : \""+search_parameters[0]+"\" } } }";


            Search search = new Search.Builder(query)
                    .addIndex("testing")
                    .addType("Doctor_Comment")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Doctor_Comment> foundTweets = result.getSourceAsObjectList(Doctor_Comment.class);
                    doctor_comments.addAll(foundTweets);
                    Log.i("DERP", "" + doctor_comments);

                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return doctor_comments;
        }
    }


    // TODO we need a function which adds tweets to elastic search
    public static class addUserTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            verifySettings();

            for (User user : users) {
                Index index = new Index.Builder(user).index("cmput301f18t05").type("User").id("" + user.getUserID()).build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                } catch (Exception e) {
                    Log.w("You", "Done goofed.");
                }
            }

            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class getUserTask extends AsyncTask<Integer, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<User> users = new ArrayList<User>();

//            String query = "{ \"query\": { \"term\" : { \"message\" : \"love\" } } }";

//            String query = "{ \"query\": { \"term\" : { \"\" : \""+search_parameters[0]+"\" } } }";

            String query = "{\"query\" : {\"term\" : { \"_id\" : \"" + search_parameters[0] + "\" }}}";
//            {"query" : {"term" : { "_id" : "435" }}}

            Search search = new Search.Builder(query)
                    .addIndex("cmput301f18t05")
                    .addType("User")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<User> foundTweets = result.getSourceAsObjectList(User.class);
                    users.addAll(foundTweets);
                    //Log.i("DERP", "" + users);

                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return users;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class DeleteUserTask extends AsyncTask<Integer, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{ \"query\": { \"term\" : { \"message\" : \""+search_parameters[0]+"\" } } }";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex("testing")
                    .addType("Problem")
                    .build();

            try {
                // TODO get the results of the query
                if (client.execute(deleteQuery).isSucceeded()) {
                    Log.i("DERP", "PROBLEM HAS ");
                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return new ArrayList<User>();
        }


    }

}
