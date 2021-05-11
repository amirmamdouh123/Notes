package org.codeforiraq.notes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Entity> AllNotes;
    private OnItemClick OnItemClickk;
    private SameItem same;
  int id;

    public MyAdapter(List<Entity> allNotes, OnItemClick onItemClickk) {
        AllNotes = allNotes;
        OnItemClickk = onItemClickk;
    }

    public List<Entity> getAllNotes() {
        return AllNotes;
    }

    public void setAllNotes(List<Entity> allNotes) {
        AllNotes = allNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.oneitem,null);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Entity h=AllNotes.get(position);
        holder.date.setText(h.getDate());
holder.hob.setText(h.getHob());
holder.delete.setImageResource(h.getDelete());

    }
    @Override
    public int getItemCount() {
        return AllNotes.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
TextView hob ,date;
ImageView delete;
EditText change;
Button set;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        hob=itemView.findViewById(R.id.hobby);
            date=itemView.findViewById(R.id.date);
            delete=itemView.findViewById(R.id.delete);
change=itemView.findViewById(R.id.change);
change.setVisibility(View.INVISIBLE);
set=itemView.findViewById(R.id.set);
            set.setVisibility(View.INVISIBLE);
set.setEnabled(false);


itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
same.clc(getAdapterPosition());
    }
});

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
           same.deleteItem(getAdapterPosition());
                }
            });

set.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String x= change.getText().toString();
        hob.setText(x);
        change.setText("");
        notifyDataSetChanged();

    }

});

        }
    }

}
