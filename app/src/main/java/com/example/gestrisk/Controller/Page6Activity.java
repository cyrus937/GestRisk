package com.example.gestrisk.Controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gestrisk.R;
import com.example.gestrisk.model.DAO;
import com.example.gestrisk.model.JavaMailAPI;
import com.example.gestrisk.model.Risque;
import com.example.gestrisk.model.RisqueDAO;
import com.example.gestrisk.model.User;
import com.example.gestrisk.model.UserDAO;
import com.example.gestrisk.model.UserRisqueDAO;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.gestrisk.Controller.Page1Activity.imageUri;

public class Page6Activity extends AppCompatActivity {

    private Button next;
    private Button previous;
    private Button cancel;

    private EditText emailRespon;

    private TextView bDate;
    private TextView bDescription;
    private TextView bLocalisation;
    private TextView bCaracterrisation;
    private TextView bEvaluation;
    private TextView bDisposition;

    private ImageView bImageView;

    private Risque mRisque;

    private RisqueDAO mDAO;

    private UserRisqueDAO mUserRisqueDAO;

    private UserDAO mUserDAO;

    private User user;

    private String message;

    public static ImageView image;

    public static Activity page6;

    public static boolean active = false;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_6);

        page6 = this;

        mUserDAO = new UserDAO(this);

        mDAO = new RisqueDAO(this);

        mUserRisqueDAO = new UserRisqueDAO(this);

        next = (Button)findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);
        cancel = (Button)findViewById(R.id.annuler);

        bDate = findViewById(R.id.bDate);
        bDescription = findViewById(R.id.bDescription);
        bLocalisation = findViewById(R.id.bLocalisation);
        bCaracterrisation = findViewById(R.id.bCaracterisation);
        bEvaluation = findViewById(R.id.bEvaluation);
        bDisposition = findViewById(R.id.bDisposition);

        bImageView = findViewById(R.id.bImageView);

        emailRespon = findViewById(R.id.emailRespon);

        next.setEnabled(false);
        previous.setEnabled(false);
        cancel.setEnabled(false);

        init();

        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emailRespon.getText().toString().isEmpty())
                {
                    int idUser,idRisque;
                    mRisque.setEmailRespon(emailRespon.getText().toString());
                    mDAO.ajouterRisque(mRisque);
                    idRisque = mDAO.findLastInsertRisque();
                    if (MainActivity.user == null)
                        user = SignUpActivity.user;
                    else
                        user = MainActivity.user;
                    idUser = mUserDAO.findIdUser(user.getNom(), user.getPassword());
                    System.out.println("idRisque = "+idRisque+"\nidUser = "+idUser );
                    mUserRisqueDAO.ajouterUserRisque(idUser,idRisque);

                    image = bImageView;
                    sendEmail();
                    Page1Activity.page1.finish();
                    Page2Activity.page2.finish();
                    Page3Activity.page3.finish();
                    Page4Activity.page4.finish();
                    Page5Activity.page5.finish();

                    Intent page3ActivityIntent = new Intent(Page6Activity.this, SignalActivity.class);
                    startActivity(page3ActivityIntent);

                }
            }
        });

        previous.setEnabled(true);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(Page6Activity.this, Page5Activity.class);
                startActivity(page1ActivityIntent);
            }
        });

        cancel.setEnabled(true);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(Page6Activity.this, SignalActivity.class);
                startActivity(page1ActivityIntent);
                finish();
            }
        });
    }

    private void sendEmail() {
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, emailRespon.getText().toString().trim(),"Présence d'un risque au sein de l'entreprise"
        ,message);

        javaMailAPI.execute();
    }

    private void init() {

        Timestamp date = new Timestamp(System.currentTimeMillis());
        bDate.setText(date.toString());
        bDescription.setText(Page3Activity.description);
        bLocalisation.setText(Page2Activity.local);
        bCaracterrisation.setText(Page3Activity.caracteristique);
        bEvaluation.setText(Page4Activity.evaluation);
        bDisposition.setText(Page5Activity.mesureCompensatoire+"\n"+Page5Activity.mesurePreventive);
        bImageView.setImageURI(imageUri);
        bImageView.setAdjustViewBounds(true);

        mRisque = new Risque(imageUri.toString(),Page2Activity.local,Page3Activity.description,Page3Activity.caracteristique,
                Page4Activity.evaluation, Page5Activity.mesureCompensatoire, Page5Activity.mesurePreventive,date,null);

        message = "Date : "+mRisque.getDate()+"\n" +
                "Localisation : "+mRisque.getLocalisation()+"\n" +
                "Description : "+mRisque.getDescription()+"\n" +
                "Caractérisation : "+mRisque.getCaracterisation()+"\n" +
                "Evaluation : "+mRisque.getEvaluation()+"\n" +
                "Disposition à prendre face au risque : \n" +
                "\t\tMesure Compensatoire : "+Page5Activity.mesureCompensatoire+"\n" +
                "\t\tMesure Préventive : "+Page5Activity.mesurePreventive;
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("Page6Activity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("Page6Activity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        active = true;
        System.out.println("Page6Activity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("Page6Activity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("Page6Activity::onDestroy()");
    }
}
