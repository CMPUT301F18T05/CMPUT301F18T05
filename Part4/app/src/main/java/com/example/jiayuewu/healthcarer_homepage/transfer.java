package com.example.jiayuewu.healthcarer_homepage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class transfer extends AppCompatActivity {
    private EditText transferText;
    private User user = new User();
    private ArrayList<User> userArrayList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        Button transfer = findViewById(R.id.transfer_button);
        transfer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                transferText = (EditText) findViewById(R.id.transfer_code_text);

                Integer code = 0;

                try {
                    code = Integer.parseInt(transferText.getText().toString());
                    transfer_with_code(code);
                } catch (Exception e) {
                    Snackbar.make(v, "UserID must only contain digits. NO letters please.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }

            public void transfer_with_code(Integer code) {
                /**
                 * Shows a simple alert message when the message is longer then the limit.
                 *
                 * @author: MysticMagic
                 */
                final AlertDialog alertDialog = new AlertDialog.Builder(transfer.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Cannot transfer. Check connectivity.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                Integer userid;
                ArrayList<transferObject> idArrayList = new ArrayList<transferObject>();
                transferObject t;

                elasticSearch.getTransferTask task
                        = new elasticSearch.getTransferTask();
                task.execute(code);

                try {
                   idArrayList = task.get();

                }	catch (Exception e) {
                    Log.e("Error", "Failed to get the user id out of the async object.");
                }

                t = idArrayList.get(0);
                userid = t.getUserID();

                elasticSearch.getUserTask getUserTask
                        = new elasticSearch.getUserTask();
                getUserTask.execute(userid);

                try {
                    userArrayList = getUserTask.get();

                }	catch (Exception e) {
                    Log.e("Error", "Failed to get the user out of the async object.");
                }

                try {
                    user = userArrayList.get(0);

                    Log.w("GOT USER", "" + user.getUserID());

                    DataHolder.setData(user);
                    if (user.getRole().equals("Patient")) {

                        try {
                            Intent patient_intent = new Intent(transfer.this, homepage_patient.class);
                            startActivity(patient_intent);
                        } catch (Exception e) {
                            Log.i ("Error in trying to open", "Patient homepage");
                        }
                    }
                    if (user.getRole().equals("Doctor")) {
                        try {
                            Intent doctor_intent = new Intent(transfer.this, homepage_doctor.class);
                            startActivity(doctor_intent);
                        } catch (Exception e) {
                            Log.i ("Error in trying to open", "Doctor homepage");
                        }
                    }
                } catch (Exception e) {
                    Log.i("User", "Not found");

                    alertDialog.show();
                }




            }
        });
    }
}
