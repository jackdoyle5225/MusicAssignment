package ie.tudublin;

import C17315223.JackVisual;

import C17315223.Project;


public class Main
{	

	public void startUI()
	{
		// uncomment the line that corresponds to the sketch you want to run
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new JackVisual());
		// processing.core.PApplet.runSketch( a, new Project());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}