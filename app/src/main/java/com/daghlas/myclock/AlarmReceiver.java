package com.daghlas.myclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by Daghlas Kaire
 * Github: https://github.com/daghlas
 * Mail: daghlaskaire58@gmail.com
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mediaPlayer.start();
        Toast.makeText(context, "wake alarm ringing", Toast.LENGTH_LONG).show();
    }
}
