package com.daghlas.myclock;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Daghlas Kaire
 * Github: https://github.com/daghlas
 * Mail: daghlaskaire58@gmail.com
 */

public class AddAlarm extends AppCompatActivity{

    Button cancel, save;
    TextView alarmTone, vibrPattern;
    CardView mon, tue, wed, thur, fri, sat, sun;
    EditText alarmNameTag;
    TimePicker timePicker;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        timePicker = findViewById(R.id.timePicker);

        cancel = findViewById(R.id.cancelAlarm);
        save = findViewById(R.id.saveAlarm);

        alarmNameTag = findViewById(R.id.setAlarmName1);

        mon = findViewById(R.id.mon);
        tue = findViewById(R.id.tue);
        wed = findViewById(R.id.wed);
        thur = findViewById(R.id.thur);
        fri = findViewById(R.id.fri);
        sat = findViewById(R.id.sat);
        sun = findViewById(R.id.sun);

        alarmTone = findViewById(R.id.tone);
        vibrPattern = findViewById(R.id.pattern);

        alarmTone.setOnClickListener(new View.OnClickListener() {
            static final int REQUEST_ALARM_TONE = 1;
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALARM);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Alarm Tone");
                startActivityForResult(intent, REQUEST_ALARM_TONE);
            }
        });

        cancel.setOnClickListener(v -> onBackPressed());

        save.setOnClickListener(v -> {
            //SET THE ALARM
            Calendar cal = Calendar.getInstance();
            cal.set(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH),
                    timePicker.getHour(),
                    timePicker.getMinute());
            setAlarm(cal.getTimeInMillis());

            //FETCH SELECTED TIME AND NAME TO DISPLAY ON ALARM LIST ON OTHER ACTIVITY
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            String alarmTag = alarmNameTag.getText().toString();

            Intent intent = new Intent(AddAlarm.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); //closes previous launch activity
            intent.putExtra("selected_hour", hour);
            intent.putExtra("selected_minute", minute);
            intent.putExtra("selected_name", alarmTag);
            startActivity(intent);
            finish();

            //reset SAVED VALUES WHEN SAVE BUTTON IS CLICKED
            intent.removeExtra("selected_name");
            intent.removeExtra("selected_hour");
            intent.removeExtra("selected_minute");
        });

        mon.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    mon.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    mon.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });
        tue.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    tue.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    tue.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });
        wed.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    wed.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    wed.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });
        thur.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    thur.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    thur.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    fri.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    fri.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });
        sat.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    sat.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    sat.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });
        sun.setOnClickListener(new View.OnClickListener() {
            boolean isClicked = true;
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    sun.setCardBackgroundColor(getResources().getColor(R.color.primary));
                    isClicked = false;
                } else {
                    sun.setCardBackgroundColor(Color.WHITE);
                    isClicked = true;
                }
            }
        });

    }

    //SETTING SELECTED ALARM TONE TITLE TO TEXT VIEW
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri alarmToneUri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
            String alarmToneName = getRingtoneTitle(alarmToneUri);
            alarmTone.setText(alarmToneName);
        }
    }

    //HELPER METHODS TO FETCH SELECTED ALARM TONE TITLE NAME
    private String getRingtoneTitle(Uri ringtoneUri) {
        Ringtone ringtone = RingtoneManager.getRingtone(this, ringtoneUri);
        return ringtone.getTitle(this);
    }

    //method to set alarm
    private void setAlarm(long timeInMillis){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this, "alarm set", Toast.LENGTH_SHORT).show();
    }

}