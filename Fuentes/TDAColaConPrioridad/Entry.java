package TDAColaConPrioridad;
/**
 * Interfaz Entry
 * @author Juan Cruz Feuilles.
 *
 * @param <K> par�metro gen�rico de clase.
 * @param <V> par�metro gen�rico de clase.
 */
public interface Entry<K,V> {

/**
 * 	Retorna la clave de la entrada.
 * @return clave aosciada a la entrada.
 */
public K getKey();
/**
 * Retorna el valor de la entrada.
 * @return valor asociado a la entrada.
 */
public V getValue();
	
}
