package com.example.prakharsriv.colorphun;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import scoreHandlers.CPScoreManager;
import scoreHandlers.ScoreModels.CPScore;

public class ScoreboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        final CPScoreManager scoreManager = new CPScoreManager(this);

        ArrayList<CPScore> scores = scoreManager.getTopScores();
        Log.i("COLORPHUN", "Total scores fetched: " + scores.size());
        List<String> stringScores = new ArrayList<String>();

        if (scores != null) {
            for (CPScore score: scores) {
                stringScores.add(score.getPlayer() + "         " + score.getScore());
            }
        }

        ArrayAdapter<String> scoreAdapter = new ArrayAdapter<String>(this,
                                                    R.layout.score_list_item,
                                                    R.id.score_list_item_view,
                                                    stringScores);

        ListView scoreListView = (ListView) findViewById(R.id.scores_list_view);
        scoreListView.setAdapter(scoreAdapter);
    }

}
