package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public abstract class HttpServlet implements Servlet {

    @Override
    public void service(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException {
        if (httpRequest.matchMethod(HttpMethod.GET)) {
            doGet(httpRequest, out);
        } else if (httpRequest.matchMethod(HttpMethod.POST)) {
            doPost(httpRequest, out);
        } else {
            HttpResponse httpResponse = new HttpResponse(out, HttpStatus.NOT_IMPLEMENTED, httpRequest.getVersion());
            httpResponse.error();
        }
    }

    public void doGet(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException {
        HttpResponse httpResponse = new HttpResponse(out, HttpStatus.METHOD_NOT_ALLOWED, httpRequest.getVersion());
        httpResponse.error();
    }

    public void doPost(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException {
        HttpResponse httpResponse = new HttpResponse(out, HttpStatus.METHOD_NOT_ALLOWED, httpRequest.getVersion());
        httpResponse.error();
    }
}
