package EstructuraDeDatos;

import java.util.ArrayList;

public class Letras {
    public String palabra;
    ArrayList<Integer> p = new ArrayList<>();

    public void Letra() {
        char letras = 97;
        int k = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < palabra.length(); j++) {
                char o = palabra.charAt(j);
                if (o == letras) {
                    k++;
                }
            }
            p.add(k);
            k=0;
            letras++;
        }
    }

    public void Imprimir() {
        char letras = 97;
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) == 0) {
                l.add(p.get(i));
            }
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println("La letra "+letras+" aparece "+l.get(i)+" veces");
            letras++;
        }
    }

    public static void main(String[] args) {
        Letras op = new Letras();
        op.palabra = "programacion";
        op.Letra();
        op.Imprimir();
    }
}
