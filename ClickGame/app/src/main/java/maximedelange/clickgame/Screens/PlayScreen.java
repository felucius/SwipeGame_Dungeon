package maximedelange.clickgame.Screens;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
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
import maximedelange.clickgame.Controller.AttackAnimationController;
import maximedelange.clickgame.Controller.BackgroundAnimationController;
import maximedelange.clickgame.Controller.CharacterAnimationController;
import maximedelange.clickgame.Controller.EnemyAnimationController;
import maximedelange.clickgame.Controller.EnemyController;
import maximedelange.clickgame.Controller.PlayerController;
import maximedelange.clickgame.Controller.TutorialController;
import maximedelange.clickgame.Database.Database;
import maximedelange.clickgame.Domain.DamageCoordinates;
import maximedelange.clickgame.Domain.EnemyCoordinates;
import maximedelange.clickgame.R;


public class PlayScreen extends AppCompatActivity {

    // Fields
    private int upgradecostHealth = 0;
    private int upgradecostDamage = 0;
    private int upgradecostAttackspeed = 0;
    private int score = 0;
    private int currentScore = 0;
    private int highScore = 0;
    private int xPos = 0;
    private int yPos = 0;
    private int x = 0;
    private int y = 0;
    private int damageX = 0;
    private int damageY = 0;
    private int direction;
    private int damageMovement1, damageMovement2, damageMovement3 = 0;
    private int enemyNameMovement1, enemyNameMovement2, enemyNameMovement3 = 0;
    private int enemyMovement1, enemyMovement2, enemyMovement3 = 0;
    private int enemyHealthBar1, enemyHealthBar2, enemyHealthBar3 = 0;
    private int enemyHealthShow1, enemyHealthShow2, enemyHealthShow3 = 0;
    private int enemyHealthCounter = 0;
    private int playerHealthBegin = 0;
    private int playerDamageBegin = 1;
    private int enemyHealthBegin = 0;
    private boolean IS_COLLIDING = false;
    private CountDownTimer countDownMovement = null;
    private CountDownTimer damageMovement = null;
    private PlayerController playerController = null;
    private EnemyController enemyController = null;
    private DamageCoordinates damageCoordinates = null;
    private EnemyCoordinates enemyCoordinates = null;
    private Database database = null;
    private AnimationDrawable characterspriteAnim = null;
    private AnimationDrawable enemySpriteAnimation = null;
    private AnimationDrawable backgroundAnimation = null;
    private AnimationDrawable characterDamageAnimation = null;
    private boolean IS_ACTIVATED = false;
    private boolean IS_ACTIVED_ONETIME = false;
    private boolean HIT_PLAYBUTTON = false;
    private boolean IS_KILLABLE = false;
    private boolean IS_DAMAGED = false;
    private boolean IS_SHOOTING = false;

    private EnemyAnimationController enemyAnimationController = null;
    private CharacterAnimationController characterAnimationController = null;
    private AttackAnimationController attackAnimationController = null;
    private BackgroundAnimationController backgroundAnimationController = null;
    private TutorialController tutorialController = null;

    // GUI components
    private RelativeLayout linearLayout = null;
    private ImageView enemy = null;
    private ImageView player = null;
    private ImageView damage = null;
    private ProgressBar healthBar = null;
    private ProgressBar enemyHealth = null;
    private TextView playerName = null;
    private TextView damageTxt = null;
    private TextView attackspeedTxt = null;
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

        enemyAnimationController = new EnemyAnimationController(this);
        characterAnimationController = new CharacterAnimationController(this);
        attackAnimationController = new AttackAnimationController(this);
        backgroundAnimationController = new BackgroundAnimationController(this);
        tutorialController = new TutorialController(this);

