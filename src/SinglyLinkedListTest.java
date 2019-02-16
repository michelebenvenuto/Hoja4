import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    AbstractList<Integer> lista = new SinglyLinkedList<Integer>();

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