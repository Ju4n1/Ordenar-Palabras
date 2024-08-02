package TDALista;

import java.util.*;
/**
 * Clase ElementIterator implenta Iterador
 * 
 * @author Juan Cruz Feuilles
 *
 * @param <E>
 */
public class ElementIterator<E> implements Iterator<E> {

	
private PositionList<E> list;
private Position<E> cursor;


/**
 * Crea un nuevo elemento iterador en base a una lista y lo prepara el cursor para recorrerla si es posible.
 * @param l lista a la cual se querra recorer.
 * @throws EmptyListException cuando la lista esta vacia.
 */
public ElementIterator(PositionList<E>l)throws EmptyListException{
	list=l;
	if(list.isEmpty())
		cursor=null;
	 else
		cursor=list.first();}


/**
 * Consulta si el cursor tiene elemento.
 */
public boolean hasNext(){
	
return cursor!=null;}


/**
 * Retorna el elemento del cursor y lo situa en el siguiente elemento.
 * @return elemento que se encuentra en el cursor.
 * @throws NoSuchElementException se lanza cuando el cursor es nulo.
 */

public E next() throws NoSuchElementException {
	   if ( cursor == null )
		   throw new NoSuchElementException ("no tiene siguiente");
	   E toReturn = cursor.element();
try {
	if (cursor == list.last())
		cursor = null;
	else
		cursor = list.next(cursor);} 
catch (EmptyListException | InvalidPositionException| BoundaryViolationException e) {e.printStackTrace();}
return toReturn;}



public void remove(){}

}
