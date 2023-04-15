package EstructuraDeDatos.EstructurasDinamicas.Pilas;

import java.util.Scanner;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        var pila = new PilaDinamica<Integer>();
        var sc = new Scanner(System.in);
        
        System.out.print("cuantos elementos quieres ingresar?\nr: ");
        var n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            pila.push(sc.nextInt());
        }
        var op = new Stack<Integer>();

        //pila.clear();
        System.out.println(pila.peek());
        System.out.println(pila.Top());
        System.out.println("esta vacia: "+pila.isEmpty());
        System.out.println("elementos: "+pila.toString());

        var Timer = new Timer();
        var tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println(pila.toString());
                pila.pop();
                if (pila.Top() == null) {
                    Timer.cancel();
                    System.out.println("esta vacia: "+pila.isEmpty());
                }
            }
        };

        Timer.schedule(tarea, 1000, 2000);

        sc.close();
    }
}
