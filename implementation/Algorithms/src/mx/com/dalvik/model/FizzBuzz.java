import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {		
        int n;
		
        System.out.println("Ingresa cantidad de numeros a mostrar: \n");
        Scanner cantidad = new Scanner(System.in);
        n = cantidad.nextInt();
		
        for (int i = 1; i <= n; i++) {
            if ( (i % 3  == 0) && (i % 5 == 0) ) { 
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz"); 
            } else if ( !(i % 3 == 0) || !(i % 5 == 0) ) {
                System.out.println(i);
            }
        }
    }    
}