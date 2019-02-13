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


    public CircularList<E> subList(int fromIndex, int toIndex) {
        Node<E> currentInOriginal = (fromIndex);

        int count = (toIndex - fromIndex) + 1;

        List<L> newSubList = new List<L>();
        newSubList.head = new Node<L>(current.data);

        Node<L> lastItemInList = newSubList.head;
        int soFar = 1;

        currentInOriginal = currentInOriginal.next;
        while(currentInOriginal!=null && soFar<count) {
            lastItemInList.next = new Node<L>(currentInOriginal.data);
            listItemInList = lastItemInList.next;

            currentInOriginal=currentInOriginal.next;
            soFar++;
        }

        return newSubList;
    }
}