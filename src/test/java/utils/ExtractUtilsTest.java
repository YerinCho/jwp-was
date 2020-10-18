package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExtractUtilsTest {
	private static final String BODY = "userId=a&password=1&name=asd&email=test%40test.com";
	private static final String FILE_DIRECTORY = "./src/test/resources/";
	private static final String POST_REQUEST = "post_request.txt";
	private static final String GET_REQUEST = "get_request.txt";

	@DisplayName("URL의 Param을 분리")
	@Test
	void extractUserInfoTest() throws UnsupportedEncodingException {
		Map<String, String> userInfo = ExtractUtils.extractUserInfo(BODY);

		assertAll(
			() -> assertThat(userInfo.get("userId")).isEqualTo("a"),
			() -> assertThat(userInfo.get("password")).isEqualTo("1"),
			() -> assertThat(userInfo.get("name")).isEqualTo("asd"),
			() -> assertThat(userInfo.get("email")).isEqualTo("test@test.com")
		);
	}

	@Test
	void extractFirstHeader() throws IOException {
		BufferedReader br = createBufferedReader(GET_REQUEST);
		Map<String, String> headers = new HashMap<>();

		ExtractUtils.extractFirstHeader(br, headers);
		assertAll(
			() -> assertThat(headers.get("method")).isEqualTo("GET"),
			() -> assertThat(headers.get("url")).isEqualTo("/user/create"),
			() -> assertThat(headers.get("userId")).isEqualTo("javajigi"),
			() -> assertThat(headers.get("password")).isEqualTo("password"),
			() -> assertThat(headers.get("name")).isEqualTo("JaeSung")
		);
	}

	@Test
	void extractExtraHeaders() throws IOException {
		BufferedReader br = createBufferedReader(POST_REQUEST);
		br.readLine();
		Map<String, String> headers = new HashMap<>();

		ExtractUtils.extractExtraHeaders(br, headers);
		assertAll(
			() -> assertThat(headers.get("Host")).isEqualTo("localhost:8080"),
			() -> assertThat(headers.get("Connection")).isEqualTo("keep-alive"),
			() -> assertThat(headers.get("Content-Length")).isEqualTo("46"),
			() -> assertThat(headers.get("Content-Type")).isEqualTo("application/x-www-form-urlencoded")
		);
	}

	private BufferedReader createBufferedReader(String fileName) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(new File(FILE_DIRECTORY + fileName));
		return new BufferedReader(new InputStreamReader(inputStream));
	}
}
