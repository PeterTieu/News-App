package com.tieutech.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//ABOUT:
//RecyclerView Adapter for the Related News Stories (to be displayed in the News Stories Fragment)
//FUNCTION:
//Links the data of each item to be displayed in the RecyclerView to the RecyclerView itself
public class RelatedNewsStoryRecyclerViewAdapter extends RecyclerView.Adapter<RelatedNewsStoryRecyclerViewAdapter.ViewHolder> {

    //======= DEFINE VARIABLES =======
    private List<NewsStory> newsStories; //Arraylist of News Stories for the RecyclerView
    private Context context; //Application Context

    //Constructor for the RecyclerView Adapter
    public RelatedNewsStoryRecyclerViewAdapter(List<NewsStory> newsStories, Context context) {
        this.newsStories = newsStories; //ArrayList
        this.context = context; //Application Context
    }

    //======= DEFINE METHODS =======
    //Upon the creation of the ViewHolder of each item in the RecyclerView
    @NonNull
    @Override
    public RelatedNewsStoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_news_stories_row, parent, false); //Create the view of the ViewHolder
        return new RelatedNewsStoryRecyclerViewAdapter.ViewHolder(itemView); //Link the ViewHolder to the RecyclerView Adapter
    }

    //Modify the display of the view elements in the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull RelatedNewsStoryRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.relatedNewsStoryImageImageView.setImageResource(newsStories.get(position).getImage()); //Display the Image of the News Story
        holder.relatedNewsStoryTitleTextView.setText(newsStories.get(position).getTitle()); //Display the Title of the News Story
        holder.relatedNewsStoryDescriptionTextView.setText(newsStories.get(position).getDescription()); //Display the Description of the News Story
    }

    //Return the size of the dataset
    @Override
    public int getItemCount() {
        return newsStories.size();
    }

    //ViewHolder for each item in the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{

        //Declare views
        ImageView relatedNewsStoryImageImageView;
        TextView relatedNewsStoryTitleTextView;
        TextView relatedNewsStoryDescriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Obtain views
            relatedNewsStoryImageImageView = (ImageView) itemView.findViewById(R.id.relatedNewsStoryImageImageView);
            relatedNewsStoryTitleTextView = (TextView) itemView.findViewById(R.id.relatedNewsStoryTitleTextView);
            relatedNewsStoryDescriptionTextView = (TextView) itemView.findViewById(R.id.relatedNewsStoryDescriptionTextView);
        }
    }
}
