package com.daghlas.myclock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Daghlas Kaire
 * Github: https://github.com/daghlas
 * Mail: daghlaskaire58@gmail.com
 */

public class AlarmsAdapter extends RecyclerView.Adapter<AlarmsAdapter.MyViewHolder> {

    Context context;
    private final List<AlarmModels> data;

    public AlarmsAdapter(Context context, List<AlarmModels> data) {
        this.context = context;
        this.data = data;
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
        AlarmModels alarmModels = data.get(position);
        holder.setTime.setText(String.format(Locale.getDefault(), "%02d:%02d", alarmModels.getHour(), alarmModels.getMinute()));
        holder.alarmName.setText(alarmModels.getAlarmTag());

        //edit alarm on adapter position click
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, AddAlarm.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView setTime, alarmName, repeat;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            setTime = itemView.findViewById(R.id.time);
            alarmName = itemView.findViewById(R.id.alarmNameTag);
            repeat = itemView.findViewById(R.id.repeat);
            view = itemView;
        }
    }
}
