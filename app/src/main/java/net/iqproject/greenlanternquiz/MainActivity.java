package net.iqproject.greenlanternquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int finalScore; //Keeps track of the final score.

    public MainActivity(){
        finalScore = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the score of the entire quiz, outputting a toast with the final score.
     * @param view
     */
    public void calculateScore(View view){
        finalScore = 0;
        finalScore = (scoreQuestion1() + scoreQuestion2() + scoreQuestion3() + scoreQuestion4() + scoreQuestion5() + scoreQuestion6());
        finalScore = (finalScore * 100)/6;
        Toast toastResult = Toast.makeText(view.getContext(),getString(R.string.final_score_text) + Integer.toString(finalScore),Toast.LENGTH_LONG);
        toastResult.show();
    }

    /**
     * Scores the question one based on the possible options to get it right.
     * @return 1 if is correct or 0 if is not.
     */
    private int scoreQuestion1(){
        TextView a1 = findViewById(R.id.answer_1);
        int answerScore;
        switch(a1.getText().toString().toLowerCase()){
            case "simon baz":
            case "jessica cruz":
            case "hal jordan":
            case "kyle rayner":
            case "guy gardner":
            case "john stewart":
                answerScore = 1;
                break;
            default:
                answerScore = 0;
        }

        return answerScore;
    }

    /**
     * Scores the question one based on the possible options to get it right.
     * @return 1 if is correct or 0 if is not.
     */
    private int scoreQuestion2(){
        CheckBox a21 = findViewById(R.id.answer_2_1);
        CheckBox a22 = findViewById(R.id.answer_2_2);
        CheckBox a23 = findViewById(R.id.answer_2_3);
        CheckBox a24 = findViewById(R.id.answer_2_4);
        CheckBox a25 = findViewById(R.id.answer_2_5);

        if(!a21.isChecked() && !a22.isChecked() && a23.isChecked() && !a24.isChecked() && a25.isChecked()){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * Scores the question one based on the possible options to get it right.
     * @return 1 if is correct or 0 if is not.
     */
    private int scoreQuestion3(){
        RadioGroup a3 = findViewById(R.id.answer_3);
        if(a3.getCheckedRadioButtonId() == R.id.answer_3_4)
            return 1;
        else
            return 0;
    }

    /**
     * Scores the question one based on the possible options to get it right.
     * @return 1 if is correct or 0 if is not.
     */
    private int scoreQuestion4(){
        TextView a4 = findViewById(R.id.answer_4);
        if(a4.getText().toString().equals("9"))
            return 1;
        else
            return 0;
    }

    /**
     * Scores the question one based on the possible options to get it right.
     * @return 1 if is correct or 0 if is not.
     */
    private int scoreQuestion5(){
        CheckBox a51 = findViewById(R.id.answer_5_1);
        CheckBox a52 = findViewById(R.id.answer_5_2);
        CheckBox a53 = findViewById(R.id.answer_5_3);
        CheckBox a54 = findViewById(R.id.answer_5_4);
        CheckBox a55 = findViewById(R.id.answer_5_5);
        CheckBox a56 = findViewById(R.id.answer_5_6);
        if(!a51.isChecked() && !a52.isChecked() && a53.isChecked() && !a54.isChecked() && a55.isChecked() && !a56.isChecked())
            return 1;
        else
            return 0;
    }

    /**
     * Scores the question one based on the possible options to get it right.
     * @return 1 if is correct or 0 if is not.
     */
    private int scoreQuestion6(){
        TextView a6 = findViewById(R.id.answer_6);
        Log.i("Score Tracking 2",a6.getText().toString());
        if(a6.getText().toString().equals("1"))
            return 1;
        else
            return 0;

    }
}
