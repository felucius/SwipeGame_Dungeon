package maximedelange.clickgame.Screens;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
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

import maximedelange.clickgame.Controller.AttackAnimationController;
import maximedelange.clickgame.Controller.BackgroundAnimationController;
import maximedelange.clickgame.Controller.CharacterAnimationController;
import maximedelange.clickgame.Controller.EnemyAnimationController;
import maximedelange.clickgame.Controller.EnemyController;
import maximedelange.clickgame.Controller.PlayerController;
import maximedelange.clickgame.Controller.PlayerStatisticsController;
import maximedelange.clickgame.Controller.TutorialController;
import maximedelange.clickgame.Database.Database;
import maximedelange.clickgame.Domain.DamageCoordinates;
import maximedelange.clickgame.Domain.EnemyCoordinates;
import maximedelange.clickgame.Domain.EnemyNames;
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
    private int level = 1;
    private int damageX = 0;
    private int damageY = 0;
    private int direction;
    private int neededScore = 5;
    private int coords[] = new int[3];
    private int enemyHealthCounter = 0;
    private int playerHealthBegin = 0;
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
    private boolean IS_KILLABLE = false;
    private boolean IS_DAMAGED = false;
    private boolean IS_SHOOTING = false;
    private boolean IS_NEXT_LEVEL = false;

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
    private TextView nextlevelScore = null;
    private TextView enemyHealthTxt = null;
    private TextView enemyName = null;
    private TextView playerHealthTxt = null;
    private TextView currentScoreTxt = null;
    private TextView highScoreTxt = null;
    private TextView playerGold = null;
    private ImageButton btnStart = null;
    private Button btnNextLevel = null;
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
        database = new Database(this, null, null, 1); // Create database.
        initializeGameInformation(); // Initialize basic gameplay information.
        createEnemy(); // Creating an enemy
        // Shows tutorial for new players
        //tutorialController.showTutorial("1", player, enemy, currentScoreTxt, btnStart, btnUpgradeScreen, btnStatusScreen);
    }

    /*
    This method animates the enemy. It gets an "direction" as parameter
    to know in which way the enemy needs to animate.
    */
    public void enemyAnimation(int direction) {
        enemySpriteAnimation = enemyAnimationController.enemyAnimation(direction);
    }

    /*
    This method animates the character. It gets an "enemyDirection" as parameter
    to know in which way the character needs to be looking/animate.
     */
    public void characterAnimation(int enemyDirection) {
        characterspriteAnim = characterAnimationController.characterAnimation(enemyDirection, this);
    }

    public void damageAnimation(int enemyDirection) {
        characterDamageAnimation = attackAnimationController.damageAnimation(enemyDirection, this);
    }

    public void startGame() {
        damageEnemy();
        setEnemyMovement();
        setDamageMovement();
        IS_KILLABLE = true;
    }

    public void showBeforePlayScreen() {
        final Dialog dialogscreen = new Dialog(PlayScreen.this);
        dialogscreen.setCanceledOnTouchOutside(false);
        dialogscreen.setCancelable(false);
        dialogscreen.setContentView(R.layout.beforeplay_screen);

        // Setting the information to the created views.
        btnStart = (ImageButton) dialogscreen.findViewById(R.id.btnPlay);
        btnStatusScreen = (ImageButton) dialogscreen.findViewById(R.id.btnStatus);
        btnUpgradeScreen = (ImageButton) dialogscreen.findViewById(R.id.btnUpgrade);

        btnStart.setImageResource(R.drawable.btnplay);
        btnUpgradeScreen.setImageResource(R.drawable.btnarmory);
        btnStatusScreen.setImageResource(R.drawable.btnstatistics);

        btnStart = (ImageButton) dialogscreen.findViewById(R.id.btnPlay);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogscreen.dismiss();
                startGame();
            }
        });

        upgradeScreen();
        statusScreen();


        if (healthBar.getProgress() <= 1 || IS_NEXT_LEVEL == true) {
            // Displaying the new information.
            btnStart = (ImageButton) dialogscreen.findViewById(R.id.btnPlay);
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogscreen.dismiss();
                    checkEnemyPosition();
                    createEnemy();

                    if (healthBar.getProgress() <= 1) {
                        level = 1;
                        getPlayscreenLevel();
                    }

                    playerController.setHealth(playerHealthBegin);
                    playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
                    healthBar.setProgress(playerController.getHealth());

                    startGame();
                    IS_NEXT_LEVEL = false;
                }
            });
        }

        dialogscreen.show();
    }

    /*
    This method shows the upgrade screen for the players. In this screen the hero
    can be upgraded with different kinds of upgrades.
     */
    public void upgradeScreen() {
        btnUpgradeScreen.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                final Dialog upgradeDialog = new Dialog(PlayScreen.this);
                upgradeDialog.setCanceledOnTouchOutside(false);
                upgradeDialog.setCancelable(false);
                upgradeDialog.setContentView(R.layout.upgrade_screen);

                // Creating views
                final TextView upgradeHealth = (TextView) upgradeDialog.findViewById(R.id.upgradeHealthTxt);
                final TextView upgradeHealthCost = (TextView) upgradeDialog.findViewById(R.id.upgradeHealthCostTxt);
                final TextView upgradeDamage = (TextView) upgradeDialog.findViewById(R.id.upgradeDamageTxt);
                final TextView upgradeDamageCost = (TextView) upgradeDialog.findViewById(R.id.upgradeDamageCostTxt);
                final TextView upgradeAttackspeed = (TextView) upgradeDialog.findViewById(R.id.upgradeAttackspeedTxt);
                final TextView upgradeAttackspeedCost = (TextView) upgradeDialog.findViewById(R.id.upgradeAttackspeedCostTxt);
                final Button btnUpgradeHealth = (Button) upgradeDialog.findViewById(R.id.btnUpgradeHealth);
                final Button btnUpgradeDamage = (Button) upgradeDialog.findViewById(R.id.btnUpgradeDamage);
                final Button btnUpgradeAttackspeed = (Button) upgradeDialog.findViewById(R.id.btnUpgradeAttackspeed);

                // Setting content to the views
                upgradeHealth.setText(String.valueOf(playerController.getHealth()));
                upgradeDamage.setText(String.valueOf(playerController.getDamage()));
                upgradeAttackspeed.setText(String.valueOf(playerController.getAttackspeed()));
                upgradeHealthCost.setText(String.valueOf("G " + upgradecostHealth));
                upgradeDamageCost.setText(String.valueOf("G " + upgradecostDamage));
                upgradeAttackspeedCost.setText(String.valueOf("G " + upgradecostAttackspeed));

                btnUpgradeHealth.setText("upgrade"); // Health
                btnUpgradeDamage.setText("upgrade"); // Damage
                btnUpgradeAttackspeed.setText("upgrade"); // Attack speed

                if (playerController.getGold() >= upgradecostHealth) {
                    btnUpgradeHealth.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            upgradeDialog.create();
                            if (playerController.getGold() >= upgradecostHealth) {
                                upgradecostHealth = playerController.healthUpgradeLogic(upgradecostHealth);
                                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
                                healthBar.setMax(playerController.getHealth());
                                healthBar.setProgress(playerController.getHealth());
                                upgradeHealth.setText(String.valueOf(playerController.getHealth()));
                                upgradeHealthCost.setText(String.valueOf("G " + upgradecostHealth));
                                playerGold.setText(String.valueOf(playerController.getGold()));

                                if (playerController.getGold() <= upgradecostHealth) {
                                    btnUpgradeHealth.setEnabled(false);
                                }
                            } else {
                                btnUpgradeHealth.setEnabled(false);
                            }
                        }
                    });
                } else {
                    btnUpgradeHealth.setEnabled(false);
                }

                if (playerController.getGold() >= upgradecostDamage) {
                    btnUpgradeDamage.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            upgradeDialog.create();
                            if (playerController.getGold() >= upgradecostDamage) {
                                upgradecostDamage = playerController.damageUpgradeLogic(upgradecostDamage);
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
                } else {
                    btnUpgradeDamage.setEnabled(false);
                }

                if (playerController.getGold() >= upgradecostAttackspeed) {
                    btnUpgradeAttackspeed.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onClick(View v) {
                            upgradeDialog.create();
                            if (playerController.getGold() >= upgradecostAttackspeed) {
                                upgradecostAttackspeed = playerController.attackspeedUpgradeLogic(upgradecostAttackspeed);
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
                } else {
                    btnUpgradeAttackspeed.setEnabled(false);
                }

                dismisspopup = (Button) upgradeDialog.findViewById(R.id.dismissPopup);
                dismisspopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        upgradeDialog.dismiss();
                    }
                });
                upgradeDialog.show();
            }
        });
    }

    public void statusScreen() {
        final PlayerStatisticsController playerStatisticsController = new PlayerStatisticsController();
        btnStatusScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog statusScreenDialog = playerStatisticsController.statusScreen(PlayScreen.this, playerController, database);
                statusScreenDialog.show();
                dismisspopup = (Button) statusScreenDialog.findViewById(R.id.dismissPopup);
                dismisspopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        statusScreenDialog.dismiss();
                    }
                });
            }
        });
    }

    /*
    Create a player with some specifications.
     */
    public void createPlayer() {
        // Create views.
        playerHealthTxt = (TextView) findViewById(R.id.txtHealthShow);
        player = (ImageView) findViewById(R.id.imagePlayer);
        healthBar = (ProgressBar) findViewById(R.id.playerHealth);
        playerName = (TextView) findViewById(R.id.txtName);

        // Creating player
        playerController.createPlayer("Jack", player, PlayScreen.this);
        playerHealthBegin = playerController.getHealth();

        // Displaying the character information.
        playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
        healthBar.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        healthBar.setMax(playerController.getHealth());
        healthBar.setProgress(playerController.getHealth());
        playerName.setText(playerController.getName());
        playerName.setY(100);
    }

    /*
    Updating the current and highscore.
     */
    public void changeScoreBar(int score) {
        currentScoreTxt.setText("score: " + score);
        highScoreTxt.setText("high score: " + highScore);
        if (score > highScore) {
            highScoreTxt.setText("high score: " + score);
            highScore = score;
        }
        checkLevelRequirement();
    }

    /*
    Checks for damage with enemy collision.
    */
    public void damageCollisionDetection() {
        Rect damageCollision = new Rect();
        Rect enemyCollision = new Rect();

        damage.getHitRect(damageCollision);
        enemy.getHitRect(enemyCollision);

        // Collision detection between damage and enemy.
        if (Rect.intersects(damageCollision, enemyCollision)) {
            IS_SHOOTING = false;
            enemy.setClickable(true);
            enemyHealthCounter -= playerController.getDamage(); // Deals damage to the health of the enemy.

            // Setting the new information
            enemyController.setHealth(enemyHealthCounter);
            enemyHealth.setProgress(enemyHealthCounter);

            IS_COLLIDING = true; // Is not colliding anymore
            IS_DAMAGED = false; // Enemy cannot be killed.

            // Display healthbar of enemy.
            if (enemyHealthBegin >= 10) {
                enemyHealthTxt.setText(String.valueOf(enemyHealthBegin + " / " + enemyController.getHealth()));
            } else {
                enemyHealthTxt.setText(String.valueOf("  " + enemyHealthBegin + " / " + enemyController.getHealth()));
            }

            // If enemy has been killed. Views are destroyed, update score and recreate an new enemy.
            if (enemyHealthCounter < 1) {
                int gold = enemyController.getGold(); // Retrieve gold from killed enemy.
                playerController.setGold(gold);
                playerGold.setText("gold: " + playerController.getGold());

                currentScore++; // Highers the current score of the fighting session.
                nextlevelScore.setText(String.valueOf(currentScore) + " / " + String.valueOf(neededScore));

                // Remove views that belong to the killed enemy.
                linearLayout.removeView(enemy);
                linearLayout.removeView(enemyHealth);
                linearLayout.removeView(enemyHealthTxt);
                linearLayout.removeView(enemyName);

                // Creating a new enemy for battle.
                enemyHealthCounter = enemyHealthBegin;
                createEnemy();
                changeScoreBar(currentScore);

                if (currentScore >= highScore) {
                    playerController.setHighScore(currentScore);
                    database.updateHighscore(playerController.getHighScore());
                } else {
                    playerController.setScore(currentScore);
                }
            }
            linearLayout.removeView(damage);
        }
    }

    /*
    Checks for enemy with player collision.
     */
    public void collisionDetection() {
        Rect playerCollision = new Rect();
        Rect enemyCollision = new Rect();

        player.getHitRect(playerCollision);
        enemy.getHitRect(enemyCollision);

        // Collision detection between player and enemy.
        if (Rect.intersects(playerCollision, enemyCollision)) {
            // Player has been killed. Specs are being set for the death of the player.
            if (healthBar.getProgress() <= 1) {
                // Displaying the new information.
                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + 0));
                healthBar.setProgress(0);
                showBeforePlayScreen();
                countDownMovement.cancel();
                damageMovement.cancel();

                // Removing information from the enemy that killed the player.
                linearLayout.removeView(enemy);
                linearLayout.removeView(enemyHealth);
                linearLayout.removeView(enemyHealthTxt);
            } else {
                IS_COLLIDING = true;
                // Setting new player health after attack.
                playerController.setHealth(playerController.enemyDoDamage(1));
                healthBar.setProgress(playerController.getHealth());
                playerHealthTxt.setText(String.valueOf(playerHealthBegin + " / " + playerController.getHealth()));
                checkEnemyPosition(); // When the enemy hit the player the enemy is spawned to it's begin point.
            }
        }
    }

    public void checkEnemyPosition() {
        enemyController.checkEnemyPosition(direction, enemy, enemyHealth, enemyHealthTxt, enemyName);
    }

    /*
    Moves the damage on the playground
    */
    public void setDamageMovement() {
        damageMovement = new CountDownTimer(10000000 * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (IS_COLLIDING) {
                    IS_COLLIDING = false;
                } else {
                    if (IS_DAMAGED) {
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
    public void setEnemyMovement() {
        player = (ImageView) findViewById(R.id.imagePlayer);
        countDownMovement = new CountDownTimer(10000000 * 1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (IS_COLLIDING) {
                    IS_COLLIDING = false;
                } else {
                    getEnemyDirection(direction);// Getting enemy's walking direction
                    collisionDetection(); // Checking player and enemy collision
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
    public void initializeGameInformation() {
        Intent intent = getIntent();
        // Create the game palyground.
        linearLayout = (RelativeLayout) findViewById(R.id.playGround);
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // gets called after layout has been done but before display.
                linearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                xPos = linearLayout.getWidth();
                yPos = linearLayout.getHeight();
            }
        });

        level = intent.getIntExtra("level", 0);
        getPlayscreenLevel();

        // Initialize controller classes.
        enemyCoordinates = new EnemyCoordinates();
        damageCoordinates = new DamageCoordinates();
        playerController = new PlayerController();
        enemyController = new EnemyController();

        createPlayer(); // Creating a new player.

        // Create views.
        damage = new ImageView(this);
        damageTxt = (TextView) findViewById(R.id.txtDamage);
        playerGold = (TextView) findViewById(R.id.txtGold);
        highScoreTxt = (TextView) findViewById(R.id.txtHighScore);
        currentScoreTxt = (TextView) findViewById(R.id.txtScore);
        nextlevelScore = (TextView) findViewById(R.id.txtNextLevelScore);

        // Displaying information.
        damageTxt.setText(String.valueOf("DMG: " + playerController.getDamage()));
        nextlevelScore.setText(String.valueOf(currentScore) + " / " + String.valueOf(neededScore));
        playerGold.setText("G: " + playerController.getGold());
        currentScoreTxt.setText(String.valueOf(currentScore));
        highScore = Integer.valueOf(database.getHighscore());

        // Initialize the basic price for an upgrade.
        upgradecostHealth = 100;
        upgradecostDamage = 100;
        upgradecostAttackspeed = 100;
        changeScoreBar(highScore);
        changeScoreBar(score);
        enemyAnimation(direction); // Get enemy sprite direction.
        damageAnimation(direction); // Damage enemy by locating it's direction.
        showBeforePlayScreen();
    }

    /*
    This method created an enemy.
    It provides a beginning X and Y coordinates
    and sprite animation.
     */
    public void createEnemy() {
        coords = enemyController.createEnemy(direction); // Generate enemy position
        direction = coords[2];
        enemyHealthCounter += 1; // Upgrades health of enemy
        enemyHealthBegin += 1; // Upgrades health of enemy
        enemyController.setHealth(enemyHealthCounter); // Setting the new health of the enemy

        // Creating views.
        enemyHealth = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        enemyHealthTxt = new TextView(this);
        enemyHealthTxt.setTextColor(Color.YELLOW);
        enemyName = new TextView(this);
        enemyName.setTextColor(Color.YELLOW);
        enemyName.setText(String.valueOf(EnemyNames.Bronze_Warrior));
        enemy = new ImageView(this);

        // Displaying information per enemy.
        enemyHealth.setMax(enemyController.getHealth());
        enemyHealth.setProgress(enemyController.getHealth());
        enemyHealth.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        // If statement for correcting the layout of displaying health.
        if (enemyHealthBegin >= 10) {
            enemyHealthTxt.setText(String.valueOf(enemyHealthBegin + " / " + enemyController.getHealth()));
        } else {
            enemyHealthTxt.setText(String.valueOf("  " + enemyHealthBegin + " / " + enemyController.getHealth()));
        }

        // Adding the actual views to the playground.
        enemy.setImageResource(R.mipmap.ic_launcher);
        enemy.setX(coords[0]); // X postiion of enemy
        enemy.setY(coords[1]); // Y position of enemy
        enemyHealth.setX(coords[0]); // X position of health display
        enemyHealth.setY(coords[1]); // Y position of health display
        enemyHealthTxt.setX(coords[0]); // X position of health text display
        enemyHealthTxt.setY(coords[1] - 40); // Y position of health text display
        enemyName.setX(coords[0] - 40); // X position of enemy name
        enemyName.setY(coords[1] - 80); // Y position of enemy name
        checkEnemyPosition();

        linearLayout.addView(enemy);
        linearLayout.addView(enemyHealth);
        linearLayout.addView(enemyHealthTxt);
        linearLayout.addView(enemyName);
        spriteDirection(direction);

        // Attack an enemy untill it is killed an created again
        if (IS_KILLABLE) {
            damageEnemy();
        }
    }

    /*
    This method damages an enemy for each tap/damage it gets.
     */
    public void damageEnemy() {
        // Attack an enemy untill it is killed an created again
        enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!IS_SHOOTING) {
                    // Set the movement beginning position
                    playerController.damageMovement1 = 465;
                    playerController.damageMovement2 = 495;
                    playerController.damageMovement3 = 900;
                    enemy.setClickable(false);
                    linearLayout.addView(damage); // Add the damage to the screen

                    // Get and set the coordinates to the damage
                    damageCoordinates.createCoordinates(direction);
                    damageX = damageCoordinates.getxPos();
                    damageY = damageCoordinates.getyPos();
                    damage.setY(damageY);
                    damage.setX(damageX);

                    characterAnimation(direction); // Player sprite points towards enemy
                    damageAnimation(direction); // Shoots enemy with an animation that is executed one time only per shot
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

    public void spriteDirection(int direction) {
        switch (direction) {
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

    public void getDamageDirection(int direction) {
        playerController.getDamageDirectionLogic(direction, damage, characterDamageAnimation);
        playerController.getDamageDirection(direction, PlayScreen.this);
    }

    public void getEnemyDirection(int direction) {
        enemyController.getEnemyDirection(direction, enemy, enemySpriteAnimation, enemyHealth, enemyHealthTxt, enemyName);
    }

    public void checkLevelRequirement() {
        if (currentScore >= neededScore) {
            neededScore *= 3.4;
            nextlevelScore.setText(String.valueOf(currentScore) + " / " + String.valueOf(neededScore));
            nextLevel();
        }
    }

    public void nextLevel() {
        countDownMovement.cancel();
        damageMovement.cancel();

        // Removing information from the enemy that killed the player.
        linearLayout.removeView(enemy);
        linearLayout.removeView(enemyHealth);
        linearLayout.removeView(enemyHealthTxt);
        linearLayout.removeView(enemyName);

        final Dialog nextLevel = new Dialog(PlayScreen.this);
        nextLevel.setCanceledOnTouchOutside(false);
        nextLevel.setCancelable(false);
        nextLevel.setContentView(R.layout.nextlevel_screen);

        btnNextLevel = (Button) nextLevel.findViewById(R.id.dismissPopup);
        btnNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextLevel.dismiss();

                final Dialog mapscreen = new Dialog(PlayScreen.this);
                mapscreen.setCanceledOnTouchOutside(false);
                mapscreen.setCancelable(false);
                mapscreen.setContentView(R.layout.mapoverlay_screen);
                ImageView showMap = (ImageView) mapscreen.findViewById(R.id.mapOverlay);
                showMap.setImageResource(R.drawable.backgroundmap);

                Button btnGetNextLevel = (Button) mapscreen.findViewById(R.id.dismissPopup);
                btnGetNextLevel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mapscreen.dismiss();
                        level++;
                        getPlayscreenLevel();
                        IS_NEXT_LEVEL = true;
                        showBeforePlayScreen();
                    }
                });

                mapscreen.show();
            }
        });

        nextLevel.show();
    }

    public void getPlayscreenLevel() {
        backgroundAnimationController.getPlayscreenLevel(level, linearLayout, backgroundAnimation);
    }

    @Override
    public void onBackPressed() {
        // Do nothing here
    }
}