package com.daghlas.myclock;

public class AlarmModels {

    String time;
    String repeat;
    int on_off;

    public AlarmModels(String time, String repeat, int on_off) {
        this.time = time;
        this.repeat = repeat;
        this.on_off = on_off;
    }

    public String getTime() {
        return time;
    }

    public String getRepeat() {
        return repeat;
    }

    public int getOn_off() {
        return on_off;
    }
}
