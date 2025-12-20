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
        Map<String, Integer> first = Storage.getStorageFruit();
        Map<String, Integer> second = Storage.getStorageFruit();
        assertSame(first,second);
    }

    @Test
    void getStorageFruit_valid_OK() {
        Storage.getStorageFruit().put("banana", 30);
        assertEquals(30,Storage.getStorageFruit().get("banana"));
    }
}

