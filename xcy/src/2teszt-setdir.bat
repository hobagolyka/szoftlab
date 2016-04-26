@Echo off
set path="C:\Program Files (x86)\Java\jdk1.8.0_91\bin";
javac Maze.java
java Maze < tesztesetek/setdir.txt
pause