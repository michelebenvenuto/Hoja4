import java.util.ArrayList;

/**
 * A stack that is based around an ArrayList
 * @param <E>the type of element that will be stores in hte stack
 */
public class StackArrayList<E> implements Stack<E> {
    /**
     * Stores the items inside the stack
     */
    public ArrayList<E> data;

    /**
     * Constructs a new ArrayList stack with an empty array
     */
    public StackArrayList(){
        data = new ArrayList<E>();
    }

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
