package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReturnOperationHandlerTest {
    private ReturnOperationHandler returnOperationHandler;

    @BeforeEach
    void setUp() {
        returnOperationHandler = new ReturnOperationHandler();
        Storage.getStorageFruit().clear();
    }

    @Test
    void handleTransaction_existFruit_Ok() {
        Storage.getStorageFruit().put("banana", 20);
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.RETURN, "banana", 30);
        returnOperationHandler.handleTransaction(fruitTransaction);
        assertEquals(50, Storage.getStorageFruit().get("banana"));
    }

    @Test
    void handleTransaction_notExistFruit_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.RETURN, "banana", 21);
        returnOperationHandler.handleTransaction(fruitTransaction);
        assertEquals(21, Storage.getStorageFruit().get("banana"));
    }
}
