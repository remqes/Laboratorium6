import java.util.InputMismatchException;
import java.util.Scanner;

public class Calkowita {
    private int pobrana;

    private static int pobieranie(){
        Scanner scan = new Scanner(System.in);
        int pobrana = 0;
        try{
            System.out.println("Podaj liczbę: ");
            pobrana = scan.nextShort();
        }catch(InputMismatchException e){
            System.err.println("Podany znak nie jest liczbą.");
            pobrana = pobieranie();
        }
        return pobrana;
    }

    private void sumaKwadratow(int pobrana){
        int suma = 0;
        try{
            if(pobrana < 98 || pobrana > 1000){
                System.err.println("Podana wartość nie spełnia założeń.");
                pobieranie();
            }
            else{
                while(pobrana!=0){
                    suma += pobrana%10;
                    pobrana/=10;
                }
                System.out.println("Suma kwadratow cyfr to "+ suma +".");
            }

        }catch (InputMismatchException e){
            System.err.println("Błąd znaku.");
        }catch (ArithmeticException e){
            System.err.println("Błąd obliczeń.");
        }
    }

    public void znak(){
        sumaKwadratow(pobieranie());
    }
}
