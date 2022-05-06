package ie.tudublin;

import C17315223.JackVisual;


public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new JackVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}