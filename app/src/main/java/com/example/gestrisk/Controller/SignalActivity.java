package com.example.gestrisk.Controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestrisk.R;
import com.example.gestrisk.model.DAO;
import com.example.gestrisk.model.Risque;
import com.example.gestrisk.model.RisqueDAO;
import com.example.gestrisk.model.UserDAO;

import java.util.ArrayList;
import java.util.jar.Manifest;

public class SignalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button add;

    private ListView mListView;

    ArrayList<String> description = new ArrayList<String>();

    ArrayList<String> caracterisation = new ArrayList<String>();

    ArrayList<String> date = new ArrayList<String>();

    ArrayList<String> photos = new ArrayList<String>();

    public static ArrayList<Risque> mRisqueArrayList = new ArrayList<Risque>();

    private RisqueDAO mDAO;

    private UserDAO mUserDAO;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signal);

        if (SignUpActivity.active)
        {
            SignUpActivity.active = false;
            SignUpActivity.signUp.finish();
        }
        if (Page6Activity.active)
        {
            Page6Activity.active = false;
            Page6Activity.page6.finish();
        }

        mDAO = new RisqueDAO(this);

        mUserDAO = new UserDAO(this);

        if (MainActivity.user != null){
            mRisqueArrayList = mDAO.findRisque(mUserDAO.findIdUser(MainActivity.user.getNom(), MainActivity.user.getPassword()));
        }

        if (SignUpActivity.user != null)
        {
            mRisqueArrayList = mDAO.findRisque(mUserDAO.findIdUser(SignUpActivity.user.getNom(), SignUpActivity.user.getPassword()));
        }

        add = (Button) findViewById(R.id.button5);

        mListView = findViewById(R.id.listView);

        //System.out.println(mRisqueArrayList.get(0));
        initialisation();
        //System.out.println(mRisqueArrayList.get(0));
        if (mRisqueArrayList != null)
        {
            MyAdapter adapter = new MyAdapter(this, description, caracterisation, date, photos);

            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //int n = mRisqueArrayList.size();
                    System.out.println("JE SUIS VRAIMENT A L'ECOLE JUSQU'A PRESENT, MOI MEME JE NE COMPRENDS PAS");
                    //for (Risque r: mRisqueArrayList)
                    //{
                        if (position == 0)
                        {
                            Toast.makeText(SignalActivity.this, mRisqueArrayList.get(position).getCaracterisation(), Toast.LENGTH_SHORT).show();
                        }
                    //}
                }
            });
        }

        add.setEnabled(true);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page1ActivityIntent = new Intent(SignalActivity.this, Page1Activity.class);
                startActivity(page1ActivityIntent);
            }
        });
    }

    private void initialisation() {
        if (mRisqueArrayList != null)
        {
            //description.clear();
            //caracterisation.clear();
            //date.clear();
            //photos.clear();
            for (Risque r : mRisqueArrayList)
            {
                description.add(r.getDescription());
                caracterisation.add(r.getCaracterisation());
                date.add(r.getDate().toString());
                photos.add(r.getPhoto());
            }
        }
        else
            System.out.println("Erreur lors de la recherche des éléments");
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context mContext;

        ArrayList<String> description;

        ArrayList<String> caracterisation;

        ArrayList<String> mdate;

        ArrayList<String> photos;

        public MyAdapter (Context c, ArrayList<String> description, ArrayList<String> caracterisation, ArrayList<String> date, ArrayList<String> photos)
        {
            super(c, R.layout.row, R.id.title, description);
            this.mContext = c;
            this.description = description;
            this.caracterisation = caracterisation;
            this.mdate = date;
            this.photos = photos;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row =layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView title = row.findViewById(R.id.title);
            TextView subtiltle = row.findViewById(R.id.subtitle);
            TextView date = row.findViewById(R.id.date);

            images.setImageURI(Uri.parse(photos.get(position)));
            title.setText(description.get(position));
            subtiltle.setText(caracterisation.get(position));
            date.setText(mdate.get(position));

            return row;
        }
    }
    @Override
    public void onBackPressed ()
    {
        moveTaskToBack(true);
        System.exit(0);
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("SignalActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("SignalActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("SignalActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("SignalActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("SignalActivity::onDestroy()");
    }

    @Override
    public void onClick(View v) {

    }
}
