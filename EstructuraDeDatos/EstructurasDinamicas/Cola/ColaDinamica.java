package EstructuraDeDatos.EstructurasDinamicas.Cola;

import java.util.EmptyStackException;

public class ColaDinamica<T> {
    private Nodo<T> primero;//el primer nodo en la fila
    private Nodo<T> Ultimo;//el ultimo nodo en la fila
    private int tamaño;//el tamaño de la fila

    public ColaDinamica() {
        this.Ultimo = this.primero = null;
        this.tamaño = 0;
    }

    public boolean isEmpty() {//comprueba si la fila esta vacia
        return (this.tamaño == 0);
    }

    public int size() {//devuelve el tamaño de la fila
        return tamaño;
    }

    public T frist() {//devuelve el primer elemento en la lista
        if (isEmpty())//devuelve true si la lista esta vacia
            throw new EmptyStackException();//da una exepcion
        else
            return this.primero.getElemento();//da el primer elemento
    }
    /*
     * FIFO
     * Frist input frist out.
     * primero en entrar y primero en salir.
     */
    public T dequeue() {//elimina el primero en la fila
        if (isEmpty())//comprueba si es true para evitar problemas
            throw new EmptyStackException();//da una exepcion
        else {
            var elemento = this.primero.getElemento();//guardas el primer elemento
            var aux = this.primero.getSiguiente();//guardas el siguiente nodo al primer elemento
            primero = null;//primero se convierte en null
            primero = aux;//primero se vuelve el siguiente del primero
            this.tamaño--;//se decrementa el tamaño de la cola
            if (isEmpty()) {//si la cola esta vacia
                Ultimo = null;//el ultimo se vuelve null para evitar que el ulitimo tenga un valor
            }//no es 100% necesario
            return elemento;//regresa el elemento
        }
    }

    public T enqueue(T elemento) {//agrega un elemento a la lista
        var nodo = new Nodo<>(elemento, null);//se crea un nuevo elemento
        /*
         * solo se guarda el elemento. el siguiente es null,
         * porque el siguiente que se añade a la fila no existe.
         */

        if (isEmpty()) {//comprueba si habia alguien formado
            //si no hay nadie el primero y el ultimo son el mismo
            this.primero = nodo;//se declara primero 
            this.Ultimo = nodo;//y ultimo, porque no hay nadie mas.
        } else {
            if (size() == 1)//si el tamaño de la fila es igual a 1
                this.primero.setSiguiente(nodo);//el siguiente al primero se vuelve en el nuevo nodo
            else//si es mayor a 1
                this.Ultimo.setSiguiente(nodo);//el siguiente del ultimo se vuelve el nodo nuevo
            this.Ultimo = nodo;//y el ultimo para los dos casos
        }
        this.tamaño++;//se incrementa el tamaño

        return nodo.getElemento();//devuelve el elemento de la cola
    }

    public String toString() {
        if (isEmpty()) {
            return null;
        }else{
            Nodo<T> aux = this.primero;
            var s = "[ ";
            while (aux != null) {
                s+=aux.toString()+" ";
                aux = aux.getSiguiente();
            }
            s+="]";
        return s;
        }
    }
}
