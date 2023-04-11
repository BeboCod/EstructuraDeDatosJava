package EstructuraDeDatos;

import java.util.Scanner;

public class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
    }

    public Boolean existe(int Busqueda) {
        return existe(this.raiz, Busqueda);
    }

    // BUSQUEDA BINARIA
    private Boolean existe(Nodo n, int Busqueda) {
        if (n == null) {
            return false;
        }

        if (n.dato == Busqueda) {
            return true;
        } else if (n.dato < Busqueda) {
            return existe(n.getDerecha(), Busqueda);
        } else {
            return existe(n.getIzquierda(), Busqueda);
        }
    }

    public void Instertar(int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
        } else {
            this.Insertar(this.raiz, dato);
        }
    }

    private void Insertar(Nodo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.Insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                Insertar(padre.getIzquierda(), dato);
            }
        }
    }

    // ORDENAMIENTO
    private void preorden(Nodo n) {
        if (n != null) {
            n.ImprimrDatos();
            preorden(n.Izquierda);
            preorden(n.Derecha);
        }
    }

    public void preorden() {
        preorden(this.raiz);
    }

    private void inorden(Nodo n) {
        if (n != null) {
            preorden(n.Izquierda);
            n.ImprimrDatos();
            preorden(n.Derecha);
        }
    }

    public void inorden() {
        inorden(this.raiz);
    }

    private void postorden(Nodo n) {
        if (n != null) {
            preorden(n.Izquierda);
            preorden(n.Derecha);
            n.ImprimrDatos();
        }
    }

    public void postorden() {
        postorden(this.raiz);
    }

    private class Nodo {
        // ATRIBUTOS
        public Nodo Izquierda;
        public Nodo Derecha;
        public int dato;

        // CONSTRUCTOR
        Nodo(int dato) {
            Derecha = Izquierda = null;
            this.dato = dato;
        }

        // GETTERS AND SETTERS
        public void setDerecha(Nodo derecha) {
            Derecha = derecha;
        }

        public void setIzquierda(Nodo izquierda) {
            Izquierda = izquierda;
        }

        public int getDato() {
            return dato;
        }

        public Nodo getDerecha() {
            return Derecha;
        }

        public Nodo getIzquierda() {
            return Izquierda;
        }

        // IMPRIME LOS DATOS
        public void ImprimrDatos() {
            System.out.print(dato + " ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArbolBinario op = new ArbolBinario();
        Scanner sc = new Scanner(System.in);

        System.out.print("cuantos nodos quieres crear?\nR= ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ".- ");
            op.Instertar(sc.nextInt());
        }

        System.out.print("que ordenamiento quieres:\n1.- Preorden\n2.- Inorden\n3.- Postorden\nR= ");
        int key = sc.nextInt();

        switch (key) {
            case 1:
                op.preorden();
                break;

            case 2:
                op.inorden();
                break;

            case 3:
                op.postorden();
                break;

            default:
                System.out.println("no existe la opcion");
                break;
        }
        System.out.print("\nnumero a buscar: ");
        int b = sc.nextInt();

        System.out.println(op.existe(b));

        sc.close();
    }
}