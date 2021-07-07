import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clasa prin care ne cream obiectele de tip scan, pentru a citi din fisierul
 * map.in, si de asemenea output, de tip FileWriter, pentru a putea scrie
 * in fisierul map.out. O alta varianta pentru afisarea in fisier ar fi fost cu
 * redirectare a outpului la stdin, dar nu cred ca acesta era scopul temei.
 */
public class Input_Output {
    /**
     *
     * @return o instanta a lui Scanner, pentru a putea citi din map.in
     */
    public static Scanner input() {
        File input = new File("map.in");
        Scanner scan = null;

        try {
            scan = new Scanner(input);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

        return scan;
    }

    /**
     *
     * @return o instanta a lui FileWriter, pentru a putea scrie in map.out
     */
    public static FileWriter output() {
        FileWriter output = null;
        try {
            output = new FileWriter("map.out", true);
        }
        catch (IOException e) {
            System.out.println();
        }
        return  output;
    }
}
