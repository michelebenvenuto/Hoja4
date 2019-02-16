import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    AbstractList<Integer> lista = new CircularList<Integer>();

    @org.junit.jupiter.api.Test
    void size() {
        lista.addLast(1);
        lista.removeLast();
        assertEquals(lista.size(),0);
    }

    @org.junit.jupiter.api.Test
    void get() {
        lista.addLast(1);
        assertEquals(lista.get(0),1);
    }
}