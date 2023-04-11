package EstructuraDeDatos;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Desinformados {

    static public Scanner sc = new Scanner(System.in);

    static public void Orden(Long[] o) {
        Set<Long> numero = new TreeSet<>();
        Set<Long> numero1 = new TreeSet<>();

        for (int i = 0; i < o.length; i++) {
            o[i] = sc.nextLong();
        }

        for (Long l : o)
            if (!numero1.add(l))
                numero.add(l);

        System.out.println(numero1.size()-numero.size());
        for (Long l : numero1)
            if (!numero.contains(l))
                System.out.println(l);
    }

    public static void main(String[] args) {
        Long o[] = new Long[sc.nextInt() + sc.nextInt()];
        Orden(o);
    }
}
