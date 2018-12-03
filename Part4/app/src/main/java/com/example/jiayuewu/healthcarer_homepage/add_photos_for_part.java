package com.example.jiayuewu.healthcarer_homepage;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class add_photos_for_part extends AppCompatActivity {
    // slideshow learned from https://www.youtube.com/watch?v=Q2FPDI99-as
    // and https://stackoverflow.com/questions/17610085/how-to-switch-automatically-between-viewpager-pages
    private Handler handler;
    private ViewPager viewPager;
    private ImageAdapter adapter;
    private int delay = 2500; //milliseconds
    private int page = 0;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private Drawable d;
    private ArrayList<photo_object> foundImages = new ArrayList<>();
    private int GALLERY = 1;
    Runnable runnable = new Runnable() {
        public void run() {
            if (adapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photos_for_part);
        setTitle("Add Photos");
        FloatingActionButton upload = findViewById(R.id.add_photos_upload);
//        setContentView(R.layout.activity_slideshow);
        handler = new Handler();
        FloatingActionButton play = findViewById(R.id.slideshow_play);
        FloatingActionButton stop = findViewById(R.id.slideshow_stop);
        viewPager = findViewById(R.id.slideshow_viewpager);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // placeholder
                requestMultiplePermissions();
                Snackbar.make(v, "Upload Button Action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                showPictureDialog();
            }
        });

        Record record = DataHolder_Record.getData();

        elasticSearch.getPhoto task = new elasticSearch.getPhoto();
        String bodyPart = getIntent().getStringExtra("part");
        task.execute(""+ record.getUserID(), ""+ record.getProblemID(),""+  record.getRecordID(), bodyPart);

        try {
            foundImages = task.get();
        } catch (Exception e) {
            Log.i("ADD PHOTO", "FERP");
        }

        ArrayList<Drawable> listOfDrawable = new ArrayList<>();
        ArrayList<Bitmap> listOfBitmaps = new ArrayList<>();

        try {
            for (photo_object po : foundImages) {
                String compressed = po.getBitmap();
                Bitmap image = convertStringToBitmap(compressed);
                Drawable d = (Drawable) new BitmapDrawable(image);
                listOfDrawable.add(d);
                listOfBitmaps.add(image);
            }
        } catch (Exception e) {
        }


//        ViewFlipper imageFlipper = (ViewFlipper)findViewById( R.id.image_flipper );
//
//        for (Bitmap photo : listOfBitmaps) {//or something like this
//            ImageView image = new ImageView ( getApplicationContext() );
//            image.setImageBitmap( photo );
//            imageFlipper.addView( image );
//        }
//
//        imageFlipper.setFlipInterval( 5000 ); //5s intervals
//        imageFlipper.startFlipping();

//        int[] imageIds = convertIntegers(listOfDrawable);


        int[] imageIds = new int[] {R.drawable.full_body, R.drawable.full_body_back};


        adapter = new ImageAdapter(this, imageIds);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                page = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        onPause();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private void  requestMultiplePermissions(){
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                    }
                })
                .onSameThread()
                .check();
    }

    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                                startActivityForResult(galleryIntent, GALLERY);
//                                Intent intent = new Intent();
//                                // Show only images, no videos or anything else
//                                intent.setType("image/*");
//                                intent.setAction(Intent.ACTION_GET_CONTENT);
//                                // Always show the chooser (if there are multiple options available)
//                                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                                break;
                            case 1:
                                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, 0);
                                break;
                        }
                    }
                });
//        pictureDialog.create();
        pictureDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    d = (Drawable) new BitmapDrawable(bitmap);
//                    String path = saveImage(bitmap);
//                    imageview.setImageBitmap(bitmap);




                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else if (requestCode == 0) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            d = (Drawable) new BitmapDrawable(bitmap);
//            imageview.setImageBitmap(thumbnail);
//            saveImage(thumbnail);

        }
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
