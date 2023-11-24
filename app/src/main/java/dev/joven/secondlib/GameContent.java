package dev.joven.secondlib;
import androidx.appcompat.app.AppCompatActivity;

import com.mgd.mgddevtools.mgdUtil;

import com.mgd.mgddevtools.mgdUserPolicy;
import com.mgd.mgddevtools.mgdGameView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;

public class GameContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(1024,1024); // Remove system UI at the Top of the Screen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // Remove Title BAR

        setContentView(R.layout.activity_game_content);

        mgdGameView gameView = findViewById(R.id.gameContent);
        gameView.setVisibility(View.INVISIBLE);

        mgdUserPolicy policy = new mgdUserPolicy(this);
        policy.setPositiveButtonClickListener( positive ->{
            policy.closeCreatedDialog();

            new Handler(Looper.getMainLooper()).postDelayed(()->{
                gameView.setVisibility(View.VISIBLE);
                gameView.createGameUI(mgdUtil.gameURL,true,"ca-app-pub-9426884596605370~7786852062");
            },300);

        });

        policy.setNegativeButtonClickListener( positive ->{
            policy.closeCreatedDialog();
            finishAffinity();
        });

        policy.createPolicyDialog("https://wlgames.site/policy","I Agree", Color.RED,"Don't Agree",Color.GREEN);
    }
}
