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




public class MainActivity extends AppCompatActivity implements TopNewsStoryRecyclerViewAdapter.OnNewsStoriesListener {



    public static String NEWS_STORY_IMAGE_INT = "news_story_image_int";
    public static String NEWS_STORY_TITLE = "news_story_title";
    public static String NEW_STORY_DESCRIPTION = "news_story_description";

    RecyclerView topNewsStoryRecyclerView;
    TopNewsStoryRecyclerViewAdapter topNewsStoryRecyclerViewAdapter;

    Fragment fragment;

    List<NewsStory> topNewsStoryArrayList = new ArrayList<>();
    public List<NewsStory> newsStoryArrayList = new ArrayList<>();

    GridLayout newsGridLayout;

    int[] topNewsStoryImageList = {
            R.drawable.news_story_image_1,
            R.drawable.news_story_image_2,
            R.drawable.news_story_image_3,
            R.drawable.news_story_image_4,
            R.drawable.news_story_image_5,
            R.drawable.news_story_image_6
    };

    String[] topNewsStoryTitleList = {
            "Bridgerton: A New Prequel Will Track Queen Charlotte's Origin Story",
            "The harsh twist in the TV comedy about Ukraine’s accidental president",
            "Twitter is adding an edit button",
            "Elon Musk’s net worth soars as he is appointed to Twitter board",
            "Wall Street suffers biggest slide in more than a year as oil prices surge",
            "Virgin Australia and Qantas launch airfares sale in WA and across Australia"
    };

    String[] topNewsStoryDescriptionList = {
            "It’s the line that Anthony delivers to Kate in the latest series of Bridgerton, but the same could be said of how I feel about Bridgerton — a show that’s both compelling and infuriating.",
            "Servant of the People is a good comedy that you might feel bad for laughing at. History hasn’t simply passed by this 2015 satire about an everyman made leader of his country – it has amplified the concept and made us look at it anew.",
            "It’s a feature that Twitter users have been requesting for so long that it’s become a meme, but now the mythical “edit button” is actually becoming a reality. Twitter has announced that it’s working to allow users to edit their tweets after posting them.",
            "Elon Musk is now the richest man ever — by a fair margin. The Tesla CEO’s fortune has shot up as the stock price of his companies, Tesla and SpaceX, continues to rise. The net worth of the world’s richest man has soared to $395 billion (USD$300 billion).",
            "The S&P 500 fell 3%, its biggest decline in 16 months, after a barrel of US oil surged to $130 overnight on the possibility the US could bar imports from Russia. Stocks around the world also fell earlier in the day, taking their cue from oil’s movements, though their losses moderated as crude receded toward $120 per barrel.",
            "A cheap airfares bonanza is enticing travellers to holiday in WA and across the nation. Virgin Australia has launched a massive 1.5 million “cheap” seats with one-way prices as low as $149 to Adelaide in economy class. And there is a further bonus 25 per cent discount for children aged two to 11."
    };


    int[] newsStoryImageList = {
            R.drawable.news_story_image_7,
            R.drawable.news_story_image_8,
            R.drawable.news_story_image_9,
            R.drawable.news_story_image_10
    };

    String[] newsStoryTitleList = {
            "Huge mansion with cinema room and sauna you can book for a weekend break",
            "‘Clear message’: Labor promises to bid to host global climate change summit if elected",
            "How worried should we be about the new ‘Deltacron’ COVID hybrid?",
            "Manchester City 1-0 Atlético Madrid: Champions League quarter-final, first leg – as it happened"
    };

