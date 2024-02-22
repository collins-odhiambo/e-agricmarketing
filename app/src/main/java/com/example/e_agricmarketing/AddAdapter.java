package com.example.e_agricmarketing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.ViewHolder> {

    private final ArrayList<String> addDescription;
    private final ArrayList<String> telephoneNum;
    private final ArrayList<String> heading;
    private final ArrayList<String> address;
    private final ArrayList<String> type;
    private final String username;
    private final ArrayList<String> addID;
    private final Context context;
    private final Activity activity;

    public AddAdapter(Activity activity, Context context, ArrayList<String> addDescription, ArrayList<String> telephoneNum,
                      ArrayList<String> heading, ArrayList<String> address, ArrayList<String> type, String username,
                      ArrayList<String> addID) {
        this.addDescription = addDescription;
        this.telephoneNum = telephoneNum;
        this.heading = heading;
        this.address = address;
        this.type = type;
        this.username = username;
        this.addID = addID;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.additem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textView1.setText(heading.get(position));
        holder.textView2.setText(type.get(position));
        holder.textView3.setText(address.get(position));
        holder.textView4.setText(telephoneNum.get(position));

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, heading.get(position), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, ProductDisplay.class);
            intent.putExtra("ADDID", addID.get(position));
            intent.putExtra("HEADING", heading.get(position));
            intent.putExtra("DESCRIPTION", addDescription.get(position));
            intent.putExtra("TYPE", type.get(position));
            intent.putExtra("USERNAME", username.charAt(position));
            intent.putExtra("ADDRESS", address.get(position));
            intent.putExtra("TELEPHONENUM", telephoneNum.get(position));
            activity.startActivityForResult(intent, 1);
        });
    }

    @Override
    public int getItemCount() {
        return addID.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.heading);
            textView2 = itemView.findViewById(R.id.type);
            textView3 = itemView.findViewById(R.id.address);
            textView4 = itemView.findViewById(R.id.telephonenum);
        }
    }
}
