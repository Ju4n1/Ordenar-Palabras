package TDAColaConPrioridad;


/**
 * La siguiente interfaz modela la implementación de una cola con prioridad segun la cátedra Estructuras de datos(UNS)
 * @author Juan cruz Feuilles.
 *
 * @param <K> parámetro genérico.
 * @param <V> parámetro genérico.
 */
public interface PriorityQueue<K,V> {

/**
 * Rertorna la cantidad de elemento que posee la cola con prioridad.	
 * @return entero correspondiente a la cantidad de elementos que posee la cola.
 */
	
public int size();

/**
 * Consulta si la cola con prioridad esta vacia.
 * @return verdadero si la cola esta vacia falso si no lo está.
 */
public boolean isEmpty();
	

/**
 * Retorna la menor entrada de la cola con prioridad.
 * @return entrada minima.
 * @throws EmptyPriorityQueueException
 */

public Entry<K,V> min()throws EmptyPriorityQueueException;
	
/**
 * Crea una nueva entrada con una clave y un valor resivido y lo inserta en la cola.
 * @param k clave de la nueva entrada.
 * @param v valor de la nueva entrada.
 * @return entrada insertada.
 * @throws InvalidKeyException si la clave es nula.
 */
public Entry<K,V> insert(K k, V v)throws InvalidKeyException;
	
/**
 * Dada un cola con prioridad retorna y remueve el menor elemento.
 * @return entrada minima.
 * @throws EmptyPriorityQueueException si la cola con prioridad está vacia.
 */
public Entry<K,V> removeMin()throws EmptyPriorityQueueException;




}
