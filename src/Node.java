/**
 * Simple node used for the circular and simple linked list
 * @param <E> type of object the node will be stored on the node
 */
class Node<E>{
   protected E data; // value stored in this element
   protected Node<E> nextElement; // ref to next

   /**
    * Constructor for a node
    * @param v object that the node will store
    * @param next pointer to the next node
    */
   public Node(E v, Node<E> next)
   // pre: v is a value, next is a reference to 
   //      remainder of list
   // post: an element is constructed as the new 
   //      head of list
   {
       data = v;
       nextElement = next;
   }

   /**
    * Constructor for a node in a list with only one element
    * @param v the object the node will store
    */
   public Node(E v)
   // post: constructs a new tail of a list with value v
   {
      this(v,null);
   }

   /**
    * Method used to get the next node
    * @return the next node on the list
    */
   public Node<E> next()
   // post: returns reference to next value in list
   {
      return nextElement;
   }

   /**
    * sets the next element of the list
    * @param next the new next element
    */
   public void setNext(Node<E> next)
   // post: sets reference to new next value
   {
      nextElement = next;
   }

   /**
    * Method used to return the object that is stored in the node
    * @return the value of the data attribute
    */
   public E value()
   // post: returns value associated with this element
   {
      return data;
   }

   /**
    * Changes the value that the node is storing
    * @param value the new value that will be stored on the node
    */
   public void setValue(E value)
   // post: sets value associated with this element
   {
      data = value;
   }
}