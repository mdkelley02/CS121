#Project 2: Jukebox Hero

* Author: Matthew Kelley
* Class: CS121 section 008
* Semester: Fall 2020

##Overview
JukeboxHero is a command line application that loads in lines from csv files that model a typical song. You can perform
a couple operations and search through your songs.

##Reflection

This was a fun program to develop, it covers a ton of concepts that I feel are integral for software development.
In the project we read through files, create a loop so that we can enter in multiple commands without shutting the
whole application down. We create a primitive search method for our class, we use the Song class which almost acts like
a model in web development.

something that screwed me up in the very beginning was using the .next() instead of .nextLine() for scanning over the
csv file. This set me back like 30 minutes as I was trying to use another array to split up the values of the csv file
and the array was out of index.

##Compiling and Using

In oder to use the software you must have a csv file that is in the src directory and has the format of
"artist,album,title,length"

To navigate the app you will input the respective letter of each feature into the command line.
First you must do "L", to load the song, from there you can perform operations on the songs loaded in.
Once you are finished you can press "Q" to exit.

##Sources Used
for all of the project I didn't use any sources aside from one. I used it to figure out how to sort the loaded songs into
only the unique ones and I did so using a Set and followed this documentation.
https://www.javacodeexamples.com/java-arraylist-get-unique-values-example/1006