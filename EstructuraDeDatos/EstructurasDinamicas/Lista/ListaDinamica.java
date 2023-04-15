package EstructuraDeDatos.EstructurasDinamicas.Lista;

public class ListaDinamica<T> {
    private Nodo<T> primero;//primero en la lista
    private Nodo<T> ultimo;//ultimo en la lista
    private int tamaño;//tamaño de la lista

    public boolean isEmpty() {//returna si esta vacia o no
        return (this.tamaño == 0);
    }

    public int size() {//returna el tamaño de la lista
        return this.tamaño;
    }

    public T get(int index) {//obtiene la posicion ingresada
        //si esta vaicia || el idndex ingresado es negativo || es el mismo tamaño o superior
        //returna nullo por que no se puede obtener
        if (isEmpty() || index<0 || index >= size())
            return null;
        else if(index == 0)//si ingresan el 0 returna el primer elemento
            return this.primero.getElemento();
        else if(index == tamaño-1)//si ingresa la ultima posicion returna el ultimo
            return this.ultimo.getElemento();
        else
            return getNodo(index).getElemento();//returna otra posicion entre medias
    }

    public Nodo<T> getNodo(int index) {//obtiene el nodo que el usuario ingrese
        //en base es lo mismo que lo anterior, con la unica diferencia
        //de que returna el nodo y no el elemento
        if (isEmpty() || index<0 || index >= size()) 
            return null;
        else if(index == 0)
            return this.primero;
        else if(index == tamaño-1)
            return this.ultimo;
        else{//busca el index ingresado
            var buscado = primero;//se establece el buscador en la primera posicion
            var contador = 0;//se establece en la primera posicion
            while (contador < index) {//mientras que sea menor a index
                buscado = buscado.getSiguiente();//va agregando su siguienete nodo y guardandolo en si mismo
                contador++;
            }
            return buscado;//returna el nodo buscado
        }
    }

    public T getFrist() {//obtiene el primer elemento de la lista
        //si esta vacia returna null de lo contrario returna el primer elemento
        return !(isEmpty()) ? primero.getElemento() : null;  
    }

    public T getLast() {//obtiene el ultimo elemento
        //si esta vacia returna null de lo contrario returna el ultimo elemento
        return !(isEmpty()) ? ultimo.getElemento() : null;
    }

    public T addFrist(T elemento) {//añade el elemento a la primera posicion de la lista
        Nodo<T> aux;//creamos una variable Nodo local

        if (isEmpty()) {//si esta vacia...
            aux = new Nodo<>(elemento, null);//se inicializa aux solo pasando el elemento
            this.ultimo = this.primero = aux;//el primer y ultimo elemento son iguales a aux
            //Explicacion: si tu estas en una fila y eres el primero en llegar,
            //eres el primero y el ultimo en la fila.
        }else{//de lo contrario aux se vuelve el primero, desplazando a el primer nodo anterior
            aux = new Nodo<T>(elemento, primero);
            this.primero = aux;
        }

        tamaño++;//incrementas el tamaño
        return primero.getElemento();//returna el valor ingresado
    }

    public T addLast(T elemento) {//añade el elemento a la ultima posicion de la lista
        Nodo<T> aux;//creamos una variable Nodo local

        if (isEmpty()) {//si esta vaicia la lista...
            addFrist(elemento);//se ejecuta la anterior funcion
        }else{//si no esta vacia...
            aux = new Nodo<T>(elemento, null);//como el sigiente a el ultimo es es null se inicializa asi
            ultimo.setSiguiente(aux);//como se desplazo el anterior nodo, el ultimo es aux
            ultimo = aux;//y se iguala
        }

        tamaño++;//se incrementa el tamaño
        return ultimo.getElemento();//se returna el ultimo valor
    }

    public T add(T elemento, int index){//se añade un elemento a una posicion especifica de la lista
        if (index == 0) {//si el index es 0...
            return addFrist(elemento);//se ejecuta el addFrist
        }else if(index == tamaño){//si el index es igual a el tamaño...
            return addLast(elemento);//lo añade al ultimo
            /*
             * Explicacion:
             * en una lista se cuenta de la siguiente forma:
             * valor: 1 2 3 4
             * index: 0 1 2 3
             * tamaño: 4
             * entonces si ingresas 4 seria el tamaño de la lista pero no daria
             * error porque no es una posicion existente.
             * quedaria asi:
             * valor: 1 2 3 4 5
             * index: 0 1 2 3 (4):siendo la posicion ingresada, por lo cual se convierte en el ultimo.
             * tamaño: 4
             */
            //si ingresas un valor menor a 0 || si ingresas un valor mayor o igual al tamaño.
            //returna null, ya que no existe.
        }else if(index < 0 || index >= size()){
            return null;
        }else{//si esta entre la ultima y la primera...
            var anterior = getNodo(index-1);//se ingresa el nodo anterior 
            var actual = getNodo(index);//se ingresa el acutal
            var aux = new Nodo<>(elemento, actual);//se inicializa en el actual 
            anterior.setSiguiente(aux);//y se establece en el posterior al anterior nodo.

            /*
             * Explicacion:
             * como es una poscion entre la primera y ultimo nodo, se busca la posicion,
             * en la que el nodo sera ingresada.
             * 
             * Usuario ingresa elemnto 10 y posicion 1
             * 
             * Lista = 
             *  valor: 1 (se quiere ingresar) 3
             *  posi:  0 (se quiere ingresar) 2
             * 
             * anterior = (1-1) = 0
             * actual = (1) = 1
             * 
             * aux = nuevo nodo (elemento 10 , posicion 1)
             * el siguiente nodo del anterior seria 1 y se establece como tal.
             * 
             * es como enlazar, primero se dice que actual es 1 y despues
             * se establece que el siguiente al anterior es 1.
             */
            
            tamaño++;//se aumenta el tamaño
            //se obtiene el valor del nodo buscado sabiendo que el nodo
            //ya esta en la lista
            return getNodo(index).getElemento();
        }
    }

