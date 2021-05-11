package org.codeforiraq.notes;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Entity.class},version = 1,exportSchema = false)
public abstract class Room_Database extends RoomDatabase {

    static Room_Database instance ;
abstract   Dao_notes dao_notes();
    public static Room_Database getInstance(Context context ){

        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),Room_Database.class,"Data_Notes").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return instance;

    }


}





