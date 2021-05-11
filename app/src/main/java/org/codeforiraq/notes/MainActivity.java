package org.codeforiraq.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick,SameItem{
RecyclerView recycle;
TextView hob;
ImageView delete;
EditText change;
MyAdapter MyAdapter;
    Calendar c;
SimpleDateFormat simple;
String Date;
List<Entity> allNotes;
Button add,set;
int Request_code=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
recycle=findViewById(R.id.recycle);
hob=findViewById(R.id.hobby);
delete =findViewById(R.id.delete);
change=findViewById(R.id.change);
c= Calendar.getInstance();
simple=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
Date=simple.format(c.getTime());
add=findViewById(R.id.add);
set=findViewById(R.id.set);



        Room_Database.getInstance(MainActivity.this).dao_notes().getNotes();
         MyAdapter=new MyAdapter(allNotes, new OnItemClick() {
             @Override
             public void OnOneClick(Entity notes) {

                Intent intent =new Intent(MainActivity.this,Add_NotesActivity.class);
                 intent.putExtra("hob",notes.getHob());
                 intent.putExtra("date",Date);
                 startActivityForResult(intent,Request_code);

             }

         });
        recycle.setAdapter(MyAdapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent intent =new Intent(MainActivity.this,Add_NotesActivity.class);
        intent.putExtra("hob","");

startActivityForResult(intent,Request_code);
    }
});


    }




    @Override
    public void clc(int postion) {

change.setVisibility(View.VISIBLE);
        set.setVisibility(View.VISIBLE);
        set.setEnabled(true);
        MyAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnOneClick(Entity notes) {
        Intent intent =new Intent(MainActivity.this,Add_NotesActivity.class);
        intent.putExtra("note",notes.getHob());
        intent.putExtra("id",notes.getDate());
        startActivityForResult(intent,Request_code);
    }

    @Override
    public void deleteItem(int position) {
allNotes.remove(position);
        MyAdapter.notifyDataSetChanged();

    }
}