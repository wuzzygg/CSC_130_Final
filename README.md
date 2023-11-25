# Data Structures & Algorithm Analysis
## California State University, Sacramento

Welcome to my GitHub repository for "Data Structures & Algorithm Analysis," a course I am taking at California State University, Sacramento, under the instruction of Professor Matthew Phillips.

### Project Description
Throughout this course, we'll engage in a series of progressive checkpoints. These checkpoints are strategically designed to build our understanding and skills in data structures and algorithm analysis. Each checkpoint is an essential step toward the final project, which will serve as a comprehensive demonstration of the knowledge and abilities acquired. The final project is expected to be a culmination of the concepts and techniques practiced in these checkpoints.

### Checkpoint #1 Specifications
For Checkpoint #1, the requirements for this assignment are as follows:

- Place Persephone somewhere in the bottom right quadrant of the screen.
- Draw a text string consisting of your name below Persephone in a custom color of your choosing.

### Checkpoint #2 Specifications
For Checkpoint #2, the requirements for this assignment are as follows:

- Load your custom sprite (128 x 128) into the game engine using Art.txt.
- Ensure that the sprite appears when running the program.
- Implement the Vector2D class using the provided template.
- Load frames into the first Queue.
- Utilize a timer, two Vector2D queues, and your custom engine to make the image move from the left side of the screen to the right.
- Implement animation reset functionality: Once the image reaches the end of the animation, it should reset by transferring the second Queue back to the first.

### Checkpoint #3 Specifications
For Checkpoint #3, the requirements for this assignment are as follows:

- Load your custom sprites (128 x 128) into the game engine using Art.txt.
- Write the spriteInfo class using the template.
- Load frames (and coordinates) into the ArrayList in the start method.
- Create a cursor variable that holds the index of your current displayed frame (relative to your ArrayList) for easy frame updates.
- Utilize a timer, the ArrayList, and your custom engine to make the images move from the left side of the screen to the right.
- Implement animation reset functionality: Once the image reaches the end of the animation, reset by making the cursor index 0.

### Checkpoint #4 Specifications
For Checkpoint #4, the requirements for this assignment are as follows:

- Name your animated character from Checkpoint #3.
- Write five (5) lines of dialog for your character.
- Save dialog into a text file using Key-Value pairs as described in this module.
- Load the text file into the game engine in the start method.
- Load ALL dialog into a Java HashMap using a StringTokenizer to parse the lines into Key-Value pairs.
- Retrieve a single line of text from your HashMap using the "get" method from Java's HashMap class.
- Display the retrieved dialog using the Gaming API "drawString" method at location 100x, 250y.