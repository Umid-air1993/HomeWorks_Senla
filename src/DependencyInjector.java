import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DependencyInjector {
    public static void injectDependencies(Object object) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().newInstance();
                field.set(object, dependency);
            }
        }
    }
}
