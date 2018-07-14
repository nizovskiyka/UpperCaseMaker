import org.slf4j.*;
import lombok.extern.slf4j.Slf4j;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Slf4j
public class UpperMaker{

    public void forceUpperCase(TestClass testClass){

        Logger log = LoggerFactory.getLogger(UpperMaker.class);

        Class<?> clazz = testClass.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {

            Annotation[] fDeclaredAnnotations = f.getDeclaredAnnotations();

            for (Annotation anno : fDeclaredAnnotations) {

                if (anno.annotationType().equals(ToUpper.class)) {

                    f.setAccessible(true);
                    try {

                        f.set(testClass, ((String) f.get(testClass)).toUpperCase());
                        log.warn("The variable " + f.getName() + " has been forced to upper case");

                    } catch (IllegalAccessException e) {
                        log.warn("The variable " + f.getName() + " has failed to be forced to upper case");
                    }
                }
            }
        }
    }
}