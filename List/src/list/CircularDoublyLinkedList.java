/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.ListIterator;

/**
 *
 * @author CDHTN
 * @param <E>
 */
public class CircularDoublyLinkedList<E> implements List<E> {
    
    private int length;
    private ListNode<E> last;
    
    public CircularDoublyLinkedList(){
        last= new ListNode<>();
        length=0;
    }
    

/**
  * Inserta un elemento al inicio de la lista.
  
  * @param e Elemento a insertar
  * @return true si el elemento se inserta con éxito, false si el elemento es nulo
  */
   
    @Override
    public boolean addFirst(E e) {
        
        if(e==null){
            return false;
        }else{
                             
            ListNode<E> nuevo= new ListNode<>();
            nuevo.setContent(e);
            
            if(isEmpty()){
               nuevo.setNext(nuevo);
               nuevo.setPrevious(nuevo);
               last=nuevo;
               
            }else{ 
               
               nuevo.setNext(last.getNext());
               nuevo.setPrevious(last);
               last.getNext().setPrevious(nuevo);
               last.setNext(nuevo);
                
          
    
            }
            length++;
            
           return true; 
        } 
    }
    
    
/**
  * Inserta un elemento al final de la lista.
  
  * @param e Elemento a insertar
  * @return true si el elemento se inserta con éxito, false si el elemento es nulo
  */
    

    @Override
    public boolean addLast(E e) {
        
        if(e==null){
            return false;
        }else{
            
            ListNode<E> nuevo= new ListNode<>();
            nuevo.setContent(e);
            
            if(isEmpty()){
                last=nuevo;
                last.setNext(nuevo);
                last.setPrevious(nuevo);
            }else{
              
              nuevo.setNext(last.getNext());
              nuevo.setPrevious(last);
              last.getNext().setPrevious(nuevo);
              last.setNext(nuevo);
              last=nuevo;
             
                
            }
            
           
            length++;
            return true;
        }
        
    }
    
    
/**
  * Inserta un elemento en una posición específica de la lista.
  * Si el elemento a insertar es nulo o la posición no es válida retorna una excepción.
     * @param index Posición.
     * @param element Elemento a insertar.
     * @throws java.lang.Exception
  */

    @Override
    public void add(int index, E element) throws Exception {
        
        if((index<0)||(index>length)){
            throw new Exception("Posición no válida");
        }else if(element==null){
            throw new Exception("Elemento a insertar no válido");
        }else{
            
            if(index==0){
               addFirst(element);
            }else if(index==length){
                addLast(element);
            }else{
                ListNode<E> aux=last;
                int i=0;
        
            do{
            
              aux=aux.getNext();
              if(i==index){
                break;
              }
              i++;
            
            }while(aux!=last);
        
            ListNode<E> nuevo= new ListNode<>();
            nuevo.setContent(element);
            nuevo.setNext(aux);
            nuevo.setPrevious(aux.getPrevious());
            aux.getPrevious().setNext(nuevo);
            aux.setPrevious(nuevo);
            length++;
            }
            
        }  
        
    }
    
    
/**
  * Remueve un elemento en una posición específica de la lista.
  * Si la posición no es válida retorna una excepción.
     * @param index Posición del elemento a remover.
  * @return E Elemento removido.
     * @throws java.lang.Exception
  */

    @Override
    public E remove(int index) throws Exception {
        
        if((index<0)||(index>length)){
            throw new Exception("Posición no válida");
        }else{
            
            
        ListNode<E> aux=last;
        int i=0;
        do{
            aux=aux.getNext();
            if(i==index){
                break;
            }
            i++;
        }while(aux!=last);
        
           E currentContent=aux.getContent();
      
           
           aux.getPrevious().setNext(aux.getNext());
           aux.getNext().setPrevious(aux.getPrevious());
           
       
           
  
        length--;
        return currentContent; 
            
        }
        
       
        
    }
    
    /**
  * Retorna un elemento de una posición específica de la lista.
  * Si la posición no es válida retorna una excepción.
     * @param index posición del elemento requerido
  * @return true
     * @throws java.lang.Exception
  */

    @Override
    public E get(int index) throws Exception{
        
       
        
        if((index>=0)&&(index<length)){
             int i=0;
             ListNode<E> aux=last;
       
             do{
                if(i==index){
                    aux=aux.getNext();
                    break;
                
                }
            
            
               aux=aux.getNext();
               i++;
            }while(aux!=last);
            
 
           return aux.getContent();
          
 
        }else{
            throw new Exception("Posición no válida");
        } 
    }
    
    /**
  * Inserta un elemento en una posición específica de la lista. Si en esa posición existe un elemento es reemplazado por el nuevo item.
  * Si la posición no es válida o el elemento es nulo retorna una excepción.
     * @param index Posición donde se insertará el elemento.
     * @param element Elemento a insertar.
  * @return E elemento reemplazado.
     * @throws java.lang.Exception 
  */

    @Override
    public E set(int index, E element) throws Exception {
        
        if((index<0)||(index>length+1)){
            throw new Exception("Posición no válida");
        }else if(element==null){
            throw new Exception("Elemento a insertar no válido");
        }else{
            
            E currentContent=null;
            
            if(isEmpty()){
                addFirst(element);
                
            }else if(index==length){
                addLast(element);
            }else{
                ListNode<E> aux;
            aux = last;
            int i=0;
            do{
                
                aux=aux.getNext();
                if(i==index){
                    break;
                }
                i++;
            }while(aux!=last);
            currentContent= aux.getContent();
            aux.setContent(element);
            
            
            }
          return currentContent;  
            
        }
        
    }
    
    
/**
  * Devuelve el número de elementos que contiene la lista.
  * @return int 
  */

    @Override
    public int size() {
        return length;
    }
    
    /**
  * Retorna true si la lista está vacía.
  * @return true 
  */

    @Override
    public boolean isEmpty() {
        return length==0;
    }
    
    /**
  * Elimina el contenido de la lista. 
  */

    @Override
    public void clear() {
        
       last=null;
       length=0;
        
    }

    /**
     *
     * @return
     */
    @Override
    
    /**
  * Retorna una cadena de caracteres con el contenido de la lista.
  * @return String 
  */
    
    public String toString() {
        String retorno="[";
        
        if(length!=0){
            int i=0;
            ListNode<E> aux=last;
        
            do{
            
              if(i==(length-1)){
                 retorno+=aux.getNext().getContent();
              }else{
                 retorno+=aux.getNext().getContent()+",";
              }
           
            i++;
            aux=aux.getNext();
            }while(last!=aux);
        }
      
        return "CircularDoublyLinkedList:" + retorno + "]";
    }
    
    /**
  * Retorna una instancia de ListIterator que permite recorrer la lista.
  * @return ListIterator
  */

    public ListIterator listIterator(){
        return new ListIterator(){
            
            ListNode<E> nodeNext =last.getNext();
            ListNode<E> nodePrevious=last;
            int i=0;
            int j=0;
            @Override
            public boolean hasNext() {
                return i<length;
                
            }

            @Override
            public E next() {
              
                E currentContent= nodeNext.getContent();
                  nodeNext=nodeNext.getNext();
                  i++;
                return currentContent;
            }

            @Override
            public boolean hasPrevious() {
                return j<length;
            }

            @Override
            public E previous() {
                 
                E currentContent=nodePrevious.getContent();
               nodePrevious=nodePrevious.getPrevious();
               j++;
                return currentContent;
                
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(Object e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(Object e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
    }
}
