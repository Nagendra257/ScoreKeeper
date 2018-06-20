package com.example.android.scorekeeper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int team_a_score = 0;
    public int team_b_score = 0;
    public TextView scoreOne;
    public TextView scoreTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreOne = (TextView) findViewById(R.id.score_a);
        scoreTwo = (TextView) findViewById(R.id.score_b);
    }

    public void displayTeamScoreA() {
        TextView scoreA = (TextView) findViewById(R.id.score_a);
        scoreA.setText(String.valueOf(team_a_score));
    }

    public void textColorChange(int scoreTeamA, int scoreTeamB) {
        TextView teamA = findViewById(R.id.score_a);
        TextView teamB = findViewById(R.id.score_b);
        if (scoreTeamB > scoreTeamA) {
            teamB.setTextColor(Color.parseColor("#76FF03"));
            teamA.setTextColor(Color.parseColor("#FF5722"));
        } else if (scoreTeamB < scoreTeamA) {
            teamA.setTextColor(Color.parseColor("#76FF03"));
            teamB.setTextColor(Color.parseColor("#FF5722"));
        } else if (scoreTeamA == scoreTeamB && scoreTeamA != 0 || scoreTeamB != 0) {
            teamA.setTextColor(Color.parseColor("#4A148C"));
            teamB.setTextColor(Color.parseColor("#4A148C"));
        } else {
            teamA.setTextColor(Color.parseColor("#000000"));
            teamB.setTextColor(Color.parseColor("#000000"));
        }
    }


    public void addSixPointsForA(View view) {
        team_a_score += 6;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreA();

    }

    public void addThreePointsForA(View view) {
        team_a_score += 3;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreA();
    }

    public void addOnePointsForA(View view) {
        team_a_score += 1;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreA();
    }

    public void penaltyPointsForA(View view) {
        if (team_a_score == 0) {
            textColorChange(team_a_score, team_b_score);

            return;
        }
        team_a_score -= 1;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreA();
    }


    ///////
    public void addSixPointsForB(View view) {
        team_b_score += 6;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreB();
    }

    public void addThreePointsForB(View view) {
        team_b_score += 3;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreB();
    }

    public void displayTeamScoreB() {
        TextView scoreB = (TextView) findViewById(R.id.score_b);
        textColorChange(team_a_score, team_b_score);

        scoreB.setText(String.valueOf(team_b_score));
    }

    public void addOnePointsForB(View view) {
        team_b_score += 1;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreB();
    }

    public void penaltyPointsForB(View view) {
        if (team_b_score == 0) {
            textColorChange(team_a_score, team_b_score);

            return;
        }
        team_b_score -= 1;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreB();
    }

    public void resetScores(View view) {
        team_a_score = 0;
        team_b_score = 0;
        textColorChange(team_a_score, team_b_score);

        displayTeamScoreA();
        displayTeamScoreB();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("scoreTeamA", scoreOne.getText().toString());
        outState.putString("scoreTeamB", scoreTwo.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreOne.setText(savedInstanceState.getString("scoreTeamA"));
        scoreTwo.setText(savedInstanceState.getString("scoreTeamB"));


        TextView teamA = (TextView) findViewById(R.id.score_a);
        team_a_score = Integer.parseInt(teamA.getText().toString());
        TextView teamB = (TextView) findViewById(R.id.score_b);
        team_b_score = Integer.parseInt(teamB.getText().toString());
        displayTeamScoreA();
        displayTeamScoreB();
        textColorChange(team_a_score, team_b_score);

    }


}
