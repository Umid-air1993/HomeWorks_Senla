public class AppConfig {
    @ConfigProperty(configFileName = "src/app.properties", propertyName = "db.url")
    private String dbUrl;

    @ConfigProperty(configFileName = "src/pp.properties", propertyName = "db.username")
    private String dbUsername;

    @ConfigProperty(configFileName = "src/app.properties", propertyName = "db.password")
    private String dbPassword;

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}


