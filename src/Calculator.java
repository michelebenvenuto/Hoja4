/**
 * Interface used by the objects that are able to calculate
 */
public interface Calculator {
    /**
     * USed to calculate an operation between to numbers
     * @param num1 the operand
     * @param num2 the operator
     * @param op a string representing a mathematical operation
     * @return the result of doing the operation between the operand and operator
     */
    public int calculate(int num1, int num2, String op);
}
