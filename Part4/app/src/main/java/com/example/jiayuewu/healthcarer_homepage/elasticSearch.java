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

import java.io.IOException;
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
     * store the data from the user and save it into the related ID Problemlist
     *
     */
    public static class addProblemTask extends AsyncTask<Problem, Void, Void> {

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
   /**GetProblemsTask:
     *
     *  get problemList from the data which related to the UserID
     *
     */
    // TODO we need a function which gets tweets from elastic search
    public static class getProblemsTask extends AsyncTask<Integer, Void, ArrayList<Problem>> {
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

    public static class deleteProblemTask extends AsyncTask<Integer, Void, ArrayList<Problem>> {
        @Override
        protected ArrayList<Problem> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{\"query\": {\"bool\": {\"must\": [{\"term\": {\"userID\": " +
                    search_parameters[0] + "} },{\"term\": {\"problemID\": " + search_parameters[1] + "}}]}}}";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Problem")
                    .build();
            try{
                client.execute(deleteQuery);
            }catch (IOException e){
                Log.i("TODO","We actually failed here, deleting a user");
                e.printStackTrace();
            }
            return null;
        }
    }

/**verifySettings:
     * verify the settings with the cmput301's serverURL
     *
     */
    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
/**AddRecordTask:
     *
    store the data from the user and save it into the related ID RecordList and save under which ProblemLIst
     */
    // TODO we need a function which adds tweets to elastic search
    public static class addRecordTask extends AsyncTask<Record, Void, Void> {

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
/**GetRecordsTask:
     * get recordList from the date which related to the UserID's problemList
     *
     */
    // TODO we need a function which gets tweets from elastic search
    public static class getRecordsTask extends AsyncTask<Integer, Void, ArrayList<Record>> {
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
/**GetDoctorCommentTask:
     * get doctor's comment form the UserID's ProblenmList"s detail
     *
     */
    // TODO we need a function which gets tweets from elastic search
    public static class getDoctorCommentTask extends AsyncTask<Integer, Void, ArrayList<Doctor_Comment>> {
        @Override
        protected ArrayList<Doctor_Comment> doInBackground(Integer... search_parameters) {

            ArrayList<Doctor_Comment> doctor_comments = new ArrayList<Doctor_Comment>();

            String query = "{\"query\": {\"bool\": {\"must\": [{\"term\": {\"problemID\": " +
                    search_parameters[0] + "} },{\"term\": {\"userID\": " + search_parameters[1] + "}}]}}}";

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
 /**addUserTask:
     * create a user info to data stream
     *
     */

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
 /**getUserTask:
     * get User's info from the date stream with the UserID
     *
     */
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

/**deleteUserTask：
     * delete User's info from the data stream with the UserID
     *
     */
    public static class deleteUserTask extends AsyncTask<Integer, Void, ArrayList<User>> {
        @Override
        protected ArrayList<User> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{ \"query\": { \"term\" : { \"userID\" : \""+search_parameters[0]+"\" } } }";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("User")
                    .build();
            try{
                client.execute(deleteQuery);
            }catch (IOException e){
                Log.i("TODO","We actually failed here, deleting a user");
                e.printStackTrace();
            }
            return null;
        }
    }

    /**setTransferTask:
     * create a trasfer info to data stream
     *
     */

    public static class setTransferTask extends AsyncTask<transferObject, Void, Void> {

        @Override
        protected Void doInBackground(transferObject... transferObjects) {
            ArrayList<transferObject> userArrayList = new ArrayList<transferObject>();

            verifySettings();

            for (transferObject transfer : transferObjects) {
                getTransferTask getUserTask
                        = new getTransferTask();
                getUserTask.execute(transfer.getUserID());

                Index index = new Index.Builder(transfer).index(cmput301f18t05).type("Transfer").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                } catch (Exception e) {
                    Log.w("elasticSearch", "Error trying to execute search.");
                }
            }

            return null;
        }
    }
    /**getTransferTask:
     * get trasnfer's info from the date stream with the code
     *
     */
    public static class getTransferTask extends AsyncTask<Integer, Void, ArrayList<transferObject>> {
        @Override
        protected ArrayList<transferObject> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<transferObject> users = new ArrayList<transferObject>();

            String query = "{\"query\" : {\"term\" : { \"code\" : \"" + search_parameters[0] + "\" }}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Transfer")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<transferObject> foundTweets = result.getSourceAsObjectList(transferObject.class);
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

    /**deleteUserTask：
     * delete User's info from the data stream with the UserID
     *
     */
    public static class deleteTransferTask extends AsyncTask<Integer, Void, ArrayList<transferObject>> {
        @Override
        protected ArrayList<transferObject> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{ \"query\": { \"term\" : { \"userID\" : \""+search_parameters[0]+"\" } } }";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Transfer")
                    .build();
            try{
                client.execute(deleteQuery);
            }catch (IOException e){
                Log.i("TODO","We actually failed here, deleting a transfer");
                e.printStackTrace();
            }
            return null;
        }
    }



    /**GetProblemsTask:
     *
     *  get problemList from the data which related to the UserID
     *
     */
    // TODO we need a function which gets tweets from elastic search
    public static class getSpecialProblem extends AsyncTask<Integer, Void, ArrayList<Problem>> {
        @Override
        protected ArrayList<Problem> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<Problem> problems = new ArrayList<Problem>();

            String query = "{\"query\": {\"bool\": {\"must\": [{\"term\": {\"problemID\": " +
                    search_parameters[0] + "} },{\"term\": {\"userID\": " + search_parameters[1] + "}}]}}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Problem")
                    .build();


            Log.i("elasticSearcgh", "IN HERER");

            try {
                // TODO get the results of the query


                SearchResult result = client.execute(search);

                Log.i("elasticSearch", "Exceuted search");
                if (result.isSucceeded()) {
                    Log.i("elasticSearch", "checking contenst");

                    List<Problem> foundTweets = result.getSourceAsObjectList(Problem.class);
                    problems.addAll(foundTweets);
                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }


            Log.i("elasticSearch", "Returned" + problems);
            return problems;
        }
    }

    /**getTransferTask:
     * get trasnfer's info from the date stream with the code
     *
     */
    public static class getPhoto extends AsyncTask<Integer, Void, ArrayList<photo_object>> {
        @Override
        protected ArrayList<photo_object> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<photo_object> users = new ArrayList<photo_object>();

            String query = "{\"query\" : {\"term\" : { \"recordID\" : \"" + search_parameters[0] + "\" }}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Photo")
                    .build();

            try {
                // TODO get the results of the query
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<photo_object> foundTweets = result.getSourceAsObjectList(photo_object.class);
                    users.addAll(foundTweets);
                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            } catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return users;
        }
    }

    /**setTransferTask:
     * create a trasfer info to data stream
     *
     */

    public static class setPhoto extends AsyncTask<photo_object, Void, Void> {

        @Override
        protected Void doInBackground(photo_object... photo_objects) {
            ArrayList<photo_object> userArrayList = new ArrayList<photo_object>();

            verifySettings();

            for (photo_object photo : photo_objects) {
                getPhoto getUserTask
                        = new getPhoto();
                getUserTask.execute(photo.getRecordID());

                Index index = new Index.Builder(photo).index(cmput301f18t05).type("Photo").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                } catch (Exception e) {
                    Log.w("elasticSearch", "Error trying to execute search.");
                }
            }

            return null;
        }
    }

    /**deleteUserTask：
     * delete User's info from the data stream with the UserID
     *
     */
    public static class deleteSpecificPhoto extends AsyncTask<Integer, Void, ArrayList<photo_object>> {
        @Override
        protected ArrayList<photo_object> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{\"query\": {\"bool\": {\"must\": [{\"term\": {\"problemID\": " +
                    search_parameters[0] + "} },{\"term\": {\"photoID\": " + search_parameters[1] + "}}]}}}";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Photo")
                    .build();
            try{
                client.execute(deleteQuery);
            }catch (IOException e){
                Log.i("TODO","We actually failed here, deleting a photo");
                e.printStackTrace();
            }
            return null;
        }
    }

    /**deleteUserTask：
     * delete User's info from the data stream with the UserID
     *
     */
    public static class deletePhoto extends AsyncTask<Integer, Void, ArrayList<photo_object>> {
        @Override
        protected ArrayList<photo_object> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{\"query\" : {\"term\" : { \"recordID\" : \"" + search_parameters[0] + "\" }}}";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("Photo")
                    .build();
            try{
                client.execute(deleteQuery);
            }catch (IOException e){
                Log.i("TODO","We actually failed here, deleting a photo");
                e.printStackTrace();
            }
            return null;
        }
    }

    /**GetProblemsTask:
     *
     *  get problemList from the data which related to the UserID
     *
     */
    // TODO we need a function which gets tweets from elastic search
    public static class getSpecificFullPhoto extends AsyncTask<Integer, Void, ArrayList<full_body_photo>> {
        @Override
        protected ArrayList<full_body_photo> doInBackground(Integer... search_parameters) {
            verifySettings();

            ArrayList<full_body_photo> problems = new ArrayList<full_body_photo>();

            String query = "{\"query\": {\"bool\": {\"must\": [{\"term\": {\"userID\": " +
                    search_parameters[0] + "} },{\"term\": {\"photoID\": " + search_parameters[1] + "}}]}}}";

            Search search = new Search.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("FullPhoto")
                    .build();


            Log.i("elasticSearcgh", "IN HERER");

            try {
                // TODO get the results of the query


                SearchResult result = client.execute(search);

                Log.i("elasticSearch", "Exceuted search");
                if (result.isSucceeded()) {
                    Log.i("elasticSearch", "checking contenst");

                    List<full_body_photo> foundTweets = result.getSourceAsObjectList(full_body_photo.class);
                    problems.addAll(foundTweets);
                } else {
                    Log.i("Error", "The search query failed to find any tweets for some reason.");
                }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }


            Log.i("elasticSearch", "Returned" + problems);
            return problems;
        }
    }

    /**setTransferTask:
     * create a trasfer info to data stream
     *
     */

    public static class setFullBody extends AsyncTask<full_body_photo, Void, Void> {

        @Override
        protected Void doInBackground(full_body_photo... full_body_photos) {
            ArrayList<full_body_photo> userArrayList = new ArrayList<full_body_photo>();

            verifySettings();

            for (full_body_photo photo : full_body_photos) {
                getSpecificFullPhoto getUserTask
                        = new getSpecificFullPhoto();
                getUserTask.execute(photo.getUserID(),photo.getPhotoID());

                Index index = new Index.Builder(photo).index(cmput301f18t05).type("FullPhoto").build();

                try {
                    // where is the client?
                    DocumentResult result = client.execute(index);
                } catch (Exception e) {
                    Log.w("elasticSearch", "Error trying to execute search.");
                }
            }

            return null;
        }
    }

    /**deleteUserTask：
     * delete User's info from the data stream with the UserID
     *
     */
    public static class deleteSpecificFullPhoto extends AsyncTask<Integer, Void, ArrayList<full_body_photo>> {
        @Override
        protected ArrayList<full_body_photo> doInBackground(Integer... search_parameters) {
            verifySettings();

            String query = "{\"query\": {\"bool\": {\"must\": [{\"term\": {\"userID\": " +
                    search_parameters[0] + "} },{\"term\": {\"photoID\": " + search_parameters[1] + "}}]}}}";

            DeleteByQuery deleteQuery = new DeleteByQuery.Builder(query)
                    .addIndex(cmput301f18t05)
                    .addType("FullPhoto")
                    .build();
            try{
                client.execute(deleteQuery);
            }catch (IOException e){
                Log.i("TODO","We actually failed here, deleting a photo");
                e.printStackTrace();
            }
            return null;
        }
    }
}
