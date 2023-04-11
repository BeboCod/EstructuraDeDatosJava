package EstructuraDeDatos.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Se utilizan para almacenar y manipular
 * elementos unicos.
 */

public class ClaseSet {
    public static void main(String[] args) {
        //No imprime elementos duplicados
        Set<String> conjuntoHash = new HashSet<>();
        conjuntoHash.add("Peru");
        conjuntoHash.add("Argentina");
        conjuntoHash.add("Colombia");
        conjuntoHash.add("Mexico");
        conjuntoHash.add("Mexico");
        conjuntoHash.add("Mexico");

        System.out.println("HashSet:");
        conjuntoHash.forEach(i -> System.out.println("Valor: "+i));

        System.out.println();

        /*
         * Se almacenan de menor a mayor, en
         * String se almacenana por orden alfabetico.
         */
        Set<String> conjuntoTree = new TreeSet<>();
        conjuntoTree.add("Cris");
        conjuntoTree.add("Maricio");
        conjuntoTree.add("Ace");
        conjuntoTree.add("Valentin");
        conjuntoTree.add("Valeria");
        conjuntoTree.add("Elli");

        System.out.println("HashTree:");
        conjuntoTree.forEach(i -> System.out.println("Valor: "+i));

        System.out.println();

        /*
         * se guardan en orden ingresado, pero no 
         * se imprimen elementos repetidos
         */
        Set<Character> conjuntoLinked = new LinkedHashSet<>();
        conjuntoLinked.add('a');
        conjuntoLinked.add('b');
        conjuntoLinked.add('c');
        conjuntoLinked.add('d');
        conjuntoLinked.add('a');

        System.out.println("LinkedHashSet:");
        conjuntoLinked.forEach(i -> System.out.println("Valor: "+i));

        /*
         * para el linked HashSet, HashSet y TreeSet, solo se guardan
         * elementos no duplicados, no importa si guardo
         * mas elementos si son duplicados no se guardan en el
         * arreglo.
         */
    }
}
