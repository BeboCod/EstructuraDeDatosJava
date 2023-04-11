package EstructuraDeDatos.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ClaseMap {
    /*
     * Todas las keys son unicas
     */
    public static void main(String[] args) {
        //Map<Key, Valor>
        /*
         * el hashMap no son valores ordenados
         * son valores sin ningun orden.
         */
        Map<Integer, String> diccionarioHash = new HashMap<>();

        diccionarioHash.put(111, "Chris");
        diccionarioHash.put(2, "Paul");
        diccionarioHash.put(3, "Sebas");
        diccionarioHash.put(4, "Aquino");

        //Para iterar el mapa, obteniendo por separado la key y el valor
        for (Map.Entry<Integer, String> i : diccionarioHash.entrySet()) {
            System.out.println("clave: "+i.getKey()+"  "+"Valor: "+i.getValue());
        }
        //Tambien de esta forma con el ForEach
        System.out.println();
        diccionarioHash.forEach((t, u) -> System.out.println("clave: "+t+"  "+"Valor: "+u));

        System.out.println();

        /*
         * TreeMap la unica diferencia que tiene es que ordena
         * las keys.
         */
        Map<Integer, String> diccionarioTree = new TreeMap<>();

        diccionarioTree.put(1, "Chris");
        diccionarioTree.put(2, "Paul");
        diccionarioTree.put(3, "Sebas");
        diccionarioTree.put(3, "Aquino");

        diccionarioTree.forEach((t, u) -> System.out.println("clave: "+t+"  "+"Valor: "+u));

        System.out.println();

        /*
         * No acepta valores repetidos y no ordena las keys
         */
        Map<Integer, String> diccionarioLinked = new LinkedHashMap<>();

        diccionarioLinked.put(51, "Chris");
        diccionarioLinked.put(26, "Paul");
        diccionarioLinked.put(36, "Sebas");
        diccionarioLinked.put(47, "Aquino");

        diccionarioLinked.forEach((t, u) -> System.out.println("clave: "+t+"  "+"Valor: "+u));
        
    }
}
