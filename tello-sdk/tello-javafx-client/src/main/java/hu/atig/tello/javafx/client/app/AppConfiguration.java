package hu.atig.tello.javafx.client.app;

public class AppConfiguration {

    private static AppConfiguration appConfig;

    private AppConfiguration() {
    }

    public static synchronized AppConfiguration getInstance() {
        if (appConfig == null)
            return new AppConfiguration();
        return appConfig;
    }


}
