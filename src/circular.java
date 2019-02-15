/*Algnos metodos son tomados de los archivos de la clase*/

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

class CircularList<E> extends AbstractList<E>{

    private Node<E> tail;
    private int count;

    public CircularList()
            // pre: constructs a new circular list
            {
            tail=null;
            count=0;
            }

    public void addFirst(E value)
            // pre: value non-null
            // post: adds element to head of list
            {
            Node<E> temp=new Node<E>(value);
            if(tail==null){ // first value added
            tail=temp;
            tail.setNext(tail);
            }else{ // element exists in list
            temp.setNext(tail.next());
            tail.setNext(temp);
            }
            count++;
            }


    public void addLast(E value)
            // pre: value non-null
            // post: adds element to tail of list
            {
            // new entry:
            addFirst(value);
            tail=tail.next();
            }


    // lo dificil es quitar el elemento de la cola

        public E removeLast()
            // pre: !isEmpty()
            // post: returns and removes value from tail of list
            {
            Node<E> finger=tail;
            while(finger.next()!=tail){
            finger=finger.next();
            }
            // finger now points to second-to-last value
            Node<E> temp=tail;
            if(finger==tail)
            {
            tail=null;
            }else{
            finger.setNext(tail.next());
            tail=finger;
            }
            count--;
            return temp.value();
            }

    @Override
    public int size() {
        return count;
    }


    @Override
    public E get(int i) {
        Node<E> finger = tail;
        for (int j=0;j<i+1;j++){
            finger = finger.next();
        }
        return finger.value();
    }

    /*NO SE UTILIZAN ESTOS METODOS FORMAN PARTE DE LA INTERFAZ*/
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E set(int i, E e) {
        return null;
    }

    @Override
    public void add(int i, E e) {

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }
}