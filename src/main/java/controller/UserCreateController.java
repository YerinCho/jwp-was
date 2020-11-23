package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import db.DataBase;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import http.MimeType;
import model.User;
import utils.FileIoUtils;

public class UserCreateController extends HttpServlet {
    @Override
    public void doPost(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException {
        MimeType mimeType = httpRequest.getMimeType();
        String path = httpRequest.getPath();
        byte[] body = FileIoUtils.loadFileFromClasspath(path);

        createUser(httpRequest);

        HttpResponse httpResponse = new HttpResponse(out, HttpStatus.FOUND, httpRequest.getVersion());
        httpResponse.response302Header(body.length, mimeType.getContentType(), "/index.html");
        httpResponse.responseBody(body);
    }

    private static void createUser(HttpRequest httpRequest) {
        String userId = httpRequest.getParam("userId");
        String password = httpRequest.getParam("password");
        String name = httpRequest.getParam("name");
        String email = httpRequest.getParam("email");
        User user = new User(userId, password, name, email);
        DataBase.addUser(user);
    }
}
