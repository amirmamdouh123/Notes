package org.codeforiraq.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnItemClick{
RecyclerView recycle;
TextView hob;
ImageView delete;
EditText change;
MyAdapter MyAdapter;
    ArrayList <Hobby> Hobbyyy=new ArrayList<>();
    Calendar c;
SimpleDateFormat simple;
String Date;


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

        Hobbyyy.add(new Hobby("Studing","Created at "+Date.toString(),R.drawable.ic_baseline_delete_24));
        Hobbyyy.add(new Hobby("Playing","Created at "+Date.toString(),R.drawable.ic_baseline_delete_24));
        Hobbyyy.add(new Hobby("Eating","Created at "+Date.toString(),R.drawable.ic_baseline_delete_24));

         MyAdapter=new MyAdapter(Hobbyyy, this);
        recycle.setAdapter(MyAdapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void OnOneClick(int postion) {

        Hobbyyy.remove(postion);
MyAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnLongClick(int postion) {


        MyAdapter.notifyDataSetChanged();

    }
}