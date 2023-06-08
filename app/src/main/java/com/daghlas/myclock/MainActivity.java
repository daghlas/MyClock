package com.daghlas.myclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Daghlas Kaire
 * Github: https://github.com/daghlas
 * Mail: daghlaskaire58@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    CardView addAlarm;
    RecyclerView recyclerView;
    List<AlarmModels> data;
    AlarmsAdapter adapter;
    TextView noAlarms;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAlarm = findViewById(R.id.addAlarm);
        noAlarms = findViewById(R.id.noAlarms);
        noAlarms.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.alarmList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        data = new ArrayList<>();

        adapter = new AlarmsAdapter(this,data);
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("selected_name")) {
            noAlarms.setVisibility(View.INVISIBLE);

            // Retrieve the selected time from the Intent extras
            int selectedHour = intent.getIntExtra("selected_hour", 0);
            int selectedMinute = intent.getIntExtra("selected_minute", 0);
            String selectedName = intent.getStringExtra("selected_name");

            // Set the selected time to the TextView in the RecyclerView's adapter
            AlarmModels alarmModels = new AlarmModels(selectedHour, selectedMinute, selectedName);
            data.add(alarmModels);
            adapter.notifyDataSetChanged();

            // Notify the adapter that a new item has been added
            //adapter.notifyItemInserted(data.size() - 1);
            // scroll the RecyclerView to the newly added item
            //recyclerView.smoothScrollToPosition(data.size() - 1);
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset shared preference value on save clicked
                sharedPreferences.edit().putString("alarmName", "").apply();
                Intent intent = new Intent(MainActivity.this, AddAlarm.class);
                startActivity(intent);
            }
        });

    }
}