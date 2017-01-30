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
    }

    public void loadArcher(){
        archer = (ImageView)findViewById(R.id.imgArcher);
        archer.setImageResource(R.drawable.archercharacterbig);

        archer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayScreen.class);
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
                Intent intent = new Intent(v.getContext(), PlayScreen.class);
                intent.putExtra("wizard", 2);
                startActivity(intent);
            }
        });
    }

    public void setupInformation(){
        actionBar = getSupportActionBar();
        actionBar.setTitle("who is jack?");
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
    }

}
