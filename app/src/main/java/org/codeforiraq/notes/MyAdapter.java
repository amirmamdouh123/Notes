package org.codeforiraq.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
ArrayList<Hobby> arrayList=new ArrayList<>();

private OnItemClick OnItemClickk;



    public MyAdapter(ArrayList<Hobby> arrayList, org.codeforiraq.notes.OnItemClick onItemClick) {
        this.arrayList = arrayList;
        OnItemClickk = onItemClick;
    }

    public ArrayList<Hobby> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Hobby> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.oneitem,null);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hobby h=arrayList.get(position);
        holder.date.setText(h.getDate());
holder.hob.setText(h.getHob());
holder.delete.setImageResource(h.getDelete());

    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
TextView hob ,date;
ImageView delete;
EditText change;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        hob=itemView.findViewById(R.id.hobby);
            date=itemView.findViewById(R.id.date);
            delete=itemView.findViewById(R.id.delete);
change=itemView.findViewById(R.id.change);
change.setVisibility(View.INVISIBLE);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  OnItemClickk.OnOneClick(getAdapterPosition());
                }
            });
hob.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        OnItemClickk.OnLongClick(getAdapterPosition());

        change.setVisibility(View.VISIBLE);

    }
});
        }
    }

}
