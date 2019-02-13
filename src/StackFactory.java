public class StackFactory {

    //regresa el stack necesario
    public Stack getStack(String neededStack){
        if (neededStack== null){
            return null;
        }
        else if(neededStack.equals("ARRAYLIST")){
            return new StackArrayList();
        }
        else if (neededStack.equals("VECTOR")){
            return new StackVector();
        }
        else if (neededStack.equals("LIST")){

            return new StackList();
        }
        return null;
    }
}
