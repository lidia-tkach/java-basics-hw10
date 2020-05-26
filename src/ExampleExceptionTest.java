import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleExceptionTest {

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                {2, 2, 4},
                {2, 3, 6},
                {10, 10, 100},
                {1, 5, 5}
        };
    }

    @DataProvider(name = "negativeData")
    public static Object[][] negativeData() {
        return new Object[][]{
                {-2, 2},
                {2, -2},
                {-5, -6},
                {100, -100}
        };
    }

    @Test(dataProvider = "data")
    public void testRectangleArea(int a, int b, int c) throws IllegalArgumentException {
        assertEquals(ExampleException.rectangleArea(a, b), c);
    }

    @Test(dataProvider = "negativeData", expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "input value is below zero!")
    public void testRectangleAreaNegative(int a, int b) throws IllegalArgumentException {
        ExampleException.rectangleArea(a, b);
    }
}