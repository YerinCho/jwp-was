package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import http.MimeType;
import utils.FileIoUtils;

public class ResourceController extends HttpServlet {
    @Override
    public void doGet(HttpRequest httpRequest, OutputStream out) throws IOException, URISyntaxException {
        MimeType mimeType = httpRequest.getMimeType();
        String path = httpRequest.getPath();
        byte[] body = FileIoUtils.loadFileFromClasspath(path);

        HttpResponse httpResponse = new HttpResponse(out, HttpStatus.OK, httpRequest.getVersion());
        httpResponse.response200Header(body.length, mimeType.getContentType());
        httpResponse.responseBody(body);
    }
}
