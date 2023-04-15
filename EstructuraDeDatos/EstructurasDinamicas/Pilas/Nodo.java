package EstructuraDeDatos.EstructurasDinamicas.Pilas;

public class Nodo<T> {//uso degenericos para poder ingresar cualquier dato
    //Atributos
    private T elemento;
    private Nodo<T> siguiente;

    //Constructor
    public Nodo(T elemento, Nodo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
    
    //getters and setters
    public T getElemento() {
        return elemento;
    }
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    //toString
    @Override
    public String toString() {
        return getElemento()+" ";
    }

}
