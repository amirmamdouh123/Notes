package org.codeforiraq.notes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Dao_notes {

    @Insert
    public void insert_notes(Entity note);

    @Update
    public int update_notes(Entity note);

    @Query("DELETE FROM Notes_table WHERE id= :id")
    public int delete(int id);

    @Query("Select * from Notes_table")
    public List<Entity> getNotes();




}