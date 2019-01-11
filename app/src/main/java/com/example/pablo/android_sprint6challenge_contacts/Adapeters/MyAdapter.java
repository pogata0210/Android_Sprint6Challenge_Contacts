package com.example.pablo.android_sprint6challenge_contacts.Adapeters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pablo.android_sprint6challenge_contacts.Model.MyContacts;
import com.example.pablo.android_sprint6challenge_contacts.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder>
{
    Context context;
    ArrayList<MyContacts> myContactsArrayList;
    private ViewGroup parent;

    public MyAdapter(Context context, ArrayList<MyContacts> myContactsArrayList)
    {
        this.context = context;
        this.myContactsArrayList = myContactsArrayList;
    }


    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
       return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder myAdapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return myContactsArrayList.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName,tvNumber;
        AppCompatImageButton callButton, messegaButton;

        public MyAdapterViewHolder(View itemView)
        {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.textName);
            tvNumber = (TextView)itemView.findViewById(R.id.text_Numbers);
            callButton = itemView.findViewById(R.id.ibcall);
            messegaButton= itemView.findViewById(R.id.ibMessage);
        }

    }
}
