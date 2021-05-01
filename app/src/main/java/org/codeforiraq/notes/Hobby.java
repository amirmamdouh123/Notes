package org.codeforiraq.notes;

import android.widget.ImageView;

public class Hobby {

String hob,date;
int delete;

    public Hobby(String hob,String date,int delete) {
        this.hob = hob;
        this.date=date;
        this.delete=delete;
    }

    public String getHob() {
        return hob;
    }

    public void setHob(String hob) {
        this.hob = hob;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
