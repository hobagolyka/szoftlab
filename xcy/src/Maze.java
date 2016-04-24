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
        //ReadMaze("tesztek/setdirtest.txt");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String Str = "";
        String[] darabok = {"","",""};
        String[] palya = {"fg", "sd", "fg"};

        System.out.println("Lehetséges parancsok:\n " +
                "load filename\n " +
                "print filename \n " +
                "step mo \n " +
                "setDir mo dir \n " +
                "pickup mo \n " +
                "setDir mo dir \n " +
                "putdown mo \n " +
                "shoot c \n " +
                "show x y \n " +
                "rep state \n " +
                "hasBox mo \n " +
                "collcectedZPM mo \n " +
                "autoZPM state \n");

        while(run)
        {
            System.out.println("Jöhetnek a parancsok: ");

            try
            {
                Str = (br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            int i = 0;
            for (String retval: Str.split(" ")){
                darabok[i] = retval;
                i++;
            }

            String parancs = darabok[0];
            String masodik = darabok[1];
            String harmadik = darabok[2];

            switch (parancs)
            {
                /* load filename
                * Leírás: A pályafájl beolvasására szolgáló parancs. A megadott fájlt egy helyre kell
                * másolni az osztályfájlokkal, ebben a mappában fogja keresni a prototípus.
                * Opciók: filename: a játéktér leírását tartalmazó txt fájl neve
                * */
                case "load":
                    palya = ReadMaze("tesztek/"+masodik);
                    break;

                /* print filename
                 *  Leírás: A megadott fájlnévvel létrehoz egy fájlt, amibe kimenti a
                 *  pálya pillanatnyiképét a 7.1.1-ben definiált pályaleíró nyelvet használva. Ha a megadott névvel már
                 *  létezik txt fájl, akkor felül fogja írni azt.
                 *  Opciók: filename: a txt fájl neve, amibe a játéktér állapotát menteni szeretnénk.
                 *  */
                case "print":
                    if (masodik != null) {
                        WriteMaze(masodik, palya);
                    }
                    break;

                /* step mo
                 * Leírás: Az mo helyén megadott movable objektumot lépteti az objektumban tárolt
                 * pillanatnyi irányban lévő mezőre. Az mo lehetséges értékeinek
                 * jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                 * Opciók: mo = {o | j | r}
                 * */
                case "step":
                    break;

                /* setDir mo dir
                * Leírás: Az mo helyén megadott movable objektum irányát állítja a dir helyén megadottra.
                * Az mo lehetséges értékeinek jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                * A dir lehetséges értékeinél a fel és az f, a le és az l, a jobb és a j illetve a
                * bal és a bjelentése páronként megegyezik.
                * Opciók: mo = {o | j | r}, dir = {fel | le | jobb | bal | f | l | j | b}
                * */
                case "setDir":
                    break;

                /* pickup mo
                * Leírás: Az mo helyén megadott movable objektum megpróbálja az
                * irányában lévőmezőn található pályaelemet felvenni. Az mo lehetséges
                * értékeinek jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                * Előfordulhat, hogy az ezredes páros számú ZPM-et vett fel a parancs végrehajtása
                * után. A specifikáció szerint ekkor egy új ZPM jön létre egy véletlenszerű helyen, ez
                * alapból automatikusan megtörténik. Ezt a funkciót az autoZPM funkcióval lehet ki- és
                * bekapcsolni (pontosabban lásd később). Az mo lehetséges értékeinek
                * jelentése megegyezik a pályaleíró nyelvben definiált jelentéssel.
                * Opciók: mo = {o | j }
                 */
                case "pickup":
                    break;

                /* putdown mo
                * Leírás: Az mo helyén megadott movable objektum megpróbálja az irányában lévő
                * mezőre letenni a nála lévő pályaelemet, ami a specifikációnak megfelelően csak doboz lehet.
                * Az mo lehetséges értékeinek jelentése megegyezik a pályaleíró nyelvben definiált
                * jelentéssel.
                * Opciók: mo = {o | j }
                 */
                case "putdown":
                    System.out.println("putdown");
                    break;


                case "shoot":
                    System.out.println("shoot");
                    break;


                case "show":
                    System.out.println("show");
                    break;


                case "rep":
                    System.out.println("rep");
                    break;


                case "hasBox":
                    System.out.println("hasBox");
                    break;


                case "collectedZPM":
                    System.out.println("collectedZPM");
                    break;


                case "autoZPM":
                    System.out.println("autoZPM");
                    break;

                default:
                    System.out.println("Sajnos ilyen parancs nincs");
                    break;
            }
        }
    }

    /**
     * Ez a függvény a pálya/labirintus beolvasására való, a paraméterben megadott elérési útvonalban megadott filet olvassa ki,
     * ez lesz a mi pályaleíró nyelvünkkel megadott pálya
     * visszatérési értéke pedig string tömbben megadott pálya
     */
    public static String[] ReadMaze(String path) throws IOException {
        URL url = Maze.class.getResource(path);
        File file2 = new File(url.getPath());
        String fname = file2.toString();

        try {
            FileData file = new FileData();
            file.ReadFile(fname);
            String[] aryLines = file.OpenFile();

            int i;
            for ( i=0; i < aryLines.length; i++ ) {
               System.out.println(aryLines[i]) ;
            }
            return aryLines;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Ez a függvény való a pálya változásainak elmentésére, egy új/vagy régi txt fileba menti el
     */
    public static void WriteMaze(String path, String[] ujpalya){
        try {
            WriteFile data = new WriteFile(path, true);
            for(int i = 0; i < ujpalya.length; i++)
                data.writeToFile(ujpalya[i]);
        } catch (IOException e){
            System.out.println(e.getMessage());
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
