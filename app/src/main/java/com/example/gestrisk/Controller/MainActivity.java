package com.example.gestrisk.Controller;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gestrisk.R;
import com.example.gestrisk.model.DAO;
import com.example.gestrisk.model.User;
import com.example.gestrisk.model.UserDAO;

import static java.lang.System.err;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private Button valide;
    private Button signup;

    private EditText username;
    private EditText pwd;

    private TextView error;

    private String name = "test";
    private String password = "test";

    public static User user;

    private UserDAO mDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mDAO = new UserDAO(this);

        valide = (Button) findViewById(R.id.button3);
        signup = (Button) findViewById(R.id.button4);

        username = (EditText)findViewById(R.id.username);
        pwd = (EditText)findViewById(R.id.pwd);

        //error = (TextView)findViewById(R.id.error);

       // error.setEnabled(true);
       // error.setVisibility(View.INVISIBLE);

        valide.setEnabled(false);
        signup.setEnabled(false);


        valide.setEnabled(true);
        System.out.println(username.getText());

       /* if (username.getText().toString().equals(name) && pwd.getText().toString().equals(password))
        {*/
            valide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    user = mDAO.findUser(username.getText().toString(), pwd.getText().toString());

                    if(user != null)
                    {
                        Intent signalActivityIntent = new Intent(MainActivity.this, SignalActivity.class);
                        startActivity(signalActivityIntent);
                    }
                    else
                    {
                        username.setError("Username Incorrect");
                        pwd.setError("PassWord Incorrect");
                        //error.setText("Username ou Mot de passe Incorrect !");
                        //error.setError("Username ou Mot de passe Incorrect !");
                        //error.setEnabled(false);
                        //error.setVisibility(View.VISIBLE);
                    }
                }
            });
       /* }
        else
            System.out.println(username.getText());*/


        signup.setEnabled(true);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpActivityIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signUpActivityIntent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        out.println("MainActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        out.println("MainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        out.println("MainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        out.println("MainActivity::onDestroy()");
    }
}
