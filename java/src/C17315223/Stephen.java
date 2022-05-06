package C17315223;

import processing.core.*;


public class Stephen
{
    
    // draws the diamond 
    void drawDiamond(JackVisual z)
    {
        z.calculateAverageAmplitude();
        float diamond = 10 + ((z.getSmoothedBands()[0])/1.5f); 
        z.stroke(z.random(0,255),255,255);
        z.pushMatrix();
        z.fill(0);
        z.strokeWeight(3);
        z.beginShape();
        z.vertex(z.width / 2, z.height / 2 + diamond *2);
        //vertex(width / 2 + 10, height / 2 + 10);
        z.vertex(z.width / 2 + diamond, z.height / 2 );
        // vertex(width / 2 + 10, height / 2  - 10);
        z.vertex(z.width / 2, z.height /2 - diamond*2);
        //vertex(width / 2 - 10, height / 2 - 10);
        z.vertex(z.width / 2 - diamond , z.height / 2 );
        z.vertex(z.width /2, z.height /2 + diamond*2);
        //vertex(width /2 - 10, height /2 + 10);
        z.endShape();
        z.beginShape();
        z.vertex(z.width / 2, z.height / 2 + diamond * 2);
        // vertex(width / 2 + 10, height / 2 + 10);
        z.vertex(z.width / 2 + diamond * 2, z.height / 2);
        // vertex(width / 2 + 10, height / 2 - 10);
        z.vertex(z.width / 2, z.height / 2 - diamond * 2);
        // vertex(width / 2 - 10, height / 2 - 10);
        z.vertex(z.width / 2 - diamond * 2, z.height / 2);
        z.vertex(z.width / 2, z.height / 2 + diamond * 2);
        // vertex(width /2 - 10, height /2 + 10);
        z.endShape();
        z.popMatrix();
    }


    // Lines connecting to diamond in the middle will close and expand to music.
    void drawTunnel(JackVisual z)
    {
        z.pushMatrix();
        z.fill(0);
        z.beginShape();
        float diamond = 10 + ((z.getSmoothedBands()[0])/1.5f);
        z.stroke(z.random(0,255),255,255);
        z.strokeWeight(3);
        z.line(0, 0, z.width / 2 - diamond, z.height / 2 - diamond);
        z.line(0, z.height, z.width / 2 - diamond, z.height / 2 + diamond);
        z.line(z.width, z.height, z.width / 2 + diamond, z.height / 2 + diamond);
        z.line(z.width, 0, z.width / 2 + diamond, z.height / 2 - diamond);
        z.endShape();
        z.popMatrix();
    }


    // Cube rotating around diamond - will pulse to the music.
    void drawCube(JackVisual z){
        z.calculateAverageAmplitude();
       z.stroke(100 + z.getSmoothedBands()[6],100 + z.getSmoothedBands()[7],100 + z.getSmoothedBands()[6]);
        z.strokeWeight(5);
        z.noFill();
        z.lights();
        z.pushMatrix();
        //
        z.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        z.translate(0, 0, -200);
        z.rotateX(angle);
        z.rotateZ(angle);       
        float boxSize = 50 + (200 * z.getSmoothedAmplitude()); 
        z.box(boxSize);   
        z.popMatrix();
        angle += z.getSmoothedBands()[6]/3000;
        
    }
    

    void drawBorder(JackVisual z)
    {
        this.z = z;
        cy = this.z.height / 10;
        
        z.colorMode(PApplet.HSB);
        for(int i = 0 ; i < z.getAudioBuffer().size() ; i ++)
        {
            z.pushMatrix();
            
            z.strokeWeight(1);
            z.stroke(PApplet.map(i, 0, z.getAudioBuffer().size(), 0, 255), 255, 255);

            
            z.rect(0, 0, z.width, cy * z.getAudioBuffer().get(i)); // Top of screen
            z.rect(0, z.height - z.border, z.width, cy * z.getAudioBuffer().get(i)); // Bottom of screen

            z.popMatrix();
        }
    }

    
    // rending all of the drawings to the screen
    public void render(JackVisual z)
    {
        z.background(0);  

        drawDiamond(z);

        drawTunnel(z);

        drawCube(z);

        drawBorder(z);


    }
    // For the rotation of the cube
    float lerpedAverage = 0;
    float angle = 0;
    JackVisual z;
    float cy = 0;
    
}