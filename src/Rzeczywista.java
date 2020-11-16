import java.util.InputMismatchException;
import java.util.Scanner;

public class Rzeczywista {
    private double cecha = 0;

    private static double wprowadzanie(){
        Scanner scan = new Scanner(System.in);
        double pobrana = 0;
        try{
            System.out.println("Podaj liczbę: ");
            pobrana = scan.nextDouble();
            if(pobrana == 0){
                System.out.println("Nie można wyliczyć mantysy z zera.");
                pobrana = wprowadzanie();
            }
        }catch (InputMismatchException e){
            System.err.println("Dany znak nie jest liczbą.");
            pobrana = wprowadzanie();
        }
        return pobrana;
    }
    private void liczenie(double pobrana){
        try{
            if(pobrana < 1) {
                while (pobrana < 1) {
                    pobrana = pobrana * 10;
                    cecha--;
                }
            }
            else if(pobrana >= 10){
                while(pobrana >= 10){
                    pobrana = pobrana/10;
                    cecha++;
                }
            }
            System.out.println("Mantysa wynosi "+pobrana+", zaś cecha "+cecha+".");
            if(cecha == 0){
                System.err.println("Cecha jest równa zero, dzielenie nie jest możliwe.");
                pobrana = wprowadzanie();
                liczenie(pobrana);
            }
            else dzielenie(pobrana, cecha);
        }catch (InputMismatchException e){
            System.err.println("Błąd znaku.");
        }
    }
    private void dzielenie(double x, double y){
        try{
            if(Double.isInfinite(x/y) || Double.isNaN(x/y)){
                System.err.println("Dzielenie przez 0 jest niedozwolone.");
            }
            System.out.println("Wynik dzielenia to "+x/y+".");
        }catch (InputMismatchException e){
            System.err.println("Błąd dzielenia.");
        }catch (ArithmeticException e){
            System.out.println("Błąd obliczeń.");
        }
    }
    public void zadanie2(){
        liczenie(wprowadzanie());
    }
}
