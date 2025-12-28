package assignments.Ex2;

import org.junit.jupiter.api.Test;

import static jdk.internal.org.jline.utils.Colors.h;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    @Test
    void TestInitConstruction() {

        Map Testpoint = new Map(3, 6, 2);


    }


    @Test
    void TestInitConstructionException() {
        //Arrange
        Map Testpoint = new Map(2, 5, 1);
        //Act + Tests
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {

        });
        assertEquals("In the method init: the variable can't get null", exception.getMessage());

    }

    @Test
    void TestDrawCircle() {
        Map map = new Map(40);
        map.drawCircle(new Index2D(7, 10), 6, 1);
        map.printMap();
    }

    @Test
    void TestDrawLine1() {
        Map map = new Map(20);
        map.drawLine(new Index2D(7, 10), new Index2D(7, 10), 1);
        map.printMap();
    }

    @Test
    void TestDrawLine2() {
        Map map = new Map(10);
        map.drawLine(new Index2D(5, 9), new Index2D(9, 9), 1);
        map.printMap();
    }

    @Test
    void TestDrawLine3() {
        Map map = new Map(10);
        map.drawLine(new Index2D(7, 6), new Index2D(1, 9), 1);
        map.printMap();
    }

    @Test
    void TestDrawLine4() {
        Map map = new Map(10);
        map.drawLine(new Index2D(6, 7), new Index2D(9, 1), 1);
        map.printMap();
    }

    @Test
    void TestDrawLine5() {
        Map map = new Map(10);
        map.drawLine(new Index2D(6, 1), new Index2D(9, 7), 1);
        map.printMap();
    }

    @Test
    void TestDrawRect1() {
        Map map = new Map(20);
        map.drawRect(new Index2D(2, 3), new Index2D(5, 6), 1);
        map.printMap();
    }

    @Test
    void TestDrawRect2() {
        Map map = new Map(20);
        map.drawRect(new Index2D(3, 7), new Index2D(5, 1), 1);
        map.printMap();
    }

    @Test
    void TestDrawRect3() {
        Map map = new Map(20);
        map.drawRect(new Index2D(3, 7), new Index2D(5, 7), 1);
        map.printMap();
    }

    @Test
    void TestDrawRect4() {
        Map map = new Map(20);
        map.drawRect(new Index2D(3, 7), new Index2D(3, 5), 1);
        map.printMap();
    }

    @Test
    void TestEquals1() {
        Map map = new Map(1);
        Object object = new Object();
        assertNotEquals(map, object);
        ;
    }

    @Test
    void TestEquals2() {
        Map map = new Map(1, 2, 1);
        Object object = new Map(1, 3, 1);
        assertNotEquals(map, object);
        ;
    }

    @Test
    void TestEquals3() {
        Map map = new Map(1, 2, 1);
        Object object = new Map(1, 2, 2);
        assertNotEquals(map, object);
        ;
    }

    @Test
    void TestEqualsTrue() {
        Map map = new Map(1, 2, 1);
        Object object = new Map(1, 2, 1);
        assertEquals(map, object);
        ;
    }
}