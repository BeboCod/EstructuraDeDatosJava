package EstructuraDeDatos.Arboles.Binario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var arbol = new ArbolBinario<Integer>();
        
        for (int i = 0; i < 10; i++)
            arbol.add(sc.nextInt());

        arbol.remove(arbol.getRoot().getHijoDerecho());
        System.out.println(arbol.getRoot().getHijoDerecho().getHijoIzquierdo());

        System.out.print("\npreorden: ");
        arbol.preorden(arbol.getRoot());
        System.out.print("\ninorden: ");
        arbol.inorden(arbol.getRoot());
        System.out.print("\npostorden: ");
        arbol.postorden(arbol.getRoot());

        sc.close();
    }
}
