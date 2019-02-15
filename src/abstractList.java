import java.util.List;

abstract class AbstractList<E>
       implements List<E> {

    public AbstractList()
    // post: does nothing
    {
    }

    public boolean isEmpty()
    // post: returns true iff list has no elements
    {
        return size() == 0;
    }

    public boolean contains(Object value) {
        // pre: value is not null
        // post: returns true iff list contains an object equal to value

        return -1 != indexOf(value);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        //Los tipos de lista Circular, doubleLinkedlist y simple list
        //funcionan a través de nodos y no de indices.
        return null;
    }
}