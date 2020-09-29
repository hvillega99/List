/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author CDHTN
 * @param <E>
 */
public class ListNode<E> {
    private E content;
    private ListNode<E> next;
    private ListNode<E> previous;
    
    public ListNode(){
        content=null;
        next=null;
        previous=null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<E> previous) {
        this.previous = previous;
    }
    
    
}
