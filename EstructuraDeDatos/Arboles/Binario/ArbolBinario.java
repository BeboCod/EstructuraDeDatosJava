package EstructuraDeDatos.Arboles.Binario;

public class ArbolBinario<T extends Comparable<T>> {
    private nodo<T> root;
    /* estos son los casos
       del swith en remove*/
    private final int ONE_NODE_LEFT = 1;
    private final int ONE_NODE_RIGHT = 2;
    private final int TWO_NODES = 3;

    public ArbolBinario() {
        this.root = null;
    }

    // obtiene la raiz, o el primer nodo del arbol
    public nodo<T> getRoot() {
        return root;
    }

    // si esta vacio el arbol devuelve null
    public boolean isEmpty() {
        return (root == null);
    }

    // compara si el nodo ingresado es igual a la raiz
    public boolean isRoot(nodo<T> n) {
        return root.equals(n);
    }

    // si el nodo ingresado no tiene hijos se considera una hoja por lo tanto
    // devuelve true
    public boolean isLeaf(nodo<T> n) {
        return (n.getHijoDerecho() == null && n.getHijoIzquierdo() == null);
    }

    // si tiene al menos un hijo sea izquierdo o derecho devuelve true
    public boolean isInternal(nodo<T> n) {
        return !isLeaf(n);
    }

    // muestra primero a los padre y despues a los hijos
    public void preorden(nodo<T> n) {
        if (n != null) {
            System.out.print(n.toString());
            preorden(n.getHijoIzquierdo());
            preorden(n.getHijoDerecho());
        }
        /*
         * Explicacion:
         * primero imprimer el padre que en el primer caso seria el root,
         * despues recorre a la izquierda, con la recursividad regresa
         * e imprime el vaLor en el que se quedo y asi asta que n == null.
         * 
         * es decir imprime primero y despues recorre.
         */
    }

    // acomoda el arbol en forma ordenada
    public void inorden(nodo<T> n) {
        if (n != null) {
            inorden(n.getHijoIzquierdo());
            System.out.print(n.toString());
            inorden(n.getHijoDerecho());
        }
        /*
         * Explicacion:
         * primero recorre las todos los nodos acomodados a la izquierda
         * de la raiz, imprime el ultimo que esta en la izquierda
         * ya comprobando que no tiene hijos ni derechos ni izquierdos,
         * despues sigue con el anterior, comprueba si ese anterior
         * tiene hijos derechos, si no los tiene imprime el nodo.
         * ahora si tuviera hijos seguiria hacia la izquierda asta que sea
         * null.
         * 
         * en pocas palabras todos los nodos los imprime de izquierda
         * a derecha.
         */
    }

    // acomoda el arbol primero mostrando a los hijos despues a los padres
    public void postorden(nodo<T> n) {
        if (n != null) {
            postorden(n.getHijoIzquierdo());
            postorden(n.getHijoDerecho());
            System.out.print(n.toString());
        }
        /*
         * Excplicacion:
         * primero llega al final de los nodos izquierdos, comprueba si
         * ese ultimo nodo izauierdo tiene hijos derechos si los tiene
         * sigue asta toparse con su ultimo nodo derecho lo imprime, entonces
         * comprueba si tiene hijos izquierdos, si los tien pasa lo anterior.
         * ahora cuando se cumple todo eso es decir ya no hay mas
         * hijos de la raiz a la izquierda por imprimir vuelve a la raiz principal y la
         * imprime, es decir primero imprime a los hijos izquierdos de la raiz,
         * despues pasa a imprimir el nodo padre de todos es decir el root,
         * despues pasa a los hijos derechos de la raiz y pasa el proceso
         * similar con la raices derechas del nodo prinicpal.
         * 
         * en pocas palabras primero imprime a todos los hijos de la izquierda en orden,
         * despues se imprime asi mismo y por ultimo pasa a imprimir a todos los
         * hijos de la derecha y se para el programa-
         */
    }

