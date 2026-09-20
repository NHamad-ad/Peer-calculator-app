public class MathApp {
    private final CalculatorService calculator;

    public MathApp(CalculatorService calculator) {
        this.calculator = calculator;
    }

    public int computeSum(int x, int y) {
        return calculator.add(x, y);
    }

    public double computeDivision(double x, double y) {
        return calculator.divide(x, y);
    }
}