package com.example.jiayuewu.healthcarer_homepage;

import android.content.Intent;
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

public class homepage_patient_my_body_content extends Fragment{
    public Button sbutton;
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
    public FloatingActionButton all_problems_button;
    public FloatingActionButton turn_around;
    public FloatingActionButton upload;



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
        body_back = getResources().getDrawable(R.drawable.body_back);

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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front Head");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Head Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back Head");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front Torso");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Torso Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back Torso");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front right Arm");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back Left Arm");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front right hand");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back left hand");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front left arm");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back right arm");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front left hand");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back right hand");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front right leg");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back left leg");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front right foot");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back left foot");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front left leg");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back right leg");
                    startActivityForResult(problem_part, 0);
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
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Front left foot");
                    startActivityForResult(problem_part, 0);
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent problem_part = new Intent(homepage_patient_my_body_content.this.getActivity(), problems_for_part.class);
                    problem_part.putExtra("part", "Back right foot");
                    startActivityForResult(problem_part, 0);
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


        turn_around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!turned){
                    bodyimg.setImageDrawable(body_back);
                    turned = true;
                    Snackbar.make(v, "Turned Around", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    bodyimg.setImageDrawable(body_front);
                    turned = false;
                    Snackbar.make(v, "Turned Around", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });
        return rootView;
    }
}
