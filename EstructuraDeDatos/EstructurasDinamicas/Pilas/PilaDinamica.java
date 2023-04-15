package EstructuraDeDatos.EstructurasDinamicas.Pilas;

import java.util.EmptyStackException;
import java.util.Objects;

public class PilaDinamica <T> {
    private Nodo<T> top;//el elemento superior
    private int tamaño;//el tamaño de la pila

    public PilaDinamica() {
        this.top = null;//cuando se crea es igual a null
        this.tamaño = 0;//al igual que el tamaño
    }

    public boolean isEmpty(){//indica si esta vacia la pila
        return this.top == null;//si es igual a null esta vacia
    }

    public int size() {//indica el tamaño de la pila
        return this.tamaño;//returna el tamaño en entero
    }

    public T pop() {//devuelve el primier elemento y lo elimina
        if (isEmpty()) {
            throw new EmptyStackException();//da error si esta vacia
        } else {
            var elemento = this.top.getElemento();//el top lo guardas
            Nodo<T> aux = this.top.getSiguiente();//el soguiente al top lo guardas
            top = null;//el top lo igualas a null para eliminarlo
            top = aux;//y el siguiente top seria el siguiente nodo
            this.tamaño--;//se decrementa porque eliminas una posicion
            return elemento;//returnas el elemento
        }
    }

    public boolean push(T element) {//introduce un elemento en la pila
        Nodo<T> aux = new Nodo<>(element, top);//creas un nuevo nodo para usarlo como memoria de la pila
        top = aux;//el top lo igualas a auxiliar
        this.tamaño++;//se incrementa el tamaño
        return true;//devuelve true si se pudo cumplir la funcion
    }

    public T Top() {//devuelve el primer elemento (no elimina nada)
        if (this.top == null) {//si el top es nullo devuelve nullo
            return null;
        } else {
            return top.getElemento();//te muestra el elemento del top
        }
    }

    public void clear() {//elimina toda la pila
        var aux = top;//igualo la primera posicion en un aux
        while (top != null) {//asta que sea igual a null el top no para
            aux = top.getSiguiente();//aux se iguala a la siguienete posicion
            top = null;//top se iguala o elimina a null
            top = aux;//top se iguala a aux que es el siguiente nodo
        }
    }

    public T peek() {
        if (top == null) {//si el top es igual a null returna nulls
            throw new EmptyStackException();//da error si esta vacia
        } else {
            var A = top;//creo una variable anterior para guardar el top acutal
            var S = top.getSiguiente();//creo una variable siguiente guardando el nodo siguiente
            while (S != null) {//mientras que S sea diferente de null se sigue ejecutando
                A = S;//Anterior se iguala a Siguiente para evitar que A sea igual a null
                S = S.getSiguiente();//Siguiente se iguala a el Siguiente nodo para avanzar
            }
            return A.getElemento();//returna el elemento de el ultimo nodo
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PilaDinamica)) {
            return false;
        }
        PilaDinamica<T> pilaDinamica = (PilaDinamica) o;
        return Objects.equals(top, pilaDinamica.top) && tamaño == pilaDinamica.tamaño;
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, tamaño);
    }

    public String toString() {//simplemente muestra la pila completa
        if (isEmpty()) {
            return null;
        }else{
            Nodo<T> aux = top;
            var s = "[ ";
            while (aux != null) {
                s+=aux.toString();
                aux = aux.getSiguiente();
            }
            s+="]";
            return s;
        }
    }
}
