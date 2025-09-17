package Calculator;

public class Operations {
    private double currentNumber;
    private double storedNumber;
    private String currentOperation;
    private boolean newNumber;

    Operations() {
        clear();
    }

    public void clear() {
        currentNumber = 0;
        storedNumber = 0;
        currentOperation = "";
        newNumber = true;
    }

    public void setCurrentOperation(String operation) {
        if (!currentOperation.isEmpty()) {
            storedNumber = result();
        } else storedNumber = currentNumber;
        currentOperation = operation;
    }

    public void setNewNumber(boolean newNumber) {
        this.newNumber = newNumber;
    }

    public boolean isNewNumber() {
        return this.newNumber;
    }

    public void setCurrentNumber(double currentNumber) {
        this.currentNumber = currentNumber;
    }

    public double result() {
        switch (currentOperation) {
            case "+" -> {
                return currentNumber + storedNumber;
            }
            case "-" -> {
                return storedNumber - currentNumber;
            }
            case "*" -> {
                return currentNumber * storedNumber;
            }
            case "/" -> {
                if (currentNumber == 0) {
                    throw new ArithmeticException("Can't divided by 0");
                } else return storedNumber / currentNumber;
            }
            default -> {
                return currentNumber;
            }
        }
    }
}