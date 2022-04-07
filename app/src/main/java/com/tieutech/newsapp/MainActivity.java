package com.tieutech.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//ABOUT:
//Main activity of the application
public class MainActivity extends AppCompatActivity implements TopNewsStoryRecyclerViewAdapter.OnNewsStoriesListener {

    //================ DECLARE VARIABLES ================
    //Key variables - to send data to the News Story Fragment
    public static String NEWS_STORY_IMAGE_INT = "news_story_image_int";
    public static String NEWS_STORY_TITLE = "news_story_title";
    public static String NEW_STORY_DESCRIPTION = "news_story_description";

    //RecyclerView variables
    RecyclerView topNewsStoryRecyclerView;
    TopNewsStoryRecyclerViewAdapter topNewsStoryRecyclerViewAdapter;

    //GridLayout variable
    GridLayout newsGridLayout;

    //Data variables
    List<NewsStory> topNewsStoryArrayList = new ArrayList<>(); //Top News List (for the Horizontal RecyclerView section)
    List<NewsStory> newsStoryArrayList = new ArrayList<>(); //News Story List (for the middle section)

    //======> TOP NEWS (data) <======
    //Image resources
    int[] topNewsStoryImageList = {
            R.drawable.news_story_image_1,
            R.drawable.news_story_image_2,
            R.drawable.news_story_image_3,
            R.drawable.news_story_image_4,
            R.drawable.news_story_image_5,
            R.drawable.news_story_image_6};

    //Titles
    String[] topNewsStoryTitleList = {
            "Bridgerton: A New Prequel Will Track Queen Charlotte's Origin Story",
            "The harsh twist in the TV comedy about Ukraine’s accidental president",
            "Twitter is adding an edit button",
            "Elon Musk’s net worth soars as he is appointed to Twitter board",
            "Wall Street suffers biggest slide in more than a year as oil prices surge",
            "Virgin Australia and Qantas launch airfares sale in WA and across Australia"};

    //Descriptions
    String[] topNewsStoryDescriptionList = {
            "It’s the line that Anthony delivers to Kate in the latest series of Bridgerton, but the same could be said of how I feel about Bridgerton — a show that’s both compelling and infuriating.",
            "Servant of the People is a good comedy that you might feel bad for laughing at. History hasn’t simply passed by this 2015 satire about an everyman made leader of his country – it has amplified the concept and made us look at it anew.",
            "It’s a feature that Twitter users have been requesting for so long that it’s become a meme, but now the mythical “edit button” is actually becoming a reality. Twitter has announced that it’s working to allow users to edit their tweets after posting them.",
            "Elon Musk is now the richest man ever — by a fair margin. The Tesla CEO’s fortune has shot up as the stock price of his companies, Tesla and SpaceX, continues to rise. The net worth of the world’s richest man has soared to $395 billion (USD$300 billion).",
            "The S&P 500 fell 3%, its biggest decline in 16 months, after a barrel of US oil surged to $130 overnight on the possibility the US could bar imports from Russia. Stocks around the world also fell earlier in the day, taking their cue from oil’s movements, though their losses moderated as crude receded toward $120 per barrel.",
            "A cheap airfares bonanza is enticing travellers to holiday in WA and across the nation. Virgin Australia has launched a massive 1.5 million “cheap” seats with one-way prices as low as $149 to Adelaide in economy class. And there is a further bonus 25 per cent discount for children aged two to 11."};

    //======> NEWS STORIES (data) <======
    //Image resources
    int[] newsStoryImageList = {
            R.drawable.news_story_image_7,
            R.drawable.news_story_image_8,
            R.drawable.news_story_image_9,
            R.drawable.news_story_image_10};

    //Titles
    String[] newsStoryTitleList = {
            "Huge mansion with cinema room and sauna you can book for a weekend break",
            "‘Clear message’: Labor promises to bid to host global climate change summit if elected",
            "How worried should we be about the new ‘Deltacron’ COVID hybrid?",
            "Manchester City 1-0 Atlético Madrid: Champions League quarter-final, first leg – as it happened"};

    //Descriptions
    String[] newsStoryDescriptionList = {
            "Just one hour and twenty minutes away from Liverpool is Moorlands in Foulridge , a luxurious mansion that sleeps a whopping 27 people. With a main house and a coach house, the setting is like something straight from a movie with a beautiful private garden and plenty of dreamy features.",
            "Australia would bid to host a United Nations climate change summit in partnership with other Pacific nations if Labor won next month’s federal election as part of the federal opposition’s bid to improve the nation’s credentials with the region on the issue.",
            "For some, news of new COVID-19 variants, which appear to have formed when different strains of the virus combine, sounds like a worst-case scenario. And it’s little comfort that they have appeared as many of Australia’s measures to control the pandemic are being wound back, including reopening our borders to more and more of the world.",
            "“It was a very hard game. They played so defensively and they’re solid. They played almost 5-5-0 and it’s very hard to find spaces. I would recommend to anyone who says something about our performance to try it on the training pitch."};

    //================ DEFINE METHODS ================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtain Views
        topNewsStoryRecyclerView = (RecyclerView) findViewById(R.id.topNewsStoriesRecyclerView); //RecyclerView to contain Top Stories
        newsGridLayout = (GridLayout) findViewById(R.id.newsGridLayout); //Grid Layout to contain News Stories

        //RecyclerViewAdapter to link the RecyclerView for Top Stories to the data
        topNewsStoryRecyclerViewAdapter = new TopNewsStoryRecyclerViewAdapter(topNewsStoryArrayList, this, this); //Instantiate the Recyclerview Adapter
        topNewsStoryRecyclerView.setAdapter(topNewsStoryRecyclerViewAdapter); //Set the Adapter to the RecyclerView

