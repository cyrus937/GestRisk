package com.example.gestrisk.Controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gestrisk.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Page4Activity extends AppCompatActivity {

    public static String evaluation;

    private Button next;
    private Button previous;

    private Button negligeable1;
    private Button faible1;
    private Button moyen1;
    private Button grave1;
    private Button tresGrave1;

    private Button negligeable2;
    private Button faible2;
    private Button moyen2;
    private Button grave2;
    private Button tresGrave2;

    private TextView bilan;

    public static Activity page4;

    public ArrayList <Boolean> test = new ArrayList<Boolean>();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_4);

        page4 = this;

        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);

        negligeable1 = findViewById(R.id.negligeable1);
        faible1 = findViewById(R.id.faible1);
        moyen1 = findViewById(R.id.moyen1);
        grave1 = findViewById(R.id.grave1);
        tresGrave1 = findViewById(R.id.tresGrave1);

        negligeable2 = findViewById(R.id.negligeable2);
        faible2 = findViewById(R.id.faible2);
        moyen2 = findViewById(R.id.moyen2);
        grave2 = findViewById(R.id.grave2);
        tresGrave2 = findViewById(R.id.tresGrave2);

        bilan = findViewById(R.id.bilan);

        next.setEnabled(false);
        previous.setEnabled(false);

        init();


        negligeable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable1.getBackground().setAlpha(250);
                faible1.getBackground().setAlpha(125);
                moyen1.getBackground().setAlpha(125);
                grave1.getBackground().setAlpha(125);
                tresGrave1.getBackground().setAlpha(125);

                init2(0, 5, 0);

                color();

            }
        });

        faible1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable1.getBackground().setAlpha(125);
                faible1.getBackground().setAlpha(250);
                moyen1.getBackground().setAlpha(125);
                grave1.getBackground().setAlpha(125);
                tresGrave1.getBackground().setAlpha(125);

                init2(0, 5, 1);

                color();
            }
        });

        moyen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable1.getBackground().setAlpha(125);
                faible1.getBackground().setAlpha(125);
                moyen1.getBackground().setAlpha(250);
                grave1.getBackground().setAlpha(125);
                tresGrave1.getBackground().setAlpha(125);

                init2(0, 5, 2);

                color();
            }
        });

        grave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable1.getBackground().setAlpha(125);
                faible1.getBackground().setAlpha(125);
                moyen1.getBackground().setAlpha(125);
                grave1.getBackground().setAlpha(250);
                tresGrave1.getBackground().setAlpha(125);

                init2(0, 5, 3);

                color();
            }
        });

        tresGrave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable1.getBackground().setAlpha(125);
                faible1.getBackground().setAlpha(125);
                moyen1.getBackground().setAlpha(125);
                grave1.getBackground().setAlpha(125);
                tresGrave1.getBackground().setAlpha(250);

                init2(0, 5, 4);

                color();
            }
        });

        negligeable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable2.getBackground().setAlpha(250);
                faible2.getBackground().setAlpha(125);
                moyen2.getBackground().setAlpha(125);
                grave2.getBackground().setAlpha(125);
                tresGrave2.getBackground().setAlpha(125);

                init2(5, 10, 5);

                color();

            }
        });

        faible2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable2.getBackground().setAlpha(125);
                faible2.getBackground().setAlpha(250);
                moyen2.getBackground().setAlpha(125);
                grave2.getBackground().setAlpha(125);
                tresGrave2.getBackground().setAlpha(125);

                init2(5, 10, 6);

                color();
            }
        });

        moyen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable2.getBackground().setAlpha(125);
                faible1.getBackground().setAlpha(125);
                moyen2.getBackground().setAlpha(250);
                grave2.getBackground().setAlpha(125);
                tresGrave2.getBackground().setAlpha(125);

                init2(5, 10, 7);

                color();
            }
        });

        grave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable2.getBackground().setAlpha(125);
                faible2.getBackground().setAlpha(125);
                moyen2.getBackground().setAlpha(125);
                grave2.getBackground().setAlpha(250);
                tresGrave2.getBackground().setAlpha(125);

                init2(5, 10, 8);

                color();
            }
        });

        tresGrave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negligeable2.getBackground().setAlpha(125);
                faible2.getBackground().setAlpha(125);
                moyen2.getBackground().setAlpha(125);
                grave2.getBackground().setAlpha(125);
                tresGrave2.getBackground().setAlpha(250);

                init2(5, 10, 9);

                color();
            }
        });

        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(evaluation == null))
                {
                    Intent page3ActivityIntent = new Intent(Page4Activity.this, Page5Activity.class);
                    startActivity(page3ActivityIntent);
                }
                else {
                    bilan.setError("");

                }
            }
        });

        previous.setEnabled(true);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(Page4Activity.this, Page3Activity.class);
                startActivity(page1ActivityIntent);
            }
        });
    }

    private void init() {
        negligeable1.getBackground().setAlpha(125);
        faible1.getBackground().setAlpha(125);
        moyen1.getBackground().setAlpha(125);
        grave1.getBackground().setAlpha(125);
        tresGrave1.getBackground().setAlpha(125);

        negligeable2.getBackground().setAlpha(125);
        faible2.getBackground().setAlpha(125);
        moyen2.getBackground().setAlpha(125);
        grave2.getBackground().setAlpha(125);
        tresGrave2.getBackground().setAlpha(125);

        for (int i = 0;i < 10; i++)
            test.add(false);
    }

    public void color()
    {
        negligeable1.setClickable(true);
        faible1.setClickable(true);
        moyen1.setClickable(true);
        grave1.setClickable(true);
        tresGrave1.setClickable(true);

        negligeable2.setClickable(true);
        faible2.setClickable(true);
        moyen2.setClickable(true);
        grave2.setClickable(true);
        tresGrave2.setClickable(true);

        if ((test.get(0) && test.get(5)))
        {
            bilan.setText("Négligeable");
            evaluation = "Négligeable";
            bilan.setTextColor(Color.WHITE);
            bilan.setBackgroundColor(getResources().getColor(R.color.greenDark));
        }

        if((test.get(1) && (test.get(6) || test.get(7))) ||
                (test.get(2) && test.get(6)) || (test.get(0) && test.get(8)) ||
                (test.get(0) && test.get(7)) || (test.get(3) && test.get(5)) ||
                (test.get(2) && test.get(5))
                || (test.get(1) && test.get(5))
                || (test.get(6) && test.get(0)))
        {
            bilan.setText("Faible");
            evaluation = "Faible";
            bilan.setTextColor(Color.WHITE);
            bilan.setBackgroundColor(getResources().getColor(R.color.greenLight));
        }
        if ((test.get(2) && (test.get(7) || test.get(8))) || (test.get(1) && test.get(9)) ||
                (test.get(3) && test.get(7)) || (test.get(0) && test.get(9)) ||
                (test.get(1) && test.get(8)) || (test.get(4) && test.get(5)) ||
                (test.get(6) && test.get(3)) || (test.get(4) && test.get(6)))
        {
            bilan.setText("Moyen");
            evaluation = "Moyen";
            bilan.setTextColor(Color.WHITE);
            bilan.setBackgroundColor(getResources().getColor(R.color.orangeLight));
        }
        if((test.get(3) && (test.get(8) || test.get(9))) ||
                (test.get(4) && test.get(8)))
        {
            bilan.setText("Grave");
            evaluation = "Grave";
            bilan.setTextColor(Color.WHITE);
            bilan.setBackgroundColor(getResources().getColor(R.color.redLight));
        }
        if (test.get(4) && test.get(9))
        {
            bilan.setText("Très Grave");
            evaluation = "Très Grave";
            bilan.setTextColor(Color.WHITE);
            bilan.setBackgroundColor(getResources().getColor(R.color.redDark));
        }
    }

    public void init2 (int start, int end, int n)
    {
        for (int i = start; i<end; i++)
            test.set(i, false);

        test.set(n, true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("Page4Activity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Page4Activity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("Page4Activity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("Page4Activity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("Page4Activity::onDestroy()");
    }
}
