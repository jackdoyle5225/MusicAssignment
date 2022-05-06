package C17315223;

import ie.tudublin.*;

public class JackVisual extends Visual {

    int border = 0;
    Project p;
    public int noWalls = 400;
    public Wall[] walls;

    public void settings() {
       fullScreen(P3D);
    }
   
    public void setup() {
        colorMode(RGB);

        startMinim();
        loadAudio("visions.mp3");
        getAudioPlayer();

        background(0);

        walls = new Wall[noWalls];
        //creates walls for each side
        for(int i = 0; i < noWalls; i+=4) {
            walls[i] = new Wall(0f, height/2, 10f, height, p );
        }

        for(int i = 1; i < noWalls; i+=4) {
            walls[i] = new Wall(width, height/2, 10f, height, p);
        }

        for(int i = 2; i < noWalls; i+=4) {
            walls[i] = new Wall(width/2, height, width, 10f, p);
        }

        for(int i = 3; i < noWalls; i+=4) {
            walls[i] = new Wall(width/2, 0f, width, 10f, p);
        }
        getAudioPlayer().cue(0);
        getAudioPlayer().play();
    }
   
    public void draw() {
        background(0);
        try {
            calculateFFT(); 
        }
        catch(VisualException e) {
            e.printStackTrace();
        }
        //display walls
        for(int i = 0; i < noWalls; i++) {
            walls[i].display(this);
        }
        
        calculateFrequencyBands();
        calculateAverageAmplitude();
        //display spotlight effect
        float dist = -25;
        float heightMult = 2;
        float previousBandValue = getSmoothedAmplitude()*1000;

        for(int i = 1; i < getFrameSize(); i++) {

            float bandValue = getSmoothedAmplitude()*(1 + (i*15));

            stroke(100 + getSmoothedBands()[0],100 + getSmoothedBands()[8],100 + getSmoothedBands()[4],255 - i);
            strokeWeight(2 + (getSmoothedAmplitude()/10));

            line(0, height-(previousBandValue*heightMult), dist*(i-1), 0, height-(bandValue*heightMult), dist*i);
            line((previousBandValue*heightMult), height, dist*(i-1), (bandValue*heightMult), height, dist*i);
            line(0, height-(previousBandValue*heightMult), dist*(i-1), (bandValue*heightMult), height, dist*i);

            line(0, (previousBandValue*heightMult), dist*(i-1), 0, (bandValue*heightMult), dist*i);
            line((previousBandValue*heightMult), 0, dist*(i-1), (bandValue*heightMult), 0, dist*i);
            line(0, (previousBandValue*heightMult), dist*(i-1), (bandValue*heightMult), 0, dist*i);

            line(width, height-(previousBandValue*heightMult), dist*(i-1), width, height-(bandValue*heightMult), dist*i);
            line(width-(previousBandValue*heightMult), height, dist*(i-1), width-(bandValue*heightMult), height, dist*i);
            line(width, height-(previousBandValue*heightMult), dist*(i-1), width-(bandValue*heightMult), height, dist*i);

            line(width, (previousBandValue*heightMult), dist*(i-1), width, (bandValue*heightMult), dist*i);
            line(width-(previousBandValue*heightMult), 0, dist*(i-1), width-(bandValue*heightMult), 0, dist*i);
            line(width, (previousBandValue*heightMult), dist*(i-1), width-(bandValue*heightMult), 0, dist*i);
    

            previousBandValue = bandValue;
        }
    }
}