package EstructuraDeDatos.EstructurasDinamicas.Cola;

public class Main {
    public static void main(String[] args) {
        ColaDinamica<Integer> cola = new ColaDinamica<>();
        System.out.println("Agregamos: "+cola.enqueue(10));
        System.out.println("Agregamos: "+cola.enqueue(15));
        System.out.println("Agregamos: "+cola.enqueue(20));
        System.out.println("Agregamos: "+cola.enqueue(25));

        System.out.println("tamaño de la cola: "+cola.size());
        System.out.println("el primero de la cola: "+cola.frist());
        System.out.println("esta vacia? "+cola.isEmpty());
        System.out.println(cola);
        
        System.out.println("Quitamos: "+cola.dequeue()+" el primero en la fila es: "+cola.frist());
        System.out.println("Quitamos: "+cola.dequeue()+" el primero en la fila es: "+cola.frist());
        System.out.println("Quitamos: "+cola.dequeue()+" el primero en la fila es: "+cola.frist());
        System.out.println("Quitamos: "+cola.dequeue());
    }
}  