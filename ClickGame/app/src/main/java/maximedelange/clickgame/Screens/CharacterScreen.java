package maximedelange.clickgame.Screens;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import maximedelange.clickgame.R;

public class CharacterScreen extends AppCompatActivity {

    // Fields
    private ImageView archer = null;
    private ImageView wizard = null;
    private ImageView axethrower = null;
    private ImageView necromancer = null;
    private ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupInformation();
        loadArcher();
        loadWizard();
        loadAxeThrower();
        loadNecroMancer();
    }

    public void loadArcher(){
        archer = (ImageView)findViewById(R.id.imgArcher);
        archer.setImageResource(R.drawable.archercharacterbig);

        archer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapScreen.class);
                intent.putExtra("archer", 1);
                startActivity(intent);
            }
        });
    }

    public void loadWizard(){
        wizard = (ImageView)findViewById(R.id.imgWizard);
        wizard.setImageResource(R.drawable.wizardcharacterbig);

        wizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapScreen.class);
                intent.putExtra("wizard", 2);
                startActivity(intent);
            }
        });
    }

    public void loadAxeThrower(){
        axethrower = (ImageView)findViewById(R.id.imgAxethrower);
        axethrower.setImageResource(R.drawable.axethrowercharacterbig);

        axethrower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapScreen.class);
                intent.putExtra("axethrower", 3);
                startActivity(intent);
            }
        });
    }

    public void loadNecroMancer(){
        necromancer = (ImageView)findViewById(R.id.imgNecromancer);
        necromancer.setImageResource(R.drawable.necromancercharacterbig);

        necromancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapScreen.class);
                intent.putExtra("necromancer", 4);
                startActivity(intent);
            }
        });
    }

    public void setupInformation(){
        actionBar = getSupportActionBar();
        actionBar.hide();
        //actionBar.setTitle("who is jack?");
        //actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
    }

    @Override
    public void onBackPressed() {
        // Do nothing here
    }
}
