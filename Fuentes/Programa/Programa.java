package Programa;
import java.util.Comparator;
import TDALista.*;
import TDAColaConPrioridad.*;
/**
 * Clase Programa.
 * @author Juan cruz Feuilles.
 *
 */
public class Programa {

 private PriorityQueue<String,String> cola;
 

 
 /**
  * Retorna el clon de la lista que resive como parametro.
  * @param l lista a clonar.
  * @return lista nueva clonada.
  */
private PositionList<String> clonarLista(PositionList<String>l){
    PositionList<String>list=new SingleLinkedList<String>();
    
    for(Position<String> pos:l.positions())
    	list.addLast(pos.element());
 return list; }
 
/**
 * Retorna una lista ordenada de manera ascendente con los elementos de la lista pasada por paráetros, usasando una cola con prioridad.
 * @param comp comparador con el cual se comparan las claves para extableser el orden.
 * @param l lista a ordenar.
 * @return lista ordenada.
 */

 public PositionList<String> heapSort(Comparator<String> comp, PositionList<String>l){
	
	 PositionList<String>list=clonarLista(l); 
	 PositionList<String>salida=new SingleLinkedList<String>();
	 cola=new Heap<String,String>(list.size()+1,comp);
try{	
	 for(Position<String>pos: list.positions())
                 cola.insert(pos.element(),pos.element());	
	 for(int i=0; i<list.size();i++)
		 salida.addLast(cola.removeMin().getValue());
   }
 catch(EmptyPriorityQueueException e1){System.out.println(e1.getMessage());}
 catch(InvalidKeyException e2){System.out.println(e2.getMessage());}

 return salida;}
 
}
