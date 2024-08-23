
import java.util.Scanner;

public class VedurVindhradi {
    public static void main(String[] args) {

        // create scanner
        Scanner scan = new Scanner(System.in);
        // scans the windspeed input and stores it
        double windspeed = scan.nextDouble();
        //close the scanner
        scan.close();

        // skoðar inputið og printar út frá listanum
        if (0 <= windspeed && windspeed <= 0.2)  {
            System.out.println("Logn");
        } else if (0.3 <= windspeed && windspeed <= 1.5) {
            System.out.println("Andvari");
        } else if (1.6 <= windspeed && windspeed <= 3.3) {
            System.out.println("Kul");         
        } else if (3.4 <= windspeed && windspeed <= 5.4) {
            System.out.println("Gola");
        } else if (5.5 <= windspeed && windspeed <= 7.9) {
            System.out.println("Stinningsgola");
        } else if (8.0 <= windspeed && windspeed <= 10.7) {
            System.out.println("Kaldi");
        } else if (10.8 <= windspeed && windspeed <= 13.8) {
            System.out.println("Stinningskaldi");         
        } else if (13.9 <= windspeed && windspeed <= 17.1) {
            System.out.println("Allhvass vindur");
        } else if (17.2 <= windspeed && windspeed <= 20.7) {
            System.out.println("Hvassvidri"); 
        } else if (20.8 <= windspeed && windspeed <= 24.4) {
            System.out.println("Stormur");
        } else if (24.5 <= windspeed && windspeed <= 28.4) {
            System.out.println("Rok");         
        } else if (28.5 <= windspeed && windspeed <= 32.6) {
            System.out.println("Ofsavedur"); 
        } else if (32.7 <= windspeed) {
            System.out.println("Farvidri");
        } else {
            System.out.println("Ekki a listanum");
        }
    }
}
