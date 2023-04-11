package EstructuraDeDatos;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {
    LinkedList<String> cola = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    ArrayList<String> Atendidos = new ArrayList<>();
    ArrayList<String> C = new ArrayList<>();

    public LinkedList<String> Cliente(int j) {
        String cliente = "", c[];
        
        for (int i = 0; i < j; i++) {
            cliente = sc.nextLine();
            c = cliente.split(" ");

            for (String s : c) {
                C.add(s);
            }

            if (c.length > 1) {
                C.remove(0);
            }

            int o = C.get(0).length();
            if (o == 6) {
                cola.add(C.get(1));
            }else{
                if (o == 10) {
                    cola.addFirst(C.get(1));
                }else{
                    if (o == 7&&cola.size()>0) {
                        Atendidos.add(cola.get(0));
                        cola.remove(0);
                    }
                }
            }
            C.clear();
        }

        return cola;
    }

    public void Atendidos() {
        for (String s : Atendidos) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Cafeteria op = new Cafeteria();
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        op.Cliente(j);
        op.Atendidos();
        sc.close();
    }
}
