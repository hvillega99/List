package list;



public interface List<E> {

    public boolean addFirst(E e); // inserta el elemento e al inicio

    public boolean addLast(E e); // inserta el elemento e al final

    public void add(int index, E element)throws Exception;

    public E remove(int index)throws Exception;

    public E get(int index)throws Exception;

    public E set(int index, E element)throws Exception;

    public int size();

    public boolean isEmpty();

    public void clear();

    @Override
    public String toString();

}
