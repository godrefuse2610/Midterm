package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FM_RecyclerViewAdapter extends RecyclerView.Adapter<FM_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<FilmModel> FilmModel;

    public FM_RecyclerViewAdapter(Context context, ArrayList<FilmModel> FilmModel,
                                  RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.FilmModel = FilmModel;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent,false);
        return new FM_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull FM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(FilmModel.get(position).getFilmName());
        holder.tvTypes.setText(FilmModel.get(position).getTypes());
        holder.tvPrice.setText(FilmModel.get(position).getPrice());
        holder.imageView.setImageResource(FilmModel.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return FilmModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvTypes, tvPrice;



        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView1);
            tvTypes = itemView.findViewById(R.id.textView2);
            tvPrice = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }
                    }
                }
            });
        }
    }
}
