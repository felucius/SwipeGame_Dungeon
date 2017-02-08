package maximedelange.clickgame.Screens;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import maximedelange.clickgame.Controller.BackgroundAnimationController;
import maximedelange.clickgame.Database.Database;
import maximedelange.clickgame.R;

public class StartScreen extends AppCompatActivity {

    // Fields
    private Button btnPlay;
    private Button btnCredits;
    private int score = 0;
    private Database database;
    private TextView textScore;
    private TextView textScoreShow;
    private TextView appName;
    private ActionBar actionBar;
    private BackgroundAnimationController backgroundAnimationController = null;
    private AnimationDrawable background = null;
    private ImageView startscreen = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        database = new Database(this, null, null, 1);
        initializeStartScreen();
        getCredits();
        setupForPlay();
        backgroundAnimation();
    }

    public void initializeStartScreen(){
        actionBar = getSupportActionBar();
        actionBar.hide();
        //actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
        appName = (TextView)findViewById(R.id.txtAppName);
        appName.setText("PIKSEL TAP");
        appName.setTextColor(Color.WHITE);
        textScoreShow = (TextView)findViewById(R.id.txtHighscoreShow);
        textScoreShow.setText("current highscore");
        textScoreShow.setTextColor(Color.GRAY);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPlay.setText("PLAY");
        btnPlay.setTextColor(Color.WHITE);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CharacterScreen.class);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }

    public void getCredits(){
        btnCredits = (Button)findViewById(R.id.btnCredits);
        btnCredits.setText("CREDITS");
        btnCredits.setTextColor(Color.WHITE);
        btnCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartScreen.this, "this is not working yet.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setupForPlay(){
        textScore = (TextView)findViewById(R.id.txtHighscore);
        score = Integer.valueOf(database.getHighscore());
        textScore.setText(String.valueOf(score));
        textScore.setTextColor(Color.GRAY);
    }

    public void backgroundAnimation(){
        startscreen = (ImageView)findViewById(R.id.backgroundscreen);
        backgroundAnimationController = new BackgroundAnimationController(StartScreen.this);
        background = backgroundAnimationController.getPlayscreenBackground();
        startscreen.setBackgroundDrawable(background);
        background.start();
    }
}
