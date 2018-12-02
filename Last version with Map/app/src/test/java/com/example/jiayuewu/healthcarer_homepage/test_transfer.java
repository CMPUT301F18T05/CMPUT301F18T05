package com.example.jiayuewu.healthcarer_homepage;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class test_transfer {

    @Test
    public void createTransfer() {
        transferObject t = new transferObject(123,324);

        //Uploads record online.
        elasticSearch.setTransferTask addTweetsTask
                = new elasticSearch.setTransferTask();
        addTweetsTask.execute(t);
    }

    @Test
    public void test_transfer() {
         transferObject t = new transferObject(123,324);
         transferObject t2 = new transferObject();
        ArrayList<transferObject> transferList = new ArrayList<transferObject>();

        //Uploads record online.
        elasticSearch.setTransferTask addTweetsTask
                = new elasticSearch.setTransferTask();
        addTweetsTask.execute(t);

        Integer x = 324;

        //Get record from elastic search.
        elasticSearch.getTransferTask getProblemsTask
                = new elasticSearch.getTransferTask();
        getProblemsTask.execute(x);

        try {
            transferList = getProblemsTask.get();
            t2  = transferList.get(0);
        } catch (Exception e) {
            Log.i("Broke", "Code OOPS");
//            assertTrue(Boolean.FALSE);
        }

        Log.i("GOT HERE", "Value is " + t2.getUserID());
        assertEquals("" + 324, "" + t2.getUserID());


    }
}
