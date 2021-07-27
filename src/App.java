import helpers.Brainz;
import helpers.Reader;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Brainz brainz = new Brainz(sc);

        brainz.welcome();

        while(brainz.aintSleepin()){
            brainz.work();
        }
        System.out.println("See you next time :)");
        sc.close();
    }
}
