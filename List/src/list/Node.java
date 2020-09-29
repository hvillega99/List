package list;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CDHTN
 */
public class Node<E> {
    private E content;
    private Node<E> next;

    public Node(E content, Node<E> next) {
        this.content = content;
        this.next = next;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "content=" + content + ", next=" + next + '}';
    }
    
    
    
}
