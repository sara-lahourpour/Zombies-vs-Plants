package PvsZ.Controller;

import PvsZ.Boundary.GameFrame;
import PvsZ.Entity.GameState;
import PvsZ.Entity.Sound.Sound;
import PvsZ.Entity.ThreadPool;


/**
 * A very simple structure for the main game loop.
 * THIS IS NOT PERFECT, but works for most situations.
 * Note that to make this work, none of the 2 methods
 * in the while loop (update() and render()) should be
 * long running! Both must execute very quickly, without
 * any waiting and blocking!
 *
 * Detailed discussion on different game loop design
 * patterns is available in the following link:
 *    http://gameprogrammingpatterns.com/game-loop.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameLoop implements Runnable {

    /**
     * Frame Per Second.
     * Higher is better, but any value above 24 is fine.
     */
    public static final int FPS = 30;

    private Sound sound;
    private GameFrame canvas;
    private GameState state;
    private GameEngine gameEngine;
    private MainController mainController;

    public GameLoop(GameFrame frame) {
        canvas = frame;
    }

    /**
     * This must be called before the game loop starts.
     */
    public void init() {
        state = new GameState();
        gameEngine=new GameEngine();
        canvas.addMouseListener(gameEngine.getMouseHandler());
        sound=new Sound();
    }

    @Override
    public void run() {
//        boolean gameOver = false;
        while (!state.isEnd() && !state.isGameOver()) {
            try {

                long start = System.currentTimeMillis();

                gameEngine.update(state);
                canvas.render(state);
                //gameOver = state.gameOver;
                sound.setSong("res/Sounds/menu.wav");

//                sound.run();

                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0)
                    Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        canvas.render(state);
    }


    /**
     * setter of main controller
     * @param mainController main controller
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
        gameEngine.setMainController(mainController);

    }

    public GameState getState() {
        return state;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

}

