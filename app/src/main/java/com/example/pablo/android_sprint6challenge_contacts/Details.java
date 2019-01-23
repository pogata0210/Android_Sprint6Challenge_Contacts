package com.example.pablo.android_sprint6challenge_contacts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class Details extends AppCompatActivity {
    private TextView userName, userNumber;
    private ImageView userImage;
    private Bitmap bitmap;
    private Intent intent;
    final AtomicBoolean canceled = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_main);

        userImage = findViewById(R.id.contact_image);
        userName = findViewById(R.id.contact_name);
        userNumber = findViewById(R.id.contact_number);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        final MyContacts user = (MyContacts) bundle.getSerializable("MyContact");

        new Thread(new Runnable() {
            @Override
            public void run() {
                bitmap = ApiDao.getImage(user.getbigger(), canceled);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        userImage.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
        userName.setText(user.getNumber() + " " + user.getFirst() + " " + user.getLast());
        userNumber.setText(user.getPhone());
    }
}
