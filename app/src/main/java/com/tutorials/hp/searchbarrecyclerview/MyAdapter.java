package com.tutorials.hp.searchbarrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

/**
 - Our MyAdapter class.
 - Derives from RecyclerView.Adapter.
 - Implements android.widget.filterable interface.
 - We include our MyViewHolder as an inner class.
 - This adapter layout will be responsible inflating model layout and binding data to resulting views.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {
    ArrayList<String> galaxies;
    ArrayList<String> currentList;

    public MyAdapter(ArrayList<String> galaxies) {
        this.galaxies = galaxies;
        this.currentList=galaxies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nametxt.setText(galaxies.get(position));
    }
    @Override
    public int getItemCount() {
        return galaxies.size();
    }

    public void setGalaxies(ArrayList<String> filteredGalaxies)
    {
        this.galaxies=filteredGalaxies;
    }

    @Override
    public Filter getFilter() {
        return FilterHelper.newInstance(currentList,this);
    }

    /*
    - Our MyViewHolder class
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nametxt;
        public MyViewHolder(View itemView) {
            super(itemView);
            nametxt= itemView.findViewById(R.id.nameTxt);
        }
    }

}
