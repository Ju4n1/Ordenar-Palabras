package TDAColaConPrioridad;

/**
 * 
 * @author Juan Cruz Feuilles
 *
 * @param <K> parámetro genérico de clase.
 * @param <V> parámetro genérico de clase.
 */

import java.util.Comparator;

public class Heap<K,V> implements PriorityQueue<K,V> {

private Entrada<K,V>[]elements;
private  Comparator<K> comp;
private int size;

/**
 * Crea una nueva cola con prioridad.
 * @param maxElem elementos máximos de la cola creada.
 * @param comp comparador de la cola.
 */

public Heap(int maxElem, Comparator<K>comp){
	   this.comp=comp;
	   elements=(Entrada<K,V>[])new Entrada[maxElem];                               
         size=0;                                  }

public int size(){
	return size;}


public boolean isEmpty(){
	return size==0;}


public Entry<K,V> min()throws EmptyPriorityQueueException{
	    if(isEmpty())
	    	throw new EmptyPriorityQueueException("no se puede obtener el elemento mínomo de una cola con prioridad esta vacia");

return  elements[1];}


public Entry<K,V> insert(K key, V value)throws InvalidKeyException{
	    
	   if (key==null)
	    	throw new InvalidKeyException("la clave ingresada es nula");
	    
	    Entrada<K,V>entrada=new Entrada(key,value);
	    
	    elements[++size]=entrada;
	    //Burbujeo hacia arriba
	    int i=size;
	    boolean seguir=true;
	   
	    while(i>1&&seguir){
	    	 
	    	  Entrada<K,V>elementoActual=elements[i];
	    	  Entrada<K,V>elementoPadre=elements[i/2];
	    	 
	    	 if(comp.compare(elementoActual.getKey(),elementoPadre.getKey())<0)
	    	     {Entrada<K,V>aux=elements[i];
	    		  elements[i]=elements[i/2];
	    		  elements[i/2]=aux;
	    		  i/=2;}
	    	 else seguir =false;
	    }
return entrada;}



public Entry<K,V> removeMin()  throws EmptyPriorityQueueException {
                 Entry<K,V> entrada = min(); // Salvo valor a retornar.
                     if( size == 1 )   
                       {elements[1] = null;   
                           size = 0;}
                     else {
                           // Paso el último a la raiz y lo borro del final
                           elements[1] = elements[size];    
                           elements[size] = null;   
                           size--;
                           // Burbujeo la raiz hacia abajo.
                           int i = 1;  // Estoy parado en la raiz
                           boolean seguir = true;
                           int m=1;//creo e inicializo m que representara al menor hijo de i
                           while ( seguir )  {// Calculo la posicion de los hijos.
                                    int hi = i*2;            
                                    int hd = i*2+1;
                                    boolean tieneHijoIzquierdo = hi <= size();        
                                    boolean tieneHijoDerecho = hd <= size();
                            
                                    if( !tieneHijoIzquierdo )   
                            	         seguir = false;
                                    else {
                                
                            	   
                                           if( tieneHijoDerecho )   
                                              {  // Calculo cual es el menor de los hijos.
                                	     
                                                 if(comp.compare( elements[hi].getKey(),  elements[hd].getKey()) < 0 )   
                                            	     m = hi; 
                                                  else m = hd;
                                                }    
                                            else m = hi;}
                                      //Me fijo si hay que intercambiar el actual con el menor de sus hijos.
                          
                                      if( comp.compare(elements[i].getKey(), elements[m].getKey()) > 0 )   
                                              {
                                               Entrada<K,V> aux = elements[i];
                                               elements[i] = elements[m];
                                               elements[m] = aux;
                                                i = m;  // Ahora actualizo a partir de m.
                                               }   
                                      else seguir = false;
                                                }
                          }
return entrada;}



}
