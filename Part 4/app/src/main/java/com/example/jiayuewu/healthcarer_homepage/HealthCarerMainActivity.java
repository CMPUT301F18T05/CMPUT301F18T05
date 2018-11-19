<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 0196cf10a8c477e26e78c529dc61b2418f9e3ae9
//package com.quintus_software.cmput301f18t05.healthcarer;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
//import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlacePicker;
//
//import java.util.ArrayList;
//
//public class HealthCarerMainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_health_carer_main);
//    }
//
//
//    private final static int PLACE_PICKER_REQUEST = 999;
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        checkPermission(requestCode, resultCode, data);
////        checkPermission(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK) {
//            switch (requestCode){
//                case PLACE_PICKER_REQUEST:
//                    Place place = PlacePicker.getPlace(this, data);
//                    String placeName = String.format("Place: %s", place.getName());
//                    double latitude = place.getLatLng().latitude;
//                    double longitude = place.getLatLng().longitude;
//
//            }
//        }
//    }
//
//
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//        try {
//            // for activty
//            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
//            // for fragment
//            //startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
//        } catch (GooglePlayServicesRepairableException e) {
//            e.printStackTrace();
//        } catch (GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
//
//
////        ArrayList<Temp_ProblemClass> x;
//
//        //Anything else we need to call.
//    }
//
//}
//
<<<<<<< HEAD
=======
package com.quintus_software.cmput301f18t05.healthcarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;

public class HealthCarerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_health_carer_main);
    }


    private final static int PLACE_PICKER_REQUEST = 999;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        checkPermission(requestCode, resultCode, data);
//        checkPermission(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode){
                case PLACE_PICKER_REQUEST:
                    Place place = PlacePicker.getPlace(this, data);
                    String placeName = String.format("Place: %s", place.getName());
                    double latitude = place.getLatLng().latitude;
                    double longitude = place.getLatLng().longitude;

            }
        }
    }

    


    @Override
    protected void onStart() {
        super.onStart();

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            // for activty
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
            // for fragment
            //startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }


//        ArrayList<Temp_ProblemClass> x;

        //Anything else we need to call. 
    }   
    
}  

>>>>>>> 8db66fd2605cd6a10a24690a6c3af5052f3500af
=======
>>>>>>> 0196cf10a8c477e26e78c529dc61b2418f9e3ae9
