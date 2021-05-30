package PvsZ.Controller;

import PvsZ.Entity.Bullets.FrozenPea;
import PvsZ.Entity.Bullets.NormalPea;
import PvsZ.Entity.Bullets.Pea;
import PvsZ.Entity.GameState;
import PvsZ.Entity.Plants.*;
import PvsZ.Entity.Sound.Sound;
import PvsZ.Entity.Sun.Sun;
import PvsZ.Entity.Zombies.*;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ListIterator;
import java.util.Random;


/**
 * GameEngine class produce the elements of PlantVsZombies game
 * it will manage all of them from creating it , moving it and shooting it to removing it.
 *
 *
 *
 * @author sara lahourpour
 * @since 1/31/2021
 * @version 0.0
 *
 */
public class GameEngine {

    private MainController mainController;
    private GameState gameState;

    private ListIterator<Plant> itrPlant;
    private ListIterator<Pea> itrPea;
    private ListIterator<Sun> itrSun;
    private ListIterator<Zombie> itrZombie;

    private MouseHandler mouseHandler;
    private Sound sound;

    private long createTime;
    private long now;

    private boolean addedSunJustOnce;

    private int xMouse, yMouse;
    private int xShrink, yShrink;
    private int xExact, yExact;

    // 0--> sunflower
    // 1--> peashooter
    // 2--> giantWall-nut
    // 3--> frozenPeashooter
    // 4--> cherry bomb
    private int selectedCard;

    private boolean clickedOnCard;
    private boolean clickedOnYard;
    private boolean clickedOnShovel;

    private boolean createdZombieInFirstWaveOnce;
    private boolean createdZombieInSecondWaveOnce;
    private boolean createdZombieInFinalWaveOnce;

    private boolean gateIsOpen;
    private int numOfGettingIntoGate;

    private int counterOuterWhile;
    private int counterInnerWhile;

    private int i;
    private int j;

    /**
     * constructor
     *
     *
     */
    public GameEngine(){

        mouseHandler=new MouseHandler();
        createTime=System.currentTimeMillis()/1000;
        addedSunJustOnce=false;

        selectedCard=-1;

        xMouse=yMouse=-1;
        xShrink=yShrink=-1;
        xExact=yExact=-1;
        clickedOnCard=clickedOnYard=clickedOnShovel=false;
        createdZombieInFirstWaveOnce=createdZombieInSecondWaveOnce=createdZombieInFinalWaveOnce=false;
        gateIsOpen=false;
        numOfGettingIntoGate=0;

        counterOuterWhile=0;
        counterInnerWhile=0;

        i=0;
        j=0;
        sound=new Sound();
        sound.setSong("res/Sounds/background.wav");
        sound.run();

    }


    /**
     * update the state of all elements
     *
     */
    public void update(GameState gameState){

        this.gameState=gameState;
        updatePlants();
        updatePeas();
        updateSuns();
        updateZombies();
        checkEnd();

    }

    /**
     * update the plants
     * from planting it to shoveling it
     *
     */
    private void updatePlants(){


        //planting
        if (clickedOnCard && clickedOnYard){

            Plant plant;
            if (gameState.getCards().get(selectedCard).isEnable()) {
                if (selectedCard == 0) {
                    plant = new Sunflower(xExact + 20, yExact);
//                gameState.getCards().get(0).setClickedOnCard(true);
                } else if (selectedCard == 1) {
                    plant = new Peashooter(xExact + 20, yExact);
//                gameState.getCards().get(1).setClickedOnCard(true);
                } else if (selectedCard == 2) {
                    plant = new GiantWall_nut(xExact + 20, yExact);
//                gameState.getCards().get(2).setClickedOnCard(true);
                } else if (selectedCard == 3) {
                    plant = new FrozenPeashooter(xExact + 20, yExact);
//                gameState.getCards().get(3).setClickedOnCard(true);
                } else {
                    plant = new CherryBomb(xExact + 20, yExact);
//                gameState.getCards().get(4).setClickedOnCard(true);
                }

                if (gameState.getTotalPoint() - plant.getSunRequired() >= 0) {
                    gameState.getCards().get(selectedCard).setClickedOnCard(true);
                    gameState.addPlant(plant);
                    gameState.decreasePoint(plant.getSunRequired());
                }

                clickedOnCard = clickedOnYard = false;
            }


        }


        itrPlant=gameState.getPlants().listIterator();

        //shoveling
        if (clickedOnShovel && clickedOnYard){

            while (itrPlant.hasNext()){
                Plant plant=itrPlant.next();
                if (plant.getX()<=xMouse && xMouse<=plant.getX()+plant.getLength()){
                    if (plant.getY()<=yMouse && yMouse<=plant.getY()+plant.getWidth()){
                        itrPlant.remove();
                        clickedOnShovel=clickedOnYard=true;
                    }
                }
            }

//            for (int i=0; i<gameState.getPlants().size() ;i++){
//                if (gameState.getPlants().get(i).getX()==xMouse && gameState.getPlants().get(i).getY()==yMouse){
//                    plant=gameState.getPlants().get(i);
//                    gameState.deletePlant(plant);
//                    clickedOnShovel=clickedOnYard=false;
//                    break;
//                }
//            }
        }


//        System.out.println("is in updatePlants");




    }

