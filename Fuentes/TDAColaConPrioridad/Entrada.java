package TDAColaConPrioridad;

/**
 * Clase Entrada implementa a la interfaz Entry.
 * 
 * @author Juan cruz Feuilles.
 *
 * @param <K> parámetro genérico de la clase.
 * @param <V> parámetro genérico de la clase.
 * 
 */
public class Entrada<K,V> implements Entry<K,V> {


private K key;
private V value;

/**
 * Crea una nueva entrada.
 * @param key clave asociada a la entrada.
 * @param value valor asociado a la entrada.
 */

public Entrada(K key, V value){
	   this.key=key;
	   this.value=value;}
/**
 * Retrona la clave de la entrada.
 * @return clave asociada a la entrada.
 */

public K getKey(){
	return key;}

/**
 * Retorna el valor de la entrada.
 * @return valor asociado a la entrada.
 */
public V getValue(){
	return value;}

/**
 * Actualiza la clave de la entrada.
 * @param clave nueva clave.
 */

public void setKey(K clave){
	    key=clave;}

/**
 * Actualiza el valor de la entrada.
 * @param valor valor nuevo.
 */

public void setValue(V valor){
	value=valor;}

}