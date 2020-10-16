package com.example.gestrisk.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gestrisk.R;
import com.example.gestrisk.model.DAO;
import com.example.gestrisk.model.User;
import com.example.gestrisk.model.UserDAO;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nom;
    private EditText prenom;
    private EditText poste;
    private EditText zone;
    private EditText email;
    private EditText passWord;
    private EditText confPassWord;
    private Button valider;
    private Button cancel;

    private UserDAO mDAO ;
    public static User user;
    public static Activity signUp;
    public static boolean active = false;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = this;

        mDAO = new UserDAO(this);

        nom = (EditText)findViewById(R.id.nom);
        prenom = (EditText)findViewById(R.id.prenom);
        poste = (EditText)findViewById(R.id.poste);
        zone = (EditText)findViewById(R.id.zone);
        email = (EditText)findViewById(R.id.email);
        passWord = (EditText)findViewById(R.id.pwd);
        confPassWord = (EditText)findViewById(R.id.pwd1);
        valider = (Button) findViewById(R.id.ok);
        cancel = (Button) findViewById(R.id.cancel);

        valider.setEnabled(false);
        cancel.setEnabled(false);

        valider.setEnabled(true);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signalActivityIntent = new Intent(SignUpActivity.this, SignalActivity.class);
                if (creer())
                {
                    startActivity(signalActivityIntent);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signalActivityIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(signalActivityIntent);
            }
        });

    }

    public boolean creer (){

        if ((passWord.getText().toString().equals(confPassWord.getText().toString())) && !passWord.getText().toString().isEmpty() && (passWord.getText().toString() != null))
        {
            if(nom.getText().toString().isEmpty() || nom.getText().toString() == null)
            {
                nom.setError("Veuillez renseigner votre nom");

                if (email.getText().toString().isEmpty() || email.getText().toString() == null)
                    email.setError("");

            }
            else if (email.getText().toString().isEmpty() || email.getText().toString() == null) {
                email.setError("");
            }
            else {
                user = new User(nom.getText().toString(), prenom.getText().toString(), poste.getText().toString()
                        , zone.getText().toString(), email.getText().toString(), passWord.getText().toString());

                mDAO.ajouter(user);
                return true;
            }
        }
        else
        {
            passWord.setError("");
            confPassWord.setError("");
            if(nom.getText().toString().isEmpty() || nom.getText().toString() == null)
            {
                nom.setError("Veuillez renseigner votre nom");

            }
            if (email.getText().toString().isEmpty() || email.getText().toString() == null)
                email.setError("");
        }
        return false;
    }

    /*@Override
    public void onBackPressed ()
    {
        moveTaskToBack(true);
        System.exit(0);
    }*/

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("SignUpActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("SignUpActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        active = true;
        System.out.println("SignUpActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("SignUpActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("SignUpActivity::onDestroy()");
    }

    @Override
    public void onClick(View v) {

    }
}
