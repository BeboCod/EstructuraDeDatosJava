package EstructuraDeDatos;

import java.util.Scanner;

public class MainNodo {
    public static void main(String[] args) {
        nodo n[] = new nodo[4];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n.length; i++) {
            String o = sc.nextLine();
            n[i] = new nodo(o);
        }

        n[0].setSiguiente(n[1]);
        n[1].setSiguiente(n[2]);
        n[2].setSiguiente(n[3]);
        nodo aux = n[0];

        for (int i = 0; i < n.length; i++) {
            String aux2 = (String)aux.getContiene();
            System.out.println(aux2);
            aux = aux.getSiguiente();
        }

        sc.close();
    }
}
