package model;

import java.util.NoSuchElementException;

public class FruitTransaction {
    private String fruit;
    private Operation operation;
    private int quantity;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public static Operation findByLetter(String letter) {
            for (Operation operation: Operation.values()) {
                if (operation.getOperation().equals(letter)) {
                    return operation;
                }
            }
            throw new NoSuchElementException("Can't find operation " + letter);
        }
    }
}

