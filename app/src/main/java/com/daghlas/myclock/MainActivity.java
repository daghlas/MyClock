package com.daghlas.myclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CardView addAlarm;
    RecyclerView recyclerView;
    ArrayList<AlarmModels> alarmModels =  new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAlarm = findViewById(R.id.addAlarm);

        recyclerView = findViewById(R.id.alarmList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        AlarmsAdapter adapter = new AlarmsAdapter(this, alarmModels);
        recyclerView.setAdapter(adapter);

        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddAlarm.class);
                startActivity(intent);
            }
        });

        // Retrieve the selected time from the Intent extras
        int selectedHour = getIntent().getIntExtra("selected_hour", 0);
        int selectedMinute = getIntent().getIntExtra("selected_minute", 0);

        String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
        String selectedName = getIntent().getStringExtra("selected_name");

        // Set the selected time to the TextView in the RecyclerView's adapter
        adapter.setSelectedTime(selectedTime);
        adapter.setSelectedName(selectedName);
        adapter.notifyDataSetChanged();

    }
}