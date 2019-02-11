import java.util.Vector;

/**
 * A stack based on a vactor
 * @param <E> the type of objects that the vector will store
 */
public class StackVector<E> implements Stack<E> {
    /**
     * Stores the itmes inside the stack
     */
    public Vector<E> data;

    /**
     * Constructs a new StackVector with an empty vector
     */
    public StackVector(){data = new Vector<E>();}

    @Override
    public void push(E item) {
        data.add(item);
    }

    @Override
    public E pop() {
        return data.remove(size()-1);
    }

    @Override
    public E peek() {
        return data.get(size()-1);
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
