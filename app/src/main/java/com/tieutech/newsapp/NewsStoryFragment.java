package com.tieutech.newsapp;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

//ABOUT:
//Fragment to display a News Story. Opened by clicking on a News Story in the MainActivity
public class NewsStoryFragment extends Fragment {

    //================ DECLARE VARIABLES ================
    //Views
    RecyclerView relatedNewsStoryRecyclerView; //RecyclerView
    ImageView newsImageImageView; //News Story Image
    TextView newsStoryTitleTextView; //News Story Title
    TextView newsStoryDescriptionTextView; //News Story Description

    //Key variables - to retrieve data from the Main Activity
    public static String NEWS_STORY_IMAGE_INT = "news_story_image_int";
    public static String NEWS_STORY_TITLE = "news_story_title";
    public static String NEW_STORY_DESCRIPTION = "news_story_description";

    //Other variables
    int newsStoryImageInt;
    String newsStoryTitle;
    String newStoryDescription;

    List<NewsStory> relatedNewsStoryArrayList = new ArrayList<>();  //Related News List (for the Related News vertical RecyclerView section)

    //======> RELATED NEWS (data) <======
    //Image resources
    int[] relatedNewsStoryImageList = {
            R.drawable.news_story_image_11,
            R.drawable.news_story_image_12,
            R.drawable.news_story_image_13,
            R.drawable.news_story_image_14,
            R.drawable.news_story_image_15,
            R.drawable.news_story_image_16
    };

    //Titles
    String[] relatedNewsStoryTitleList = {
            "Market subdued as flight cancellations hit travel stocks",
            "Joint plan for hydrogen hub next to wind farm",
            "Elon Musk and Jeff Bezos go head to head in satellite battle",
            "Hubble Space Telescope spies Earendel in furthest ever look back in time",
            "Carbon innovation needed on larger scale to fight climate change",
            "Cryptocurrency exchanges shun EU anti-laundering directive"
    };

    //Descriptions
    String[] relatedNewsStoryDescriptionList = {
            "Travel shares fell this morning after airlines had to cancel flights, blaming the disruption on staff having coronavirus. IAG fell 2p, or 1.4 per cent, to 139¼p after the British Airways owner scaled back its timetable until the end of May because of staff shortages and illness caused by Covid. EasyJet, the budget airline, which has axed at least 222 flights since Friday, slipped 11½p, or 2.1 per cent, to 544p. ",
            "SSE and Siemens Gamesa plan to create a green hydrogen hub next to a Highlands wind farm. The two companies want to invest tens of millions of pounds to build an electrolyser to create the hydrogen and a battery storage facility at the Gordonbush site in Sutherland. They announced last year they were looking at opportunities to create facilities at onshore sites.",
            "Amazon has bought space on scores of rockets to launch its $10 billion network of satellites as it tries to compete with Elon Musk in the quest to deliver a fully operational internet service.",
            "Astronomers have looked further back in time than ever before to glimpse a star as it looked 12.9 billion years ago — a discovery made possible by the Hubble Space Telescope and an extraordinary wrinkle in the fabric of space. Earendel — an Old English term for “morning star” — formed within the first billion years after the Big Bang, when the universe was 7 per cent of its present age. The most distant single star ever seen, it is 50 times the mass of our sun and millions of times as bright",
            "Drastic action is needed to limit climate change, including sucking CO2 out of the air, the UN has warned. The process has been used for more than 50 years on a small scale: on submarines to keep the crew alive; spacecraft use something similar for astronauts. Removing CO2 on a large scale is a different proposition but is urgently needed, the Intergovernmental Panel on Climate Change (IPCC) says.",
            "No cryptocurrency exchanges have registered with the Central Bank almost a year after an EU anti-money laundering and financial terrorism directive requiring them to do so came into force. The bank said it was engaging with a “significant” number of firms in relation to applications for registration and their anti-money laundering frameworks. It said it has “prioritised” the assessment of applications."
    };

    //================ DEFINE METHODS ================
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsStoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsStoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsStoryFragment newInstance(String param1, String param2) {
        NewsStoryFragment fragment = new NewsStoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //Upon the start of the creation of the entire view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //If there are data sent from the Main Activity
        if (getArguments() != null) {
            //Retrieve data sent from the Main Activity
            newsStoryImageInt = getArguments().getInt(NEWS_STORY_IMAGE_INT); //News Story Image
            newsStoryTitle = getArguments().getString(NEWS_STORY_TITLE); //News Story Title
            newStoryDescription = getArguments().getString(NEW_STORY_DESCRIPTION); //News Story Description
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_story, container, false);
    }

    //Upon the creation of the entire view
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //Obtain views
        newsImageImageView = (ImageView) getView().findViewById(R.id.newsImageImageView); //News Story Image
        newsStoryTitleTextView = (TextView) getView().findViewById(R.id.newsStoryTitleTextView); //News Story Title
        newsStoryDescriptionTextView = (TextView) getView().findViewById(R.id.newsStoryDescriptionTextView); //News Story Description
        relatedNewsStoryRecyclerView = (RecyclerView) getView().findViewById(R.id.relatedNewsStoriesRecyclerView); //RecyclerView to display the Related News Stories

        //Modify the views
        newsImageImageView.setImageResource(newsStoryImageInt);
        newsStoryTitleTextView.setText(newsStoryTitle);
        newsStoryDescriptionTextView.setText(newStoryDescription);

        //RecyclerViewAdapter to link the RecyclerView for Related Stories to the data
        RelatedNewsStoryRecyclerViewAdapter relatedNewsStoryRecyclerViewAdapter = new RelatedNewsStoryRecyclerViewAdapter(relatedNewsStoryArrayList, getActivity()); //Instantiate the Recyclerview Adapter
        relatedNewsStoryRecyclerView.setAdapter(relatedNewsStoryRecyclerViewAdapter); //Set the Adapter to the RecyclerView

        //LinearLayoutManager to set the layout of the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        relatedNewsStoryRecyclerView.setLayoutManager(layoutManager); //Link the LayoutManager to the RecyclerView

        //Instantiate all the Related News Story objects and add them to the relatedNewsStoryArrayList
        for (int i = 0; i < relatedNewsStoryImageList.length; i++) {
            NewsStory topNewsStory = new NewsStory(relatedNewsStoryImageList[i], relatedNewsStoryTitleList[i], relatedNewsStoryDescriptionList[i]);
            relatedNewsStoryArrayList.add(topNewsStory);
        }
    }
}