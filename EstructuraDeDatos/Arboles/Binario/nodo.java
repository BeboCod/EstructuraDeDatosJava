package EstructuraDeDatos.Arboles.Binario;

import java.util.Objects;

public class nodo<T extends Comparable<T>> {
    private T elemento;
    private nodo<T> padre, hijoDerecho, hijoIzquierdo;
    

    public nodo(T elemento, nodo<T> padre) {
        this.elemento = elemento;
        this.padre = padre;
        this.hijoDerecho = this.hijoIzquierdo = null;
    }

    public nodo(T elemento) {
        this.elemento = elemento;
    }
    
    public nodo() {
        this.hijoDerecho = this.hijoIzquierdo = this.padre =null;
    }

    public nodo(nodo<T> hijoDerecho, nodo<T> hijoIzquierdo, T elemento) {
        this.hijoDerecho = hijoDerecho;
        this.hijoIzquierdo = hijoIzquierdo;
        this.elemento = elemento;
    }

    public nodo(T elemento, nodo<T> hijoDerecho, nodo<T> hijoIzquierdo) {
        this.elemento = elemento;
        this.hijoDerecho = hijoDerecho;
        this.hijoIzquierdo = hijoIzquierdo;
    }
    
    public T getElemento() {
        return elemento;
    }
    public nodo<T> getHijoDerecho() {
        return hijoDerecho;
    }
    public nodo<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }
    public nodo<T> getPadre() {
        return padre;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public void setHijoDerecho(nodo<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    public void setHijoIzquierdo(nodo<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
    public void setPadre(nodo<T> padre) {
        this.padre = padre;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof nodo)) {
            return false;
        }
        nodo<T> nodo = (nodo<T>) o;
        return Objects.equals(elemento, nodo.elemento) && Objects.equals(padre, nodo.padre) && Objects.equals(hijoDerecho, nodo.hijoDerecho) && Objects.equals(hijoIzquierdo, nodo.hijoIzquierdo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elemento, padre, hijoDerecho, hijoIzquierdo);
    }


    @Override
    public String toString() {
        return ""+getElemento()+" ";
    }

}
