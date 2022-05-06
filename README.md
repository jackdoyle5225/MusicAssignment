# Music Visualiser Project

Name:
	Jack Doyle
	Stephen Hughes
	Michael Farrell

Student Number: 
	C17315223	(Jack)
	D21126653	(Stephen)
	D21126674	(Michael)

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
In our assignment we decided that it would be best for us to work on our own individual visuals using Processing. The general theme throughout each visual is that they are all connecting to the amplitude / Frequencies of the music causing it to pulse, spin etc. The music is also interacting with the lighting and colours of the drawings. The main visual is a combination of our work and will be the one included in the video.

# Instructions
In our project we decided that it would be best to label the file as our names and have each class separate for the purposes of editing code.
We intended to have a switch statement that allowed us to switch between each visual as well as 


Case 1 - Combo

Case 2 - Stephen
My file starts with the middle of the screen being the diamond that I drew using vertex mapping while setting the shape to have getSmoothAmplitude. The diamond shape will pulsate to music.

I then introduced a tunnel effect drawing lines to the center of the shape; however, by adding the diamond value from the previous section it was connecting to the edges of the diamond, causing the lines to also decrease and expand to the amplitude of the song.

I introduced a rotating cube to add some dimension to the shape and also to give the cube surrounding the diamond shape - this was achieved using box and boxsize.

Finally, I had a border effect that was similar to the waveform, but instead I had it expand from the top and bottom of the screen using height and width.
# How it works

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

