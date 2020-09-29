package list;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author CltControl
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
    
    private int capacity;
    private int length; //tamaño efectivo
    private E elements[];
    
    public ArrayList(){
        capacity=10;
        elements=(E[]) new Object[capacity];
        length=0;
    }
    
    private void addCapacity(){ //aumentar el tamaño a la lista
       
        E arreglo[]=(E[]) new Object[capacity*2];
        for(int i=0;i<capacity;i++){
            arreglo[i]=elements[i];
        }
        elements= arreglo;
        capacity=capacity*2;
    }
    

    @Override
    public boolean addFirst(E e) {
        
        if(e==null){
            return false;
        }else{
            if(isEmpty()){
                elements[length]=e;
             length+=1;
             return true;
            }else{
               if(length==capacity){addCapacity();}
               for(int i=0; i<length;i++){
                 elements[length-i]=elements[(length-i)-1];
               }
               elements[0]=e;
               length+=1;
               return true;
            }
        }
        
    }

    @Override
    public boolean addLast(E e) {
        if(e==null){
            return false;
        }else{
          if( capacity==length){addCapacity();}
          elements[length]=e;
          length+=1;
          return true;
        }
    }

    @Override
    public void add(int index, E element) throws Exception {
       if((index<=length)&&(element!=null)&&(index>=0)){
           if( capacity==length){addCapacity();}
           if(index<length){
               for(int i=0;i<length-index;i++){
                   elements[length-i]=elements[(length-i)-1];
               }
           }
           elements[index]=element;
           length+=1;
       }else{
           throw new Exception("Posición ilegal en la lista");
       }
           
        
    }

    @Override
    public E remove(int index) throws Exception {
        
      if((index<=length)&&(index>=0)){
            
            
        if(elements[index]==null){
            return null;
        }else{
            E object=elements[index];
            
            E arreglo[]=(E[]) new Object[capacity];
            
            int i=0,j=0;
            while(i<length){
                if(i==index){j=1;}
                arreglo[i]=elements[i+j];
                i++;
            }
            
            elements=arreglo;
            length=length-1;
            
            return object;
        }
            
      }else{
            throw new Exception("Posición ilegal en la lista");
      }
  
    }
    

    @Override
    public E get(int index)throws Exception{
       if((index>length)||(index<0)){
           throw new Exception("Posición ilegal en la lista");
       }else{
           return elements[index];
       }
    }

    @Override
    public E set(int index, E element)throws Exception {
        if(element==null){
            throw new Exception("Elemento ingresado no válido");
        }else if((element==null)||(index>length)||(index<0)){
            throw new Exception("Posición ilegal en la lista");
        }else{
            E item= elements[index];
             elements[index]=element;  
             return item;
        }
   
    }
      

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public void clear() {
        capacity=10;
        elements=(E[]) new Object[capacity]; 
        length=0;
    }

    @Override
    public String toString() {
        
        String retorno="[";
        
        
        for(int i=0;i<length;i++){
            if(i!=length-1){
               retorno+= elements[i]+","; 
            }else{
               retorno+=elements[i]; 
            }
        }
        
        retorno+="]";
        
        return "ArrayList:"+retorno;
    }
    
    public Iterator<E> iterator(){
        
        return new Iterator<E>(){
            int pos=0;
            @Override
            public boolean hasNext() {
                return pos<length;
            }

            @Override
            public E next() {
                return elements[pos++];
            }
            
        };
    }
    
    
    
}
