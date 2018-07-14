import org.testng.Assert;
import org.testng.annotations.Test;

public class Tester {
    private UpperMaker upperMaker = new UpperMaker();
    @Test()
    public void testUpperCase() {
        TestClass testClass = new TestClass();
        testClass.setX("abcd");
        upperMaker.forceUpperCase(testClass);
        Assert.assertEquals(testClass.getX().toUpperCase(), testClass.getX());
        Assert.assertTrue(testClass.getX() instanceof String);
    }
}
