import java.io.*;
import java.io.IOException;
import java.io.File;
import java.net.URL;

public class Maze {

    private static boolean run = true;

    /**
     * Ez a függvény a main függvény, innen indul a játék
     */
    public static void main(String[] args) throws IOException
    {
        URL url = Maze.class.getResource("tesztek/setdirtest.txt");
        File file2 = new File(url.getPath());
        String fname = file2.toString();

            try {
                FileData file = new FileData();
                file.ReadFile(fname);
                String[] aryLines = file.OpenFile();

                int i;
                for ( i=0; i < aryLines.length; i++ ) {
                    System.out.println( aryLines[i] ) ;
                }

            } catch (IOException e){
                System.out.println( e.getMessage() );
            }
    }

    /**
     * Ez a függvény a képernyő/konzol törtlését végzi
     */
    public static void clear()
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            } else
            {
                System.out.print("\033[H\033[2J");
            }
        }
        catch (final Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
