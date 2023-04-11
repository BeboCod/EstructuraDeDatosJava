package EstructuraDeDatos.Set.Ejercicios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EncontrarDuplicados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos numeros quieres ingresar?: ");
        int k = sc.nextInt(), o[] = new int[k];
        

        System.out.println("Ingresa los elementos:");
        for (int i = 0; i < o.length; i++) {
            o[i] = sc.nextInt();
        }

        Set<Integer> Val = new HashSet<>();
        Set<Integer> Dup = new HashSet<>();

        for (int i : o) {
            if (!Dup.add(i)) {
                Val.add(i);
            }
        }

        if (Val.size() > 0) {
            System.out.print("Se encontraron: "+Val.size()+"\nson:");
            Val.forEach(i -> System.out.print(i+" "));
        } else {
            System.out.println("No se encontraron duplicados");
        }
        sc.close();
    }
}
