package com.company;

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {
        String filename1 = "";
        String filename2= "";
        boolean valid = true;
        if (args.length < 2) {
            try {
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please add the path of the first file");
                filename1 = console.readLine();
                System.out.println("Please add the path of the first file");
                filename2 = console.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            filename1 = args[0];
            filename2 = args[1];
        }
        String line1,line2;
        try {
                InputStream fis1 = new FileInputStream(filename1);
                InputStreamReader isr1 = new InputStreamReader(fis1, Charset.forName("UTF-8"));
                BufferedReader br1 = new BufferedReader(isr1);

                InputStream fis2 = new FileInputStream(filename2);
                InputStreamReader isr2 = new InputStreamReader(fis2, Charset.forName("UTF-8"));
                BufferedReader br2 = new BufferedReader(isr2);
                while ((line1 = br1.readLine()) != null) {
                    if((line2 = br2.readLine()) == null){
                        valid = false;
                        break;
                    }
                    if ( !line1.equalsIgnoreCase(line2)){
                        valid = false;
                        break;
                    }
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(valid){
            System.out.println("MATCH");
        }
        else
        {
            System.out.println("FAIL");
        }
    }
}
