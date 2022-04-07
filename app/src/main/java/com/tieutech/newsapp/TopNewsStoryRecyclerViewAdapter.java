package com.tieutech.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//ABOUT:
//RecyclerView Adapter for the Top News Stories (to be displayed in the News Stories Fragment)
//FUNCTION:
//Links the data of each item to be displayed in the RecyclerView to the RecyclerView itself
public class TopNewsStoryRecyclerViewAdapter extends RecyclerView.Adapter<TopNewsStoryRecyclerViewAdapter.ViewHolder> {

    //======= DEFINE VARIABLES =======
    private List<NewsStory> newsStories; //Arraylist of News Stories for the RecyclerView
    private Context context; //Application Context
    private OnNewsStoriesListener onNewsStoriesListener; //Interface defining methods to override in the MainActivity

    //Constructor for the RecyclerView Adapter
    public TopNewsStoryRecyclerViewAdapter(List<NewsStory> newsStories, Context context, OnNewsStoriesListener onNewsStoriesListener) {
        this.newsStories = newsStories;
        this.context = context;
        this.onNewsStoriesListener = onNewsStoriesListener;
    }

    //======= DEFINE METHODS =======
    //Upon the creation of the ViewHolder of each item in the RecyclerView
    @NonNull
    @Override
    public TopNewsStoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_news_stories_column, parent, false); //Create the view of the ViewHolder
        return new ViewHolder(itemView, onNewsStoriesListener); //Link the ViewHolder to the RecyclerView Adapter
    }

    //Modify the display of the view elements in the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull TopNewsStoryRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.topNewsStoryImageImageView.setImageResource(newsStories.get(position).getImage()); //Display the Image of the Top News Story
    }

    //Return the size of the dataset
    @Override
    public int getItemCount() {
        return newsStories.size();
    }

    //ViewHolder for each item in the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView topNewsStoryImageImageView; //View for the image of the Top News Story
        OnNewsStoriesListener onNewsStoriesListener; //Interface defining methods to override in the MainActivity

        public ViewHolder(@NonNull View itemView, OnNewsStoriesListener onNewsStoriesListener) {
            super(itemView);

            //Obtain view
            topNewsStoryImageImageView = (ImageView) itemView.findViewById(R.id.topNewsStoryImageImageView);
            this.onNewsStoriesListener = onNewsStoriesListener;
            itemView.setOnClickListener(this);
        }

        //OnClick listener for the ViewHolder
        @Override
        public void onClick(View view) {
            onNewsStoriesListener.onTopNewStoryClick(getAdapterPosition()); //Call the method defined by MainActivity
        }
    }

    //Interface to be implemented by the MainActivity
    public interface OnNewsStoriesListener {
        void onTopNewStoryClick(int position); //Listener method to override in the MainActivity
    }
}
