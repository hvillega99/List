package list;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CDHTN
 * @param <E>
 */

public class LinkedList<E> implements List<E> {
    private Node<E> first; //primer elemento de la lista
    private Node<E> last; //último elemento de la lista
    private int length;  //tamaño efectivo
    
    public LinkedList(){
        length=0;
        first=null;
        last=null;
    }
    
   

    @Override
    public boolean addFirst(E e) {
        Node<E> node=new Node<>(e,first);
        if(e==null){
            return false;
        }else if(isEmpty()){
            first=last=node;
            return true;
        }else{
           
            
            first=node;
            length+=1;

            return true;
        }
    }

    @Override
    public boolean addLast(E e) {
      
         Node<E> node = new Node<>(e,null);
        if(e == null) return false;
        else if(isEmpty()){
            first = last = node;
        }
        else{
            last.setNext(node);
            last = node;
        }
           length++;
           return true;
        
    }

    /**
     *
     * @param index
     * @param element
     * @throws Exception
     */
    @Override
     public void add(int index, E element) throws Exception{
        if(index>=0 && index<=length){
             
            Node<E> nuevo = new Node<>(element,null);
            if(index==0){
                //el nodo a ingresar está al inicio
              addFirst(element);
            }else if(index==length){
                //el nodo a ingresar está al final
              addLast(element);
            }else{
               // el nodo a insertar está en medio
              Node<E>aux = first;
              for(int i = 0;i < index-1;i ++){
                aux = aux.getNext();
              }
              Node<E> siguiente = aux.getNext();
              aux.setNext(nuevo);
              nuevo.setNext(siguiente);
              length++;
            }
             
        }else{
             
              throw new Exception ( "Posición ilegal en la lista") ;  
             
        }
         
         
      
   }
  


    @Override
    public E remove(int index) throws Exception {
        if(index>=0 && index < length){
             E element=get(index);
          if(index==0){
          //El nodo a eliminar esta en la primera posicion
            first= first.getNext();
          }else{
           
            Node<E> aux = first;
            for(int i = 0 ; i < index - 1 ; i ++) {
               aux = aux.getNext();
            }
             Node<E> prox = aux.getNext();
             aux.setNext(prox.getNext());
           }
            length --;
            return element;
        }else{
            throw new Exception("Posición ilegal en la lista");
        }
    }

    @Override
    public E get(int index) throws Exception {
        if((index<=length)&&(index>=0)){
            int cont=0;
            E content=null;
            for(Node<E>n=first;n!=null;n=n.getNext()){
                if(cont==index){
                    content=n.getContent();
                    break;
                }
                cont++;
            }
            return content;
        }else{
            throw new Exception("Posición ilegal en la lista");
        }
        

    }

    @Override
    public E set(int index, E element) throws Exception {
        if(element==null){
            return null;
        }else{
            E item = get(index);
            try {
                remove(index);
            } catch (Exception ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                add(index, element);
            } catch (Exception ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
            return item;
        }
    }
    
    @Override
    public int size() {
        return length;
        
    }

    @Override
    public boolean isEmpty() {
        
        return first==null;
    }

    @Override
    public void clear() {
        last=null;
        first=null;
        length=0;
    }

    @Override
    public String toString() {
        Node<E> n=first;
        String retorno="[";
        
        while(n!=null){
            if(n.getNext()!=null){
                retorno+=n.getContent()+",";
            }else{
                retorno+=n.getContent();
            }
            
            n=n.getNext();
        }
        
        
        retorno+="]";
        return "LinkedList:" + retorno;
    }
    
    public Iterator iterator(){
       
        return new Iterator(){
            Node<E> nodo=first;
            @Override
            public boolean hasNext() {
                
               return nodo!=null; 
                
            }

            @Override
            public E next() {
                E content=nodo.getContent();
                
                nodo=nodo.getNext();
                return content;
            }
            
        };
    }
    
    
    
}
