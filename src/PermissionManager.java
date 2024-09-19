import java.util.Properties;

public class PermissionManager {
    @Inject

    private Properties properties;

    public PermissionManager() {
        this.properties = new Properties();
    }

    public PermissionManager(Properties properties) {
        this.properties = properties;
    }

    public boolean isAllowed(String permission) {
        return Boolean.parseBoolean(properties.getProperty(permission, "false"));
    }
}
