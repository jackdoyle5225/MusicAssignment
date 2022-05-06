package C17315223;

import ie.tudublin.*;

public class Project extends Visual{

    public void settings()
    {
        fullScreen(P3D);
    }

    int lerpedAverage;
    int mode = 1;
    int border = 0;
    boolean paused = false;

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
            case '4':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                break;
            }
        }
    }

    public void setup()
    {
        colorMode(RGB);

        startMinim();
        loadAudio("visions.mp3");
        getAudioPlayer();

        background(0);
    }

    Stephen s = new Stephen();
    Michael m = new Michael();
    JackVisual j = new JackVisual();
    //michael

    public void draw()
    {
        switch(mode)
        {
            case 1:
            {

            }
            
            case 2:
            {  
                // s.render(this);
                // break;
            }

            case 3: 
            {
                break;
            }

            case 4: 
            {
                // m.render(this);
                // break;
            }
        }
    }

}
