package com.example.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {

    private int id;
    private long time;

    public DelayObject(int id, long delayTime)
    {
        this.id = id;
        this.time = System.currentTimeMillis() + delayTime;
    }

    @Override
    public long getDelay(TimeUnit unit)
    {
        long diff = time - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed obj)
    {
        if (this.time < ((DelayObject)obj).time) {
            return -1;
        }
        if (this.time > ((DelayObject)obj).time) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "DelayObject{" +
                "id='" + id + '\'' +
                ", time=" + time +
                '}';
    }
}
