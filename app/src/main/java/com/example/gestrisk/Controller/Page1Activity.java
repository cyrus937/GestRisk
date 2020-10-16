package com.example.gestrisk.Controller;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gestrisk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page1Activity extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;

    public static String photo;

    public static Activity page1;

    private Button next;
    private Button previous;
    private FloatingActionButton pictureButton;
    private ImageView mImageView;

    public static Uri imageUri;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_1);

        page1 = this;

        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);

        pictureButton = findViewById(R.id.pictureButton);
        mImageView = findViewById(R.id.image);

        next.setEnabled(false);
        previous.setEnabled(false);

        pictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED)
                    {
                        //permission not enabled , request it
                        String [] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        //show popup to request permissions
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else
                    {
                        //permission granted
                        openCamera();
                    }
                }
                else
                {
                    openCamera();
                }
            }
        });

        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page2ActivityIntent = new Intent(Page1Activity.this, Page2Activity.class);
                startActivity(page2ActivityIntent);
            }
        });

        previous.setEnabled(true);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signalActivityIntent = new Intent(Page1Activity.this, SignalActivity.class);
                startActivity(signalActivityIntent);
            }
        });
    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        // Camera intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }

    //handling permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //permission from popup was granted
                    openCamera();
                }
                else
                {
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {
            System.out.println("me voiciiiiiiiiiiii  "+imageUri);
            photo = imageUri.toString();
            mImageView.setImageURI(imageUri);
            mImageView.setAdjustViewBounds(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("Page1Activity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Page1Activity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("Page1Activity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("Page1Activity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("Page1Activity::onDestroy()");
    }
}