    public boolean exist(T elemento) {//devuelve boolean si existe el elemento en la lista
        var aux = getNodo(0);//iniciamos un aux con el primer nodo de la lista

        if (isEmpty()) {//si no esta llena returna false...
            return false;//ya que no puede existir
        }else{//si esta llena...
            while (aux != null) {//mientras que aux sea diferente de null
                if (aux.getElemento() == elemento)//si el elemento es igual a el elemento buscado
                    return true;
                aux = aux.getSiguiente();
            }
            return false;//si no se encontro en la lista devuelve false
        }
    }

    public int indexOF(T elemento) {//devuelve el index anterior al elemento ingresado 
        var aux = this.primero;

        if (isEmpty())//si esta vacio...
            return -1;//devuelve -1 en señal de que no se encuentra un indexs anterior
        else{//si esta lleno...
            var i = 0;//se crea para poder contar las vueltas
            while (aux != null) {//mientras aux se adiferente de null
                if (aux.getElemento() == elemento)//si se encuentra el elemento...
                    return (i-1);//retuna el i - 1 indicando la posicion anterior a el index 
                i++;
                aux = aux.getSiguiente();//avanza al siguiente nodo
            }
            return -1;//si no seencuentra se devuelve
        }
    }

    public T removeFrist() {//quita la primera posicion
        if (isEmpty())//si esta vacia no se puede quitar nada asi que
            throw new IndexOutOfBoundsException(tamaño);
        else {//si no lo esta...
            var elemento = this.primero.getElemento();//se guarda el elemento para poder returnarlo
            var aux = this.primero.getSiguiente();//se establece como el siguiente del primero
            
            this.primero = null;//se elimina el primero
            this.primero = aux;//primero se iguala a aux
            this.tamaño--;//se decrementa

            if (size() == 1)//si el tamaño es 1...
                this.ultimo = this.primero;//el ultimo se vuelve el primero
            else if(size() == 0)//so el tamaño es 0...
                this.ultimo = null;//el ultimo se vuelve null
            
            return elemento;
        }
    }

    public T removeLast() {//remueve la ultima posicion
        if (isEmpty()) {
            return null;
        } else {
            var elemento = this.ultimo.getElemento();//se guarda el elemento
            var aux = getNodo(tamaño-2);//se guarda el nodo antepenultimo
            
            if (aux == null){// si aux == null...
                this.ultimo = null;//ultimo es null

            if (size() == 1)//comprueba si tiene un size de 1
                this.primero = null;//asi el primero tambien seria null
            else if (size() == 2)//si es 2
                this.ultimo = this.primero;//el ultimo es el primero
                /*
                 * Explicacion: 
                 * lista:
                 * eleme: 1 2 
                 * index: 0 1 
                 * 
                 * eleme:1
                 * index: 0
                 * si elimino el 1 el ultimo se vuelve el primero.
                 */
            }else{//aux no es null
                this.ultimo = aux;//el ultimo se vuelve el aux
                this.ultimo.setSiguiente(null);//y el siguiente de aux es null
            }
            
            return elemento;
        }
    }

    public T remove(int index) {//remueve una posicion elegida
        if (index >= size() || index < 0 || isEmpty())//hace comprobaciones...
            throw new IndexOutOfBoundsException(index);//para evitar el fuera de memeria
        else if(index == 0)//si es igual a 0...
            return removeFrist();//simplemente llama al removeFrist ya que vas a remover el primer index
        else if(index == size()-1)//lo mismo que el anterior pero...
            return removeLast();//con el ultimo
        else{//si no tiene errores el index
            var actual = getNodo(index);//se agarra el nodo del index digitado
            var element = actual.getElemento();//se obtiene su elemento
            var anterior = getNodo(index-1);//se consigue el nodo anterior a el actual

            actual = null;//el actual se elimina
            actual = anterior;//el anterior se vuelve el actual
            anterior.setSiguiente(getNodo(index+1));//y el siguiente nodo al index se vuelve el siguiente del actual

            /*
             * Explicacion: 
             * obtengo el nodo actual que es el que sera borrado,
             * despues consigo su elemento simplemente para que sea returnado,
             * el anterior se necesita para poder relacionar la lista
             * y evitar que se desincronize la fila (se podria con el post
             * solo se necesitaria al ultimo obtener el index-1) el codigo,
             * no se ve afectado por el -1 o +1 ya que anteriormente eliminamos
             * de la ecuacion los limites evitando que un +1 o -1 se vuelvan
             * null.
             * 
             * el actual se convierte en null para eliminarlo(es para que la 
             * papelera lo recoga y no guarde memeoria), el actual se iguala 
             * a el anterior esto para entre lazar la lista y evitar que no 
             * esten enlazadas por ultimo el anterior como no tiene un nodo 
             * siguiente establecemos que el nodo index +1 es su siguiente.
             */

            return element;
        }
    }

    public void set(T elemento,int index) {//modifica la posicion con el elemento ingresado
        if (isEmpty())
            throw new IndexOutOfBoundsException(tamaño);
        else
            getNodo(index).setElemento(elemento);
        
    }

    public String toString() {
        if (isEmpty()) {
            return null;
        }else{
            Nodo<T> aux = primero;
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