        //LinearLayoutManager to set the layout of the RecyclerView (and make it horizontal)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        topNewsStoryRecyclerView.setLayoutManager(layoutManager); //Link the LayoutManager to the RecyclerView

        //Instantiate all the Top News Story objects and add them to the topNewsStoryArrayList
        for (int i = 0; i < topNewsStoryImageList.length; i++) {
            NewsStory topNewsStory = new NewsStory(topNewsStoryImageList[i], topNewsStoryTitleList[i], topNewsStoryDescriptionList[i]);
            topNewsStoryArrayList.add(topNewsStory);
        }

        //Instantiate all the Top News Story objects and add them to the topNewsStoryArrayList
        for (int i = 0; i < newsStoryImageList.length; i++) {
            NewsStory newsStory = new NewsStory(newsStoryImageList[i], newsStoryTitleList[i], newsStoryDescriptionList[i]);
            newsStoryArrayList.add(newsStory);
        }

        //===== Modify the view elements of the GridLayout to display the News Stories ====

        //CHECKPOINT: Check how many views are in the newsGridLayout view
        Log.i("Child #", newsGridLayout.getChildCount() + "");

        int newsStoryIndex = 0; //Index for the News Story that is being focussed on to

        //Loop through all of the views inside the Grid Layout of the News Stories
        for (int i = 0; i < newsGridLayout.getChildCount(); i++) {

            View child = newsGridLayout.getChildAt(i); //Obtain the child view

            //If the view is the ImageView (i.e. the image of the News Story)
            if (child instanceof ImageView) {
                ((ImageView) child).setImageResource(newsStoryArrayList.get(newsStoryIndex).getImage());
            }
            //If the view is the FIRST TextView of a News Story (i.e. the Description)
            else if ((child instanceof TextView) && (i == 1 || i == 4 || i == 7 || i == 10)) {
                ((TextView) child).setText(newsStoryArrayList.get(newsStoryIndex).getTitle());
            }
            //If the view is the SECOND TextView of a News Story (i.e. the Title)
            else if ((child instanceof TextView) && (i == 2 || i == 5 || i == 8 || i == 11)) {
                ((TextView) child).setText(newsStoryArrayList.get(newsStoryIndex).getDescription());
                newsStoryIndex++; //Increment the News Story Index
            }
        }

        hideNewsStoryFragment(); //Hide the News Story Fragment
    }

    //Hide the News Story Fragment
    public void hideNewsStoryFragment() {
        //Obtain the Fragment Manager and Fragment Transaction
        FragmentManager fragmentManager = getSupportFragmentManager(); //Create a Fragment Manager
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //Create a Fragment Transaction from the Fragment Manager

        //Obtain the Fragment and link it to the Fragment Transaction
        Fragment fragment = fragmentManager.findFragmentById(R.id.newsStoryFragment); //Obtain the Fragment from the Fragment Container View view
        fragmentTransaction.hide(fragment); //Hide the Fragment
        fragmentTransaction.commit(); //Commit the Fragment Transaction
    }

    //Open the News Story Fragment
    public void openNewsStoryFragment(Bundle bundle) {
        //Obtain the Fragment Manager and Fragment Transaction
        FragmentManager fragmentManager = getSupportFragmentManager(); //Create a Fragment Manager
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //Create a Fragment Transaction from the Fragment Manager

        //Obtain the Fragment and link it to the Fragment Transaction
        Fragment newsStoryFragment = new NewsStoryFragment(); //Instantiate the News Story Fragment
        newsStoryFragment.setArguments(bundle); //Set the Bundle to the Fragment
        fragmentTransaction.replace(R.id.newsStoryFragment, newsStoryFragment).addToBackStack("tag").commit(); //Commit the Fragment Transaction
    }

    //OnClick listener: For each of the News Story images (ImageView)
    public void newStoryOnClick(View view) {
        ImageView newStoryImageView = (ImageView) view; //Obtain the ImageView

        int newStoryImageViewTag = Integer.parseInt(newStoryImageView.getTag().toString()); //Obtain the tag set for each ImageView

        //==== Send data to the News Story Fragment ====
        Bundle bundle = new Bundle(); //Create a Bundle to send data to the NewsStoryFragment
        bundle.putInt(NEWS_STORY_IMAGE_INT, newsStoryArrayList.get(newStoryImageViewTag).getImage()); //Send the Resource ID (int) of the Image Resource of the selected News Story
        bundle.putString(NEWS_STORY_TITLE, newsStoryArrayList.get(newStoryImageViewTag).getTitle()); //Send the Title of the selected News Story
        bundle.putString(NEW_STORY_DESCRIPTION, newsStoryArrayList.get(newStoryImageViewTag).getDescription()); //Send the Description of the selected News Story

        openNewsStoryFragment(bundle); //Open the News Story Fragment
    }

    //OnClick listener: For each of the Top News Story images (ImageView)
    @Override
    public void onTopNewStoryClick(int position) {

        //CHECKPOINT: Verify that the "position" variable reflects the numbering of the selected Top News Story
        Log.i("Top News Story Position",position + "");

        //==== Send data to the News Story Fragment ====
        Bundle bundle = new Bundle();
        bundle.putInt(NEWS_STORY_IMAGE_INT, topNewsStoryArrayList.get(position).getImage()); //Send the Resource ID (int) of the Image Resource of the selected Top News Story
        bundle.putString(NEWS_STORY_TITLE, topNewsStoryArrayList.get(position).getTitle()); //Send the Title of the selected Top News Story
        bundle.putString(NEW_STORY_DESCRIPTION, topNewsStoryArrayList.get(position).getDescription()); //Send the Description of the selected News Story

        openNewsStoryFragment(bundle); //Open the News Story Fragment
    }
}