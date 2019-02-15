/**
 * A stack based around one of the list classes of the proyect
 * @param <E> the type of object that is stored on the stacklist
 */
public class StackList<E> implements Stack<E> {
    /**
     * Used to store the data
     */
    public AbstractList<E> data;

    /**
     * Constructor used to instance of a Stacklist
     * @param list the desired list that the Stack list will be based around
     */
    public StackList(AbstractList<E> list){data =list;}

    @Override
    public void push(E item) {
        data.addLast(item);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.get(size());
    }

    @Override
    public boolean empty() {
        return size()==0;
    }

    @Override
    public int size() {
        return data.size();
    }
}
