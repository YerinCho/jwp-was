package http;

import java.util.Arrays;

public enum HttpMethod {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE;

    public static HttpMethod from(String httpMethod) {
        return Arrays.stream(values())
            .filter(method -> method.name().equals(httpMethod))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 http 요청 메소드입니다."));
    }

    public HttpMethod get() {
        return this;
    }
}
