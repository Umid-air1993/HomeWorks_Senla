import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {
    public static void loadConfig(Object object) throws IOException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ConfigProperty.class)) {
                ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);
                String configFileName = configProperty.configFileName();
                String propertyName = configProperty.propertyName().isEmpty()
                        ? clazz.getSimpleName() + "." + field.getName()
                        : configProperty.propertyName();

                Properties properties = new Properties();
                try (FileInputStream fis = new FileInputStream(configFileName)) {
                    properties.load(fis);
                }

                String value = properties.getProperty(propertyName);
                if (value != null) {
                    field.setAccessible(true);
                    Class<?> fieldType = configProperty.type();
                    if (fieldType == int.class) {
                        field.setInt(object, Integer.parseInt(value));
                    } else if (fieldType == boolean.class) {
                        field.setBoolean(object, Boolean.parseBoolean(value));
                    } else {
                        field.set(object, value);
                    }
                }
            }
        }
    }
}
