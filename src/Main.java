import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int number;


        //MENU
        System.out.println("################################################");
        System.out.println("#|--------------------------------------------|#");
        System.out.println("#| [1]Create a .TXT File                      |#");
        System.out.println("#| [2]Read a .TXT                             |#");
        System.out.println("#| [3]Delete .TXT Files                       |#");
        System.out.println("#| [4]QUIT                                    |#");
        System.out.println("#|--------------------------------------------|#");
        System.out.println("#|-------------Choose a Number----------------|#");
        System.out.println("################################################");

        Scanner s = new Scanner(System.in);

        number = s.nextInt();

        do {


            if (number < 1) {

                System.out.println("Such eine größere Zahl aus.");

                break;

            } else if (number == 1) {

                Scanner so = new Scanner(System.in);

                System.out.println("Choose a Path");
                String _speicherort = so.nextLine();
                new File(_speicherort).mkdirs();

                Scanner _s = new Scanner(System.in);

                System.out.println("Gebe der .TXT ein Namen!\nEingabe: ");
                String _txt = _s.nextLine();
                TextFile txtCreator = new TextFile(new File(_speicherort + "\\" + _txt + ".txt"));


                if (txtCreator.createIfNotExists())

                    System.out.println(_txt + " wurde in " + _speicherort + " erstellt!");


                // schreibt in die .TXT - Datei!

                Scanner __s = new Scanner(System.in);

                System.out.println("Geben Sie hier ihre Notiz ein!:");
                String text = __s.nextLine();

                txtCreator.writeLine(text);

                System.out.println("Es wurde erfolgreich die Notiz gespeichert!");

                break;

            } else if (number == 2){

                // Read Folder
                Scanner s_ = new Scanner(System.in);

                System.out.println("Gebe den Path ein:");
                String _speicherort = s_.nextLine();

                System.out.println("Gebe den Namen der .TXT ein!");
                String _txt = s_.nextLine();

                System.out.println("In dem Path sind folgende Datein drin:");
                File f = new File(_speicherort);
                File[] fileArray = f.listFiles();

                ReadFolder readF = new ReadFolder();
                readF.listFolder(f);

                //.TXT auslesen
                System.out.println("In der Datei steht als Notiz:");
                int zahl = 0;
                String linie;

                FileInputStream fis = new FileInputStream(_speicherort + "\\" + _txt + ".txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                String inhalt = "";

                try {
                    linie = br.readLine();
                    while (linie != null) {
                        inhalt += linie;

                        if ("".equals(linie)) {
                            zahl++;
                        }
                        linie = br.readLine();
                    }
                    br.close();
                } catch (IOException ioAusnahme) {
                    System.out.println("Datei konnte nicht geöffnet werden!");
                }

                System.out.println(inhalt);
                break;


            }else if (number == 3){

                //Delete Files
                String _pathdf = s.nextLine();
                System.out.println("Geben Sie den Path ein + .TXT:");


                File df = new File(_pathdf + ".txt");

                df.delete();

                break;

            }


        } while (!(number == 4));





    }

}


