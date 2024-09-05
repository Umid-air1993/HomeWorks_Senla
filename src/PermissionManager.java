import java.util.Properties;

public class PermissionManager {
private Properties properties;
public PermissionManager(Properties properties) {
    this.properties = properties;
}
public boolean isAllowed(String permission) {
    return Boolean.parseBoolean(properties.getProperty(permission,"false"));
}
}
