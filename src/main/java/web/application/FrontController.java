package web.application;

import java.util.HashMap;
import java.util.Map;

import web.application.controller.Controller;
import web.application.controller.CreateUserController;
import web.application.controller.RootController;
import web.application.controller.StaticController;
import web.server.domain.request.HttpRequest;
import web.server.domain.response.HttpResponse;

public class FrontController implements Controller {

    private final Map<String, Controller> mapper;

    public FrontController() {
        mapper = new HashMap<>();
        mapper.put("/user/create", CreateUserController.getInstance());
        mapper.put("/", RootController.getInstance());
    }

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.hasPathOfStaticFile()) {
            StaticController.getInstance().service(httpRequest, httpResponse);
            return;
        }
        if (mapper.containsKey(httpRequest.getPath())) {
            mapper.get(httpRequest.getPath()).service(httpRequest, httpResponse);
            return;
        }
        httpResponse.respondPageNotFound();
    }
}
