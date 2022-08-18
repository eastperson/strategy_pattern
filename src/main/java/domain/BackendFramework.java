package domain;

import java.util.List;

public enum BackendFramework {
    SpringFramework, SpringBoot, Django, Flask, NodeJS, GIN;

    public static List<BackendFramework> JavaBackendFrameworks() {
        return List.of(SpringFramework, SpringBoot);
    }

    public static List<BackendFramework> PythonBackendFrameworks() {
        return List.of(Django, Flask);
    }

    public static List<BackendFramework> JavascriptBackendFrameworks() {
        return List.of(NodeJS);
    }

    public static List<BackendFramework> GoBackendFrameworks() {
        return List.of(GIN);
    }
}
