/**
 * Class that uses the factor design pattern to return a specified stack
 */
public class StackFactory {
    /**
     * Method used to create an instance of the desired stack type
     * @param neededStack string specifying what type of stack is needed
     * @param list a list to create a stacklist only used if necessary
     * @return the desired type of stack
     */
    public Stack getStack(String neededStack, AbstractList list){
        if (neededStack== null){
            return null;
        }
        else if(neededStack.equals("ARRAYLIST")){
            return new StackArrayList();
        }
        else if (neededStack.equals("VECTOR")){
            return new StackVector();
        }
        else if (neededStack.equals("LIST")&&list!=null){

            return new StackList(list);
        }
        return null;
    }
}
