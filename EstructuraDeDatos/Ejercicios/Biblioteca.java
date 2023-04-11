package EstructuraDeDatos.Ejercicios;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Biblioteca {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Libro> librosDisponibles;
    private Stack<Libro> librosPrestados; 
    private Queue<Cliente> listaDeEspera;

    public Biblioteca(){
        librosDisponibles = new ArrayList<>();
        librosPrestados = new Stack<>();
        listaDeEspera = new LinkedList<>();
        MetodosSueltosAleatorios op = new MetodosSueltosAleatorios();
        for (int i = 0; i < 10; i++) {
            librosDisponibles.add(new Libro(""+op.nombresLibrosAleatorios()[0], ""+op.nombresLibrosAleatorios()[1], (int)op.nombresLibrosAleatorios()[2]));
        }
    }

    public int verLibros() {
        int i = 0;
        for (Libro libro : librosDisponibles) {
            i++;
            System.out.println(i+".- "+libro);
        }
        return i;
    }

    public void pedir() {
        int Dis = verLibros();

        System.out.print("cual libro quieres solicitar?\nR=");
        int key = sc.nextInt();

        if (key < librosDisponibles.size()) {
        }

    }

    public Cliente pedirCliente(){
        System.out.print("\nNombre: ");
        String nom = sc.nextLine();
        int ed;
        do {
            System.out.print("\nEdad: ");
            ed = sc.nextInt();
        } while (ed >= 18);
        System.out.print("\nRfc: ");
        String Rfc = sc.nextLine();
        System.out.print("\nsexo: ");
        char sex = sc.next().charAt(0);
        System.out.print("Direccion: ");
        String dire = sc.nextLine();
        System.out.print("\nCurp: ");
        String curp = sc.next();
        Cliente o;
        return o = new Cliente(nom, ed, dire, curp, Rfc, sex);
    }
}
