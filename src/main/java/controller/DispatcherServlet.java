package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import http.HttpRequest;

public class DispatcherServlet {
    private final HandlerMapping handlerMapping;

    public DispatcherServlet(HandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    public void process(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException {
        Servlet servlet = handlerMapping.getController(httpRequest.getUrl());
        if (httpRequest.isResourceUrl()) {
            servlet = new ResourceController();
        }
        servlet.service(httpRequest, out);
    }
}
