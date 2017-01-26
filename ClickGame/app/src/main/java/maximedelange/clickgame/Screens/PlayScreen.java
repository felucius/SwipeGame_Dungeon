package maximedelange.clickgame.Screens;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import maximedelange.clickgame.Controller.EnemyController;
import maximedelange.clickgame.Controller.PlayerController;
import maximedelange.clickgame.Database.Database;
import maximedelange.clickgame.Domain.Coordinates;
import maximedelange.clickgame.R;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class PlayScreen extends AppCompatActivity {

    // Fields
    private int upgradecostHealth = 0;
    private int upgradecostDamage = 0;
    private int score = 0;
    private int currentScore = 0;
    private int highScore = 0;
    private int xPos = 0;
    private int yPos = 0;
    private int x = 0;
    private int y = 0;
    private String tutorialID = null;
    private int direction;
    private int enemyNameMovement1, enemyNameMovement2, enemyNameMovement3 = 0;
    private int enemyMovement1, enemyMovement2, enemyMovement3 = 0;
    private int enemyHealthBar1, enemyHealthBar2, enemyHealthBar3 = 0;
    private int enemyHealthShow1, enemyHealthShow2, enemyHealthShow3 = 0;
    private int enemyHealthCounter = 0;
    private int playerHealthBegin = 0;
    private int playerDamageBegin = 1;
    private int enemyHealthBegin = 0;
    private boolean isColliding = false;
    private CountDownTimer countDownMovement = null;
    private PlayerController playerController = null;
    private EnemyController enemyController = null;
    private Coordinates coordinates = null;
    private Database database = null;
    private AnimationDrawable characterspriteAnim = null;
    private AnimationDrawable skeletonspriteAnim = null;
    private AnimationDrawable backgroundAnim = null;
    private boolean IS_ACTIVATED = false;
    private boolean IS_ACTIVED_ONETIME = false;
    private boolean HIT_PLAYBUTTON = false;
    private boolean IS_KILLABLE = false;

    // GUI components
    private RelativeLayout linearLayout = null;
    private ImageView enemy = null;
    private ImageView player = null;
    private ImageView damage = null;
    private ProgressBar healthBar = null;
    private ProgressBar enemyHealth = null;
    private TextView playerName = null;
    private TextView damageTxt = null;
    private TextView enemyHealthTxt = null;
    private TextView enemyName = null;
    private TextView playerHealthTxt = null;
    private TextView currentScoreTxt = null;
    private TextView highScoreTxt = null;
    private TextView playerGold = null;
    private ImageButton btnStart = null;
    private ImageButton btnUpgradeScreen = null;
    private ImageButton btnStatusScreen = null;
    private Button dismisspopup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create database
        database = new Database(this, null, null, 1);
        // Initialize gameplay information
        initializeGameInformation();
        createEnemy();
        //showTutorial("1");
        playGame();
        upgradeScreen();
        statusScreen();
        spriteAnimation(direction);
    }

    public void spriteAnimation(int direction){
        switch(direction){
            case 0:
                skeletonspriteAnim = new AnimationDrawable();
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright1), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright2), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright3), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright4), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright5), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright6), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugright7), 150);
                break;
            case 1:
                skeletonspriteAnim = new AnimationDrawable();
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft1), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft2), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft3), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft4), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft5), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft6), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugleft7), 150);
                break;
            case 2:
                skeletonspriteAnim = new AnimationDrawable();
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup1), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup2), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup3), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup4), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup5), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup6), 150);
                skeletonspriteAnim.addFrame(getResources().getDrawable(R.drawable.slugup7), 150);
                break;
        }
    }

    public void characterAnimation(int enemyDirection){
        switch(enemyDirection){
            case 0:
                characterspriteAnim = new AnimationDrawable();
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left1), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left2), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left3), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left4), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left5), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left6), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left7), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left8), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.left9), 150);
                break;
            case 1:
                characterspriteAnim = new AnimationDrawable();
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right1), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right2), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right3), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right4), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right5), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right6), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right7), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right8), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.right9), 150);
                break;
            case 2:
                characterspriteAnim = new AnimationDrawable();
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down1), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down2), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down3), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down4), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down5), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down6), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down7), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down8), 150);
                characterspriteAnim.addFrame(getResources().getDrawable(R.drawable.down9), 150);
                break;
        }

    }

    public void backgroundAnimation(){
        backgroundAnim = new AnimationDrawable();
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest1), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest2), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest3), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest4), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest5), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest6), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest7), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest8), 450);
        backgroundAnim.addFrame(getResources().getDrawable(R.drawable.backgroundforest9), 450);
    }

    public void startGame(){
        if(HIT_PLAYBUTTON){
            if(!IS_ACTIVED_ONETIME){
                setEnemyMovement();
                damageEnemy();
                IS_ACTIVATED = true;
                IS_KILLABLE = true;
                IS_ACTIVED_ONETIME = true;
            }
            else if(!IS_ACTIVATED){
                setEnemyMovement();
                damageEnemy();
                IS_ACTIVATED = true;
                IS_KILLABLE = true;
            }
        }
    }

    public void pauseGame(){
        if(IS_ACTIVATED) {
            countDownMovement.cancel();
            Toast.makeText(PlayScreen.this, "paused", Toast.LENGTH_SHORT).show();
            enemy.setOnClickListener(null);
            IS_ACTIVATED = false;
        }
    }

    public void playGame(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HIT_PLAYBUTTON = true;
                if(!IS_ACTIVED_ONETIME){
                    startGame();
                }
                else if(IS_ACTIVATED){
                    pauseGame();

                    final Dialog dialog = new Dialog(PlayScreen.this);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setContentView(R.layout.pause_screen);
                    dialog.show();

                    Button pauseContinue = (Button)dialog.findViewById(R.id.continueGame);
                    pauseContinue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            startGame();
                        }
                    });

                    Button pauseExit = (Button)dialog.findViewById(R.id.exitGame);
                    pauseExit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(), StartScreen.class);
                            // TODO: SAVING THE HIGHSCORE... IF THERE IS ANY
                            // TODO: ALSO GIVE WARNING MESSAGE IF THEY REALLY WANT TO QUIT.
                            startActivity(intent);
                        }
                });
                }
            }
        });
    }

    public void upgradeScreen(){
        btnUpgradeScreen.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                pauseGame();

                final Dialog dialog = new Dialog(PlayScreen.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.upgrade_screen);

                final TextView upgradeHealth = (TextView)dialog.findViewById(R.id.upgradeHealthTxt);
                final TextView upgradeHealthCost = (TextView)dialog.findViewById(R.id.upgradeHealthCostTxt);
                final TextView upgradeDamage = (TextView)dialog.findViewById(R.id.upgradeDamageTxt);
                final TextView upgradeDamageCost = (TextView)dialog.findViewById(R.id.upgradeDamageCostTxt);

                upgradeHealth.setText(String.valueOf(playerController.getHealth()));
                upgradeDamage.setText(String.valueOf(playerController.getDamage()));
                upgradeHealthCost.setText(String.valueOf("G " + upgradecostHealth));
                upgradeDamageCost.setText(String.valueOf("G " + upgradecostDamage));

                final Button btnUpgradeHealth = (Button) dialog.findViewById(R.id.btnUpgradeHealth);
                final Button btnUpgradeDamage = (Button) dialog.findViewById(R.id.btnUpgradeDamage);

                btnUpgradeHealth.setText("upgrade");
                btnUpgradeHealth.setTypeface(null, Typeface.BOLD);

                if(playerController.getGold() >= upgradecostHealth) {
                    btnUpgradeHealth.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {

                            dialog.create();
                            if (playerController.getGold() >= upgradecostHealth) {
                                playerController.setBuyUpgrade(upgradecostHealth);
                                playerController.setAmountOfUpgrades(1);

                                for (int i = 0; i < playerController.getAmoutOfUpgrades(); i++) {
                                    upgradecostHealth *= 1.6;
                                }

                                playerController.setUpgradeHealth(1);
                                playerHealthBegin = playerController.getHealth();
                                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
                                healthBar.setMax(playerController.getHealth());
                                healthBar.setProgress(playerController.getHealth());
                                upgradeHealth.setText(String.valueOf(playerController.getHealth()));
                                upgradeHealthCost.setText(String.valueOf("G " + upgradecostHealth));
                                playerGold.setText(String.valueOf(playerController.getGold()));
                                if (playerController.getGold() <= upgradecostHealth) {
                                    btnUpgradeHealth.setEnabled(false);
                                }
                            }
                            else{
                                btnUpgradeHealth.setEnabled(false);
                                Toast.makeText(PlayScreen.this, "not enough mony", Toast.LENGTH_SHORT);
                            }
                        }
                    });
                }
                else{
                    btnUpgradeHealth.setEnabled(false);
                    Toast.makeText(PlayScreen.this, "not enough mony", Toast.LENGTH_SHORT);
                }

                if(playerController.getGold() >= upgradecostDamage) {
                    btnUpgradeDamage.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            dialog.create();
                            if (playerController.getGold() >= upgradecostDamage) {
                                playerController.setBuyUpgrade(upgradecostDamage);
                                playerController.setAmountOfUpgrades(1);

                                for (int i = 0; i < playerController.getAmoutOfUpgrades(); i++) {
                                    upgradecostDamage *= 2.3;
                                }

                                playerController.setUpgradeDamage(1);
                                damageTxt.setText(String.valueOf("DMG: " + playerController.getDamage()));
                                upgradeDamage.setText(String.valueOf(playerController.getDamage()));
                                upgradeDamageCost.setText(String.valueOf("G " + upgradecostDamage));
                                playerGold.setText(String.valueOf(playerController.getGold()));
                                if (playerController.getGold() <= upgradecostDamage) {
                                    btnUpgradeDamage.setEnabled(false);
                                }
                            } else {
                                btnUpgradeDamage.setEnabled(false);
                                Toast.makeText(PlayScreen.this, "not enough mony", Toast.LENGTH_SHORT);
                            }
                        }
                    });
                }
                else{
                    btnUpgradeDamage.setEnabled(false);
                    Toast.makeText(PlayScreen.this, "not enough mony", Toast.LENGTH_SHORT);
                }

                dismisspopup = (Button)dialog.findViewById(R.id.dismissPopup);
                dismisspopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        startGame();
                    }
                });

                dialog.show();
            }
        });
    }

    public void statusScreen(){
        btnStatusScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseGame();

                final Dialog dialog = new Dialog(PlayScreen.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.status_screen);

                TextView statusHealth = (TextView)dialog.findViewById(R.id.playerStatusHealthTxt);
                TextView statusTapDamage = (TextView)dialog.findViewById(R.id.playerStatusTapDamageTxt);
                TextView statusHighScore = (TextView)dialog.findViewById(R.id.playerStatusHighScoreTxt);
                TextView statusCurrentScore = (TextView)dialog.findViewById(R.id.playerStatusCurrentScoreTxt);

                statusHealth.setText("HEALTH: " + playerController.getHealth());
                statusTapDamage.setText("DAMAGE: " + playerController.getDamage());
                statusHighScore.setText("HIGH SCORE: " + database.getHighscore());
                statusCurrentScore.setText("SCORE: " + playerController.getScore());

                dialog.show();

                dismisspopup = (Button)dialog.findViewById(R.id.dismissPopup);
                dismisspopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        startGame();
                    }
                });
            }
        });
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.play_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //btnStart = (ImageView)findViewById(R.id.action_play);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_play) {
            if(!IS_ACTIVATED){
                setEnemyMovement();
                damageEnemy();
                IS_ACTIVATED = true;
                IS_KILLABLE = true;
            }
            else if(IS_ACTIVATED){
                countDownMovement.cancel();
                Toast.makeText(PlayScreen.this, "paused", Toast.LENGTH_SHORT).show();
                enemy.setOnClickListener(null);
                IS_ACTIVATED = false;
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
    /*
    Create a player with some specifications
     */
    public void createPlayer(){
        playerHealthTxt = (TextView)findViewById(R.id.txtHealthShow);
        playerHealthTxt.setTextColor(Color.WHITE);
        playerHealthBegin = playerController.getHealth();
        playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
        player = (ImageView)findViewById(R.id.imagePlayer);
        healthBar = (ProgressBar)findViewById(R.id.playerHealth);
        healthBar.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        healthBar.setMax(playerController.getHealth());
        healthBar.setProgress(playerController.getHealth());

        player.setY(100);
        player.setImageResource(R.drawable.left1);

        playerName = (TextView)findViewById(R.id.txtName);
        playerName.setTextSize(16);
        playerName.setTextColor(Color.WHITE);
        playerName.setTypeface(null, Typeface.BOLD);
        playerName.setText(playerController.getName());
        playerName.setY(100);
    }

    /*
    Updating the current and highscore
     */
    public void changeScoreBar(int score){
        //scoreBar = getSupportActionBar();
        //scoreBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
        currentScoreTxt.setText("score: " + score);
        currentScoreTxt.setTextColor(Color.WHITE);
        highScoreTxt.setText("high score: " + highScore);
        highScoreTxt.setTextColor(Color.WHITE);
        //scoreBar.setTitle("high score: " + highScore);
        if(score > highScore){
            highScoreTxt.setText("high score: " + score);
            highScore = score;
        }
    }

    /*
    Checks for enemy with player collision
     */
    public void collisionDetection(){
        Rect playerCollision = new Rect();
        Rect enemyCollision = new Rect();

        player.getHitRect(playerCollision);
        enemy.getHitRect(enemyCollision);

        // Collision detection between player and enemy
        if(Rect.intersects(playerCollision, enemyCollision)){
            // Player has been killed. Specs are being set for the death of the player
            if(healthBar.getProgress() <= 1){
                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + 0));
                playerHealthTxt.setTextColor(Color.WHITE);
                healthBar.setProgress(0);
                Toast.makeText(PlayScreen.this, "GAME OVER", Toast.LENGTH_LONG).show();
                countDownMovement.onFinish();
                linearLayout.removeView(enemy);
                linearLayout.removeView(enemyHealth);
                linearLayout.removeView(enemyHealthTxt);
            }else{
                isColliding = true;
                // Setting new player health after attack
                playerController.setHealth(playerController.enemyDoDamage(1));
                healthBar.setProgress(playerController.getHealth());
                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));

                switch (direction){
                    case 0:
                        enemyMovement1 = 0;
                        enemyHealthBar1 = 0;
                        enemyHealthShow1 = 0;
                        enemy.setX(enemyMovement1);
                        enemyHealth.setX(enemyHealthBar1);
                        enemyHealthTxt.setX(enemyHealthShow1);
                        break;
                    case 1:
                        enemyMovement2 = 855;
                        enemyHealthBar2 = 855;
                        enemyHealthShow2 = 855;
                        enemy.setX(enemyMovement2);
                        enemyHealth.setX(enemyHealthBar2);
                        enemyHealthTxt.setX(enemyHealthShow2);
                        break;
                    case 2:
                        enemyMovement3 = 1340;
                        enemyHealthBar3 = 1590;
                        enemyHealthShow3 = 1610;
                        enemy.setY(enemyMovement3);
                        enemyHealth.setY(enemyHealthBar3);
                        enemyHealthTxt.setY(enemyHealthShow3);
                        break;
                }
            }
        }
    }

    /*
    Moves the enemy on the playground
     */
    public void setEnemyMovement(){
        player = (ImageView)findViewById(R.id.imagePlayer);
        countDownMovement = new CountDownTimer(10000000 * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isColliding){
                    isColliding = false;
                }else{
                    getDirection(direction);
                    collisionDetection();
                    isColliding = false;
                }
            }

            @Override
            public void onFinish() {

            }
        };

        countDownMovement.start();
    }

    public void initializeGameInformation(){
        linearLayout = (RelativeLayout)findViewById(R.id.playGround);
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                // gets called after layout has been done but before display.
                linearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                xPos = linearLayout.getWidth();
                yPos = linearLayout.getHeight();
            }
        });

        linearLayout.setBackgroundResource(R.drawable.backgroundforest1);
        backgroundAnimation();
        linearLayout.setBackgroundDrawable(backgroundAnim);
        backgroundAnim.start();

        coordinates = new Coordinates();
        playerController = new PlayerController("Jack");
        enemyController = new EnemyController();

        //damage = new ImageView(this);

        btnStart = (ImageButton)findViewById(R.id.btnPlay);
        btnStart.setImageResource(R.drawable.btnplay2);
        btnUpgradeScreen = (ImageButton)findViewById(R.id.btnUpgrade);
        btnUpgradeScreen.setImageResource(R.drawable.btnarmory2);
        btnStatusScreen = (ImageButton)findViewById(R.id.btnStatus);
        btnStatusScreen.setImageResource(R.drawable.btnstatistic2);

        damageTxt = (TextView)findViewById(R.id.txtDamage);
        damageTxt.setTextSize(14);
        damageTxt.setTextColor(Color.WHITE);
        damageTxt.setText(String.valueOf("DMG: " + playerController.getDamage()));

        playerGold = (TextView)findViewById(R.id.txtGold);
        playerGold.setTextColor(Color.WHITE);
        playerGold.setTextSize(14);
        playerGold.setText("G: " + playerController.getGold());
        highScoreTxt = (TextView)findViewById(R.id.txtHighScore);
        highScoreTxt.setTextSize(24);
        highScoreTxt.setTypeface(null, Typeface.BOLD);
        currentScoreTxt = (TextView)findViewById(R.id.txtScore);
        currentScoreTxt.setTextSize(24);
        currentScoreTxt.setTypeface(null, Typeface.BOLD);
        currentScoreTxt.setText(String.valueOf(currentScore));
        highScore = Integer.valueOf(database.getHighscore());
        upgradecostHealth = 100;
        upgradecostDamage = 100;
        changeScoreBar(highScore); //??
        changeScoreBar(score);     //??
        createPlayer();
    }

    public void createEnemy(){
        // Enemy position
        enemyController.setGold(enemyController.randomEnemyGold());
        enemyMovement1 = 0;
        enemyMovement2 = 855;
        enemyMovement3 = 1435;
        enemyNameMovement1 = 0;
        enemyNameMovement2 = 855;
        enemyNameMovement3 = 1435;
        direction = coordinates.createCoordinates();
        x = coordinates.getxPos();
        y = coordinates.getyPos();

        // Enemy health
        enemyHealthBar1 = 0;
        enemyHealthBar2 = 855;
        enemyHealthBar3 = 1685;
        enemyHealthShow1 = 0;
        enemyHealthShow2 = 855;
        enemyHealthShow3 = 1705;
        enemyHealthCounter += 1;
        enemyController.setHealth(enemyHealthCounter);
        enemyHealth = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        enemyHealth.setMax(enemyController.getHealth());
        enemyHealth.setProgress(enemyController.getHealth());
        enemyHealth.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        enemyHealthBegin += 1;
        enemyHealth.setX(x);
        enemyHealth.setY(y + 150);
        enemyHealthTxt = new TextView(this);
        enemyHealthTxt.setTextColor(Color.WHITE);
        enemyHealthTxt.setTypeface(null, Typeface.BOLD);
        enemyHealthTxt.setX(x);
        enemyHealthTxt.setY(y + 170);
        enemyName = new TextView(this);

        // If statement for correcting the layout of displaying health
        if(enemyHealthBegin >= 10){
            enemyHealthTxt.setText(String.valueOf(enemyHealthBegin + " / " + enemyController.getHealth()));
        }else{
            enemyHealthTxt.setText(String.valueOf("  " + enemyHealthBegin + " / " + enemyController.getHealth()));
        }

        // Creating the actual views
        enemy = new ImageView(this);
        enemy.setImageResource(R.mipmap.ic_launcher);
        enemy.setX(x);
        enemy.setY(y);
        linearLayout.addView(enemy);
        linearLayout.addView(enemyHealth);
        linearLayout.addView(enemyHealthTxt);
        linearLayout.addView(enemyName);
        spriteDirection(direction);
        // Attack an enemy untill it is killed an created again
        if(IS_KILLABLE){
            damageEnemy();
        }
    }

    public void damageEnemy(){
        // Attack an enemy untill it is killed an created again
        enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Player sprite points towards enemy
                characterAnimation(direction);
                player.setImageResource(0);
                player.setBackgroundDrawable(characterspriteAnim);
                characterspriteAnim.start();
                characterspriteAnim.setOneShot(true);

                enemyHealthCounter -= playerController.getDamage() ;
                enemyController.setHealth(enemyHealthCounter);
                enemyHealth.setProgress(enemyHealthCounter);

                // If statement for correcting the layout of displaying health
                if(enemyHealthBegin >= 10){
                    enemyHealthTxt.setText(String.valueOf(enemyHealthBegin + " / " + enemyController.getHealth()));
                }else{
                    enemyHealthTxt.setText(String.valueOf("  " + enemyHealthBegin + " / " + enemyController.getHealth()));
                }

                // If enemy has been killed. Views are destroyed, update score and recreate an new enemy
                if(enemyHealthCounter < 1){
                    Toast.makeText(PlayScreen.this, "killed", Toast.LENGTH_SHORT).show();

                    // Retrieve gold from killed enemy.
                    int gold = enemyController.getGold();
                    playerController.setGold(gold);
                    playerGold.setTextColor(Color.WHITE);
                    playerGold.setText("gold: " + playerController.getGold());

                    currentScore ++;
                    linearLayout.removeView(enemy);
                    linearLayout.removeView(enemyHealth);
                    linearLayout.removeView(enemyHealthTxt);
                    enemyHealthCounter = enemyHealthBegin;
                    createEnemy();
                    changeScoreBar(currentScore);
                    if(currentScore >= highScore){
                        playerController.setHighScore(currentScore);
                        database.updateHighscore(playerController.getHighScore());
                    }else{
                        playerController.setScore(currentScore);
                    }

                    // TODO: DO SOMETHING WITH GETTING GOLD FOR UPGRADES
                }
            }
        });
    }

    public void spriteDirection(int direction){
        switch(direction){
            case 0:
                enemy.setImageResource(R.drawable.slugright1);
                spriteAnimation(direction);
                enemy.setBackgroundDrawable(skeletonspriteAnim);
                break;
            case 1:
                enemy.setImageResource(R.drawable.slugleft1);
                spriteAnimation(direction);
                enemy.setBackgroundDrawable(skeletonspriteAnim);
                break;
            case 2:
                enemy.setImageResource(R.drawable.slugup1);
                spriteAnimation(direction);
                enemy.setBackgroundDrawable(skeletonspriteAnim);
                break;
        }
    }

    public void getDirection(int direction){
        switch(direction){
            case 0:
                enemyMovement1 += 1;
                enemyHealthBar1 += 1;
                enemyHealthShow1 += 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(skeletonspriteAnim);
                skeletonspriteAnim.start();
                enemy.setX(enemyMovement1);
                enemyHealth.setX(enemyHealthBar1);
                enemyHealthTxt.setX(enemyHealthShow1);
                break;
            case 1:
                enemyMovement2 -= 1;
                enemyHealthBar2 -= 1;
                enemyHealthShow2 -= 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(skeletonspriteAnim);
                skeletonspriteAnim.start();
                enemy.setX(enemyMovement2);
                enemyHealth.setX(enemyHealthBar2);
                enemyHealthTxt.setX(enemyHealthShow2);
                break;
            case 2:
                enemyMovement3 -= 1;
                enemyHealthBar3 -= 1;
                enemyHealthShow3 -= 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(skeletonspriteAnim);
                skeletonspriteAnim.start();
                enemy.setY(enemyMovement3);
                enemyHealth.setY(enemyHealthBar3);
                enemyHealthTxt.setY(enemyHealthShow3);
                break;
        }
    }

    public void showTutorial(String tutorialID){
        // Sequence
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view
        config.setContentTextColor(Color.RED);
        config.setDismissTextColor(Color.WHITE);
        config.setMaskColor(Color.DKGRAY);

        final MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this);//,tutorialID);

        sequence.setConfig(config);
        sequence.addSequenceItem(player, "This is" + playerController.getName() + " and he lives in a castle", "GOT IT");
        sequence.addSequenceItem(enemy, "Jack needs to defend himself from enemies", "GOT IT");
        sequence.addSequenceItem(currentScoreTxt, "For each kill, gain a new score count", "GOT IT");
        sequence.addSequenceItem(btnStart, "After tutorial, press here to start and pause the game", "GOT IT");
        sequence.addSequenceItem(btnUpgradeScreen, "Here you can purchase upgrades for " + playerController.getName(), "GOT IT");
        sequence.addSequenceItem(btnStatusScreen, "Here you can see the status of " + playerController.getName(), "GOT IT");
        sequence.addSequenceItem(player, "Goodluck to you, Jack!", "FIGHT");


        sequence.start();
    }
}
