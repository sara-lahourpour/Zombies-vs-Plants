package PvsZ.Entity.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


/**
 * Sound class represents the audio part of PlantVsZombies game
 * and it will handle the way should read the audio files especially
 * .wav files
 * also it will implementing the thread class to having
 * the GameFrame and Sound at almost same time
 *
 *
 *
 * @author saralahourpour
 * @since 2/3/2021
 * @version 0.0
 *
 */
public class Sound implements Runnable{


    //number of times that music get played
    private int i;

    private final int BUFFER_SIZE = 128000;
    private String songName;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;


    /**
     * constructor
     *
     */
    public Sound(){
        i=0;
    }

    /**
     * @param filename the name of the file that is going to be played
     */
    public void setSong(String filename){
        songName=filename;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        //this is just for harmony between the frame and sound
        i++;
        if (i==1)
            return;



        try {
            soundFile = new File(songName);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();


    }


}





