package com.example.pablo.android_sprint6challenge_contacts;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pablo.android_sprint6challenge_contacts.Model.MyContacts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        loadContacts();
    }

    private ArrayList<MyContacts> loadContacts() {
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.NUMBER);

    ArrayList<MyContacts> arrayList = new ArrayList<>();

    if(cursor.getCount()>0)
    {
        while (cursor.moveToNext())
        {
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

            if(number.length() > 0){

                Cursor phoneCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", new String[]{id},null);

                if (phoneCursor.getCount() > 0)
                {while(phoneCursor.moveToNext())
                {
                    String phoneNumberValue = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
            }
        }
    }
    }
}
