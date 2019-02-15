

public class StackList<E> implements Stack<E> {
    //TODO revisar por cambios para utilizar las listas definidas
    public AbstractList<E> data;

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
