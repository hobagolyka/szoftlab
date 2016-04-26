@Echo off
set path="C:\Program Files (x86)\Java\jdk1.8.0_91\bin";
javac src/*.java
java src/Maze < tesztesetek/init.txt
pause
