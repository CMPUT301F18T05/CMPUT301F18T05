/**
 * elasticSearch class runs elastic search to save and get data from online.
 *
 * @author: CMPUT301F18T05
 * @since: 1.0
 *
 * Copyright 2018 HSC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.jiayuewu.healthcarer_homepage;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DeleteByQuery;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * elastSearch class
 *
 * this class holds all the elastic search functions which push and pull information
 * to a server, for online storage.
 */
public class elasticSearch {
    static String cmput301f18t05 = "cmput301f18t05test";
    private static JestDroidClient client;

    /**
     * AddProblemTask
     *
     * This task takes a problem object, and then 
     */
    public static class AddProblemTask extends AsyncTask<Problem, Void, Void> {

        @Override
        protected Void doInBackground(Problem... problems) {
            verifySettings();

            for (Problem problem : problems) {
                Index index = new Index.Builder(problem).index(cmput301f18t05).type("Problem").build();

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
    public static class GetProblemsTask extends AsyncTask<Integer, Void, ArrayList<Problem>> {
        @Override
        protected ArrayList<Problem> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<Problem> problems = new ArrayList<Problem>();

            String query = "{\"query\" : {\"term\" : { \"userID\" : \"" + search_parameters[0] + "\" }}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Problem")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Problem> foundTweets = result.getSourceAsObjectList(Problem.class);
                    problems.addAll(foundTweets);
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
                Index index = new Index.Builder(record).index(cmput301f18t05).type("Record").build();

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
    public static class GetRecordsTask extends AsyncTask<Integer, Void, ArrayList<Record>> {
        @Override
        protected ArrayList<Record> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<Record> records = new ArrayList<Record>();

            String query = "{\"query\" : {\"term\" : { \"problemID\" : \"" + search_parameters[0] + "\" }}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Record")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Record> foundRecords = result.getSourceAsObjectList(Record.class);
                    records.addAll(foundRecords);
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

            for (Doctor_Comment doctor_comment : doctor_comments) {
                Index index = new Index.Builder(doctor_comment).index(cmput301f18t05)
                        .type("Doctor_Comment").build();

                try {
                    // where is the client?
                    client.execute(index);
                } catch (Exception e) {
                    Log.w("You", "Done goofed.");
                }
            }
            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class GetDoctorCommentTask extends AsyncTask<Integer, Void, ArrayList<Doctor_Comment>> {
        @Override
        protected ArrayList<Doctor_Comment> doInBackground(Integer... search_parameters) {

            ArrayList<Doctor_Comment> doctor_comments = new ArrayList<Doctor_Comment>();

            String query = "{\"query\" : {\"term\" : { \"problemID\" : \"" + search_parameters[0] + "\" }}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Doctor_Comment")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Doctor_Comment> foundTweets = result.getSourceAsObjectList(Doctor_Comment.class);
                    doctor_comments.addAll(foundTweets);
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

    public static class addUserTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            ArrayList<User> userArrayList = new ArrayList<User>();

            verifySettings();

            for (User user : users) {
                getUserTask getUserTask
                        = new getUserTask();
                getUserTask.execute(user.getUserID());

                Log.w("HEYO", "HERH");
                Index index = new Index.Builder(user).index(cmput301f18t05).type("User").build();

                try {
                    // where is the client?
                    Log.w("RUNNING", "NOW");
                    DocumentResult result = client.execute(index);
                } catch (Exception e) {
                    Log.w("You", "Done goofed.");
                }
            }

            return null;
        }
    }

    public static class getUserTask extends AsyncTask<Integer, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<User> users = new ArrayList<User>();

            String query = "{\"query\" : {\"term\" : { \"userID\" : \"" + search_parameters[0] + "\" }}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("User")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<User> foundTweets = result.getSourceAsObjectList(User.class);
                    users.addAll(foundTweets);
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


    public static class deleteUserTask extends AsyncTask<Integer, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{ \"query\": { \"term\" : { \"userID\" : \""+search_parameters[0]+"\" } } }";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("User")
                    .build();

            return new ArrayList<User>();
        }
    }
}
