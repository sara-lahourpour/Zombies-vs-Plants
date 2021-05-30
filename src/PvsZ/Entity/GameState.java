package PvsZ.Entity;

import PvsZ.Entity.Bullets.Pea;
import PvsZ.Entity.Cards.*;
import PvsZ.Entity.LawnMower.LawnMower;
import PvsZ.Entity.Plants.Plant;
import PvsZ.Entity.Sun.Sun;
import PvsZ.Entity.Zombies.Zombie;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * GameState class represents the state of PlantVsZombies game
 * and holds its details
 *
 *
 *
 * @author sara lahourpour
 * @since 1/23/2021
 * @version 0.0
 *
 */
public class GameState {


    private ArrayList<Plant> plants;
    private ArrayList<Zombie> zombies;
    private ArrayList<Pea> peas;
    private ArrayList<Sun> suns;
    private ArrayList<Card> cards;
    private ArrayList<LawnMower> lawnMowers;
    private boolean end;
    private boolean gameOver;
    private boolean paused;
    private int difficulty;
    private int totalPoint;
    private int[] zombieInRow;


    /**
     * constructor
     */
    public GameState(){

        plants=new ArrayList<>();
        zombies=new ArrayList<>();
        peas=new ArrayList<>();
        suns=new ArrayList<>();

        zombieInRow=new int[5];
        Arrays.fill(zombieInRow, 0);

        cards=new ArrayList<>(5);
        cards.add(new CardSunflower());
        cards.add(new CardPeaShooter());
        cards.add(new CardWallNut());
        cards.add(new CardFrPeaShooter());
        cards.add(new CardCherry());

        lawnMowers=new ArrayList<>(5);
        LawnMower lawnMower1=new LawnMower();
        LawnMower lawnMower2=new LawnMower();
        LawnMower lawnMower3=new LawnMower();
        LawnMower lawnMower4=new LawnMower();
        LawnMower lawnMower5=new LawnMower();

        lawnMower1.setY(140);
        lawnMower2.setY(250);
        lawnMower3.setY(360);
        lawnMower4.setY(480);
        lawnMower5.setY(600);

        lawnMowers.add(lawnMower1);
        lawnMowers.add(lawnMower2);
        lawnMowers.add(lawnMower3);
        lawnMowers.add(lawnMower4);
        lawnMowers.add(lawnMower5);

        end=false;
        gameOver=false;
        paused=false;
        totalPoint=50;

    }


    /**
     * getter of plants array
     * @return plants
     */
    public ArrayList<Plant> getPlants() {
        return plants;
    }

    /**
     * add plant
     * @param plant plant
     */
    public void addPlant(Plant plant){
        plants.add(plant);
    }

    /**
     * delete plant
     * @param plant plant
     */
    public void deletePlant(Plant plant){
        plants.remove(plant);
    }

    /**
     * getter of zombies array
     * @return zombies
     */
    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    /**
     * add zombie
     * @param zombie zombie
     */
    public void addZombie(Zombie zombie){
        zombies.add(zombie);
    }

    /**
     * delete zombie
     * @param zombie zombie
     */
    public void deleteZombie(Zombie zombie){
        zombies.remove(zombie);
    }

    /**
     * getter of peas
     * @return peas
     */
    public ArrayList<Pea> getPeas() {
        return peas;
    }

    /**
     * add pea
     * @param pea pea
     */
    public void addPea(Pea pea){
        peas.add(pea);
    }

    /**
     * delete pea
     * @param pea pea
     */
    public void deletePea(Pea pea){
        peas.remove(pea);
    }

    /**
     * getter of suns
     * @return suns
     */
    public ArrayList<Sun> getSuns() {
        return suns;
    }

    /**
     * add sun
     * @param sun sun
     */
    public void addSun(Sun sun){
        suns.add(sun);
    }

    /**
     * delete sun
     * @param i index number of suns array
     */
    public void deleteSun(int i){
        suns.remove(i);
    }

    /**
     * check whether game is over or not
     * @return true if game is over,and false if not
     */
    public boolean isEnd() {
        return end;
    }

    /**
     * set the end true
     * @param end end
     */
    public void setEnd(boolean end) {
        this.end=end;
    }

    /**
     * @return true if game over and false if not
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * setter of game over
     * @param gameOver use it to set true the field
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * getter of paused
     * @return true if paused and false if not
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * setter of paused
     * @param paused paused
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * getter of total sun achieved by user
     * @return total sun
     */
    public int getTotalPoint() {
        return totalPoint;
    }

    /**
     * increase point
     * @param point point
     */
    public void increasePoint(int point) {
        totalPoint=totalPoint+point;
    }

    /**
     * decrease point
     * @param point point
     */
    public void decreasePoint(int point){
        totalPoint=totalPoint-point;
    }

    /**
     * getter of zombie in row
     * @return ZombieInRow
     */
    public int[] getZombieInRow() {
        return zombieInRow;
    }

    /**
     * set that is there any zombie at that specific row or not
     * @param row row , range from 0 to 4
     * @param zombieIn if true we have zombie in that row , if false we don't have
     */
    public void setZombieInRow(int row, int zombieIn) {
        zombieInRow[row]=zombieIn;
    }

    /**
     * getter of cards
     * @return cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }


    /**
     * getter of lawnmowers array
     * @return lawnmowers array
     */
    public ArrayList<LawnMower> getLawnMowers() {
        return lawnMowers;
    }

    /**
     * getter of difficulty
     * @return difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * setter of difficulty
     * @param difficulty difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
