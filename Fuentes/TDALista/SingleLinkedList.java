package TDALista;

import java.util.Iterator;
/**
 * Clase SingleLinkedList impelemta la Interfaz PositionList
 * @author Juan Cruz Feuilles
 *
 * @param <E> parámetro genérico de clase.
 */

public class SingleLinkedList<E> implements PositionList<E>{

private int tamaño;

private Nodo<E> cabeza;
	

/**
 * Crea una nueva lista simpplemente enlazada vacio con cabeza nula.
 */

public SingleLinkedList(){
	    tamaño=0;
	   cabeza=new Nodo<E>();}



public int size(){
	return tamaño;}

public boolean isEmpty(){
	return tamaño==0;}



public Position<E> first()throws EmptyListException{
	if (isEmpty())
     throw new EmptyListException("La lista está vacia:::::::::::::::::::Lista.first()");
	return cabeza;}



public Position<E> last()throws EmptyListException{
	Nodo<E> toReturn=null;
	if(isEmpty())
		throw new EmptyListException("La lista está vacia:::::::::::::::Lista.last()");
    if(size()==1)
    	toReturn=cabeza;
    else{
         Nodo<E>nod=cabeza;
         while (nod.getSiguiente()!=null)
    	 nod=nod.getSiguiente();
         toReturn=nod;                                 
         }
return toReturn;}



public Position<E> prev(Position<E>p)throws InvalidPositionException,BoundaryViolationException{
	    Nodo<E>nodo=checkPosition(p);
	    if(cabeza==nodo)
	 	  throw new BoundaryViolationException("no existe una posicion previa a la cabeza de la lista");
        Nodo<E>nodoAux=cabeza;
        while(nodoAux.getSiguiente()!=nodo&&nodoAux.getSiguiente()!=null)
        	   nodoAux=nodoAux.getSiguiente();
        if(nodoAux==null)
        	throw new InvalidPositionException("la posicion no pertenece a la lista:::::::::::::Lista.prev(p)");
return nodoAux;}
	


public Position<E> next(Position<E>p)throws InvalidPositionException,BoundaryViolationException{
            Nodo<E>nodo=checkPosition(p);
            if(nodo.getSiguiente()==null)
	           throw new BoundaryViolationException("la posicion no pertenece a la lista::::::::::::::Lista.next(p)");
return nodo.getSiguiente();}



public void addFirst(E element){
	Nodo<E>nuevo=new Nodo<E>(element);
	if(isEmpty())
	    cabeza=nuevo;
	else{
		nuevo.setSiguiente(cabeza);
	    cabeza=nuevo;}
tamaño++;}



public void addLast(E element){
	Nodo<E>nuevo=new Nodo<E>(element);
	if(isEmpty())
		cabeza=nuevo;
	else{
 	     Nodo<E>nod=cabeza;
 	     while(nod.getSiguiente()!=null)
 	    	  nod=nod.getSiguiente();
 	     nod.setSiguiente(nuevo);}
tamaño++;}


public void addBefore(Position<E> p, E e )throws InvalidPositionException {
          Nodo<E> n = checkPosition(p);

try{          
          if( p == first()) 
	           addFirst(e);
          else {
                Nodo<E> anterior = (Nodo <E>) prev(p);
                Nodo<E> nuevo = new Nodo<E>( e, n );
                anterior.setSiguiente( nuevo );
                tamaño++;}
    }
catch(EmptyListException e1){System.out.println(e1.getMessage());}
catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
}




public void addAfter(Position<E>p, E element)throws InvalidPositionException{
       
	   if(isEmpty())
		   throw new InvalidPositionException("la lista está vacia::::::::::::::Lista.addAfter(p,e)");

	   Nodo<E>nodo=checkPosition(p);
       Nodo<E>nuevo=new Nodo<E>(element);
       nuevo.setSiguiente(nodo.getSiguiente());
       nodo.setSiguiente(nuevo);
 tamaño++;}



public E remove(Position<E>p)throws InvalidPositionException{
       if(isEmpty())
    	   throw new InvalidPositionException("no se puede eliminar una posicion de una lista vacia");
       Nodo<E>nodo=checkPosition(p);
       E aux=p.element();
       if( nodo == cabeza )
    	   cabeza = cabeza.getSiguiente();
    	   else try{
    	        Nodo<E> anterior = (Nodo<E>) prev(p);
    	        anterior.setSiguiente( nodo.getSiguiente());
    	           }
                catch(BoundaryViolationException e1){System.out.println(e1.getMessage());}
tamaño--;
return aux;}



public E set(Position<E>p, E e)throws InvalidPositionException{
	    if(isEmpty())
	    	throw new InvalidPositionException("no se puede reemplazar el elemento de una posicion en una lista vacia");
	    Nodo<E>nodo=checkPosition(p);
	    E toReturn=nodo.element();
        nodo.setElement(e);
return toReturn;}


public Iterable<Position<E>> positions(){
	PositionList<Position<E>>list=new SingleLinkedList<Position<E>>();
	try{
		if(!isEmpty())
		    {Position<E>pos=first();
		     while(pos!=last()){
			     list.addLast(pos);
		         pos=next(pos);}
		    list.addLast(pos);}
	    }
	catch(EmptyListException e1){System.out.println(e1.getMessage());}
	catch(BoundaryViolationException e2){System.out.println(e2.getMessage());}
	catch(InvalidPositionException e3){System.out.println(e3.getMessage());}
	
return list;}


public Iterator<E> iterator(){
	try{
		return new ElementIterator(this);
		   }
		catch(EmptyListException e){e.printStackTrace();}
		return null;}




/**
 * Checkea que la posicion pasada por parámetros no sea nula y que sea una posicion válida para una lista. 
 * @param p posicion.
 * @return si la posicion es valida la retorna como un nodo.
 * @throws InvalidPositionException en caso que la posicion sea nula o que no corresponda a una posicion válida de lista simplemente enlazada.
 */

private Nodo<E> checkPosition( Position<E> p )throws InvalidPositionException {
           try {
                if( p == null ) 
	              throw new InvalidPositionException( "La posicion es nula" );
           return (Nodo<E>) p;
                } 
           catch(ClassCastException e) {
           throw new InvalidPositionException( "Error casteo la posicion no corresponde a una lista simplemente enlazada" );}
} 


}
