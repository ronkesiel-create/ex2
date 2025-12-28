package assignments.Ex2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Index2DTest {
    /**
     *
     * tests if A point  Coordinates of x and y.
     * creates variables for Coordinates of x and y.
     * constructs an Index2D point form given integers of x and y.
     * Checks if there are equals to each other
     */
    @Test
    void TestIsCoordinatesCorrectly() {
        //Arrange
        int resultX = 10;
        int resultY = 20;

        int resultX0 = 0;
        int resultY0 = 0;

        //Act
        Index2D point = new Index2D(resultX, resultY);

        Index2D point0 = new Index2D(resultX0, resultY0);

        //Tests
        assertEquals(resultX, point.getX(), "The result should be 10");
        assertEquals(resultY, point.getY(), "The result should be 20");

        assertEquals(0, point0.getX(), "The result should be 0");
        assertEquals(0, point0.getY(), "same as in position x");

        assertTrue(point.getX() >= 0, "The result should be bigger of equal to 0");
        assertTrue(point.getY() >= 0, "same as in position x");

        assertFalse(point.getX() < 0, "The result should be smaller than 0");
        assertFalse(point.getY() < 0, "same as in position x");


    }

    /**
     * tests for Copying an Index.
     * checks for 3 different scenarios
     *
     */
    @Test
    void TestCopyContractor1() {
        //Arrange
        Index2D OGPixel = new Index2D(3, 5);
        Index2D CopyPixel = new Index2D(OGPixel);
        //Act
        assertNotNull(CopyPixel);
        assertNotNull(OGPixel);
        assertEquals(OGPixel, CopyPixel);
        //Tests
        assertEquals(3, CopyPixel.getX(), "The result should be 3");
        assertEquals(5, CopyPixel.getY(), "The result should be 5");

        assertNotEquals(5, CopyPixel.getX(), "The correct result should be 3");
        assertNotEquals(3, CopyPixel.getY(), "The correct result should be 5");
    }

    @Test
    void TestCopyContractor2() {
        //Arrange
        Index2D OGPixel = new Index2D(-3, -5);
        Index2D CopyPixel = new Index2D(OGPixel);
        //Act
        assertNotNull(CopyPixel);
        assertNotNull(OGPixel);
        //Tests
        assertEquals(-3, CopyPixel.getX());
        assertEquals(-5, CopyPixel.getY());
    }

    @Test
    void TestCopyContractor3() {
        //Arrange
        Index2D OGPixel = new Index2D(-3, 5);
        Index2D CopyPixel = new Index2D(OGPixel);
        //Act
        assertNotNull(CopyPixel);
        assertNotNull(OGPixel);
        //Tests
        assertEquals(-3, CopyPixel.getX());
        assertEquals(5, CopyPixel.getY());
    }



    @Test
    void TestDistanceOf2Points() {
        //Arrange + Act
        Index2D Pixel1 = new Index2D(8, 6);
        Index2D Pixel2 = new Index2D(4, 3);
        //Tests
        assertEquals(5, Pixel1.distance2D(Pixel2));
        assertEquals(5, Pixel1.distance2D(Pixel2));
        assertNotEquals(4, Pixel1.distance2D(Pixel2));
        assertEquals(5, Pixel2.distance2D(Pixel1));

    }





    /**
     * Tests of an exception in given Index2D variable
     * @throws RuntimeException if Pixel1==null.
     */
    @Test
    void TestDistanceOf2PointsException() {
        //Arrange
        Index2D Pixel1 = new Index2D(8, 6);
        //Act + Tests
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Pixel1.distance2D(null);

        });
        assertEquals("In the method distance2D: the variable can't get null", exception.getMessage());
    }

    /**
     * tests for copying an Index.
     */
    @Test
    void TestEquals() {
        //Arrange
        Index2D Pixel1 = new Index2D(8, 6);
        //Act
        Object Pixel2 = new Index2D(Pixel1);
        //Tests
        assertNotNull(Pixel1);
        assertNotNull(Pixel2);
        assertEquals(Pixel1, Pixel2);
        assertTrue(Pixel1.equals(Pixel2));
    }

}