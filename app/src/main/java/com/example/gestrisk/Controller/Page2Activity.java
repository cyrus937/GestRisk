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

public class Page2Activity extends AppCompatActivity {

    public static String local;

    private Button next;
    private Button previous;

    private EditText localisation;

    public static Activity page2;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);

        page2 = this;

        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);
        localisation = findViewById(R.id.localisation);

        next.setEnabled(false);
        previous.setEnabled(false);

        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!localisation.getText().toString().isEmpty())
                {
                    local = localisation.getText().toString();
                    Intent page3ActivityIntent = new Intent(Page2Activity.this, Page3Activity.class);
                    startActivity(page3ActivityIntent);
                }
                else {
                    localisation.setError("");
                    Toast.makeText(getApplicationContext(),"Veuillez renseignez la localisation",Toast.LENGTH_SHORT).show();
                }
            }
        });

        previous.setEnabled(true);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(Page2Activity.this, Page1Activity.class);
                startActivity(page1ActivityIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("Page2Activity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Page2Activity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("Page2Activity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("Page2Activity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("Page2Activity::onDestroy()");
    }
}
