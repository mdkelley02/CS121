# Project 4: Reader of Books

* Author: Matthew Kelley
* Class: CS121 Section 3
* Semester: Fall 2020

## Overview

The Reader of Books project is a GUI based
application for the Library of Books application created in Project 3.
It loads each books via a csv into a Book object which we can then use
to create a button which represents it. Upon pressing the button it will
load the content of that respective book into another panel.

## Reflection

Always cool to be able to have a tangible front-end to the logic behind
your code. swing is pretty cut and dry. You have one frame that you add
all of your panels to, each panel is comprised of componets, its a nice way
divide all your componets and easily add them to the application. It sort of
acts like a <div> in HTML.

I really ran into no issues creating the project other than when I finally got
to updating the ReaderPanel from the BookButton. This was odd to me as the button
itself was manipulating the data of an object inside of another class in another file.
Ultimately I ended up solving the issue by passing the ActionListener
from the ReaderOfBooksPanel to the LibraryPanel as a parameter, from there
once I was inside the panel I simply added the ActionListener to my fields and
passed it into my BookButton.

## Compiling and Using

Once you start the application, all you must do is enter in the filepath
of the CSV, this could either be "/etext/booklist.csv" or "/etext/booklist-full.csv"
this will then load the book buttons, from there you may click on them to
load the content of the book into the pane.

## Sources used

I used no outside sources other than looking at how the GUIs work
inside of previous projects that we had done throughout the course.


