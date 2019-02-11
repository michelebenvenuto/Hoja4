/**
 * Interface for all objects that are Stacks
 * @param <E> the type of item that the stack will store
 */
public interface Stack<E>
{
    /**
     * Function that adds items to tje top of the stack
     * @param item item that should be placed at the top of the stack
     */
    public void push(E item);
    // pre:
    // post: item is added to stack
    // will be popped next if no intervening push

    /**
     * Function for removing the item on the top of the stack
     * @return the item on the last position of the stack
     */
    public E pop();
    // pre: stack is not empty
    // post: most recently pushed item is removed and returned

    /**
     * Gets the value of the item on top of the stack without popping it
     * @return the value of the item on top of the stack
     */
    public E peek();
    // pre: stack is not empty
    // post: top value (next to be popped) is returned

    /**
     * Gets whether the stack is empty or not
     * @return true if the stack is empty, false if it is not
     */
    public boolean empty();
    // post: returns true if and only if the stack is empty

    /**
     * Gets the number of elements on the stack
     * @return an int that is the number of elements
     */
    public int size();
    // post: returns the number of elements in the stack

}