    /**
     * update the peas
     * from creating it to removing it by getting to the end of the row (just in one case if it won't any catch zombie)
     *
     */
    private void updatePeas(){

        //creating pea
//        itrPlant=gameState.getPlants().listIterator();
        for (int i=0 ; i< gameState.getPlants().size() ; i++){
            if (gameState.getPlants().get(i) instanceof Peashooter){
                Peashooter peashooter=(Peashooter) gameState.getPlants().get(i);
//                System.out.println("ZombieInRow : [ "+((peashooter.getY()-120)/120)+" ]");
//                System.out.println("in first if");
                if ( gameState.getZombieInRow()[(peashooter.getY()-60)/120] >0){
//                    j++;
//                    if (j==1) {
//                        peashooter.setFirstTimeShoot();
//                    }
                    if (peashooter.isTimeToShoot()) {
                        NormalPea normalPea = new NormalPea(peashooter.getX()+50, peashooter.getY() );
                        gameState.getPeas().add(normalPea);
//                        System.out.println("in second if");
//                        System.out.println("created NormalPea");
                    }
                }
            }
            else if (gameState.getPlants().get(i) instanceof FrozenPeashooter){
                FrozenPeashooter frozenPeashooter=(FrozenPeashooter) gameState.getPlants().get(i);

//                System.out.println("ZombieInRow : [ "+((frozenPeashooter.getY()-120)/120)+" ]");
                if (gameState.getZombieInRow()[(frozenPeashooter.getY()-60)/120]>0){

                    if (frozenPeashooter.isTimeToShoot()) {

                        FrozenPea frozenPea = new FrozenPea(frozenPeashooter.getX()+50, frozenPeashooter.getY());
                        gameState.addPea(frozenPea);
                        System.out.println("created FrozenPea");
                    }

                }
            }
        }


        //removing peas by getting to the end of the row
        itrPea=gameState.getPeas().listIterator();
        while (itrPea.hasNext()){
            Pea pea=itrPea.next();
            if (pea.getX()==1280){
                itrPea.remove();
            }
        }


//        System.out.println("is in updatePeas");

    }

