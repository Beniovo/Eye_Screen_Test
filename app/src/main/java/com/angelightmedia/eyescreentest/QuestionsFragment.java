package com.angelightmedia.eyescreentest;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuestionsFragment extends Fragment {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;
    View v;
    List<Question> questionsList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private ColorStateList textColorDefaultRb;
    public String feedback;

    private int score;
    private boolean answered;
    private TextView tv1_Qtn_Frag, tv2_Qtn_Frag, tvCounter;
    private ImageView iv1_Qtn_Frag;
    private RadioGroup radioGrp_Qtn_Frag;
    private RadioButton rBtn_Optn1, rBtn_Optn2, rBtn_Optn3, rBtn_Optn4, rBtn_Optn5, rBtn_Optn6,
            rBtn_Optn7, rBtn_Optn8, rBtn_Optn9;
    private Button btn_Submit_Qtn_Frag;
    private FragmentListener fragmentListener;

    public interface FragmentListener {

        void onSendToFeedbackA(String feedback);
    }

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */

    //private View mContentView;
    //private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            v.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



    v = inflater.inflate(R.layout.fragment_questions, container, false);
        tv1_Qtn_Frag = v.findViewById(R.id.tv1_Qtn_Frag);
        tv2_Qtn_Frag = v.findViewById(R.id.tv2_Qtn_Frag);
        tvCounter = v.findViewById(R.id.tvCounter);
        iv1_Qtn_Frag= v.findViewById(R.id.iv1_Qtn_Frag);
        radioGrp_Qtn_Frag = v.findViewById(R.id.radioGrp_Qtn_Frag);
        rBtn_Optn1 = v.findViewById(R.id.rBtn_Optn1);
        rBtn_Optn2 = v.findViewById(R.id.rBtn_Optn2);
        rBtn_Optn3 = v.findViewById(R.id.rBtn_Optn3);
        rBtn_Optn4 = v.findViewById(R.id.rBtn_Optn4);
        rBtn_Optn5 = v.findViewById(R.id.rBtn_Optn5);
        rBtn_Optn6 = v.findViewById(R.id.rBtn_Optn6);
        rBtn_Optn7 = v.findViewById(R.id.rBtn_Optn7);
        rBtn_Optn8 = v.findViewById(R.id.rBtn_Optn8);
        rBtn_Optn9 = v.findViewById(R.id.rBtn_Optn9);
        btn_Submit_Qtn_Frag = v.findViewById(R.id.btn_Submit_Qtn_Frag);
        textColorDefaultRb = rBtn_Optn1.getTextColors();

   return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVisible = true;

        //get all questions in a list
        DBHelper dbHelper = new DBHelper(getContext(), null, null, 1);
        questionsList = dbHelper.getAllQuestions();
        questionCountTotal = questionsList.size();

        //show the next question method
        showNextQuestion();

        //click here to submit answer
        btn_Submit_Qtn_Frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if answered is false then
                if(!answered){
                    //check if any button is checked
                    if(rBtn_Optn1.isChecked() || rBtn_Optn2.isChecked()){
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(getContext(), "please answer question", Toast.LENGTH_SHORT).show();
                    }
                }else // if answered is true
                    {showFeedback();
                }
            }
        });




        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
       // view.findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }
      //passing data to other fragment
    public void updateText(String newText){


    }




    private void showNextQuestion(){

        rBtn_Optn1.setTextColor(textColorDefaultRb);
        rBtn_Optn1.setVisibility(View.INVISIBLE);
        rBtn_Optn2.setTextColor(textColorDefaultRb);
        rBtn_Optn2.setVisibility(View.INVISIBLE);
        rBtn_Optn3.setTextColor(textColorDefaultRb);
        rBtn_Optn3.setVisibility(View.INVISIBLE);
        rBtn_Optn4.setTextColor(textColorDefaultRb);
        rBtn_Optn4.setVisibility(View.INVISIBLE);
        rBtn_Optn5.setTextColor(textColorDefaultRb);
        rBtn_Optn5.setVisibility(View.INVISIBLE);
        rBtn_Optn6.setTextColor(textColorDefaultRb);
        rBtn_Optn6.setVisibility(View.INVISIBLE);
        rBtn_Optn7.setTextColor(textColorDefaultRb);
        rBtn_Optn7.setVisibility(View.INVISIBLE);
        rBtn_Optn8.setTextColor(textColorDefaultRb);
        rBtn_Optn8.setVisibility(View.INVISIBLE);
        rBtn_Optn9.setTextColor(textColorDefaultRb);
        rBtn_Optn9.setVisibility(View.INVISIBLE);
        radioGrp_Qtn_Frag.clearCheck();

        if(questionCounter < questionCountTotal) {

            currentQuestion = questionsList.get(questionCounter);
            //currentImage = ;
            //currentInstruction = ;


            tv1_Qtn_Frag.setText(currentQuestion.getQuestion());
            if(currentQuestion.getOption1()!= "null") {
                rBtn_Optn1.setText(currentQuestion.getOption1());
                rBtn_Optn1.setVisibility(View.VISIBLE);
            }
            if(currentQuestion.getOption1()!= "null") {
                rBtn_Optn2.setText(currentQuestion.getOption1());
                rBtn_Optn2.setVisibility(View.VISIBLE);
            }

            questionCounter++;
            tvCounter.setText(R.string.question  + questionCounter + R.string.slash + questionCountTotal);
            answered = false;
            //btn_Submit_Qtn_Frag.setText(R.string.submit);
        }else{
            btn_Submit_Qtn_Frag.setText(R.string.submit);
            finishQuiz();


        }
    }

    private void finishQuiz(){

        Intent resultIntent = new Intent();
        //resultIntent.putExtra();

        onDetach();
    }

    private void showFeedback() {


            currentQuestion = questionsList.get(questionCounter);
            feedback = currentQuestion.getFeedback();
            //sending feedback to activity
            fragmentListener.onSendToFeedbackA(feedback);

    }

    private void checkAnswer(){
       answered = true;

       RadioButton rbSelelected = v.findViewById(radioGrp_Qtn_Frag.getCheckedRadioButtonId());
       String answer = rbSelelected.getText().toString();
       if(answer.trim().equals(currentQuestion.getAnswer().trim())){
           rbSelelected.setTextColor(Color.GREEN);
           score++;
       }
       else {rbSelelected.setTextColor(Color.RED);}



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // check if interface is implemented by activity
        if(context instanceof FragmentListener){
            fragmentListener = (FragmentListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must imlement FragmentListiner");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    v= null;

    }



    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        v.setVisibility(View.GONE);
        mVisible = false;


    }

    @Nullable
    private ActionBar getSupportActionBar() {
        ActionBar actionBar = null;
        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            actionBar = activity.getSupportActionBar();
        }
        return actionBar;
    }
}