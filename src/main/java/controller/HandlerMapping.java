package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HandlerMapping {
    private Map<String, Servlet> handlerMapping = new HashMap<>();

    public HandlerMapping() {
        this.handlerMapping.put("/user/create", new UserCreateController());
    }

    public Servlet getController(String path) {
        Servlet servlet = handlerMapping.get(path);
        if (Objects.isNull(servlet)) {
            return new ErrorController();
        }
        return servlet;
    }
}