    /**
     * update suns
     * from creating it ,and moving it to removing it.
     * collecting the sun handled in {@link #isClickedOnSun()}.
     *
     */
    private void updateSuns(){



        //creating sun

        //sun from sunflower
        for (int i = 0; i < gameState.getPlants().size(); i++) {
            if (gameState.getPlants().get(i) instanceof Sunflower){
                Sunflower sunflower=(Sunflower) gameState.getPlants().get(i);
                if (sunflower.canCreateSun()){
                    Sun sun=new Sun(true);
                    sun.setX(sunflower.getX());
                    sun.setY(sunflower.getY());
                    gameState.addSun(sun);
                }
            }
        }

        //sun from panel
        //FIXME : why it create suns so soon?, and why it creates them more than one? Done
        now=System.currentTimeMillis()/1000;

        if (!((now-createTime)%25==0)){
            addedSunJustOnce=false;
        }

        if ((now-createTime)%25==0 &&  !(now==createTime) && !addedSunJustOnce){
            Sun sun=new Sun(false);
            gameState.addSun(sun);

            addedSunJustOnce=true;

//            System.out.println("at game Engine UpdateSuns bugged method ----> added one sun");
        }


//        if (createTime==now)
//            System.out.println("same "+(now-createTime));
//        else
//            System.out.println("not same "+(now-createTime));


        itrSun=gameState.getSuns().listIterator();
        //moving sun
        //check whether it is the proper time that sun get disappeared or not
        while (itrSun.hasNext()){
            Sun sun=itrSun.next();
            if (!sun.isFromSunflower()){
                if (!sun.isStopped()){
                    sun.move();
                }else{
//                    System.out.println("wants to check remove sun");
                    if (!sun.stillExist()){
                        itrSun.remove();
//                        System.out.println("removed sun");
                    }
                }
            }else {
                if (!sun.stillExist()){
                    itrSun.remove();
                }
            }
        }


        //collecting sun had been handled in isClickedOnSun() method

//        System.out.println("is in updateSuns");



    }

    /**
     * set the first wave of zombies
     *
     */
    private void inFirstWave(){


        if (!((now-createTime)%30==0)){
            createdZombieInFirstWaveOnce=false;
        }


//        System.out.println(" in first wave , before creating "+(now-createTime));
        if ((now-createTime)%30==0 &&  !createdZombieInFirstWaveOnce && !(now==createTime)){
            //!createdZombieInFirstWaveOnce &&
            Zombie zombie=new NormalZombie();
            gameState.getZombies().add(zombie);
            gameState.getZombieInRow()[(zombie.getY()-60)/120]++;
            createdZombieInFirstWaveOnce=true;
//            i++;
//            if (i==1){
//                sound.setSong("res/Sounds/zombies_coming.wav");
//                sound.run();
//            }
        }


    }

    /**
     * set the second wave of zombies
     *
     */
    private void inSecondWave(){

        if (!((now-createTime)%30==0)){
            createdZombieInSecondWaveOnce=false;
        }

//        System.out.println(" in second wave , before creating "+(now-createTime));


        if ((now-createTime)%30==0 && !createdZombieInSecondWaveOnce && !(now==createTime)){
            Zombie zombie1=new NormalZombie();
            gameState.getZombies().add(zombie1);

            Zombie zombie2=new ConeHeadZombie();
            gameState.getZombies().add(zombie2);

//            gameState.getZombieInRow()[(zombie1.getY()-120)/120]=true;
            gameState.getZombieInRow()[(zombie1.getY()-60)/120]++;

            gameState.getZombieInRow()[(zombie2.getY()-60)/120]++;

            createdZombieInSecondWaveOnce=true;
//            System.out.println("created zombie in first wave");

        }


    }

    /**
     * set the final wave of zombies
     *
     */
    private void inFinalWave(){

        if (!((now-createTime)%30==0)){
            createdZombieInFinalWaveOnce=false;
        }

//        System.out.println(" in final wave , before creating "+(now-createTime));


        if ((now-createTime)%25==0 && !createdZombieInFinalWaveOnce && !(now==createTime)){
            Zombie zombie1=new FlagZombie();
            gameState.getZombies().add(zombie1);

            Zombie zombie2=new BucketHeadZombie();
            gameState.getZombies().add(zombie2);

            gameState.getZombieInRow()[(zombie1.getY()-60)/120]++;
            gameState.getZombieInRow()[(zombie2.getY()-60)/120]++;

            createdZombieInFinalWaveOnce=true;
        }

    }


