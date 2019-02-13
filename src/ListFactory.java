import java.util.List;

public class ListFactory {
    //regresa el stack necesario
    public List getList(String neededList){
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
