package com.example.gestrisk.model;

import android.content.Context;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.gestrisk.Controller.MainActivity;
import com.example.gestrisk.Controller.Page1Activity;
import com.example.gestrisk.Controller.Page2Activity;
import com.example.gestrisk.Controller.Page6Activity;
import com.example.gestrisk.Controller.SignUpActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailAPI extends AsyncTask<Void,Void,Void> {

    private Context mContext;
    private Session mSession;

    private String mEmail;
    private String mSubject;
    private String mMessage;

    private ProgressDialog mProgressDialog;

    //Constructor
    public JavaMailAPI(Context mContext, String mEmail, String mSubject, String mMessage) {
        this.mContext = mContext;
        this.mEmail = mEmail;
        this.mSubject = mSubject;
        this.mMessage = mMessage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Show progress dialog while sending email
        mProgressDialog = ProgressDialog.show(mContext,"Sending message", "Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismiss progress dialog when message successfully send
        mProgressDialog.dismiss();

        //Show success toast
        Toast.makeText(mContext,"Message Sent",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties

        final User user;
        if (MainActivity.user == null)
            user = SignUpActivity.user;
        else
            user = MainActivity.user;
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        mSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        System.out.println(user.getEmail());
                        return new PasswordAuthentication("app.gestrisk@gmail.com", "appgestrisk31");
                    }
                });

        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(mSession);


            //Setting sender address
            mm.setFrom(new InternetAddress(user.getEmail()));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(mEmail));
            //Adding subject
            mm.setSubject(mSubject);

            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(mMessage);

            MimeBodyPart mbp2 = new MimeBodyPart();

            Uri uri = Page1Activity.imageUri;
            String selectedFilePath = FilePath.getPath(this.mContext, uri);
            final File file = new File(selectedFilePath);

            DataSource source = new FileDataSource(file);
            mbp2.setDataHandler(new DataHandler(source));
            mbp2.setFileName(file.getName());


            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mbp1);
            multipart.addBodyPart(mbp2);


// Send the complete message parts
            mm.setContent(multipart);
        // Send message

            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
            Exception ex = null;
            if ((ex = e.getNextException()) != null) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