        // Create database.
        database = new Database(this, null, null, 1);
        // Initialize basic gameplay information.
        initializeGameInformation();
        // Creating an enemy
        createEnemy();
        // Starts the game
        playGame();
        // Shows tutorial for new players
        //tutorialController.showTutorial("1", player, enemy, currentScoreTxt, btnStart, btnUpgradeScreen, btnStatusScreen);
    }

    /*
    This method animates the enemy. It gets an "direction" as parameter
    to know in which way the enemy needs to animate.
     */
    public void enemyAnimation(int direction){
        switch(direction){
            case 0:
                enemySpriteAnimation = enemyAnimationController.getEnemyLevel1Left();
                break;
            case 1:
                enemySpriteAnimation = enemyAnimationController.getEnemyLevel1Right();
                break;
            case 2:
                enemySpriteAnimation = enemyAnimationController.getEnemyLevel1Up();
                break;
        }
    }

    /*
    This method animates the character. It gets an "enemyDirection" as parameter
    to know in which way the character needs to be looking/animate.
     */
    public void characterAnimation(int enemyDirection){
        Intent intent = getIntent();
        switch(enemyDirection){
            case 0:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterspriteAnim = characterAnimationController.getArcherLeft();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterspriteAnim = characterAnimationController.getWizardLeft();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterspriteAnim = characterAnimationController.getAxeThrowerLeft();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterspriteAnim = characterAnimationController.getNecromancerLeft();
                }
                break;
            case 1:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterspriteAnim = characterAnimationController.getArcherRight();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterspriteAnim = characterAnimationController.getWizardRight();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterspriteAnim = characterAnimationController.getAxeThrowerRight();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterspriteAnim = characterAnimationController.getNecromancerRight();
                }
                break;
            case 2:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterspriteAnim = characterAnimationController.getArcherDown();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterspriteAnim = characterAnimationController.getWizardDown();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterspriteAnim = characterAnimationController.getAxeThrowerDown();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterspriteAnim = characterAnimationController.getNecromancerDown();
                }
                break;
        }
    }

    public void damageAnimation(int enemyDirection){
        Intent intent = getIntent();
        switch(enemyDirection){
            case 0:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterDamageAnimation = attackAnimationController.getArrowLeft();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterDamageAnimation = attackAnimationController.getSpellLeft();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterDamageAnimation = attackAnimationController.getAxeLeft();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterDamageAnimation = attackAnimationController.getNecroSpellLeft();
                }
                break;
            case 1:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterDamageAnimation = attackAnimationController.getArrowRight();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterDamageAnimation = attackAnimationController.getSpellRight();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterDamageAnimation = attackAnimationController.getAxeRight();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterDamageAnimation = attackAnimationController.getNecroSpellRight();
                }
                break;
            case 2:
                if(intent.getIntExtra("archer", 0) == 1){
                    characterDamageAnimation = attackAnimationController.getArrowDown();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    characterDamageAnimation = attackAnimationController.getSpellDown();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    characterDamageAnimation = attackAnimationController.getAxeDown();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    characterDamageAnimation = attackAnimationController.getNecroSpellDown();
                }
                break;
        }
    }

    /*
    This method starts the game.
    It checks if the game has already been started.
    If the game has been started, the game can be paused again
    and the enemies are not killable when paused
     */
    public void startGame(){
        // Active only once
        if(HIT_PLAYBUTTON){
            btnStart.setImageResource(R.drawable.btnplay);
            // Activate gameplay after the first time start has been pressed
            if(!IS_ACTIVED_ONETIME){
                btnStart.setImageResource(R.drawable.btnplay);
                damageEnemy();
                setEnemyMovement();
                setDamageMovement();
                IS_ACTIVATED = true;
                IS_KILLABLE = true;
                IS_ACTIVED_ONETIME = true;
            }
            /*
            Activate gameplay if the "Continue" button on the dialog
            has been pressed
             */
            else if(!IS_ACTIVATED){
                btnStart.setImageResource(R.drawable.btnplay);
                damageEnemy();
                setEnemyMovement();
                setDamageMovement();
                IS_ACTIVATED = true;
                IS_KILLABLE = true;
            }
        }
    }

    /*
    This method will pause the game.
    The timer for the enemy movement will be stopped.
     */
    public void pauseGame(){
        if(IS_ACTIVATED) {
            btnStart.setImageResource(R.drawable.btnpause);
            countDownMovement.cancel();
            damageMovement.cancel();
            Toast.makeText(PlayScreen.this, "paused", Toast.LENGTH_SHORT).show();
            IS_ACTIVATED = false;
        }
    }

    /*
    This method starts the game.
    If the game is already active, the game will be paused.
    And a dialog will be displayed. This dialog contains text message
    to either "Quit" or "Continue" the gameplay.
     */
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

                    final Dialog pauseDialog = new Dialog(PlayScreen.this);
                    pauseDialog.setCanceledOnTouchOutside(false);
                    pauseDialog.setCancelable(false);
                    pauseDialog.setContentView(R.layout.pause_screen);
                    pauseDialog.show();

                    Button pauseContinue = (Button)pauseDialog.findViewById(R.id.continueGame);
                    pauseContinue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pauseDialog.dismiss();
                            startGame();
                        }
                    });

                    Button pauseExit = (Button)pauseDialog.findViewById(R.id.exitGame);
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

    /*
    This method shows the upgrade screen for the players. In this screen the hero
    can be upgraded with different kinds of upgrades.
     */
    public void upgradeScreen(){
        btnUpgradeScreen.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                pauseGame();

                final Dialog upgradeDialog = new Dialog(PlayScreen.this);
                upgradeDialog.setCanceledOnTouchOutside(false);
                upgradeDialog.setCancelable(false);
                upgradeDialog.setContentView(R.layout.upgrade_screen);

                // Creating views
                final TextView upgradeHealth = (TextView)upgradeDialog.findViewById(R.id.upgradeHealthTxt);
                final TextView upgradeHealthCost = (TextView)upgradeDialog.findViewById(R.id.upgradeHealthCostTxt);
                final TextView upgradeDamage = (TextView)upgradeDialog.findViewById(R.id.upgradeDamageTxt);
                final TextView upgradeDamageCost = (TextView)upgradeDialog.findViewById(R.id.upgradeDamageCostTxt);
                final TextView upgradeAttackspeed = (TextView)upgradeDialog.findViewById(R.id.upgradeAttackspeedTxt);
                final TextView upgradeAttackspeedCost = (TextView)upgradeDialog.findViewById(R.id.upgradeAttackspeedCostTxt);
                final Button btnUpgradeHealth = (Button)upgradeDialog.findViewById(R.id.btnUpgradeHealth);
                final Button btnUpgradeDamage = (Button)upgradeDialog.findViewById(R.id.btnUpgradeDamage);
                final Button btnUpgradeAttackspeed = (Button)upgradeDialog.findViewById(R.id.btnUpgradeAttackspeed);

                // Setting content to the views
                upgradeHealth.setText(String.valueOf(playerController.getHealth()));
                upgradeDamage.setText(String.valueOf(playerController.getDamage()));
                upgradeAttackspeed.setText(String.valueOf(playerController.getAttackspeed()));
                upgradeHealthCost.setText(String.valueOf("G " + upgradecostHealth));
                upgradeDamageCost.setText(String.valueOf("G " + upgradecostDamage));
                upgradeAttackspeedCost.setText(String.valueOf("G " + upgradecostAttackspeed));

                // Health
                btnUpgradeHealth.setText("upgrade");
                btnUpgradeHealth.setTextSize(10);
                btnUpgradeHealth.setTypeface(null, Typeface.BOLD);

                // Damage
                btnUpgradeDamage.setText("upgrade");
                btnUpgradeDamage.setTextSize(10);
                btnUpgradeDamage.setTypeface(null, Typeface.BOLD);

                // Attack speed
                btnUpgradeAttackspeed.setText("upgrade");
                btnUpgradeAttackspeed.setTextSize(10);
                btnUpgradeAttackspeed.setTypeface(null, Typeface.BOLD);

                if(playerController.getGold() >= upgradecostHealth) {
                    btnUpgradeHealth.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            upgradeDialog.create();
                            if (playerController.getGold() >= upgradecostHealth) {
                                playerController.setBuyUpgrade(upgradecostHealth);
                                // Adding 1 to the amount of upgrades.
                                playerController.setAmountOfHealthUpgrades(1);

                                /*
                                 Checking for the amount of upgrades. For each upgrade the price
                                 is getting up by percentage
                                 */
                                for (int i = 0; i < playerController.getAmountOfHealthUpgrades(); i++) {
                                    upgradecostHealth *= 1.5;
                                }

                                // Adding the new information.
                                playerController.setUpgradeHealth(3);

                                // Retrieve the new information.
                                playerHealthBegin = playerController.getHealth();

                                // Displaying the new information.
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
                            }
                        }
                    });
                }
                else{
                    btnUpgradeHealth.setEnabled(false);
                }

                if(playerController.getGold() >= upgradecostDamage) {
                    btnUpgradeDamage.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            upgradeDialog.create();
                            if (playerController.getGold() >= upgradecostDamage) {
                                playerController.setBuyUpgrade(upgradecostDamage);
                                // Adding 1 to the amount of upgrades
                                playerController.setAmountOfDamageUpgrades(1);

                                /*
                                 Checking for the amount of upgrades. For each upgrade the price
                                 is getting up by a percentage.
                                */
                                for (int i = 0; i < playerController.getAmountOfDamageUpgrades(); i++) {
                                    upgradecostDamage *= 1.5;
                                }

                                // Adding the new information
                                playerController.setUpgradeDamage(1);

                                // Displaying the new information.
                                damageTxt.setText(String.valueOf("DMG: " + playerController.getDamage()));
                                upgradeDamage.setText(String.valueOf(playerController.getDamage()));
                                upgradeDamageCost.setText(String.valueOf("G " + upgradecostDamage));
                                playerGold.setText(String.valueOf(playerController.getGold()));

                                if (playerController.getGold() <= upgradecostDamage) {
                                    btnUpgradeDamage.setEnabled(false);
                                }
                            } else {
                                btnUpgradeDamage.setEnabled(false);
                            }
                        }
                    });
                }
                else{
                    btnUpgradeDamage.setEnabled(false);
                }

                if(playerController.getGold() >= upgradecostAttackspeed) {
                    btnUpgradeAttackspeed.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            upgradeDialog.create();
                            if (playerController.getGold() >= upgradecostAttackspeed) {
                                playerController.setBuyUpgrade(upgradecostAttackspeed);
                                // Adding 1 to the amount of upgrades
                                playerController.setAmountOfAttackspeedUpgrades(1);

                                /*
                                 Checking for the amount of upgrades. For each upgrade the price
                                 is getting up by a percentage.
                                */
                                for (int i = 0; i < playerController.getAmountOfAttackspeedUpgrades(); i++) {
                                    upgradecostAttackspeed *= 1.5;
                                }

                                // Adding the new information
                                playerController.setUpgradeAttackspeed(5);

                                // Displaying the new information.
                                attackspeedTxt.setText(String.valueOf("SPEED: " + playerController.getAttackspeed()));
                                upgradeAttackspeed.setText(String.valueOf(playerController.getAttackspeed()));
                                upgradeAttackspeedCost.setText(String.valueOf("G " + upgradecostAttackspeed));
                                playerGold.setText(String.valueOf(playerController.getGold()));

                                if (playerController.getGold() <= upgradecostAttackspeed) {
                                    btnUpgradeAttackspeed.setEnabled(false);
                                }
                            } else {
                                btnUpgradeAttackspeed.setEnabled(false);
                            }
                        }
                    });
                }
                else{
                    btnUpgradeAttackspeed.setEnabled(false);
                }

                dismisspopup = (Button)upgradeDialog.findViewById(R.id.dismissPopup);
                dismisspopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        upgradeDialog.dismiss();
                        startGame();
                    }
                });

                upgradeDialog.show();
            }
        });
    }

    public void statusScreen(){
        btnStatusScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseGame();

                final Dialog statusScreenDialog = new Dialog(PlayScreen.this);
                statusScreenDialog.setCanceledOnTouchOutside(false);
                statusScreenDialog.setCancelable(false);
                statusScreenDialog.setContentView(R.layout.status_screen);

                // Create textviews
                TextView statusHealth = (TextView)statusScreenDialog.findViewById(R.id.playerStatusHealthTxt);
                TextView statusTapDamage = (TextView)statusScreenDialog.findViewById(R.id.playerStatusTapDamageTxt);
                TextView statusHighScore = (TextView)statusScreenDialog.findViewById(R.id.playerStatusHighScoreTxt);
                TextView statusCurrentScore = (TextView)statusScreenDialog.findViewById(R.id.playerStatusCurrentScoreTxt);
                TextView statusGold = (TextView)statusScreenDialog.findViewById(R.id.playerStatusGoldTxt);
                TextView statusHealthUpgrades = (TextView)statusScreenDialog.findViewById(R.id.playerStatusAmountOfHealthUpgradesTxt);
                TextView statusDamageUpgrades = (TextView)statusScreenDialog.findViewById(R.id.playerStatusAmountOfDamageUpgradesTxt);
                TextView statusAttackspeedUpgrades = (TextView)statusScreenDialog.findViewById(R.id.playerStatusAmountOfAttackspeedTxt);

                // Displaying the character information
                statusHealth.setText("HEALTH: " + playerController.getHealth());
                statusTapDamage.setText("DAMAGE: " + playerController.getDamage());
                statusHighScore.setText("HIGH SCORE: " + database.getHighscore());
                statusCurrentScore.setText("SCORE: " + playerController.getScore());
                statusGold.setText("GOLD: " + playerController.getGold());
                statusHealthUpgrades.setText("TOTAL HEALTH UPGRADES: " + playerController.getAmountOfHealthUpgrades());
                statusDamageUpgrades.setText("TOTAL DAMAGE UPGRADES: " + playerController.getAmountOfDamageUpgrades());
                statusAttackspeedUpgrades.setText("TOTAL ATTACK SPEED UPGRADES: " + playerController.getAmountOfAttackspeedUpgrades());

                statusScreenDialog.show();

                dismisspopup = (Button)statusScreenDialog.findViewById(R.id.dismissPopup);
                dismisspopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        statusScreenDialog.dismiss();
                        startGame();
                    }
                });
            }
        });
    }

    /*
    Create a player with some specifications.
     */
    public void createPlayer(){
        Intent intent = getIntent();

        damageMovement1 = 465;
        damageMovement2 = 495;
        damageMovement3 = 900;

        // Getting player information.
        playerHealthBegin = playerController.getHealth();

        // Create views.
        playerHealthTxt = (TextView)findViewById(R.id.txtHealthShow);
        player = (ImageView)findViewById(R.id.imagePlayer);
        healthBar = (ProgressBar)findViewById(R.id.playerHealth);
        playerName = (TextView)findViewById(R.id.txtName);

        // Displaying the character information.
        playerHealthTxt.setTextColor(Color.WHITE);
        playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
        healthBar.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        healthBar.setMax(playerController.getHealth());
        healthBar.setProgress(playerController.getHealth());
        playerName.setTextSize(16);
        playerName.setTextColor(Color.WHITE);
        playerName.setTypeface(null, Typeface.BOLD);
        playerName.setText(playerController.getName());
        playerName.setY(100);

        player.setY(80);

        if(intent.getIntExtra("archer", 0) == 1){
            player.setImageResource(R.drawable.characterarcher1l1);
        }
        else if(intent.getIntExtra("wizard", 0) == 2){
            player.setImageResource(R.drawable.characterwizard1down1left);
        }
        else if(intent.getIntExtra("axethrower", 0) == 3){
            player.setImageResource(R.drawable.characteraxethrowerlvl1left1);
        }
        else if(intent.getIntExtra("necromancer", 0) == 4){
            player.setImageResource(R.drawable.characternecromancerlvl1left1);
        }
    }

    /*
    Updating the current and highscore.
     */
    public void changeScoreBar(int score){
        currentScoreTxt.setText("score: " + score);
        currentScoreTxt.setTextColor(Color.WHITE);
        highScoreTxt.setText("high score: " + highScore);
        highScoreTxt.setTextColor(Color.WHITE);
        if(score > highScore){
            highScoreTxt.setText("high score: " + score);
            highScore = score;
        }
    }

    /*
    Checks for damage with enemy collision.
    */
    public void damageCollisionDetection(){
        Rect damageCollision = new Rect();
        Rect enemyCollision = new Rect();

        damage.getHitRect(damageCollision);
        enemy.getHitRect(enemyCollision);

        // Collision detection between damage and enemy.
        if(Rect.intersects(damageCollision, enemyCollision)){
            IS_SHOOTING = false;
            enemy.setClickable(true);
            // Deals damage to the health of the enemy.
            enemyHealthCounter -= playerController.getDamage();

            // Setting the new information
            enemyController.setHealth(enemyHealthCounter);
            enemyHealth.setProgress(enemyHealthCounter);

            // Is not colliding anymore and enemy also cannot be killed.
            IS_COLLIDING = true;
            IS_DAMAGED = false;

            // Display healthbar of enemy.
            if(enemyHealthBegin >= 10){
                enemyHealthTxt.setText(String.valueOf(enemyHealthBegin + " / " + enemyController.getHealth()));
            }else{
                enemyHealthTxt.setText(String.valueOf("  " + enemyHealthBegin + " / " + enemyController.getHealth()));
            }

            // If enemy has been killed. Views are destroyed, update score and recreate an new enemy.
            if(enemyHealthCounter < 1){
                // Retrieve gold from killed enemy.
                int gold = enemyController.getGold();
                playerController.setGold(gold);
                playerGold.setTextColor(Color.WHITE);
                playerGold.setText("gold: " + playerController.getGold());

                // Highers the current score of the fighting session.
                currentScore ++;

                // Remove views that belong to the killed enemy.
                linearLayout.removeView(enemy);
                linearLayout.removeView(enemyHealth);
                linearLayout.removeView(enemyHealthTxt);

                // Creating a new enemy for battle.
                enemyHealthCounter = enemyHealthBegin;
                createEnemy();
                changeScoreBar(currentScore);

                if(currentScore >= highScore){
                    playerController.setHighScore(currentScore);
                    database.updateHighscore(playerController.getHighScore());
                }else{
                    playerController.setScore(currentScore);
                }
            }

            linearLayout.removeView(damage);

        }
    }


    /*
    Checks for enemy with player collision.
     */
    public void collisionDetection(){
        Rect playerCollision = new Rect();
        Rect enemyCollision = new Rect();

        player.getHitRect(playerCollision);
        enemy.getHitRect(enemyCollision);

        // Collision detection between player and enemy.
        if(Rect.intersects(playerCollision, enemyCollision)){
            // Player has been killed. Specs are being set for the death of the player.
            if(healthBar.getProgress() <= 1){
                // Displaying the new information.
                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + 0));
                playerHealthTxt.setTextColor(Color.WHITE);
                healthBar.setProgress(0);

                final Dialog gameOverDialog = new Dialog(PlayScreen.this);
                gameOverDialog.setCanceledOnTouchOutside(false);
                gameOverDialog.setCancelable(false);
                gameOverDialog.setContentView(R.layout.gameover_screen);
                gameOverDialog.show();

                TextView score = (TextView)gameOverDialog.findViewById(R.id.gameOverScore);
                score.setText("SCORE: " + currentScore);

                Button restartGame = (Button)gameOverDialog.findViewById(R.id.restartGame);
                restartGame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gameOverDialog.dismiss();
                        Intent intent = new Intent(v.getContext(), CharacterScreen.class);
                        startActivity(intent);
                    }
                });

                Button pauseExit = (Button)gameOverDialog.findViewById(R.id.exitGame);
                pauseExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), StartScreen.class);
                        // TODO: SAVING THE HIGHSCORE... IF THERE IS ANY
                        // TODO: ALSO GIVE WARNING MESSAGE IF THEY REALLY WANT TO QUIT.
                        startActivity(intent);
                    }
                });

                countDownMovement.cancel();
                damageMovement.cancel();

                // Removing information from the enemy that killed the player.
                linearLayout.removeView(enemy);
                linearLayout.removeView(enemyHealth);
                linearLayout.removeView(enemyHealthTxt);
            }else{
                IS_COLLIDING = true;
                // Setting new player health after attack.
                playerController.setHealth(playerController.enemyDoDamage(1));
                healthBar.setProgress(playerController.getHealth());
                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));

                // When the enemy hit the player the enemy is spawned to it's begin point.
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
    Moves the damage on the playground
    */
    public void setDamageMovement(){
        damageMovement = new CountDownTimer(10000000 * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(IS_COLLIDING){
                    IS_COLLIDING = false;
                }else{
                    /*
                    If the player deals damage the direction of the enemy is getting retrieved.
                    In this case the damage knows in what direction it needs to go.
                     */
                    if(IS_DAMAGED){
                        getDamageDirection(direction);
                    }
                    damageCollisionDetection();
                    IS_COLLIDING = false;
                }
            }

            @Override
            public void onFinish() {
                // Nothing to do here
            }
        };

        damageMovement.start();
    }

    /*
    Moves the enemy on the playground
     */
    public void setEnemyMovement(){
        player = (ImageView)findViewById(R.id.imagePlayer);
        countDownMovement = new CountDownTimer(10000000 * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(IS_COLLIDING){
                    IS_COLLIDING = false;
                }else{
                    // Getting the direction the enemy needs to walk in.
                    getEnemyDirection(direction);
                    // Checking for the collision between player and enemy
                    collisionDetection();
                    IS_COLLIDING = false;
                }
            }

            @Override
            public void onFinish() {
                // Nothing to do here
            }
        };

        countDownMovement.start();
    }

    /*
    This method initialize the basic components for the game to work.
     */
    public void initializeGameInformation(){
        // Create the game palyground.
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

        getPlayscreenLevel();

        /*
        // Setting a background for the playfield.
        linearLayout.setBackgroundResource(R.drawable.backgroundlvl1);
        backgroundAnimation = backgroundAnimationController.getBackground();
        linearLayout.setBackgroundDrawable(backgroundAnimation);
        backgroundAnimation.start();
        */

        // Initialize controller classes.
        enemyCoordinates = new EnemyCoordinates();
        damageCoordinates = new DamageCoordinates();
        playerController = new PlayerController("Jack");
        enemyController = new EnemyController();

        // Create views.
        damage = new ImageView(this);
        btnStart = (ImageButton)findViewById(R.id.btnPlay);
        btnUpgradeScreen = (ImageButton)findViewById(R.id.btnUpgrade);
        btnStatusScreen = (ImageButton)findViewById(R.id.btnStatus);
        damageTxt = (TextView)findViewById(R.id.txtDamage);
        attackspeedTxt = (TextView)findViewById(R.id.txtAttackspeed);
        playerGold = (TextView)findViewById(R.id.txtGold);
        highScoreTxt = (TextView)findViewById(R.id.txtHighScore);
        currentScoreTxt = (TextView)findViewById(R.id.txtScore);

        // Setting the information to the created views.
        btnStart.setImageResource(R.drawable.btnplay);
        btnUpgradeScreen.setImageResource(R.drawable.btnarmory);
        btnStatusScreen.setImageResource(R.drawable.btnstatistics);

        // Displaying information.
        damageTxt.setTextSize(16);
        damageTxt.setTextColor(Color.WHITE);
        damageTxt.setText(String.valueOf("DMG: " + playerController.getDamage()));
        damageTxt.setTypeface(null, Typeface.BOLD);
        attackspeedTxt.setTextSize(16);
        attackspeedTxt.setTextColor(Color.WHITE);
        attackspeedTxt.setText(String.valueOf("SPEED: " + playerController.getAttackspeed()));
        attackspeedTxt.setTypeface(null, Typeface.BOLD);
        playerGold.setTextColor(Color.WHITE);
        playerGold.setTextSize(16);
        playerGold.setText("G: " + playerController.getGold());
        playerGold.setTypeface(null, Typeface.BOLD);
        highScoreTxt.setTextSize(24);
        highScoreTxt.setTypeface(null, Typeface.BOLD);
        currentScoreTxt.setTextSize(24);
        currentScoreTxt.setTypeface(null, Typeface.BOLD);
        currentScoreTxt.setText(String.valueOf(currentScore));
        highScore = Integer.valueOf(database.getHighscore());

        // Initialize the basic price for an upgrade.
        upgradecostHealth = 100;
        upgradecostDamage = 100;
        upgradecostAttackspeed = 100;
        changeScoreBar(highScore);
        changeScoreBar(score);

        // Creating a new player.
        createPlayer();
        // Initialize screens.
        upgradeScreen();
        statusScreen();
        // Get enemy sprite direction.
        enemyAnimation(direction);
        // Damage enemy by locating it's direction.
        damageAnimation(direction);
    }

    /*
    This method created an enemy.
    It provides a beginning X and Y coordinates
    and sprite animation.
     */
    public void createEnemy(){
        // Enemy position
        enemyController.setGold(enemyController.randomEnemyGold());
        enemyMovement1 = 0;
        enemyMovement2 = 855;
        enemyMovement3 = 1435;
        enemyNameMovement1 = 0;
        enemyNameMovement2 = 855;
        enemyNameMovement3 = 1435;

        // Getting the begin coordinates for each enemy.
        direction = enemyCoordinates.createCoordinates();
        x = enemyCoordinates.getxPos();
        y = enemyCoordinates.getyPos();

        // Enemy health.
        enemyHealthBar1 = 0;
        enemyHealthBar2 = 855;
        enemyHealthBar3 = 1685;
        enemyHealthShow1 = 0;
        enemyHealthShow2 = 855;
        enemyHealthShow3 = 1705;
        enemyHealthCounter += 1;

        // Creating views.
        enemyHealth = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        enemyHealthTxt = new TextView(this);
        enemyName = new TextView(this);
        enemy = new ImageView(this);

        // Displaying information per enemy.
        enemyController.setHealth(enemyHealthCounter);
        enemyHealth.setMax(enemyController.getHealth());
        enemyHealth.setProgress(enemyController.getHealth());
        enemyHealth.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        enemyHealthBegin += 1;
        enemyHealth.setX(x);
        enemyHealth.setY(y + 150);
        enemyHealthTxt.setTextColor(Color.WHITE);
        enemyHealthTxt.setTypeface(null, Typeface.BOLD);
        enemyHealthTxt.setX(x);
        enemyHealthTxt.setY(y + 170);

        // If statement for correcting the layout of displaying health.
        if(enemyHealthBegin >= 10){
            enemyHealthTxt.setText(String.valueOf(enemyHealthBegin + " / " + enemyController.getHealth()));
        }else{
            enemyHealthTxt.setText(String.valueOf("  " + enemyHealthBegin + " / " + enemyController.getHealth()));
        }

        // Adding the actual views to the playground.
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

    /*
    This method damages an enemy for each tap/damage it gets.
     */
    public void damageEnemy(){
        // Attack an enemy untill it is killed an created again
        enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!IS_SHOOTING){
                    // Set the movement beginning position
                    damageMovement1 = 465;
                    damageMovement2 = 495;
                    damageMovement3 = 900;
                    enemy.setClickable(false);

                    // Add the damage to the screen
                    linearLayout.addView(damage);

                    // Get and set the coordinates to the damage
                    damageCoordinates.createCoordinates(direction);
                    damageX = damageCoordinates.getxPos();
                    damageY = damageCoordinates.getyPos();
                    damage.setY(damageY);
                    damage.setX(damageX);

                    // Player sprite points towards enemy
                    // Shoots enemy with an animation that is executed one time only per shot
                    characterAnimation(direction);
                    damageAnimation(direction);
                    player.setImageResource(0);
                    player.setBackgroundDrawable(characterspriteAnim);
                    characterspriteAnim.start();
                    characterspriteAnim.setOneShot(true);

                    IS_DAMAGED = true;
                    damageCollisionDetection();
                    IS_SHOOTING = true;
                }
            }
        });
    }

    public void spriteDirection(int direction){
        switch(direction){
            case 0:
                enemy.setImageResource(R.drawable.enemy1sword1);
                enemyAnimation(direction);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                break;
            case 1:
                enemy.setImageResource(R.drawable.enemy1swordr1);
                enemyAnimation(direction);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                break;
            case 2:
                enemy.setImageResource(R.drawable.enemy1swordup1);
                enemyAnimation(direction);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                break;
        }
    }

    public void getDamageDirectionLogic(){
        switch(direction){
            case 0:
                damage.setImageResource(0);
                damage.setBackgroundDrawable(characterDamageAnimation);
                characterDamageAnimation.start();
                damageMovement1 -= playerController.getAttackspeed();
                damage.setX(damageMovement1);
                break;
            case 1:
                damage.setImageResource(0);
                damage.setBackgroundDrawable(characterDamageAnimation);
                characterDamageAnimation.start();
                damageMovement2 += playerController.getAttackspeed();
                damage.setX(damageMovement2);
                break;
            case 2:
                damage.setImageResource(0);
                damage.setBackgroundDrawable(characterDamageAnimation);
                characterDamageAnimation.start();
                damageMovement3 += playerController.getAttackspeed();
                damage.setY(damageMovement3);
                break;
        }
    }

    public void getDamageDirection(int direction){
        Intent intent = getIntent();
        switch(direction){
            case 0:
                if(intent.getIntExtra("archer", 0) == 1){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    getDamageDirectionLogic();
                }

                break;
            case 1:
                if(intent.getIntExtra("archer", 0) == 1){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    getDamageDirectionLogic();
                }
                break;
            case 2:
                if(intent.getIntExtra("archer", 0) == 1){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("wizard", 0) == 2){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("axethrower", 0) == 3){
                    getDamageDirectionLogic();
                }
                else if(intent.getIntExtra("necromancer", 0) == 4){
                    getDamageDirectionLogic();
                }
                break;
        }
    }

    public void getEnemyDirection(int direction){
        switch(direction){
            case 0:
                enemyMovement1 += 1;
                enemyHealthBar1 += 1;
                enemyHealthShow1 += 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                enemySpriteAnimation.start();
                enemy.setX(enemyMovement1);
                enemyHealth.setX(enemyHealthBar1);
                enemyHealthTxt.setX(enemyHealthShow1);
                break;
            case 1:
                enemyMovement2 -= 1;
                enemyHealthBar2 -= 1;
                enemyHealthShow2 -= 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                enemySpriteAnimation.start();
                enemy.setX(enemyMovement2);
                enemyHealth.setX(enemyHealthBar2);
                enemyHealthTxt.setX(enemyHealthShow2);
                break;
            case 2:
                enemyMovement3 -= 1;
                enemyHealthBar3 -= 1;
                enemyHealthShow3 -= 1;
                enemy.setImageResource(0);
                enemy.setBackgroundDrawable(enemySpriteAnimation);
                enemySpriteAnimation.start();
                enemy.setY(enemyMovement3);
                enemyHealth.setY(enemyHealthBar3);
                enemyHealthTxt.setY(enemyHealthShow3);
                break;
        }
    }

    public void getPlayscreenLevel(){
        Intent intent = getIntent();
        int level = intent.getIntExtra("level", 0);
        switch(level){
            case 1:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl1);
                break;
            case 2:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl2);
                backgroundAnimation = backgroundAnimationController.getPlayscreenBackgroundlevel2();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 3:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl3v2);
                backgroundAnimation = backgroundAnimationController.getPlayscreenBackgroundlevel3();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 4:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl4);
                backgroundAnimation = backgroundAnimationController.getPlayscreenBackgroundlevel4();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 5:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl5);
                backgroundAnimation = backgroundAnimationController.getPlayscreenBackgroundlevel5();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            case 6:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl6);
                backgroundAnimation = backgroundAnimationController.getPlayscreenBackgroundlevel6();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
            default:
                // Setting a background for the playfield.
                linearLayout.setBackgroundResource(R.drawable.backgroundlvl6);
                backgroundAnimation = backgroundAnimationController.getPlayscreenBackgroundlevel6();
                linearLayout.setBackgroundDrawable(backgroundAnimation);
                backgroundAnimation.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // Do nothing here
    }
}
