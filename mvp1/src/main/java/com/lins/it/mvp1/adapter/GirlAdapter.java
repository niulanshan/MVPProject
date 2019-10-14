package com.lins.it.mvp1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lins.it.mvp1.R;
import com.lins.it.mvp1.bean.Girl;

import java.util.List;

public class GirlAdapter extends RecyclerView.Adapter {
    private List<Girl> list;

    public GirlAdapter(List<Girl> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_girl, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Girl girl = list.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.image.setImageResource(girl.getIcon());
        viewHolder.name.setText(girl.getName());
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public void setData(List<Girl> list) {
        this.list = list;
    }

     static class ItemViewHolder extends RecyclerView.ViewHolder{
         ImageView image;
         TextView name;

         public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }

    }
}
