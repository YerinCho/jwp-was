package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import http.HttpRequest;

public interface Servlet {
    void service(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException;
}
