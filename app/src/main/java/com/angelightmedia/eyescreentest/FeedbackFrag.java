package com.angelightmedia.eyescreentest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedbackFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedbackFrag extends Fragment {

    TextView tv1_Fb_Frag;
    Button bt_nxt_question;
    View v;
    String feedbackText;
    private FragmentBListener fragmentBListener;

    public interface FragmentBListener {

        void onSendToFeedbackB(String feedback);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FeedbackFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedbackFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedbackFrag newInstance(String param1, String param2) {
        FeedbackFrag fragment = new FeedbackFrag();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
    v = inflater.inflate(R.layout.fragment_feedback, container, false);
    tv1_Fb_Frag = v.findViewById(R.id.tv1_fb_Frag);
    bt_nxt_question = v.findViewById(R.id.bt_nxt_question);
    return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        bt_nxt_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             onDetach();
             tv1_Fb_Frag.setText("");

            }
        });
    }

    // method that will take variable from the activity
    //to update the frag
    // i have already hidden the questions frag in activity
    //B gets feedback from A and shows it
    public void updateText(String newText){
       tv1_Fb_Frag.setText(newText);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // check if interface is implemented by activity
        if(context instanceof QuestionsFragment.FragmentListener){
            fragmentBListener = (FragmentBListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must imlement FragmentListiner");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentBListener = null;
    }

}