    String[] newsStoryDescriptionList = {
            "Just one hour and twenty minutes away from Liverpool is Moorlands in Foulridge , a luxurious mansion that sleeps a whopping 27 people. With a main house and a coach house, the setting is like something straight from a movie with a beautiful private garden and plenty of dreamy features.",
            "Australia would bid to host a United Nations climate change summit in partnership with other Pacific nations if Labor won next month’s federal election as part of the federal opposition’s bid to improve the nation’s credentials with the region on the issue.",
            "For some, news of new COVID-19 variants, which appear to have formed when different strains of the virus combine, sounds like a worst-case scenario. And it’s little comfort that they have appeared as many of Australia’s measures to control the pandemic are being wound back, including reopening our borders to more and more of the world.",
            "“It was a very hard game. They played so defensively and they’re solid. They played almost 5-5-0 and it’s very hard to find spaces. I would recommend to anyone who says something about our performance to try it on the training pitch."
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragment = (Fragment) findViewById(R.id.fragment);



        //Obtain RecyclerView view (inside activity_main.xml)
        topNewsStoryRecyclerView = (RecyclerView) findViewById(R.id.topNewsStoriesRecyclerView);
        newsGridLayout = (GridLayout) findViewById(R.id.newsGridLayout);






        //Create RecyclerViewAdapter (which links the RecyclerView to the data)
        topNewsStoryRecyclerViewAdapter = new TopNewsStoryRecyclerViewAdapter(topNewsStoryArrayList, this, this);
        topNewsStoryRecyclerView.setAdapter(topNewsStoryRecyclerViewAdapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        topNewsStoryRecyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < topNewsStoryImageList.length; i++) {
            NewsStory topNewsStory = new NewsStory(topNewsStoryImageList[i], topNewsStoryTitleList[i], topNewsStoryDescriptionList[i]);
            topNewsStoryArrayList.add(topNewsStory);
        }







        //CHECKPOINT: Check how many views are in the newsGridLayout view
        Log.i("getChildCount", newsGridLayout.getChildCount() + "");

        for (int i = 0; i < newsStoryImageList.length; i++) {

            NewsStory newsStory = new NewsStory(newsStoryImageList[i], newsStoryTitleList[i], newsStoryDescriptionList[i]);

            newsStoryArrayList.add(newsStory);
        }


        int newsStoryIndex = 0;

        for (int i = 0; i < newsGridLayout.getChildCount(); i++) {

            View child = newsGridLayout.getChildAt(i);

            if (child instanceof ImageView) {
                ((ImageView) child).setImageResource(newsStoryArrayList.get(newsStoryIndex).getImage());
            } else if ((child instanceof TextView) && (i == 1 || i == 4 || i == 7 || i == 10)) {
                ((TextView) child).setText(newsStoryArrayList.get(newsStoryIndex).getTitle());
            } else if ((child instanceof TextView) && (i == 2 || i == 5 || i == 8 || i == 11)) {
                ((TextView) child).setText(newsStoryArrayList.get(newsStoryIndex).getDescription());
                newsStoryIndex++;
            }

        }






        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        Fragment bottomFragment = manager.findFragmentById(R.id.newsStoryFragment);
        ft.hide(bottomFragment);
        ft.commit();
    }







    public void recyclerViewItemOnClick(View view) {

//        TopNewsStoryRecyclerViewAdapter.ViewHolder viewHolder = (TopNewsStoryRecyclerViewAdapter.ViewHolder) view.getTag();
//
//        Log.i("tagg", viewHolder.toString());
//
//        topNewsStoryRecyclerView.getTag();
        Log.i("tagg", topNewsStoryRecyclerView.getTag() + "");

    }



















    public void newStoryOnClick(View view) {

        ImageView newStoryImageView = (ImageView) view;

        Bundle bundle = new Bundle();


        int newStoryImageViewTag = Integer.parseInt(newStoryImageView.getTag().toString());


        bundle.putInt(NEWS_STORY_IMAGE_INT, newsStoryArrayList.get(newStoryImageViewTag).getImage());
        bundle.putString(NEWS_STORY_TITLE, newsStoryArrayList.get(newStoryImageViewTag).getTitle());
        bundle.putString(NEW_STORY_DESCRIPTION, newsStoryArrayList.get(newStoryImageViewTag).getDescription());

        Log.i("NEWS_STORY_INDEX", Integer.parseInt(newStoryImageView.getTag().toString()) + "");



        Fragment newsStoryFragment = new NewsStoryFragment();

        newsStoryFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.newsStoryFragment, newsStoryFragment).addToBackStack( "tag" ).commit();


    }




    @Override
    public void onTopNewStoryClick(int position) {
        topNewsStoryArrayList.get(position);

        Log.i("onNoteClciked", position + "");







        Bundle bundle = new Bundle();


        bundle.putInt(NEWS_STORY_IMAGE_INT, topNewsStoryArrayList.get(position).getImage());
        bundle.putString(NEWS_STORY_TITLE, topNewsStoryArrayList.get(position).getTitle());
        bundle.putString(NEW_STORY_DESCRIPTION, topNewsStoryArrayList.get(position).getDescription());





        Fragment newsStoryFragment = new NewsStoryFragment();

        newsStoryFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.newsStoryFragment, newsStoryFragment).addToBackStack( "tag" ).commit();




    }


}