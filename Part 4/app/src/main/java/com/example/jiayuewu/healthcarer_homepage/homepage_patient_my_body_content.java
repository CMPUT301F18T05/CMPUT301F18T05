package com.example.jiayuewu.healthcarer_homepage;

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
        turn_around = rootView.findViewById(R.id.turn_around_button);
        upload = rootView.findViewById(R.id.upload_button);
        body_front = getResources().getDrawable(R.drawable.body_front);
        body_back = getResources().getDrawable(R.drawable.body_back);

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // placeholder
                Snackbar.make(v, "Search Button Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        head_spot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!turned){
                    // placeholder
                    Snackbar.make(v, "Head Spot Front", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    // placeholder
                    Snackbar.make(v, "Head Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Torso Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Arm Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Hand Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Left Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Leg Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
                } else {
                    // placeholder
                    Snackbar.make(v, "Right Foot Spot Back", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
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
