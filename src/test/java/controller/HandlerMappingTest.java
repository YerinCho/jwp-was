package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandlerMappingTest {
    private HandlerMapping handlerMapping = new HandlerMapping();

    private static Stream<Arguments> providePathServlet() {
        return Stream.of(
            Arguments.of("/user/create", new UserCreateController()),
            Arguments.of("/invalid", new ErrorController())
        );
    }

    @ParameterizedTest
    @MethodSource("providePathServlet")
    @DisplayName("경로에 맞는 컨트롤러 반환")
    void getControllerTest(String path, HttpServlet servlet) {
        assertEquals(handlerMapping.getController(path).getClass(), servlet.getClass());
    }

}
