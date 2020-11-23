package webserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DispatcherServlet;
import controller.HandlerMapping;
import http.HttpRequest;

public class RequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;
    private DispatcherServlet dispatcherServlet;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
        this.dispatcherServlet = new DispatcherServlet(new HandlerMapping());
    }

    public void run() {
        logger.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
            connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            HttpRequest httpRequest = new HttpRequest(in);
            dispatcherServlet.process(httpRequest, out);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
