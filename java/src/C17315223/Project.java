package C17315223;

import ddf.minim.*;
import ddf.minim.analysis.FFT;
import ie.tudublin.*;


public class Project extends JackVisual{

    public void settings()
    {
        fullScreen(P3D);
    }

    int lerpedAverage;
    int mode = 1;
    int border = 0;
    boolean paused = false;

    Stephen s = new Stephen();
    Michael m = new Michael();
    JackVisual j = new JackVisual();

    public void keyPressed()
    {
        if (key >= '0' && key <= '4')
        {
        mode = key - '0';
    }

        switch(key)
        {
            case ' ':
            {
                if(paused)
                {
                    getAudioPlayer().play();
                    paused = false;
                }

                else
                {
                    getAudioPlayer().pause();
                    paused = true;
                }
                break;
            }

            case '1':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }

            case '2':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }

            case '3':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }
        }
    }

    public void setup()
    {
        colorMode(HSB);
        frameRate(60);

        startMinim();
        loadAudio("visions.mp3");
        getAudioPlayer();
        background(0);

        try {
            calculateFFT(); 
        }
        catch(VisualException e) {
            e.printStackTrace();
        }
    }

    public void draw()
    {
        background(0);
        switch(mode)
        {
            case 1:
            {
                m.render(this);
                break;
            }
            
            case 2:
            {  
                s.render(this);
                break;
            }

            case 3: 
            {
                break;
            }

        }
    }

}
