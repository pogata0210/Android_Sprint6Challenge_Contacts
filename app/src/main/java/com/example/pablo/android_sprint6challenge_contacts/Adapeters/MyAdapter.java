package com.example.pablo.android_sprint6challenge_contacts.Adapeters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pablo.android_sprint6challenge_contacts.Model.MyContacts;
import com.example.pablo.android_sprint6challenge_contacts.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
    Context context;
    ArrayList<MyContacts> myContactsArrayList;
    private ViewGroup parent;

    public MyAdapter(Context context, ArrayList<MyContacts> myContactsArrayList) {
        this.context = context;
        this.myContactsArrayList = myContactsArrayList;
    }


    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int ViewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder holder, int position) {
        MyContacts myContacts = myContactsArrayList.get(position);
        holder.tvName.setText(myContacts.getName());
        holder.tvNumber.setText(myContacts.getNumber());
    }

    @Override
    public int getItemCount() {
        return myContactsArrayList.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvNumber;
        AppCompatImageButton callButton, messegaButton;

        public MyAdapterViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textName);
            tvNumber = (TextView) itemView.findViewById(R.id.text_Numbers);
            callButton = itemView.findViewById(R.id.ibcall);
            messegaButton = itemView.findViewById(R.id.ibMessage);

            callButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + myContactsArrayList.get(getAdapterPosition()).getNumber()));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    context.startActivities(intent);
                }
            });

            messegaButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent (Intent.ACTION_SENDTO,Uri.parse("smsto:" + myContactsArrayList.get(getAdapterPosition()).getNumber()));
                    context.startActivity(i);
                }
            });
        }

    }
}
