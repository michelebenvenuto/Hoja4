import java.util.List;

public class StackList<E> implements Stack<E> {
    //TODO revisar por cambios para utilizar las listas definidas
    public List<E> data;

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
