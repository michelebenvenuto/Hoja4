import java.util.List;

/**
 * Class using the Factory design pattern to create different types of lists
 */
public class ListFactory {
    //regresa la lista necesaria

    /**
     * Method used to create the desired list
     * @param neededList a string representing the needed list
     * @return the list that is required
     */
    public AbstractList getList(String neededList){
        if (neededList== null){
            return null;
        }
        else if(neededList.equals("SINGLE")){
            return new SinglyLinkedList<String>();
        }
        else if (neededList.equals("DOUBLE")){
            return new DoublyLinkedList();
        }
        else if (neededList.equals("CIRCULAR")){

            return new CircularList();
        }
        return null;
    }
}
