package com.daghlas.myclock;

/**
 * Created by Daghlas Kaire
 * Github: https://github.com/daghlas
 * Mail: daghlaskaire58@gmail.com
 */

public class AlarmModels {

    int hour;
    int minute;
    int repeat;
    String alarmTag;

    int on_off;

    public AlarmModels(int hour, int minute, String alarmTag){
        this.hour = hour;
        this.minute = minute;
        //this.repeat = repeat;
        this.alarmTag = alarmTag;
        //this.on_off = on_off;
    }

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getRepeat() {
        return repeat;
    }
    public String getAlarmTag() {
        return alarmTag;
    }
    public int getOn_off() {
        return on_off;
    }
}
