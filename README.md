# Let Me Out!
> Let me out is a room escape game built using Java Swing and IntellIJ. This game is playable on a computer screen and for the moment there is only the computer version. There are various interactions involved such as mouse clicks, hover, and dragging. The goal is to find the hidden items around the room and try to get out of it within the limited time.
>
![screenshot](https://user-images.githubusercontent.com/57294220/197063803-4c767754-2bdb-4dea-b80f-1b9cc7813b8c.jpg)

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Demo](#demo)
* [Setup](#setup)
* [Room for Improvement](#room-for-improvement)
* [Acknowledgements](#acknowledgements)
* [Contact](#contact)

## General Information
The purpose of this project is for the user to discover how to get out of the room while also solving the mystery of the character’s life. The game has a first person point of view and is composed of several static scenes of one room. The player can navigate through different angles of said room. He has to find clues in order to get out as fast as possible. Users can gain and use special tools to interact with the objects in the scene.


## Technologies Used
- Java - Oracle JDK 17.0
- Java Swing Framework
- OS : No specific OS required, but tested on Linux(ubuntu) and Windows.

## Features
- Inventory : Register the found item, drag item from the Inventory to use
- Rooms: Different rooms hold different objects to be picked and to be interacted with
- Pickable Objects: Objects found within the room which can be picked and found in the inventory
- Interactive Items: Items within the room that if they are paired with the a picked object, they allow a new interaction and a new clue to be found

Item interactions:
- Basic interaction : Double Mouse Click to pick up objects in the game.
- Light up the switch : Hovering in a darkroom with a transparent circle put in the cursor position, light switches on when clicked
- Newspaper : Hovering around the frame to find the hidden number
- UV Light : Dragging the flashlight tool, which activates the quarter of a circle, which if dragged to the right position in the room makes a number appear 
- Cleaning(Scratching) dust: Clean the dirty mirror to find the hint, dragging over the darker mirror continuously
- Zoom effect : Zoom item is dragged over the first room, zooming the image. Navigation is possible through the dragging of the image
- Interactive objects: active when clicked (Drawer, closet, pillow, box, painting)
- Safe: Button clicking gives the number clicked

## Demo

https://user-images.githubusercontent.com/57294220/197063993-7928243a-26c4-4c92-bb3f-635fb2d270bb.mp4


## Setup
- Excutable by [exe](https://drive.google.com/file/d/1Dvm0zhn8gVduu9IM_lYy6-zy4HmDYCvo/view?usp=sharing)
- [jar](https://drive.google.com/file/d/1uHIixfCcPp933_F9_r-hQQGEZ5Le-gM7/view?usp=sharing)
- Runnable on IntelliJ Main


## Room for Improvement
There are certain technical aspects which need improvement on. The zoom item works on every room, except that it always shows the zoom of first room, mostly because we designed it to only give a clue for one room. Also the pickable items open new frames instead of being added to the one main frame. That means that for example, the safe once it has been closed and reopened, the key inside is still there even if picked, because the frame gets restarted everytime. 


## Room for future implementations:
- Add story boarding
- Other active objects
- Add more levels and constrains such as timer

## Acknowledgements
- The navigation of the scrollPane by dragging was inspired by [here](https://stackoverflow.com/questions/10243257/java-scroll-image-by-mouse-dragging)

## Contact
Created by irudaa( jiin.lim@universite-paris-saclay.fr) & hibaslimani (hiba.slimani@university-paris-saclay.fr) - feel free to contact me!
