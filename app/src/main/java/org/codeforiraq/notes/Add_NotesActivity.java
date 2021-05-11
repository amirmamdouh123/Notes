package org.codeforiraq.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Add_NotesActivity extends AppCompatActivity {

Button save;
EditText et_Note;
String note_intent;
String id_intent;
    Calendar c;
    SimpleDateFormat simple;
    String Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__notes);
        c= Calendar.getInstance();
        simple=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date=simple.format(c.getTime());
        Intent returnIntent=new Intent();
        save=findViewById(R.id.save);
        et_Note=findViewById(R.id.neww);
Intent data_notes = getIntent();
id_intent=data_notes.getExtras().getString("hob");
note_intent=data_notes.getExtras().getString(Date);
et_Note.setText(id_intent);



save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (id_intent.isEmpty()){
            String note_description = et_Note.getText().toString();
Entity note=new Entity (note_description,note_intent,R.drawable.ic_baseline_delete_24);
Room_Database.getInstance(Add_NotesActivity.this).dao_notes().insert_notes(note);

        }
        else {
            String note_description =et_Note.getText().toString();
            Entity note=new Entity (note_description,note_intent,R.drawable.ic_baseline_delete_24);
            Room_Database.getInstance(Add_NotesActivity.this).dao_notes().update_notes(note);


        }
    }
});

    }
}