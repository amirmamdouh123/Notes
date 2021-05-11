package org.codeforiraq.notes;
import androidx.room.*;
@androidx.room.Entity (tableName = "Notes_table")


public class Entity {
@PrimaryKey(autoGenerate = true)
int id ;
String hob;
        String date;

    int delete;

    public Entity(String hob,String date,int delete) {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