    /**
     * update zombies
     * from creating it , eating plants ,and moving it to removing it.
     */
    private void updateZombies(){

        now=System.currentTimeMillis()/1000;

        //creating zombies
        if ((now-createTime)<=150){
            inFirstWave();
        }else if ((now-createTime)<=330){
            inSecondWave();
        }else if ((now-createTime)<=480){
            inFinalWave();
        }



        //moving zombies
        itrZombie=gameState.getZombies().listIterator();
        while (itrZombie.hasNext()){
            Zombie zombie=itrZombie.next();
            if (!zombie.isEating()){
                zombie.move();
            }
        }


        //eating plants
        //removing eating plants
        //deciding zombie should move or stop
        itrZombie=gameState.getZombies().listIterator();
        itrPlant=gameState.getPlants().listIterator();

        numOfGettingIntoGate++;

        if (numOfGettingIntoGate%2==0){
            gateIsOpen=true;
        }


        if (gateIsOpen) {
            while (itrZombie.hasNext()) {
                Zombie zombie = itrZombie.next();
//                counterOuterWhile++;
//                System.out.println("outer while: "+counterOuterWhile);
                while (itrPlant.hasNext()) {
                    Plant plant = itrPlant.next();
//                    System.out.println("zombie y : "+zombie.getY() + "zombie row : "+((zombie.getY() - 60) / 120));

//                    counterInnerWhile++;
//                    System.out.println("inner while: "+counterInnerWhile);

                    //int type=0;
                    //
                    //if (zombie instanceof ConeHeadZombie){
                    //    type=1;
                    //}else if (zombie instanceof BucketHeadZombie){
                    //    type=2;
                    //}
                    //
//                    System.out.println("Zombie ---> "+"  x :"+zombie.getX()+"  y :"+zombie.getY());
//                    System.out.println("Plant ---> "+"  x :"+plant.getX()+"  y :"+plant.getY());

                    if (zombie.getX() <= Math.abs(plant.getX() + plant.getWidth() )&&
                            Math.abs(plant.getX() + plant.getWidth() )<= Math.abs(zombie.getX() + zombie.getWidth()) ) {

//                        System.out.println("x is ok in eating");
//                        System.out.println("zombie x :" + zombie.getX());
//                        System.out.println("plant x + width :" + (plant.getX() + plant.getWidth()));
//                        System.out.println(zombie.isEating());
//                          && plant.getY()>=zombie.getY()+zombie.getLength()
                        if (zombie.getY() <= plant.getY() && plant.getY()<=zombie.getY()+zombie.getLength()) {
//                            System.out.println("y is ok in eating");
                            zombie.setEating(true);
//                            System.out.println("in second if");
                            plant.reduceLife(zombie.getDamage());
//                            sound.setSong("res/Sounds/chomp.wav");
//                            sound.run();
                            if (plant.getLife() <= 0) {
//                                System.out.println("zombie finished the plant");
//                                System.out.println("in third if");
                                zombie.setEating(false);
                                itrPlant.remove();
                            }
                        }
                    }

                }
            }
            gateIsOpen=false;
        }


        //removing zombies by getting pea to them
        //removing peas by getting to zombies
        //handling the damage and speed of zombies
        itrPea=gameState.getPeas().listIterator();
        itrZombie=gameState.getZombies().listIterator();
        while (itrZombie.hasNext()) {
            Zombie zombie=itrZombie.next();

//            counterOuterWhile++;

            while (itrPea.hasNext()) {
                Pea pea = itrPea.next();

//                counterInnerWhile++;
//                System.out.println("inner while: "+counterInnerWhile);
//                System.out.println("before if to check peas and zombies");
//                System.out.println("Zombie ---> "+"  x :"+zombie.getX()+"  y :"+zombie.getY());
//                System.out.println("Pea ---> "+"  x :"+pea.getX()+"  y :"+pea.getY());

                if ( zombie.getY() <= pea.getY() && pea.getY() <= zombie.getY() + zombie.getLength() ) {
//                    System.out.println("moving pea");
//                    pea.move();
//                    System.out.println("y pea is ok");
                    if ( zombie.getX()<= Math.abs(pea.getX() +pea.getWidth()) && pea.getX() <=Math.abs(zombie.getX()+zombie.getWidth()) ) {
                        //&& pea.getX() <=zombie.getX()+zombie.getWidth()
//                        System.out.println("x pea is ok");
                        zombie.reduceLife(pea.getDamage());
//                        System.out.println("reduce zombie life");
                        if (pea instanceof FrozenPea) {
                            zombie.reduceSpeed();
                        }
                        if (zombie.getLife() <= 0) {
                            gameState.getZombieInRow()[(zombie.getY() - 60) / 120] --;
                            itrZombie.remove();
                        }
//                        System.out.println("removed pea");
                        itrPea.remove();
                    }else {
                        pea.move();
                    }

                }
                //FIXME done
                else {
//                    System.out.println("moving pea");
                    pea.move();

                }
            }
        }







//        System.out.println("is in updateZombies");

    }


