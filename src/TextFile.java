import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class TextFile {

    private File file;

    public TextFile(File file) {
        this.file = file;
    }

    public boolean createIfNotExists() {

        if (file != null) {

            try {

                file.createNewFile();

            } catch (IOException e) {

                System.err.println("Error creating " + file.toString());

            }

            if (file.isFile() && file.canWrite() && file.canRead())
                return true;
        }

        return false;
    }

    public void writeLine(String write) {

        try {
            PrintWriter out = new PrintWriter(file);
            out.println(write);
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Datei kann nicht geschrieben werden");
        }



    }

    public void readFile() {




    }
}