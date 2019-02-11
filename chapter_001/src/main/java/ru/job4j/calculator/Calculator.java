package ru.job4j.calculator;
/**
 *Calculate
 *@author Alexey Bogutsky
 */
public class Calculator {
    private double result;
    public double getResult() {
        return this.result;
    }
/** Method add
 * @param first - first operand.
 * @param second - second operand
 */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /** Method substruct
     * @param first - first operand.
     * @param second - second operand
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }
    /** Method multiply
     * @param first - first operand.
     * @param second - second operand
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }
    /** Method divide
     * @param first - first operand.
     * @param second - second operand
     */
    public void divide(double first, double second) {
        this.result = first / second;
    }
}
