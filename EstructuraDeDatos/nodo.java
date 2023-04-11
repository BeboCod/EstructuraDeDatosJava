package EstructuraDeDatos;

public class nodo {
    private nodo siguiente;
    private String contiene;

    nodo(){
        setSiguiente(null);
        setContiene(null);
    }
    nodo(String c){
        setSiguiente(null);
        setContiene(c);
    }
    nodo(nodo n){
        setContiene(null);
        setSiguiente(n);
    }
    nodo(String c, nodo n){
        setContiene(c);
        setSiguiente(n);
    }

    public String getContiene() {
        return contiene;
    }
    public nodo getSiguiente() {
        return siguiente;
    }
    public void setContiene(String contiene) {
        this.contiene = contiene;
    }
    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }


}
