package com.api.auto.testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.auto.utils.PropertiesFileUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_API_Login {
	private String account;
	private String password;
	private Response response;
	private ResponseBody responseBody;
	private JsonPath jsonBody;

	@BeforeClass
	public void init() throws IOException {
		// Đọc các giá trị từ tệp cấu hình
		String baseUrl = PropertiesFileUtils.getProperty("baseurl");
		account = PropertiesFileUtils.getProperty("account");
		password = PropertiesFileUtils.getProperty("password");
		String loginPath = PropertiesFileUtils.getProperty("loginPath");
		// Thiết lập địa chỉ gốc cho các yêu cầu REST
		RestAssured.baseURI = baseUrl;
		// Tạo dữ liệu yêu cầu đăng nhập		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("account", account.toString());
		body.put("password", password.toString());
		RequestSpecification req = RestAssured.given().contentType(ContentType.JSON).body(body);
		// Gửi yêu cầu đăng nhập và lấy phản hồi
		response = req.post(loginPath);
		responseBody = response.body();
		jsonBody = response.jsonPath();
	}

	@Test(priority = 1)
	public void TC02_ValidateMessage() {
		  // Xác nhận mã trạng thái phản hồi là 200 và trường "message" tồn tại
		assertEquals(response.getStatusCode(), 200, "Status code not 200");
		assertEquals(true, responseBody.asString().contains("message"), "Message field not found");
		String message = jsonBody.getString("message");
		assertEquals(message, "Đăng nhập thành công", "Đăng nhập thất bại");

	}

	@Test(priority = 2)
	public void TC03_ValidateToken() {
		  // Xác nhận trường "token" tồn tại và lưu giá trị token vào tệp cấu hình
		assertEquals(true, responseBody.asString().contains("token"), "Token field not found");
		String token = jsonBody.getString("token");
		if (token != null) {
			PropertiesFileUtils.saveToken("token", token);// Lay token
		}
	}

	@Test(priority = 3)
	public void TC05_ValidateUserType() {
		// Xác nhận trường "user" và "type" tồn tại, kiểm tra giá trị "type" có khớp UNGVIEN hay không
		assertEquals(true, responseBody.asString().contains("user"), "user field not found");
		assertEquals(true, responseBody.asString().contains("type"), "type field not found");
		String type = jsonBody.getString("user.type");
		assertEquals(type, "UNGVIEN", "Type not macth UNGVIEN");
	}

	@Test(priority = 4)
	public void TC06_ValidateAccount() {
		// Xác nhận trường "user", "account" và "password" tồn tại, kiểm tra giá trị "account" và "password" có khớp với dữ liệu trong tệp cấu hình không
		assertEquals(true, responseBody.asString().contains("user"), "user field not found");
		assertEquals(true, responseBody.asString().contains("account"), "type field not found");
		assertEquals(true, responseBody.asString().contains("password"), "password field not found");
		String accountCheck = jsonBody.getString("user.account");
		String passwordCheck = jsonBody.getString("user.password");
		assertEquals(accountCheck, account, "account not match");
		assertEquals(passwordCheck, password, "account not match");
	}
}