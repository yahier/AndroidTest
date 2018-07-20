package com.yahier.androidtest.multipleThreads;

/**
 * Created by yahier on 2018/7/20.
 */

public class Task {
    int id;
    Runnable runnable;

    public Task(int id, Runnable runnable) {
        this.id = id;
        this.runnable = runnable;
    }


    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            if (task.id == id) {
                return true;
            }
        }
        return false;
    }
}