    // recursivo
    public nodo<T> add(nodo<T> origen, T elemento) {
        // origen es root
        // se cre un nodo
        nodo<T> nodo = null;
        if (root == null) {// si detecta que el root no existe
            nodo = new nodo<T>(elemento);// inicializa el elemento al nodo
            root = nodo;// y lo iguala lo que significa que es el primero que añadimos
        } else if (origen == null)// si el origen es null...
            throw new NullPointerException();
        else {// pero si ya hay un root
              // el metodo compareto returna un numero mayor que cero si
              // el elemento que se quiere agregar es menor a el de el nodo
              // origen.
            if (origen.getElemento().compareTo(elemento) > 0) {
                if (origen.getHijoIzquierdo() != null)
                    nodo = add(origen.getHijoIzquierdo(), elemento);
                else {
                    nodo = new nodo<T>(elemento, origen);
                    origen.setHijoIzquierdo(nodo);
                }
                /*
                 * Explicacion:
                 * comprueba primero si el origen es mayor que el elemento
                 * a ingresar, si lo es entonces pasa al siguiene.
                 * si es el nodo izquierdo del origen esta vacio pasa a el else
                 * en el else se inicializa el nuevo nodo con el elemento y el
                 * padre de el, que en este caso seria el origen y se establece
                 * como el padre y por ultimo hijo izquierdo de origen seria
                 * el nuevo nodo creado.
                 * falto por mencionar que pasa si el hijo izquierdo del origen
                 * no esta vacio, pues con la recursividad establece a el hijo
                 * izquierdo como nuevo origen y tambien se pasa el elemento para
                 * evitar perderlo.
                 * 
                 * en pocas palabras primero se busca un espacio en el cual agregarlo
                 * si se puede agregar en el hijo izquierdo del origen se añade
                 * de lo contrario se vuelve a repetir el proceso asta encontrar un lugar.
                 */
            } else {
                if (origen.getHijoDerecho() != null)
                    nodo = add(origen.getHijoDerecho(), elemento);
                else {
                    nodo = new nodo<T>(elemento, origen);
                    origen.setHijoDerecho(nodo);
                }
                /* aqui es literal lo mismo pero hacia la derecha */
            }
            /*
             * falto por recalcar el primer if.
             * lo unico que compara es si el elemento que queremos
             * agregar es menot a el origen, que al principio seria
             * el root, entonces seria para saber hacia que zona del
             * arbol se tiene que ir el nuevo nodo.
             * 
             * cabe recalcar que cuando se aplica la recursividad
             * se compara si ese elemento es mayor o menor, entonces
             * no es que siempre el nodo vaya a moverse hacia la derecha,
             * sino compara asta encontrar el mejor lugar.
             */
        }

        return nodo;
    }

    // iterativo
    public nodo<T> add(T elemento) {
        // se crea un nodo nuevo y se iguala a null
        nodo<T> nodo = null;

        // si la raiz principal es null enonces
        // se asigna el elemento digitado a la raiz principal
        if (root == null) {
            root = new nodo<T>(elemento);
        } else {// sino...
            var aux = root;// root se guarda en el aux
            // se crea una "Bandera" para indicar si...
            var insertado = false;// ya se encontro un lugar a el elemento
            while (!insertado) {// mientras sea falso sigue sino sale

                if (aux.getElemento().compareTo(elemento) > 0) {

                    if (aux.getHijoIzquierdo() != null)
                        aux = aux.getHijoIzquierdo();// diferencia
                    else {
                        nodo = new nodo<T>(elemento, aux);// diferencia
                        aux.setHijoIzquierdo(nodo);
                        insertado = true;
                        return nodo;
                    }

                } else {

                    if (aux.getHijoDerecho() != null)
                        aux = aux.getHijoDerecho();// diferencia
                    else {
                        nodo = new nodo<T>(elemento, aux);// diferencia
                        aux.setHijoDerecho(nodo);
                        insertado = true;
                        return nodo;
                    }

                }
                /*
                 * cuando no se usa la recursividad
                 * se guardan los elementos en variables para que se
                 * pueda usar cuando vuelve a ejecutarse el bucle.
                 * el bucle sustituyendo a la recursivida.
                 */
            }
        }
        return null;
        /*
         * en esencia es lo mismo que el anterior con la unica
         * diferencia de que ya no se usa recursividad
         * y la recursividad seria cambiada por un while.
         */
    }

    // altura con respecto al nodo ingresado
    public int altura(nodo<T> n) {
        int height = 0;// se crea para guardarlo como iterador

        // si es interno osea tiene como minimo un hijo...
        if (!isInternal(n)) {
        } else {
            if (n.getHijoIzquierdo() != null) {// si tiene un hijo izquierdo
                height = Math.max(height, altura(n.getHijoIzquierdo()));
            }

            if (n.getHijoDerecho() != null) {// si tiene un hijo derecho
                height = Math.max(height, altura(n.getHijoDerecho()));
            }

            height++;
        }
        return height;
    }

    public int profundidad(nodo<T> n) {
        var aux = n;
        var i = 0;

        while (aux != null)
            if (root == aux)
                return i;
            else {
                aux = aux.getPadre();
                i++;
            }

        /*
         * simplemente se itera asta encintrar
         * el elemento y esa seria su profundidad
         * porque recordemos.
         * la profundidad se cuenta de arriba a abajo.
         * la altura se cuenta de abajo hacia arriba.
         */

        return 0;
    }

