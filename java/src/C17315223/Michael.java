package C17315223;


import processing.core.PApplet;

public class Michael {
    
  float angle = 0;
  float c;

    public void drawCircle(JackVisual z) {       // Draws Circles
    
        z.calculateAverageAmplitude();  
        float circle = (1000 * z.getSmoothedAmplitude());   
        z.stroke(z.random(0,255),255,255);        
        z.strokeWeight(5);
        z.noFill();
        z.ellipse(z.width / 2, z.height / 2, 1000 + (z.lerpedAverage * 300), 1000 + (z.lerpedAverage * 300) + circle);
        z.ellipse(z.width / 2, z.height / 2, 800 + (z.lerpedAverage * 300), 800 + (z.lerpedAverage * 300) + circle); 
        z.ellipse(z.width / 2, z.height / 2, 600 + (z.lerpedAverage * 300), 600 + (z.lerpedAverage * 300) + circle); 
        z.ellipse(z.width / 2, z.height / 2, 400 + (z.lerpedAverage * 300), 400 + (z.lerpedAverage * 300) + circle); 
    }

    float theta = 0;    // Starting angle

    void setup(float size, JackVisual z) {
    z.size(400, 300);
    }

    void draw(float sin,JackVisual z) {
    z.background(255);

    theta += 0.02;    // Increases theta 
    z.noStroke();
    z.fill(0);
    float angle = theta;

    
    for (int a = 0; a <= z.width; a += 10) {                  // Draws points along the sin wave
        float y = hue(sin(angle), -1, 1, 0, z.height);    // Calculates float y 
        z.ellipse(a, y, 16, 16);                                // Draws ellipse
        angle += 0.1;                                           // Increases angle
    }
    }

    private float hue(int sin, int i, int j, int k, int height) {
        return 0;
    }

    private int sin(float angle) {
        return 0;
    }

    public void drawSpiral(JackVisual z)       // Draws spiral in the middle that expands with music volume
    {
        // z.background(0);
        z.stroke(255);
        // z.colorMode(PApplet.HSB);
        z.camera();
        float average = 0;
        float sum = 0;
        float transAverage = 0;

    for (int i = 0; i < z.getAudioBuffer().size(); i++) {       // Calculating the average of the buffer
        sum += PApplet.abs(z.getAudioBuffer().get(i));
    }
    average = sum / z.getAudioBuffer().size();
    transAverage = PApplet.lerp(transAverage, average, 0.8f);   // Moves closer to frame

    float r = 1f;
    int points = 3;
    float thetaPog = PApplet.PI / (float) points;
    z.strokeWeight(2);
    float lastA = z.width / 2, lastB = z.height / 2;

    for (int i = 0; i < 500; i++) {                         // Thickness of strokes
        float s = PApplet.map(i, 0, 100, 0, 150) % 150f;
        z.stroke(s, 255, 255, 155);
        float theta = i * (thetaPog + transAverage * 2);
        float a = z.width / 2 + PApplet.sin(theta) * r;
        float b = z.height / 2 - PApplet.cos(theta) * r;
        r += 0.6f + transAverage;
        z.line(lastA, lastB, a, b);
        lastA = a;
        lastB = b;
    }
    drawCircle(z);
    }

    public void render(JackVisual z)     // Reads drawings to the screen
    {
        drawSpiral(z);
    }
}
