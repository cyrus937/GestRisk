package com.example.gestrisk.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gestrisk.R;

import androidx.appcompat.app.AppCompatActivity;

public class Page3Activity extends AppCompatActivity  {

    public static String description;
    public static String caracteristique;

    private Button next;
    private Button previous;

    private ImageButton corona;
    private ImageButton radio;
    private ImageButton outils;
    private ImageButton sons;
    private ImageButton feu;
    private ImageButton electrique;
    private ImageButton chute;
    private Button autre;

    private EditText caract;

    public static Activity page3;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_3);

        page3 = this;

        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);

        corona = findViewById(R.id.corona);
        radio = findViewById(R.id.radioActivite);
        outils = findViewById(R.id.outils);
        sons = findViewById(R.id.sons);
        feu = findViewById(R.id.feu);
        electrique = findViewById(R.id.electrique);
        chute = findViewById(R.id.chute);

        autre = findViewById(R.id.autre);

        caract = findViewById(R.id.caracteristique);

        next.setEnabled(false);
        previous.setEnabled(false);

        corona.setClickable(true);

        corona.setScaleType(ImageView.ScaleType.CENTER_CROP);
        radio.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //outils.setScaleType(ImageView.ScaleType.CENTER_CROP);
        sons.setScaleType(ImageView.ScaleType.CENTER_CROP);
        feu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        electrique.setScaleType(ImageView.ScaleType.CENTER_CROP);
        chute.setScaleType(ImageView.ScaleType.CENTER_CROP);


        corona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque de COVID-19";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque chimique";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        outils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque mécanique";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        sons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque sonore";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        feu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque d'incendie / explosion";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        electrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque électrique";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        chute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Risque de chute";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        autre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                description = "Autre risque";
                Toast.makeText(getApplicationContext(),description,Toast.LENGTH_SHORT).show();

            }
        });

        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!description.isEmpty())
                {
                    caracteristique = caract.getText().toString();
                    Intent page3ActivityIntent = new Intent(Page3Activity.this, Page4Activity.class);
                    startActivity(page3ActivityIntent);
                }
                else {
                    //caract.setError("");
                    Toast.makeText(getApplicationContext(),"Veuillez renseignez la description",Toast.LENGTH_SHORT).show();
                }
            }
        });

        previous.setEnabled(true);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(Page3Activity.this, Page2Activity.class);
                startActivity(page1ActivityIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("Page3Activity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Page3Activity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("Page3Activity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("Page3Activity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("Page3Activity::onDestroy()");
    }
/*
    @Override
    public void onClick(View v) {

        if (corona.isClickable())
        {
            description = "Risque de COVID-19";
        }
        if (radio.isSelected())
        {

        }
        if (outils.isSelected())
        {

        }
        if (sons.isSelected())

        if (feu.isSelected())

        if (electrique.isSelected())

        if (chute.isSelected())

        if (autre.isSelected())

        //Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
    }*/
}
