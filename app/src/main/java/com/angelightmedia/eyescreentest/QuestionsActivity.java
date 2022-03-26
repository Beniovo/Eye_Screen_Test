package com.angelightmedia.eyescreentest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class QuestionsActivity extends AppCompatActivity implements QuestionsFragment.FragmentListener, FeedbackFrag.FragmentBListener {

    private QuestionsFragment questionsFragment;
    private  FeedbackFrag feedbackFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);



        questionsFragment = new QuestionsFragment();
        feedbackFrag = new FeedbackFrag();
        fragmentManager = this.getSupportFragmentManager();

       fragmentManager.beginTransaction()
                .show(questionsFragment)
                .hide(feedbackFrag)
                .commit();
    }



    @Override
    //we are implementing the interface here
    public void onSendToFeedbackA(String feedback) {
        //sending feedback from frag a to b
        //activity gets the feedback and sends to B and hides questions
        feedbackFrag.updateText(feedback);
        // hiding the questionfrag
        fragmentManager.beginTransaction()
                //.R.id.replace(questionsFragment)
                .commit();


    }

    @Override
    public void onSendToFeedbackB(String feedback) {
        //send from feedback to question fragment

    }


}