package sample;
//importoj klasat per checkboxa
import Rezultatet.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    //pointerat per fxml id
    public Button RollButton;
    public ImageView dice1;
    public ImageView dice2;
    public ImageView dice3;
    public ImageView dice4;
    public ImageView dice5;
    public CheckBox onesCheck;
    public CheckBox twosCheck;
    public CheckBox threesCheck;
    public CheckBox foursCheck;
    public CheckBox fivesCheck;
    public CheckBox sixesCheck;
    public CheckBox chanceCheck;
    public CheckBox ThreeKindsCheck;
    public CheckBox FourKindsCheck;
    public CheckBox TwoPairCheck;
    public CheckBox FullHouseCheck;
    public CheckBox LittleSCheck;
    public CheckBox BigSCheck;
    public CheckBox YahtzeeCheck;
    public Label BonusCheck;
    public Label TotalCheck;

    //variablat
    //numri i gjuajtejeve (deri ne 3)
    private int throwNum = 0;
    //na duhet ni array me vlerat e 5 gjujtjeve, e perdorim si passed variabel te konstruktort e klasave per kalkulime
    private int[] rezultati = new int[5];
    //Shuma finale
    private int totalSum = 0;

    //per me i bo permanent disable checkboxat
    private boolean onesCheckdisable = false;
    private boolean twosCheckdisable = false;
    private boolean threesCheckdisable = false;
    private boolean foursCheckdisable = false;
    private boolean fivesCheckdisable = false;
    private boolean sixesCheckdisable = false;
    private boolean chanceCheckdisable = false;
    private boolean threeKindsCheckdisable = false;
    private boolean fourKindsCheckdisable = false;
    private boolean twoPairCheckdisable = false;
    private boolean fullHouseCheckdisable = false;
    private boolean littleSCheckdisable = false;
    private boolean bigSCheckdisable = false;
    private boolean yahtzeeCheckdisable = false;

    //variablat per bonus, nese jon true krejt ja jep ni bonus, 35 per Small, edhe Big 100;
    //per small ose kolona e par, jon tnevojshme me i dit krejt a i ka check
    //se nese e ka mrri me pak rolls, munen me ju shtu disa her bonusi
    private boolean smallOnes = false;
    private boolean smallTwos = false;
    private boolean smallThrees = false;
    private boolean smallFours = false;
    private boolean smallFives = false;
    private boolean smallSixes = false;
    private boolean smallChance = false;
    //kushti osht qe me pas shumen kolona e par mbi 63
    private int smallSumCheck = 0;
    //per big ose kolona e dyt
    private boolean bigThree = false;
    private boolean bigFour = false;
    private boolean bigTwoPair = false;
    private boolean bigFullH = false;
    private boolean bigLS = false;
    private boolean bigBS = false;
    private boolean bigYahtzee = false;
    private int bigSumCheck = 0;

    //klasat
    ONES ones;
    TWOS twos;
    THREES threes;
    FOURS fours;
    FIVES fives;
    SIXES sixes;
    CHANCE chance;
    THREEKINDS threekinds;
    FOURKINDS fourkinds;
    TWOPAIR twopair;
    FULLHOUSE fullhouse;
    LITTLES littles;
    BIGS bigs;
    YAHTZEE yahtzee;

    //variabla per hover per button
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #c3d0d4; -fx-border-color: #8cb48c; -fx-border-width: 5; -fx-background-radius: 17; -fx-border-radius: 15;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #c3d0d4; -fx-border-color: #8cb48c; -fx-border-width: 5; -fx-background-radius: 17; -fx-border-radius: 15;";

    //butoni me lu lojen Roll the Dices
    public void rollDice() {
        //Ndrysho foton per 6 imageViews me bo qe po rrotullohet zari
        URL rollingDice = getClass().getResource("../Dices/DiceRolling.gif");
        dice1.setImage(new Image(rollingDice.toExternalForm()));
        dice2.setImage(new Image(rollingDice.toExternalForm()));
        dice3.setImage(new Image(rollingDice.toExternalForm()));
        dice4.setImage(new Image(rollingDice.toExternalForm()));
        dice5.setImage(new Image(rollingDice.toExternalForm()));

        //Nese bohen 3 gjujtje, mos e le me gjujt deri sa te bon select ni rezultat
        throwNum++;
        if(throwNum==3){ RollButton.setDisable(true); }
        else {RollButton.setDisable(false);}

        //Le gif me lujt per 2.5 sekonda
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        //Thirre klasen zari
                        Dice Dice = new Dice(6);

                        //Per secilin zar (5 max) rrotullo 1 her
                        for(int i = 1; i<=5 ; i++){
                            //funksioni rrotullo zarin
                            int diceVal = Dice.roll();

                            //Ruje rez e hedhjes ne array
                            rezultati[i-1]=diceVal;

                            //Ndrysho foton nbaz cilit zar jemi (i) edhe cili numer ka ra (case)
                            switch (diceVal) {
                                case 1:
                                    URL diceSide1 = getClass().getResource("../Dices/Side1.png");
                                    if(i==1){dice1.setImage(new Image(diceSide1.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide1.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide1.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide1.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide1.toExternalForm()));}
                                    break;
                                case 2:
                                    URL diceSide2 = getClass().getResource("../Dices/Side2.png");
                                    if(i==1){dice1.setImage(new Image(diceSide2.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide2.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide2.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide2.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide2.toExternalForm()));}
                                    break;
                                case 3:
                                    URL diceSide3 = getClass().getResource("../Dices/Side3.jpg");
                                    if(i==1){dice1.setImage(new Image(diceSide3.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide3.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide3.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide3.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide3.toExternalForm()));}
                                    break;
                                case 4:
                                    URL diceSide4 = getClass().getResource("../Dices/Side4.jpg");
                                    if(i==1){dice1.setImage(new Image(diceSide4.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide4.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide4.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide4.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide4.toExternalForm()));}
                                    break;
                                case 5:
                                    URL diceSide5 = getClass().getResource("../Dices/Side5.png");
                                    if(i==1){dice1.setImage(new Image(diceSide5.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide5.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide5.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide5.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide5.toExternalForm()));}
                                    break;
                                case 6:
                                    URL diceSide6 = getClass().getResource("../Dices/Side6.png");
                                    if(i==1){dice1.setImage(new Image(diceSide6.toExternalForm()));}
                                    if(i==2){dice2.setImage(new Image(diceSide6.toExternalForm()));}
                                    if(i==3){dice3.setImage(new Image(diceSide6.toExternalForm()));}
                                    if(i==4){dice4.setImage(new Image(diceSide6.toExternalForm()));}
                                    else{dice5.setImage(new Image(diceSide6.toExternalForm()));}
                                    break;
                            }
                        }
                    }
                    //koha qe pret mu kry gif
                }, 2500
        );
        //Nuk e shpreh rezultatin deri sa tkryhet animacioni
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2600),
                ae -> {
                    //mas animacionit kur kryhet, thirri klasat me percaktu rez, me leju checkboxat mu click
                    //edhe me display textin ne baz rez qe na kthehet
                    ones = new ONES(rezultati);
                    onesCheckbox();
                    twos = new TWOS(rezultati);
                    twosCheckbox();
                    threes = new THREES(rezultati);
                    threesCheckbox();
                    fours = new FOURS(rezultati);
                    foursCheckbox();
                    fives = new FIVES(rezultati);
                    fivesCheckbox();
                    sixes = new SIXES(rezultati);
                    sixesCheckbox();
                    chance = new CHANCE(rezultati);
                    chanceCheck();
                    threekinds = new THREEKINDS(rezultati);
                    threekindsCheck();
                    fourkinds = new FOURKINDS(rezultati);
                    fourkindsCheck();
                    twopair = new TWOPAIR(rezultati);
                    twopairCheck();
                    fullhouse = new FULLHOUSE(rezultati);
                    fullhouseCheck();
                    littles = new LITTLES(rezultati);
                    littlesCheck();
                    bigs = new BIGS(rezultati);
                    bigsCheck();
                    yahtzee = new YAHTZEE(rezultati);
                    yahtzeeCheck();
                }
                ));
        //play bohet tnjejten koh me pauzen e maperparshme, 0.1 sekonda ma von ja nis me i bo display edhe claculate
        timeline.play();

    }

    //Kur shtypet ni CheckBox
    //merrja shumen, shto ne total result, ndrro textin, bone permanent disable qat checkbox
    //gjithashtu i bon disable krejt checkboxat tjer edhe ja hjek rezultatet
    //kur e shtyp ni checkbox ja bon number of roll back to 0 qe me mujt me gju edhe 3 her
    //niher kalkulohet bonusi, bonusi aktivizohet veq kur krejt checkboxat e kolones jon check
    public void resultONESClick(){

        //per bonus
        smallOnes=true;
        smallSumCheck+=ones.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + ones.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        onesCheckdisable = true;

        //re-roll
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultTWOSClick(){

        //per bonus
        smallTwos=true;
        smallSumCheck+=twos.getShuma();
        showBonus();

        //per shumen totale
        totalSum = totalSum + smallBonus() + twos.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        twosCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultTHREESClick(){

        //per bonus
        smallThrees=true;
        smallSumCheck+=threes.getShuma();
        showBonus();

        //me kalkulu shumen
        totalSum = totalSum + smallBonus() + threes.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        threesCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultFOURSClick(){

        //per bonus
        smallFours=true;
        smallSumCheck+=fours.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + fours.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        foursCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultFIVESClick(){

        //per bonus
        smallFives=true;
        smallSumCheck+=fives.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + fives.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        fivesCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultSIXESClick(){

        //per bonus
        smallSixes=true;
        smallSumCheck+=sixes.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + sixes.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        sixesCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultCHANCEClick(){

        //per bonus
        smallChance=true;
        smallSumCheck+=chance.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + smallBonus() + chance.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        chanceCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void result3OAKClick(){

        //per bonus
        bigThree=true;
        bigSumCheck+=threekinds.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + threekinds.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        threeKindsCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void result4OAKClick(){

        //per bonus
        bigFour=true;
        bigSumCheck+=fourkinds.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + fourkinds.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        fourKindsCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void result2PClick(){

        //per bonus
        bigTwoPair=true;
        bigSumCheck+=twopair.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + twopair.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        twoPairCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultFULLHOUSEClick(){

        //per bonus
        bigFullH=true;
        bigSumCheck+=fullhouse.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + fullhouse.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        fullHouseCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultLITTLESClick(){

        //per bonus
        bigLS=true;
        bigSumCheck+=littles.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + littles.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        littleSCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultBIGSClick(){

        //per bonus
        bigBS=true;
        bigSumCheck+=bigs.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + bigs.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        bigSCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }
    public void resultYAHTZEEClick(){

        //per bonus
        bigYahtzee=true;
        bigSumCheck+=yahtzee.getShuma();
        showBonus();

        //shuma totale
        totalSum = totalSum + bigBonus() + yahtzee.getShuma();
        TotalCheck.setText(String.valueOf(totalSum));
        yahtzeeCheckdisable = true;
        throwNum = 0;
        RollButton.setDisable(false);

        //disable checkboxave
        disableCheckBox();

        //ndrro ngjyren
        ngjyraRez();
    }


    //Kur shtypet butoni roll, funskionet i kalkulojn shumat e pikve per opsione edhe i bojn enable opsionet
    //nese ni opsion e ka disable true smunet per 2ten her me u ri-shtyp
    public void onesCheckbox(){
        if(onesCheckdisable==false){
            onesCheck.setDisable(false);
            int onesSum = ones.getShuma();
            onesCheck.setText(String.valueOf(onesSum));
        }
    }
    public void twosCheckbox(){
        if(twosCheckdisable==false){
            twosCheck.setDisable(false);
            int twosSum = twos.getShuma();
            twosCheck.setText(String.valueOf(twosSum));
        }
    }
    public void threesCheckbox(){
        if(threesCheckdisable==false){
            threesCheck.setDisable(false);
            int threesSum = threes.getShuma();
            threesCheck.setText(String.valueOf(threesSum));
        }
    }
    public void foursCheckbox(){
        if(foursCheckdisable==false){
            foursCheck.setDisable(false);
            int foursSum = fours.getShuma();
            foursCheck.setText(String.valueOf(foursSum));
        }
    }
    public void fivesCheckbox(){
        if(fivesCheckdisable==false){
            fivesCheck.setDisable(false);
            int fivesSum = fives.getShuma();
            fivesCheck.setText(String.valueOf(fivesSum));
        }
    }
    public void sixesCheckbox(){
        if(sixesCheckdisable==false){
            sixesCheck.setDisable(false);
            int sixesSum = sixes.getShuma();
            sixesCheck.setText(String.valueOf(sixesSum));
        }
    }
    public void chanceCheck(){
        if(chanceCheckdisable==false){
            chanceCheck.setDisable(false);
            int chanceSum = chance.getShuma();
            chanceCheck.setText(String.valueOf(chanceSum));
        }
    }
    public void threekindsCheck(){
        if(threeKindsCheckdisable==false){
            ThreeKindsCheck.setDisable(false);
            int threeKSum = threekinds.getShuma();
            ThreeKindsCheck.setText(String.valueOf(threeKSum));
        }
    }
    public void fourkindsCheck(){
        if(fourKindsCheckdisable==false){
            FourKindsCheck.setDisable(false);
            int fourKSum = fourkinds.getShuma();
            FourKindsCheck.setText(String.valueOf(fourKSum));
        }
    }
    public void twopairCheck(){
        if(twoPairCheckdisable==false){
            TwoPairCheck.setDisable(false);
            int twoPSum = twopair.getShuma();
            TwoPairCheck.setText(String.valueOf(twoPSum));
        }
    }
    public void fullhouseCheck(){
        if(fullHouseCheckdisable==false){
            FullHouseCheck.setDisable(false);
            int fullHSum = fullhouse.getShuma();
            FullHouseCheck.setText(String.valueOf(fullHSum));
        }
    }
    public void littlesCheck(){
        if(littleSCheckdisable==false){
            LittleSCheck.setDisable(false);
            int littleSSum = littles.getShuma();
            LittleSCheck.setText(String.valueOf(littleSSum));
        }
    }
    public void bigsCheck(){
        if(bigSCheckdisable==false){
            BigSCheck.setDisable(false);
            int bigSSum = bigs.getShuma();
            BigSCheck.setText(String.valueOf(bigSSum));
        }
    }
    public void yahtzeeCheck(){
        if(yahtzeeCheckdisable==false){
            YahtzeeCheck.setDisable(false);
            int yahtzeeSum = yahtzee.getShuma();
            YahtzeeCheck.setText(String.valueOf(yahtzeeSum));
        }
    }

    //funskioni me ja bo disable edhe me hjek tekstin
    private void disableCheckBox(){
        onesCheck.setDisable(true);
        onesCheck.setText("");
        twosCheck.setDisable(true);
        twosCheck.setText("");
        threesCheck.setDisable(true);
        threesCheck.setText("");
        foursCheck.setDisable(true);
        foursCheck.setText("");
        fivesCheck.setDisable(true);
        fivesCheck.setText("");
        sixesCheck.setDisable(true);
        sixesCheck.setText("");
        chanceCheck.setDisable(true);
        chanceCheck.setText("");
        ThreeKindsCheck.setDisable(true);
        ThreeKindsCheck.setText("");
        FourKindsCheck.setDisable(true);
        FourKindsCheck.setText("");
        TwoPairCheck.setDisable(true);
        TwoPairCheck.setText("");
        FullHouseCheck.setDisable(true);
        FullHouseCheck.setText("");
        LittleSCheck.setDisable(true);
        LittleSCheck.setText("");
        BigSCheck.setDisable(true);
        BigSCheck.setText("");
        YahtzeeCheck.setDisable(true);
        YahtzeeCheck.setText("");
    }

    //funksionet me kalkulu bonuset
    private int smallBonus(){
        if((smallOnes==true)&&(smallTwos==true)&&(smallThrees==true)&&(smallFours==true)&&(smallFives==true)
                &&(smallSixes==true)&&(smallChance==true)&&(smallSumCheck>62)){
            return 35;
        }
        else return 0;
    }
    private int bigBonus(){
        if((bigThree==true)&&(bigFour==true)&&(bigTwoPair==true)&&(bigFullH==true)&&(bigLS==true)
                &&(bigBS==true)&&(bigYahtzee==true)&&(bigSumCheck>99)){
            return 100;
        }
        else return 0;
    }

    //Display bonusin
    private void showBonus(){
        if ((smallBonus()==35)||(bigBonus()==100)){
            int bonusDisplay = smallBonus()+bigBonus();
            BonusCheck.setText(String.valueOf(bonusDisplay));
        }
    }

    //ndrro ngjyren e rez
    private void ngjyraRez() {
        if (totalSum < 26) {
            TotalCheck.setStyle("-fx-text-fill: RED");
        } else if ((totalSum > 74)&&(totalSum<126)) {
            TotalCheck.setStyle("-fx-text-fill: Blue");
        } else if (totalSum>124){
            TotalCheck.setStyle("-fx-text-fill: Green");
        } else {
            TotalCheck.setStyle("-fx-text-fill: Black");
        }
    }

    //hover effect
    public void mouseEnter(){
        RollButton.setStyle(HOVERED_BUTTON_STYLE);
        RollButton.setOpacity(1);
    }
    public void mouseExit(){
        RollButton.setStyle(IDLE_BUTTON_STYLE);
        RollButton.setOpacity(0.7);
    }
}
