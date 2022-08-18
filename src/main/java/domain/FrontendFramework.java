package domain;

import java.util.List;

public enum FrontendFramework {
    VueJS, ReactJS, AngularJS, JSP;

    public static List<FrontendFramework> JavaFrontendFrameworks() {
        return List.of(JSP);
    }

    public static List<FrontendFramework> JavascriptFrontendFrameworks() {
        return List.of(VueJS, ReactJS, AngularJS);
    }
}
