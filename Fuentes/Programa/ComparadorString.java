package Programa;
/**
 * Clase ComparadorString extiende a Comparator
 * 
 * @author Juan Cruz Feuilles
 *
 * @param <E>
 */
public class ComparadorString<E extends String> implements java.util.Comparator<E> {

	

/**
 * Compara dos string alfabeticamente
 * @param o1 String a comparar.
 * @param o1 String a comparar
 * @return 0 si son iguales, 1 si o1 es menor que o2, -1 si o1 es mayor que o2
 */
	
public int compare(String o1, String o2) {
   
   int salida=0;
   
   int  cant;//Cantidad de caracteres a comparar. 
    
   
   //Determina la cantidad de caractes a alalizar.
   if(o1.length()>o2.length())    
       cant=o2.length();
   else if(o1.length()<o2.length())
         cant=o1.length();
        else cant=o1.length();
	   
     boolean seguir=true;//Condicion de corte While cuando los carecteres son distintos.
     
     int i=0;//Puntero  que recorre los Sitring unos a uno.
     
     double e1,e2;//Ordinales correspondientes a los aracteres iésimos de los Strings
    
     
     
     while(i<cant&&seguir){
    	
     
    	e1=(double)o1.charAt(i);//Caracter iésimo del primer String.
    	e2=(double)o2.charAt(i);//Caracter iésimo del segundo String.
    	  
    
      if ((e1>=97)&(e1<=122))
    	  e1-=32;
        //El siguiente else introduce caracteres expesificos del castellano/español.
       else{ 
    	   
    	     //Vocales asentuadas.
    	   
    	      if(e1==225|e1==193)
                   e1=(double)'A'; 
    	      if(e1==201|e1==233)
                  e1=(double)'E';
    	      if(e1==205|e1==237)
                  e1=(double)'I';
    	      if(e1==211|e1==243)
                  e1=(double)'O';
    	      if(e1==218|e1==250)
                  e1=(double)'U';
    	              
            //Incluye la Ñ y ñ
               if(e1==209|e1==241)
            	 e1=78.1; 
             }
            
      //Repite lo hecho anteriormente con el caracter del segundo string.
      
      if ((e2>=97)&(e2<=122))
           e2-=32;
       else{  
               
    	     if(e2==225|e2==193)
    	       e2=(double)'A';
	          if(e2==201|e2==233)
                  e2=(double)'E';
	          if(e2==205|e2==237)
                   e2=(double)'I';
	          if(e2==211|e2==243)
                  e2=(double)'O';
	          if(e2==218|e2==250)
                  e2=(double)'U';
    	   
    	      if(e2==209|e2==241)
                 	 e2=78.1;
               }
          
                
       
       //Compara los caracteres de los Strings uno a uno.
      
       if(e1<e2)
           {salida=-1;
            seguir=false;}
        else
    	     if(e1>e2)
    	         {seguir=false;
    	          salida=1;}
    	      else if(e1==e2)
    	    	     salida=0;
          
       
      
        i++;}//end while
    
    //Entra cuando un String es prefijo del otro
     
      if(salida==0&o1.length()<o2.length())
	         salida=-1; 
      else if(salida==0&o1.length()>o2.length())
    	      salida=1; 
	   
return salida;}
	
}