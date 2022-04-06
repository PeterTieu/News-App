package com.tieutech.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopNewsStoryRecyclerViewAdapter extends RecyclerView.Adapter<TopNewsStoryRecyclerViewAdapter.ViewHolder> {

    private List<NewsStory> newsStories;
    private Context context;

    private OnNewsStoriesListener onNewsStoriesListener;


    //Constructor for the
    public TopNewsStoryRecyclerViewAdapter(List<NewsStory> newsStories, Context context, OnNewsStoriesListener onNewsStoriesListener) {
        this.newsStories = newsStories;
        this.context = context;
        this.onNewsStoriesListener = onNewsStoriesListener;
    }

    //Create the view of the ViewHolder - only run once?
    @NonNull
    @Override
    public TopNewsStoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Create the ViewHolder
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_news_stories_column, parent, false);

        return new ViewHolder(itemView, onNewsStoriesListener);
    }

    //Bind data to the RecyclerView view
    @Override
    public void onBindViewHolder(@NonNull TopNewsStoryRecyclerViewAdapter.ViewHolder holder, int position) {
        //Bind data to the ViewHolder
        holder.topNewsStoryImageImageView.setImageResource(newsStories.get(position).getImage());
    }

    //Returns the size of the dataset - invoked by the LayoutManager
    @Override
    public int getItemCount() {
        return newsStories.size();
    }


    //Defines the view of a SINGLE item in the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView topNewsStoryImageImageView;
        OnNewsStoriesListener onNewsStoriesListener;

        public ViewHolder(@NonNull View itemView, OnNewsStoriesListener onNewsStoriesListener) {
            super(itemView);

            //Obtain the views of each of the items
            topNewsStoryImageImageView = (ImageView) itemView.findViewById(R.id.topNewsStoryImageImageView);


            this.onNewsStoriesListener = onNewsStoriesListener;

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            onNewsStoriesListener.onTopNewStoryClick(getAdapterPosition());
        }
    }


    public interface OnNewsStoriesListener {
        void onTopNewStoryClick(int position);


    }
}
