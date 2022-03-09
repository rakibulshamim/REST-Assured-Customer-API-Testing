package Pages;

import Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;

import java.io.*;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Customer {
    Properties properties = new Properties();
    FileInputStream file = new FileInputStream("./src/test/resources/config.properties");

    public Customer() throws FileNotFoundException {
    }

    public void callingCustomerLoginAPI() throws ConfigurationException, IOException {
        properties.load(file);
        RestAssured.baseURI = properties.getProperty("baseUrl");
        Response response =
                given()
                        .contentType("application/json")
                        .body("{\n" +
                                "    \"username\":\"salman\",\n" +
                                "    \"password\":\"salman1234\"\n" +
                                "}")
                        .when()
                        .post("/customer/api/v1/login")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath resObj = response.jsonPath();
        String token = resObj.get("token");
        Utils.setEnvVariable("token", token);
        System.out.println(token);
    }

    public void callingCustomerListAPI() throws IOException {
        properties.load(file);
        RestAssured.baseURI = properties.getProperty("baseUrl");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", properties.getProperty("token"))
                        .when()
                        .get("/customer/api/v1/list")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        JsonPath resObj = response.jsonPath();
        String id = resObj.get("Customers[0].id").toString();
        Assert.assertEquals("101", id);
    }

    public void searchCustomer() throws IOException {
        properties.load(file);
        RestAssured.baseURI = properties.getProperty("baseUrl");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", properties.getProperty("token"))
                        .when()
                        .get("/customer/api/v1/get/102")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath resObj = response.jsonPath();
        String name = resObj.get("name");
        Assert.assertEquals("Mr. Jamal Islam", name);
        System.out.println(response.asString());
    }

    public Integer ID;
    public String name;
    public String email;
    public String address;
    public String phone_number;

    public void GenerateCustomer() throws IOException, ConfigurationException {
        properties.load(file);
        RestAssured.baseURI = "https://randomuser.me";
        Response response =
                given()
                        .contentType("application/json")
                        .when()
                        .get("/api")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath resObj = response.jsonPath();
        ID = (int) Math.floor(Math.random() * (999999 - 100000) + 1);
        name = resObj.get("results[0].name.first");
        email = resObj.get("results[0].email");
        address = resObj.get("results[0].location.state");
        phone_number = resObj.get("results[0].cell");
        Utils.setEnvVariable("id", ID.toString());
        Utils.setEnvVariable("name", name);
        Utils.setEnvVariable("email", email);
        Utils.setEnvVariable("address", address);
        Utils.setEnvVariable("phone_number", phone_number);
        System.out.println(response.asString());
    }

    public void createCustomer() throws IOException {
        properties.load(file);
        RestAssured.baseURI = properties.getProperty("baseUrl");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", properties.getProperty("token"))
                        .body("" +
                                "{\"id\":" + properties.getProperty("id") + ",\n" +
                                "    \"name\":\"" + properties.getProperty("name") + "\", \n" +
                                "    \"email\":\"" + properties.getProperty("email") + "\",\n" +
                                "    \"address\":\"" + properties.getProperty("address") + "\",\n" +
                                "    \"phone_number\":\"" + properties.getProperty("phone_number") + "\"}")
                        .when()
                        .post("/customer/api/v1/create")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        JsonPath resObj = response.jsonPath();
        String message = resObj.get("message");
        Assert.assertEquals("Success", message);
        System.out.println(response.asString());
    }

    public void updateCustomerInfo() throws IOException {
        properties.load(file);
        RestAssured.baseURI = properties.getProperty("baseUrl");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", properties.getProperty("token"))
                        .body("{\n" +
                                "    \"id\": 102,\n" +
                                "    \"name\": \"Mr. Rahim Islam\",\n" +
                                "    \"email\": \"mrjamal@test.com\",\n" +
                                "    \"address\": \"Mirpur,Dhaka\",\n" +
                                "    \"phone_number\": \"01502020110\"\n" +
                                "}")
                        .when()
                        .put("/customer/api/v1/update/102")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath resObj = response.jsonPath();
        String message = resObj.get("message");
        Assert.assertEquals("Success", message);
        System.out.println(response.asString());
    }

    public void deleteCustomer() throws IOException {
        properties.load(file);
        RestAssured.baseURI = properties.getProperty("baseUrl");
        String id = properties.getProperty("id");
        Response response =
                given()
                        .contentType("application/json")
                        .header("Authorization", properties.getProperty("token"))
                        .when()
                        .delete("/customer/api/v1/delete/"+id)
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath resObj = response.jsonPath();
        String message = resObj.get("message");
        Assert.assertEquals("Customer deleted!", message);
        System.out.println(response.asString());
    }
}
