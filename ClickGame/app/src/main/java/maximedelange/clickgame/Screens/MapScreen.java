package maximedelange.clickgame.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import maximedelange.clickgame.R;

public class MapScreen extends AppCompatActivity {

    private ImageButton btnGoToLevel;
    private ImageView gameMap;
    private ActionBar actionBar;
    private int level = 1;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadLevel1();
        loadLevel2();
        loadLevel3();
        loadLevel4();
        loadGameMap();
    }

    public void loadLevel1(){
        btnGoToLevel = (ImageButton)findViewById(R.id.btnlevel1);
        btnGoToLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), PlayScreen.class); // TODO PLAYSCREEN = level 1, 2 etc..
                intent.putExtra("level", 1);
                loadCharacter();
                startActivity(intent);
            }
        });
    }

    public void loadLevel2(){
        btnGoToLevel = (ImageButton)findViewById(R.id.btnlevel2);
        btnGoToLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), PlayScreen.class); // TODO PLAYSCREEN = level 1, 2 etc..
                intent.putExtra("level", 2);
                loadCharacter();
                startActivity(intent);
            }
        });
    }

    public void loadLevel3(){
        btnGoToLevel = (ImageButton)findViewById(R.id.btnlevel3);
        btnGoToLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), PlayScreen.class); // TODO PLAYSCREEN = level 1, 2 etc..
                intent.putExtra("level", 3);
                loadCharacter();
                startActivity(intent);
            }
        });
    }

    public void loadLevel4(){
        btnGoToLevel = (ImageButton)findViewById(R.id.btnlevel4);
        btnGoToLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), PlayScreen.class); // TODO PLAYSCREEN = level 1, 2 etc..
                intent.putExtra("level", 4);
                loadCharacter();
                startActivity(intent);
            }
        });
    }

    public void loadGameMap(){
        actionBar = getSupportActionBar();
        actionBar.hide();
        gameMap = (ImageView)findViewById(R.id.imgMap);
        gameMap.setImageResource(R.drawable.backgroundmap);
    }

    public void loadCharacter(){
        Intent intentGet = getIntent();
        if(intentGet.getIntExtra("archer", 0) == 1){
            intent.putExtra("archer", 1);
        }
        else if(intentGet.getIntExtra("wizard", 0) == 2){
            intent.putExtra("wizard", 2);
        }
        else if(intentGet.getIntExtra("axethrower", 0) == 3){
            intent.putExtra("axethrower", 3);
        }
        else if(intentGet.getIntExtra("necromancer", 0) == 4){
            intent.putExtra("necromancer", 4);
        }
    }

    @Override
    public void onBackPressed() {
        // Do nothing here
    }
}
