package br.com.carlosbonfatti.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class BaseTest implements Constant {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = CPF;
        RestAssured.basePath = CPFERROR;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();
        ResponseSpecBuilder resBuilder =new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAXI_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
