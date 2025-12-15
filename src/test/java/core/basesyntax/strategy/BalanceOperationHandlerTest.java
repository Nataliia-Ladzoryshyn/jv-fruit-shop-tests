package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceOperationHandlerTest {
    private BalanceOperationHandler balanceOperationHandler;

    @BeforeEach
    void setUp() {
        balanceOperationHandler = new BalanceOperationHandler();
        Storage.getStorageFruit().clear();
    }

    @Test
    void handleTransaction_valid_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.BALANCE, "banana", 30);
        balanceOperationHandler.handleTransaction(fruitTransaction);
        Map<String, Integer> storage = Storage.getStorageFruit();
        assertEquals(1, storage.size());
        assertEquals(30, storage.get("banana"));
    }
}
