import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {
    private double x, y;
    private static double wprowadzanie1(){
        Scanner scan = new Scanner(System.in);
        double x = 0;
        try{
            System.out.println("Pierwsza liczba: ");
            x = scan.nextDouble();
        }catch(InputMismatchException e){
            System.err.println("Podano błędną liczbę.");
            x = wprowadzanie1();
        }
        return x;
    }
    private static double wprowadzanie2(){
        Scanner scan = new Scanner(System.in);
        double y = 0;
        try{
            System.out.println("Druga liczba: ");
            y = scan.nextDouble();
        }catch(InputMismatchException e){
            System.err.println("Podano błędną liczbę.");
            y = wprowadzanie2();
        }
        return y;
    }

    private double add(double x, double y){
        try {
            System.out.println("Wynik dodawania to "+ (x+y) + ".");
        }catch(InputMismatchException e){
            System.err.println("Bład dodawania [znak].");
            return add(wprowadzanie1(), wprowadzanie2());
        }catch(ArithmeticException e){
            System.err.println("Bład dodawania [operacja].");
            return add(wprowadzanie1(), wprowadzanie2());
        }
        return x+y;
    }
    private double sub(double x, double y){
        try{
            System.out.println("Wynik odejmowania to "+ (x-y) + ".");
        }catch(InputMismatchException e){
            System.err.println("Bład odejmowania [znak].");
            return sub(wprowadzanie1(), wprowadzanie2());
        }catch(ArithmeticException e){
            System.err.println("Bład odejmowania [operacja].");
            return sub(wprowadzanie1(), wprowadzanie2());
        }
        return x-y;
    }
    private double multi(double x, double y){
        try{
            System.out.println("Wynik mnożenia to "+ (x*y) + ".");
        }catch(InputMismatchException e){
            System.err.println("Bład mnożenia [znak].");
            return multi(wprowadzanie1(), wprowadzanie2());
        }catch(ArithmeticException e){
            System.err.println("Bład mnożenia [operacja].");
            return multi(wprowadzanie1(), wprowadzanie2());
        }
        return x*y;
    }
    private double div(double x, double y){
        try{
            if(Double.isInfinite(x/y) || Double.isNaN(x/y)){
                System.err.println("Dzielenie przez 0 jest niedozwolone");
                return div(x, wprowadzanie2());
            }
            System.out.println("Wynik dzielenia to "+ (x/y) + ".");
        }catch(InputMismatchException e) {
            System.err.println("Bład dzielenia [znak].");
            return div(wprowadzanie1(), wprowadzanie2());
        }catch(ArithmeticException e){
            System.err.println("Bład dzielenia [operacja].");
            return div(wprowadzanie1(), wprowadzanie2());
        }
        return x/y;
    }
    private double exp(double x, double y){
        try{
            System.out.println("Wynik potęgowania to "+ (Math.pow(x,y)) + ".");
        }catch(InputMismatchException e){
            System.err.println("Bład potęgowania [znak].");
            return exp(wprowadzanie1(), wprowadzanie2());
        }catch(ArithmeticException e){
            System.err.println("Bład potęgowania [operacja].");
            return exp(wprowadzanie1(), wprowadzanie2());
        }
        return Math.pow(x,y);
    }
    private double square(double x, double y){
        try{
            if(Double.isInfinite(Math.pow(x,1/y)) || Double.isNaN(Math.pow(x,1/y))){
                System.err.println("Pierwiastkowanie liczb ujemnych jest niedozwolone");
                return square(wprowadzanie1(), y);
            }
            System.out.println("Wynik pierwiastkowania to "+ (Math.pow(x,1/y)) + ".");
        }catch(InputMismatchException e){
            System.err.println("Bład pierwiastkowania [znak].");
            return square(wprowadzanie1(), wprowadzanie2());
        }catch(ArithmeticException e){
            System.err.println("Bład pierwiastkowania [operacja].");
            return square(wprowadzanie1(), wprowadzanie2());
        }
        return Math.pow(x,1/y);
    }

    public void menu(){
        System.out.println("MENU: \n1. Addition\n2. Subtration\n3. " +
                "Multiplication\n4. Division\n5. Exponentiation\n6. " +
                "SquareRoot\nPodaj swój wybór: ");
        try{
            Scanner scan = new Scanner(System.in);
            short wybor = scan.nextShort();
            switch(wybor){
                case 1: {
                    x = wprowadzanie1();
                    y = wprowadzanie2();
                    add(x, y);
                } break;
                case 2: {
                    x = wprowadzanie1();
                    y = wprowadzanie2();
                    sub(x, y);
                } break;
                case 3: {
                    x = wprowadzanie1();
                    y = wprowadzanie2();
                    multi(x, y);
                } break;
                case 4: {
                    x = wprowadzanie1();
                    y = wprowadzanie2();
                    div(x, y);
                } break;
                case 5: {
                    x = wprowadzanie1();
                    y = wprowadzanie2();
                    exp(x, y);
                } break;
                case 6: {
                    x = wprowadzanie1();
                    y = wprowadzanie2();
                    square(x, y); break;
                }
                default:
                    System.out.println("Nieobsługiwany znak.");
            }
        }catch (InputMismatchException e){
            System.err.println("Wprowadzono niepoprawny znak.");
        }
    }
}
