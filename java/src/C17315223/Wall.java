package C17315223;

import processing.core.*;

public class Wall extends PApplet {

    float startingZ = -10000;
    float maxZ = 50;
    
    float x, y, z;
    float sizeX, sizeY;
    Project v;

    Wall(float x, float y, float sizeX, float sizeY, Project v) {
        this.x = x;
        this.y = y;
        this.z = random(startingZ, maxZ);

        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.v = v;
    }

    void display(JackVisual v) {

        v.fill(100 + v.getSmoothedBands()[0],100 + v.getSmoothedBands()[8],100 + v.getSmoothedBands()[4],20);
        v.noStroke();

        v.pushMatrix();

        v.translate(x, y, z);

        v.scale(sizeX*(v.getAudioBuffer().size()/600), sizeY*(v.getAudioBuffer().size()/400), 20);

        v.box(1);
        v.popMatrix();

        v.fill(100 + v.getSmoothedBands()[0],100 + v.getSmoothedBands()[8],100 + v.getSmoothedBands()[4],20);
        v.noStroke();

        v.pushMatrix();

        v.translate(x, y, z);

        v.scale(sizeX, sizeY, 10);

        v.box(1);
        v.popMatrix();

        z +=  (v.getSmoothedBands()[4])/3;
        if (z >= maxZ) {
            z = startingZ;  
        }
    }
}
