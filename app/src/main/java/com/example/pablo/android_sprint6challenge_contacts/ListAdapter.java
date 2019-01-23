package com.example.pablo.android_sprint6challenge_contacts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView contactImg;

        ViewGroup cardBox;

        TextView contactName;

        TextView contactNumber;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            contactImg = itemView.findViewById(R.id.contact_image);

            cardBox = itemView.findViewById(R.id.layout);

            contactName = itemView.findViewById(R.id.contact_name);

            contactNumber = itemView.findViewById(R.id.contact_number);

        }
    }
    private final ArrayList<MyContacts> dataList;
    private Context context;
    Bitmap bitmap = null;
    private Activity activity;
    final AtomicBoolean canceled = new AtomicBoolean(false);

    ListAdapter(ArrayList<MyContacts> dataList, Activity activity){
        this.dataList = dataList;
        this.activity = activity;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyContacts data= dataList.get(position);


        holder.contactName.setText(data.getFirst()+ " " + data.getLast());
        holder.contactNumber.setText(data.getNumber());

        new Thread(new Runnable() {
            @Override
            public void run() {
                bitmap =ApiDao.getImage(data.getPictureThumbnail(), canceled);
            }
        }).start();
        holder.contactImg.setImageBitmap(bitmap);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.contact_main, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

