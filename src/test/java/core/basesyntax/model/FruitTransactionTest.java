package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FruitTransactionTest {
    @Test
    void getter_Work_Ok() {
        Operation operation = Operation.BALANCE;
        String fruit = "banana";
        int quantity = 10;

        FruitTransaction newFruit = new FruitTransaction(operation, fruit, quantity);
        assertEquals(operation, newFruit.getOperation());
        assertEquals(fruit,newFruit.getFruit());
        assertEquals(quantity,newFruit.getQuantity());
    }
}
