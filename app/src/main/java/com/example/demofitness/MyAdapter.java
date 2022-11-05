package com.example.demofitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<com.example.demofitness.Diet> dietArrayList;

    public MyAdapter(Context context, ArrayList<com.example.demofitness.Diet> dietArrayList) {
        this.context = context;
        this.dietArrayList = dietArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        com.example.demofitness.Diet diet = dietArrayList.get(position);
        holder.tvHeading.setText(diet.heading);
        holder.titleimage.setImageResource(diet.titleimage);
        holder.briefDiet.setText(diet.briefDiet);

        boolean isVisible = diet.visibility;
        holder.constraintLayout.setVisibility(isVisible?View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {
        return dietArrayList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvHeading;
        TextView briefDiet;
        ShapeableImageView titleimage;

        ConstraintLayout constraintLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHeading = itemView.findViewById(R.id.tvHeading);
            titleimage = itemView.findViewById(R.id.title_image);
            briefDiet = itemView.findViewById(R.id.briefDiet);
            constraintLayout = itemView.findViewById(R.id.expandedLayout);

            tvHeading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    com.example.demofitness.Diet diet = dietArrayList.get(getAdapterPosition());
                    diet.setVisibility(!diet.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