    /**
     * check if the zombie get into the the house or not
     */
    private void checkEnd(){

        itrZombie=gameState.getZombies().listIterator();
        while (itrZombie.hasNext()){
            Zombie zombie=itrZombie.next();
            if (zombie.getX()<=0){
                System.out.println("game is end");
                gameState.setGameOver(true);
                sound.setSong("res/Sounds/atebrains.wav");
                sound.run();
            }
        }

        long now=System.currentTimeMillis()/1000;
        if ((now-createTime)>=480){
            gameState.setEnd(true);
        }

    }


    /**
     * convert the x and y coordinate of mouse to x,yShrink and x,yExact
     * xShrink range 0 to 8,
     * yShrink range 0 to 4,
     * x,yExact is in the middle of cell (used for plants and suns)
     *
     */
    private void inSmallerScale(){

        xShrink=(xMouse-50)/130;
        yShrink=(yMouse-120)/120;

        xExact=50+(xShrink*130);
        yExact=120+(yShrink*120);

    }


    /**
     * check whether the user clicked on shovel or not
     *
     */
    private void checkClickedOnShovel(){

        if (xMouse>=740 && xMouse<=856 && yMouse>= 30 && yMouse<=120){
            clickedOnShovel=true;
        }

    }


    /**
     * check whether the user clicked on card or not
     *
     */
    private void checkClickedOnCard() {

        if (xMouse>= 140 && xMouse<= 720 && yMouse>= 30 && yMouse<= 120){

            clickedOnCard=true;

            if (xMouse <= 256)
                selectedCard=0;
            else if (xMouse <= 372)
                selectedCard=1;
            else if (xMouse <= 488)
                selectedCard=2;
            else if (xMouse <= 604)
                selectedCard=3;
            else
                selectedCard=4;
        }

    }


    /**
     * check whether the user clicked on sun or not
     * @return true if clicked on it and false if not
     *
     */
    private boolean isClickedOnSun(){

        itrSun=gameState.getSuns().listIterator();

//        for (int i=0; i< gameState.getSuns().size() ; i++){
//            if (gameState.getSuns().get(i).getX()==xMouse && gameState.getSuns().get(i).getY()==yMouse){
//                gameState.increasePoint(gameState.getSuns().get(i).getBonus());
//                gameState.deleteSun(i);
//                System.out.println("clicked on sun");
//                return true;
//            }
//
//        }

        while (itrSun.hasNext()){
            Sun sun=itrSun.next();
            if (sun.getX()<=xMouse && xMouse<=sun.getX()+sun.getLength()){
                if (sun.getY()<=yMouse && yMouse<=sun.getY()+sun.getWidth()) {
                    gameState.increasePoint(sun.getBonus());
                    itrSun.remove();
//                    System.out.println("clicked on sun");
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * check whether the user clicked on yard or not
     *
     */
    private void checkClickedOnYard() {

        if ( yMouse>= 120 && yMouse<= 720 && xMouse>=140 && xMouse<=1280){
            clickedOnYard=true;
        }
    }

    private void checkClickedOnMenu(){

        if ( 1100<=xMouse && xMouse<=1270){
            if ( 20 <=yMouse && yMouse<=60 ){
                gameState.setPaused(true);
                mainController.showMenu();
            }
        }
    }

    /**
     * getter of mouse handler will be used in game frame
     * @return mouse handler
     */
    public MouseHandler getMouseHandler() {
        if (mouseHandler==null){
            return new MouseHandler();
        }else {
            return mouseHandler;
        }
    }


    /**
     * setter of main controller
     * @param mainController main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * event handling for mouse
     *
     */
    private class MouseHandler extends MouseAdapter{


        @Override
        public void mouseClicked(MouseEvent e) {

            xMouse=e.getX();
            yMouse=e.getY();

            inSmallerScale();
            checkClickedOnCard();
            checkClickedOnShovel();

            if (!isClickedOnSun()) {
                checkClickedOnYard();
            }

            checkClickedOnMenu();

        }

    }


}
