package com.example.gestrisk.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestrisk.R;

import androidx.appcompat.app.AppCompatActivity;

public class Page5Activity extends AppCompatActivity {

    public static String mesureCompensatoire;
    public static String mesurePreventive;

    private Button next;
    private Button previous;

    private EditText mesureComp;
    private EditText mesurePre;

    public static Activity page5;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_5);

        page5 = this;

        mesureComp = findViewById(R.id.mesureComp);
        mesurePre = findViewById(R.id.mesurePre);

        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);

        next.setEnabled(false);
        previous.setEnabled(false);

        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!Error(mesureComp, mesurePre))
                {
                    mesureCompensatoire = mesureComp.getText().toString();
                    mesurePreventive = mesurePre.getText().toString();
                    Intent page3ActivityIntent = new Intent(Page5Activity.this, Page6Activity.class);
                    startActivity(page3ActivityIntent);
                }
                {
                    Toast.makeText(getApplicationContext(),"ERROR !",Toast.LENGTH_SHORT).show();
                }
            }
        });

        previous.setEnabled(true);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(Page5Activity.this, Page4Activity.class);
                startActivity(page1ActivityIntent);
            }
        });
    }

    public boolean Error (EditText mesureComp, EditText mesurePre)
    {
        boolean estVide = true;
        if (mesureComp.getText().toString() == null && mesurePre.getText().toString() == null)
        {
            mesureComp.setError("");
            mesurePre.setError("");
        }
        else if (mesureComp.getText().toString() == null)
        {
            mesureComp.setError("");
        }
        else if (mesurePre.getText().toString() == null)
        {
            mesurePre.setError("");
        }
        else
            estVide = false;

        return estVide;
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("Page5Activity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Page5Activity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("Page5Activity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("Page5Activity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("Page5Activity::onDestroy()");
    }
}
