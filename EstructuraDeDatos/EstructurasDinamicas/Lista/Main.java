package EstructuraDeDatos.EstructurasDinamicas.Lista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        var sc = new Scanner(System.in);
        
        try {
            var c = 0;
            var i = 0;
            while (c != 'a') {
                lista.add(c, i);
                c = sc.nextInt();
                i++;
            }
        } catch (Exception e) {
        }
        lista.removeFrist();

        System.out.println("\nesta vacia la lista?: "+lista.isEmpty());
        System.out.println("\nse añade el: "+lista.addFrist(1)+" en primero");
        System.out.println("\nse añade el: "+lista.addLast(11)+" en ultimo");
        System.out.println("\nexiste el 10 en la lista?: "+lista.exist(10));
        System.out.println("\ncual es el anterior index de 10 en la lista?: "+lista.indexOF(10));
        System.out.println("\nremueve el primer elemento: "+lista.removeFrist());
        System.out.println("\nremueve el ultimo elemento: "+lista.removeLast());
        System.out.println("\nremuevo la posicion 4: "+lista.remove(3));
        System.out.println("\nprimer elemento: "+lista.getFrist());
        System.out.println("\nultimo elemento: "+lista.getLast());
        //System.out.println("\nla posicion 4 modifica su elemento por 152");
        //lista.set(152, 3);
        System.out.println("\n"+lista.toString());
        sc.close();
    }
}
