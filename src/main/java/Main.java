import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//to upper case annotation
@interface ToUpper {
}



public class Main {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        testClass.setX("abcd");

        UpperMaker upperMaker = new UpperMaker();
        upperMaker.forceUpperCase(testClass);
    }
}