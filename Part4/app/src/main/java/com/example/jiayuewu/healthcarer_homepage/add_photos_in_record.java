/**
 * homepage_patient_my_body_content
 *This part user can see a human's body which has red points to show every important parts for
 * human's body. User can  turn around this body and click red points to see this part's name and
 * add problems by clicking the "add" button.
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

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class add_photos_in_record extends AppCompatActivity {
    public Button editButton;
    public boolean turned = false;
    public ImageView bodyimg;
    public ImageButton head_spot_button;
    public ImageButton torso_spot_button;
    public ImageButton left_arm_spot_button;
    public ImageButton left_hand_spot_button;
    public ImageButton right_arm_spot_button;
    public ImageButton right_hand_spot_button;
    public ImageButton left_leg_spot_button;
    public ImageButton left_foot_spot_button;
    public ImageButton right_leg_spot_button;
    public ImageButton right_foot_spot_button;
    public Drawable body_front;
    public Drawable body_back;
    public Drawable rbody_back;
    public Drawable rbody_front;
    public FloatingActionButton turn_around;
    public PhotoView photoViewFront;
    public PhotoView photoViewBack;
    public Matrix front_matrix;
    public Matrix back_matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_photos_in_record);
        setTitle("Add Photos");

        bodyimg = findViewById(R.id.body_image);
        head_spot_button = findViewById(R.id.head_spot);
        torso_spot_button = findViewById(R.id.torso_spot);
        left_arm_spot_button = findViewById(R.id.left_arm_spot);
        left_hand_spot_button = findViewById(R.id.left_hand_spot);
        right_arm_spot_button = findViewById(R.id.right_arm_spot);
        right_hand_spot_button = findViewById(R.id.right_hand_spot);
        left_leg_spot_button = findViewById(R.id.left_leg_spot);
        left_foot_spot_button = findViewById(R.id.left_foot_spot);
        right_leg_spot_button = findViewById(R.id.right_leg_spot);
        right_foot_spot_button = findViewById(R.id.right_foot_spot);
        turn_around = findViewById(R.id.turn_around_button);
        body_front = getResources().getDrawable(R.drawable.body_front);
        rbody_front = getResources().getDrawable(R.drawable.full_body);
        body_back = getResources().getDrawable(R.drawable.body_back);
        rbody_back = getResources().getDrawable(R.drawable.full_body_back);

        photoViewFront = findViewById(R.id.photoViewFront);
        photoViewBack = findViewById(R.id.photoViewBack);
        editButton = findViewById(R.id.edit_button);
        //imageView = findViewById(R.id.imageView);
        photoViewFront.setZoomable(false);
        photoViewBack.setZoomable(false);
        photoViewBack.setImageDrawable(rbody_back);
        photoViewFront.setImageDrawable(rbody_front);
        front_matrix = new Matrix();
        back_matrix = new Matrix();

        ArrayList<full_body_photo> listFullBodyFront = new ArrayList<>();

        elasticSearch.getSpecificFullPhoto getFrontTask
                = new elasticSearch.getSpecificFullPhoto();
        getFrontTask.execute(DataHolder.getData().getUserID(),1);

        try {
            listFullBodyFront = getFrontTask.get();
        } catch (Exception e) {
            Log.i("Homepage_patient_my", "No front user photos found");
        }

        if (listFullBodyFront.isEmpty()) {
            photoViewFront.setImageDrawable(rbody_front);
        } else {
            Drawable d = (Drawable) new BitmapDrawable(convertStringToBitmap(listFullBodyFront.get(0).getBitmap()));
            photoViewFront.setImageDrawable(d);
        }

        ArrayList<full_body_photo> listFullBodyBack = new ArrayList<>();

        elasticSearch.getSpecificFullPhoto getBackTask
                = new elasticSearch.getSpecificFullPhoto();
        getBackTask.execute(DataHolder.getData().getUserID(),-1);

        try {
            listFullBodyBack = getBackTask.get();
        } catch (Exception e) {
            Log.i("Homepage_patient_my", "No front user photos found");
        }

        if (listFullBodyBack.isEmpty()) {
            Log.i("HOMEPAGE", "NOTHING FOUND, SO DEFAULTED");
            photoViewBack.setImageDrawable(rbody_back);
        } else {
            Drawable d = (Drawable) new BitmapDrawable(convertStringToBitmap(listFullBodyBack.get(0).getBitmap()));
            photoViewBack.setImageDrawable(d);
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mIcon.setZoomable(false);
                if (!turned) {
                    if (photoViewFront.isZoomable()) {
                        photoViewFront.getSuppMatrix(front_matrix);
                        photoViewFront.setZoomable(false);
                        photoViewFront.setDisplayMatrix(front_matrix);
                        bodyimg.setVisibility(View.INVISIBLE);
                    } else {
                        photoViewFront.getSuppMatrix(front_matrix);
                        photoViewFront.setZoomable(true);
                        photoViewFront.setDisplayMatrix(front_matrix);
                        bodyimg.setVisibility(View.VISIBLE);
                    }
                } else {
                    if (photoViewBack.isZoomable()) {
                        photoViewBack.getSuppMatrix(back_matrix);
                        photoViewBack.setZoomable(false);
                        photoViewBack.setDisplayMatrix(back_matrix);
                        bodyimg.setVisibility(View.INVISIBLE);
                    } else {
                        photoViewBack.getSuppMatrix(back_matrix);
                        photoViewBack.setZoomable(true);
                        photoViewBack.setDisplayMatrix(back_matrix);
                        bodyimg.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        turn_around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    bodyimg.setImageDrawable(body_back);
                    photoViewFront.setVisibility(View.INVISIBLE);
                    photoViewBack.setVisibility(View.VISIBLE);
                    turned = true;
                    Snackbar.make(v, "Turned Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    bodyimg.setImageDrawable(body_front);
                    photoViewBack.setVisibility(View.INVISIBLE);
                    photoViewFront.setVisibility(View.VISIBLE);
                    turned = false;
                    Snackbar.make(v, "Turned Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        head_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Head Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front Head");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Head Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back Head");
                    startActivityForResult(ap, 0);
                }

            }
        });

        torso_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Torso Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front Torso");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Torso Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back Torso");
                    startActivityForResult(ap, 0);
                }

            }
        });

        left_arm_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Left Arm Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front right Arm");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back Left Arm");
                    startActivityForResult(ap, 0);
                }
            }
        });

        left_hand_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Left Hand Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front right hand");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back left hand");
                    startActivityForResult(ap, 0);
                }
           }
        });

        right_arm_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Right Arm Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front left arm");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back right arm");
                    startActivityForResult(ap, 0);
                }
            }
        });

        right_hand_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Right Hand Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front left hand");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back right hand");
                    startActivityForResult(ap, 0);
                }
            }
        });

        left_leg_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Left Leg Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front right leg");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back left leg");
                    startActivityForResult(ap, 0);
                }
            }
        });

        left_foot_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Left Foot Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front right foot");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back left foot");
                    startActivityForResult(ap, 0);
                }
            }
        });

        right_leg_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Right Leg Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front left leg");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back right leg");
                    startActivityForResult(ap, 0);
                }
            }
        });

        right_foot_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Right Foot Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Front left foot");
                    startActivityForResult(ap, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent ap = new Intent(add_photos_in_record.this, add_photos_for_part.class);
                    ap.putExtra("part", "Back right foot");
                    startActivityForResult(ap, 0);
                }
            }
        });

    }
    public String convertBitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

        byte[] byteArray = byteArrayOutputStream .toByteArray();
        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);

        return encoded;
    }

    public Bitmap convertStringToBitmap(String base64) {
        byte[] data = Base64.decode(base64, Base64.DEFAULT);
//        String text = new String(data, "UTF-8");

        Bitmap decodedByte = BitmapFactory.decodeByteArray(data, 0, data.length);

        return decodedByte;
    }
}
