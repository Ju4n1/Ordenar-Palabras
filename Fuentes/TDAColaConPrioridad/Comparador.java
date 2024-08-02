package TDAColaConPrioridad;
/**
 * Clase Comparador implementa al comparador de java.
 * 
 * @author Juan Cruz feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */
public class Comparador<E> implements java.util.Comparator<E> {

	/**
	 * Compara dos elementos genéricos. 
	 * @param o1
	 * @param o2
	 * @return <0 si o1 es mayor a o2, <0 si o1 es menor que o2, 0 si o1 es igual o o2 
	 */
	public int compare(E o1, E o2) {
		
		return ((Comparable<E>) o1).compareTo(o2);
	}
	
}

