/*Saúl Contreras - 18409
Michele Benevuto - 

Clase MyCalculator.java implente la interfaz Calculator

*/

/**
 * Used to do different operations with two numbers
 */
class MyCalculator implements Calculator{
    static MyCalculator instance = null;
    //constructor para el singleton
    private MyCalculator(){}
    //para que se cree solo un sigleton
    static public MyCalculator getInstance(){
        if (instance==null){
            instance = new MyCalculator();
        }
        return instance;
    }
    public int calculate(int num1, int num2, String op){
    	int retorno=0;
    	if (op=="+"){
    		retorno = num1+num2;
    	}
    	else if(op=="-"){
    		retorno = num1-num2;
    	}
    	else if(op=="*"){
    		retorno = num1*num2;
    	}
    	else if(op=="/"){
    		retorno = num1/num2;
    	}
    	return retorno;
    }
}

