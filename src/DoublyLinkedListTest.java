import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    AbstractList<Integer> lista = new DoublyLinkedList<Integer>();

    @Test
    void size() {
        lista.addLast(1);
        lista.removeLast();
        assertEquals(lista.size(),0);
    }
    @Test
    void get() {
        lista.addLast(1);
        assertEquals(lista.get(0),1);
    }
}