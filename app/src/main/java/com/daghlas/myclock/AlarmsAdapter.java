package com.daghlas.myclock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmsAdapter extends RecyclerView.Adapter<AlarmsAdapter.MyViewHolder> {

    Context context;
    ArrayList<AlarmModels> alarmModels;

    public AlarmsAdapter(Context context, ArrayList<AlarmModels> alarmModels){
        this.context = context;
        this.alarmModels = alarmModels;
    }

    @NonNull
    @Override
    public AlarmsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.alarm_view, parent, false);
        return new AlarmsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmsAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
