/*Saúl Contreras - 18409
Michele Benevuto - 

Clase MyCalculator.java implente la interfaz Calculator

*/

/**
 * Used to do different operations with two numbers
 */
public class MyCalculator implements Calculator{

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

