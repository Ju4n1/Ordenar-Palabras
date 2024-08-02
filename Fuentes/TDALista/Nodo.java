package TDALista;
/**
 * Clase Nodo implementa a la calse Position.
 * 
 * @author Juan Cruz Feuilles.
 *
 * @param <E> parámetro genérico de clase.
 */
public class Nodo<E> implements Position<E> {

/**
 * Atributos de clase.
 * 
 */
private E elemento;
	
private Nodo<E> siguiente;	
	
/**
 * Crea un nuevo nodo asociandole un elemento y un nodo siguiente..
 * @param elemento elemento asociado al nodo.
 * @param siguiente nodo siguiente al nodo creado.
 */
public Nodo(E elemento, Nodo<E> siguiente){
	 
	 this.siguiente=siguiente;
	 this.elemento=elemento;}

/**
 * Crea un nuevo nodo con un elemento asociado cuyo nodo siguiente es nulo.
 * @param elemento elemento asociado al nodo.
 */
public Nodo(E elemento){
	
	this.elemento=elemento;
	     siguiente=null;}
/**
 * Crea un nuevo nodo cuyo elemento es nulo y su nodo siguiente tambien es nulo.
 */
public Nodo(){
	elemento=null;
	siguiente=null;}

public E element(){
	 
	return elemento;}
/**
 * Retorna el elemento siguiente del nodo.
 * @return elemento siguiente.
 */

public Nodo<E> getSiguiente(){
	       
	        return siguiente;}

/**
 * Actualiza el elemento asociado al nodo.
 * @param item nuevo elemento.
 */
public void setElement(E item){
	            
	            elemento=item;}

/**
 * Actualiza el nodo siguiente del nodo.
 * @param sig nuevo nodo siguiente.
 */

public void setSiguiente(Nodo<E> sig){
	
	       siguiente=sig;}

}
