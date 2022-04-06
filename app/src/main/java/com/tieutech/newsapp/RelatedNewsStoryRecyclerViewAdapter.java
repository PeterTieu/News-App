package com.tieutech.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RelatedNewsStoryRecyclerViewAdapter extends RecyclerView.Adapter<RelatedNewsStoryRecyclerViewAdapter.ViewHolder> {

    private List<NewsStory> newsStories;
    private Context context;


    //Constructor for the
    public RelatedNewsStoryRecyclerViewAdapter(List<NewsStory> newsStories, Context context) {
        this.newsStories = newsStories;
        this.context = context;
    }

    //Create the view of the ViewHolder - only run once?
    @NonNull
    @Override
    public RelatedNewsStoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Create the ViewHolder
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_news_stories_row, parent, false);

        return new RelatedNewsStoryRecyclerViewAdapter.ViewHolder(itemView);
    }

    //Bind data to the RecyclerView view
    @Override
    public void onBindViewHolder(@NonNull RelatedNewsStoryRecyclerViewAdapter.ViewHolder holder, int position) {
        //Bind data to the ViewHolder
        holder.relatedNewsStoryImageImageView.setImageResource(newsStories.get(position).getImage());
        holder.relatedNewsStoryTitleTextView.setText(newsStories.get(position).getTitle());
        holder.relatedNewsStoryDescriptionTextView.setText(newsStories.get(position).getDescription());
    }

    //Returns the size of the dataset - invoked by the LayoutManager
    @Override
    public int getItemCount() {
        return newsStories.size();
    }


    //Defines the view of a SINGLE item in the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView relatedNewsStoryImageImageView;
        TextView relatedNewsStoryTitleTextView;
        TextView relatedNewsStoryDescriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Obtain the views of each of the items
            relatedNewsStoryImageImageView = (ImageView) itemView.findViewById(R.id.relatedNewsStoryImageImageView);
            relatedNewsStoryTitleTextView = (TextView) itemView.findViewById(R.id.relatedNewsStoryTitleTextView);
            relatedNewsStoryDescriptionTextView = (TextView) itemView.findViewById(R.id.relatedNewsStoryDescriptionTextView);
        }

    }



}
