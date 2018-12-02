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
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class homepage_patient_my_body_content extends Fragment{
    public Button sbutton;
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
    public FloatingActionButton all_problems_button;
    public FloatingActionButton turn_around;
    public FloatingActionButton upload;
    public PhotoView photoViewFront;
    public PhotoView photoViewBack;
    public Matrix front_matrix;
    public Matrix back_matrix;
    public User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homepage_patient_my_body, container, false);
        sbutton = rootView.findViewById(R.id.search_button);
        bodyimg = rootView.findViewById(R.id.body_image);
        head_spot_button = rootView.findViewById(R.id.head_spot);
        torso_spot_button = rootView.findViewById(R.id.torso_spot);
        left_arm_spot_button = rootView.findViewById(R.id.left_arm_spot);
        left_hand_spot_button = rootView.findViewById(R.id.left_hand_spot);
        right_arm_spot_button = rootView.findViewById(R.id.right_arm_spot);
        right_hand_spot_button = rootView.findViewById(R.id.right_hand_spot);
        left_leg_spot_button = rootView.findViewById(R.id.left_leg_spot);
        left_foot_spot_button = rootView.findViewById(R.id.left_foot_spot);
        right_leg_spot_button = rootView.findViewById(R.id.right_leg_spot);
        right_foot_spot_button = rootView.findViewById(R.id.right_foot_spot);
        all_problems_button = rootView.findViewById(R.id.all_problems_button);
        turn_around = rootView.findViewById(R.id.turn_around_button);
        upload = rootView.findViewById(R.id.upload_button);
        body_front = getResources().getDrawable(R.drawable.body_front);
        rbody_front = getResources().getDrawable(R.drawable.full_body);
        body_back = getResources().getDrawable(R.drawable.body_back);
        rbody_back = getResources().getDrawable(R.drawable.full_body_back);

        photoViewFront = rootView.findViewById(R.id.photoViewFront);
        photoViewBack = rootView.findViewById(R.id.photoViewBack);
        editButton = rootView.findViewById(R.id.edit_button);
        //imageView = rootView.findViewById(R.id.imageView);
        photoViewFront.setZoomable(false);
        photoViewBack.setZoomable(false);
        photoViewBack.setImageDrawable(rbody_back);
        photoViewFront.setImageDrawable(rbody_front);
        front_matrix = new Matrix();
        back_matrix = new Matrix();

        user = DataHolder.getData();



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
                        try {
                            Bitmap viewCapture = null;

                            photoViewFront.setDrawingCacheEnabled(true);
                            viewCapture = Bitmap.createBitmap(photoViewFront.getDrawingCache());
                            photoViewFront.setDrawingCacheEnabled(false);

                            Drawable d = (Drawable) new BitmapDrawable(viewCapture);

                            photoViewFront.setImageDrawable(d);

                            Snackbar.make(v, "Saving front photo.", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();

                            uploadPaperDoll(user.getUserID(), -1, viewCapture);
                        } catch (Exception e) {
                            Snackbar.make(v, "Could not save front photo.", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
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
                        try {
                            Bitmap viewCapture = null;

                            photoViewBack.setDrawingCacheEnabled(true);
                            viewCapture = Bitmap.createBitmap(photoViewBack.getDrawingCache());
                            photoViewBack.setDrawingCacheEnabled(false);

                            Drawable d = (Drawable) new BitmapDrawable(viewCapture);

                            photoViewBack.setImageDrawable(d);



                            uploadPaperDoll(user.getUserID(), 1, viewCapture);

                            Snackbar.make(v, "Saving back photo.", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } catch (Exception e) {
                            Snackbar.make(v, "Could not save back photo.", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
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

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // placeholder
                Intent search_intent = new Intent(homepage_patient_my_body_content.this.getActivity(), search_result.class);
                startActivityForResult(search_intent, 0);
            }
        });

        head_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Head Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front Head");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Head Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back Head");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front Torso");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Torso Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back Torso");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front right Arm");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back Left Arm");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front right hand");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back left hand");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front left arm");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back right arm");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front left hand");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back right hand");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front right leg");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back left leg");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front right foot");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back left foot");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front left leg");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back right leg");
                    //startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Front left foot");
                    //startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), records_for_part.class);
                    problem_part.putExtra("part", "Back right foot");
                    //startActivityForResult(problem_part, 0);
                }
            }
        });

        all_problems_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent all_problems_intent = new Intent(homepage_patient_my_body_content.this.getActivity(), all_problems.class);
                startActivityForResult(all_problems_intent, 0);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // placeholder
                Snackbar.make(v, "Upload Button Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return rootView;
    }

    public void uploadPaperDoll(Integer userID, Integer photoID, Bitmap image){
        full_body_photo newPhoto = new full_body_photo(userID, photoID, image);

        elasticSearch.setFullBody getUserTask
                = new elasticSearch.setFullBody();
        getUserTask.execute(newPhoto);
    }

}