    // remueve los nododos deseados
    public void remove(nodo<T> n) {
        if (root == null) {
        } else if (isLeaf(n)) {
            removeLeaf(n);
        } else if (n.getHijoDerecho() != null && n.getHijoIzquierdo() == null) {
            removeInternal(n, ONE_NODE_RIGHT);
        } else if (n.getHijoDerecho() == null && n.getHijoIzquierdo() != null) {
            removeInternal(n, ONE_NODE_LEFT);
        } else {
            removeInternal(n, TWO_NODES);
        }
        /*
         * simplemente llama a los otros metodos dependiendo de:
         * 1.- si es una hoja, llama a removeLeaf
         * 
         * 2.- si el nodo tiene el hijo derecho pero no el izquierdo.
         * 3.- si el nodo tiene el hijo izquierdo pero no el derecho.
         * 4.- si tiene los dos hijos.
         * 
         * 2.- llama a removeInternal con el nodo a remover y el tipo de nodo en este
         * caso 1
         * 3.- llama a removeInternal con el nodo a remover y el tipo de nodo en este
         * caso 2
         * 4.- llama a removeInternal con el nodo a remover y el tipo de nodo en este
         * caso 3
         */
    }

    // remover hoja
    private void removeLeaf(nodo<T> n) {
        if (isRoot(n)) {// si es la raiz principal...
            root = null;// simplemente se elimina considerando de que no tiene hijos
        } else if (isLeaf(n)) {// si no lo es y si es una hoja...
            var padre = n.getPadre();
            // se crea una variable con el padre del nodo a eliminar

            // si el hijo izquierdo es el que se quiere eliminar...
            if (padre.getHijoIzquierdo() == n) {
                // se elimina su conexion con el padre
                padre.setHijoIzquierdo(null);
            }

            if (padre.getHijoDerecho() == n)// igual pero con el derecho
                padre.setHijoDerecho(null);

            // por ultimo se elimina el nodo que se queria eliminar
            // ya que primero se elimina los lazos con el padre
            // despues se elimina el nodo.
            // para evitar que el lazo del padre apunte a null.
            n = null;
        }
    }

