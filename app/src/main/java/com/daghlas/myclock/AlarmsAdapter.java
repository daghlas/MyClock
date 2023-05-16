package com.daghlas.myclock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmsAdapter extends RecyclerView.Adapter<AlarmsAdapter.MyViewHolder> {

    Context context;
    ArrayList<AlarmModels> alarmModels;

    private String selectedTime;

    @SuppressLint("NotifyDataSetChanged")
    public void setSelectedTime(String time) {
        selectedTime = time;
        notifyDataSetChanged();
    }
    private String selectedName;
    @SuppressLint("NotifyDataSetChanged")
    public void setSelectedName(String name) {
        selectedName = name;
        notifyDataSetChanged();
    }

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
        holder.setTime.setText(selectedTime);
        holder.alarmName.setText(selectedName);
        //holder.setTime.setText(alarmModels.getTime());
    }

    @Override
    public int getItemCount() {
        return 1;
        //return alarmModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView setTime, alarmName, repeat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            setTime = itemView.findViewById(R.id.time);
            alarmName = itemView.findViewById(R.id.alarmNameTag);
            repeat = itemView.findViewById(R.id.repeat);
        }
    }
}
