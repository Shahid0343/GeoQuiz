package com.shahid.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mTextView;
    private Button mNextBtn;
    //array of question class
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_ocean, true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_america,true),
            new Question(R.string.question_asia,true)
    };

    private int indexOfQuestion = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueBtn = (Button) findViewById(R.id.btn_true);
        mFalseBtn = (Button) findViewById(R.id.btn_false);
        mNextBtn = (Button) findViewById(R.id.btn_next);
        mTextView = (TextView) findViewById(R.id.question_text_view);
        this.upDateQuestion();
        mTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indexOfQuestion = (indexOfQuestion + 1) % mQuestionBank.length;
                upDateQuestion();
            }
        });
    }

    private void upDateQuestion(){
        int questionOfTextId = mQuestionBank[indexOfQuestion].getmTextResId();
        mTextView.setText(questionOfTextId);
    }

    private void checkAnswer(boolean ans){
        boolean ansTrue = mQuestionBank[indexOfQuestion].ismAnsTrue();
        int massageRsId = 0;
        if(ans == ansTrue){
            massageRsId = R.string.correct_toast;
        }else {
            massageRsId = R.string.incorrect_toast;
        }
        Toast.makeText(this,massageRsId,Toast.LENGTH_LONG).show();
    }
}