    // se remueve un nodo con hijos y multiples nietos
    private void removeInternal(nodo<T> n, int tipoNodo) {// se pide cuantos hijos tiene
        nodo<T> siguiente = null;// se crea un nodo que es el sigiente al nodo n
        var band = false;

        switch (tipoNodo) {
            case ONE_NODE_LEFT:// hijo izquierdo
                siguiente = n.getHijoIzquierdo();
                /*
                 * simplemente se considera que si n
                 * tiene solo un hijo y es el izquierdo
                 * simplemente el siguiente se considera
                 * ese unico hijo.
                 */
                break;

            case ONE_NODE_RIGHT:// hijo derecho
                siguiente = minSubTree(n.getHijoDerecho());
                /*
                 * con el metodo minSubTree se busca el nodo
                 * menor de el hijo derecho de n en este caso.
                 * si no encuenta un nodo izquierdo simplemente
                 * returna el mismo hijo derecho.
                 * esto se hace con el fin de poder reordenar bien
                 * el arbol.
                 * 
                 * para entenderlo mejor.
                 * tenemos el siguiente arbol
                 *     8
                 *     \
                 *     10
                 *    / \
                 *   9 12
                 *      \
                 *      20
                 *     / \
                 *    14 30
                 *   / \
                 *  13 16
                 *    /
                 *  15
                 * si deceamos eliminar el 12 seguiria los siguientes pasos.
                 * -se tomaria el hijo derecho en este caso 20
                 * -se llegaria asta el ultimo nodo izquierdo de 20 en este caso 13
                 */
                break;

            case TWO_NODES:// ambos hijos
                //como en el ejemplo anterior hace lo mismo 
                siguiente = minSubTree(n.getHijoDerecho());

                //sino es root no pasa nada
                if (isRoot(siguiente.getPadre())) {
                }else{//si es root...
                    /*
                     * si en este caso queremos eliminar el 10 pasaria lo siguiente
                     * 
                     *     8
                     *     \
                     *     10
                     *    / \
                     *   9 12
                     *      \
                     *      20
                     *     / \
                     *    14 30
                     *   / \
                     *  13 16
                     *    /
                     *  15
                     * 
                     * -buscamos el numero mas a la izquierda de 10 en este caso 9 se iguala a siguiente.
                     * -si siguiente es root no pasa mada pero si no lo es...
                     * -el hijo izquierdo de n = 9, entonces su padre se establece como siguiente.
                     * -lo mismo pero con el hijo derecho.
                     * -si el padre de siguiente y su hijo izquierdo = 9, si es igual a siguiente.
                     *  -entonces se establece que 10 ya no es padre de 9.
                     * -sino lo mismo pero con el derecho
                     *  -lo mismo pero con el derecho
                     * 
                     * por ultimo pasa una bandera = true.
                     */
                    n.getHijoIzquierdo().setPadre(siguiente);
                    n.getHijoDerecho().setPadre(siguiente);

                    if (siguiente.getPadre().getHijoIzquierdo() == siguiente)
                        siguiente.getPadre().setHijoIzquierdo(null);
                    else if (siguiente.getPadre().getHijoDerecho() == siguiente)
                        siguiente.getPadre().setHijoDerecho(null);
                    band = true;
                }
                break;
        }

        //si entro en el caso 3 ya no entra a el else
        if (band) {
        } else {
            if (siguiente.getPadre().getHijoIzquierdo() == siguiente)
                siguiente.getPadre().setHijoIzquierdo(null);
            else if (siguiente.getPadre().getHijoDerecho() == siguiente)
                siguiente.getPadre().setHijoDerecho(null);
            /*
             * usando el ejemplo de el caso 2.
             * 
             * -si el hijo izquierdo del padre de siguiente = 13 es igual a siguiente = 13
             *  -entonces el hijo izquierdo del padre del siguiente se establece como null.
             * -sino seria lo mismo pero con derecha.
             *  -lo mismo pero con hijo derecho
             * 
             * esto para evitar que 14 siga pensando que su hijo es 13.
             * ya que con lo siguiente los lazos de 13 se ven afectados,
             * pero en cambio los lazos de 14 no, por lo que se tiene
             * que establecer que 14 ya no tienes hijos.
             */
        }

        //el padre de siguiente se establece como 
        //el padre de n, con el ejemplo anterior
        //el padre de siguiente seria 10
        siguiente.setPadre(n.getPadre());

        if (isRoot(n)) {//si en es la raiz principal...
            root = siguiente;//simplemente siguiente es root
        } else {//sino
            if (n.getPadre().getHijoIzquierdo() == n)
                n.getPadre().setHijoIzquierdo(siguiente);
            else if (siguiente.getPadre().getHijoDerecho() == n)
                n.getPadre().setHijoDerecho(siguiente);    
            /*
             * usando el ejemplo anterior. 
             * -si el hijo izquierdo del padre de n = null es igual a n = 10.
             *  -entonces el padre de n = 8 su nuevo hijo izquierdo es sigiente = 10.
             *  -pero como no se cumple
             * -sino si el hijo izquierdo del padre de n = 10 es igual a n = 10
             *  -entonces el padre n = 8 su nuevo hijo derecho es sigiente = 12.
             */
        }

        //si el hijo derecho de n = 12 es diferente de null y el hijo derecho n es diferente de siguiente = 12
        if (n.getHijoDerecho() != null && n.getHijoDerecho() != siguiente)
            siguiente.setHijoDerecho(n.getHijoDerecho());
            //se establece que el hijo derecho de siguiente es el hijo derecho de n.
        if (n.getHijoIzquierdo() != null && n.getHijoIzquierdo() != siguiente)
            siguiente.setHijoIzquierdo(n.getHijoIzquierdo());
            //se establece que el hijo izquierdo de siguiente es el hijo izquierdo de n = 9.

        n = null;//por ultimo se iguala a null para eliminar el nodo.
        /*
         * n = nodo a eliminar, siguiente = es el nodo mas a la izquierda de el siguiente nodo derecho.
         * para entenderlo:
         * 1.-se busca el ultimo hijo izquierdo de siguiente.
         * 2.-se reasignan los hijos de n a siguiente
         * 3.-se asigna el padre de n a siguiente.(siguiente se relaciona con el padre de n)
         * 4.-ahora el padre se relaciona con el hijo es decir con siguiente
         * 5.-si el n tiene hijos se le asignan ahora a siguiente.
         * 6.-por ultimo se elimina el nodo.
         * en resumen: se busca el nodo menor del siguiente nodo derecho, se reasignan
         * los hijos a el nuevo, al nuevo se le reasigna el padre, el padre lo relacionamos
         * con el nuevo, si el que hibamos a eliminar tiene hijos se le reasiganan a el nuevo,
         * y por ultimo el a eliminar se elimina.
         * es una simple reconeccion de nodos.
         */
    }

    public nodo<T> minSubTree(nodo<T> nodo) {
        // si es uno en algun caso salta para evitar errores
        if (nodo != null && nodo.getHijoIzquierdo() != null) {
            while (!isLeaf(nodo)) {// mientras que sea diferente de una hoja
                nodo = minSubTree(nodo.getHijoIzquierdo());// agarra el nodo mas a la izquierda
            }
        }
        /*
         * en resumen el metodo agarra el nodo mas inclinado a
         * la izquierda del nodo derecho del que yo quiero eliminar.
         */
        return nodo;
    }
}
