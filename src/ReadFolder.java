import java.io.File;

public class ReadFolder{

    public void listFolder(File folder) {

        File[] files = folder.listFiles();
        if (files != null){

            for (int i = 0; i < files.length; i++) {

                System.out.print(files[i].getAbsolutePath());
                if (files[i].isDirectory()) {
                    System.out.print(" (Ordner)\n");
                } else {

                    System.out.println(" (Datei) \n ");

                }

            }

        }


    }




}