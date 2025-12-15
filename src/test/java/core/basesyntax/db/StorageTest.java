package core.basesyntax.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorageTest {
    @BeforeEach
    void setUp() {
        Storage.getStorageFruit().clear();
    }

    @Test
    void getStorageFruit_sameInstance_Ok() {
        Map<String, Integer> firstCall = Storage.getStorageFruit();
        Map<String, Integer> secondCall = Storage.getStorageFruit();
        assertSame(firstCall,secondCall);
    }

    @Test
    void getStorageFruit_valid_OK() {
        Storage.getStorageFruit().put("banana", 30);
        assertEquals(30,Storage.getStorageFruit().get("banana"));
    }
}
