package stepDefinition;

import io.restassured.RestAssured;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class TestScenario {

    @Given("^Weather station URL is running$")
    public void Weather_station_URL_is_running() throws Throwable {
        RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";
    }

    @When("^User makes a request without API key response code is 401$")
    public void User_makes_a_request_without_API_key_response_code_is_401() throws Throwable {

        given()
                .header("key","")
                .header("Content-Type","application/json")
                .param("external_id", "DEMO_TEST001")
                .param("name", "Team Demo Test Station 001")
                .param("latitude", "33.33")
                .param("longitude", "-122.43")
                .param("altitude", "222")
                .post("/stations")
                .then().statusCode(401);
    }

    @When("^User register a station successfully response code is 201$")
    public void User_register_a_station_successfully_response_code_is_201() throws Throwable {

        given()
                .header("key","7229a179ba899b4d9b5ad19bf8b2d67f")
                .header("Content-Type","application/json")
                .param("external_id", "DEMO_TEST001")
                .param("name", "Team Demo Test Station 001")
                .param("latitude", "33.33")
                .param("longitude", "-122.43")
                .param("altitude", "222")
                .post("/stations");
        given()
                .header("key","7229a179ba899b4d9b5ad19bf8b2d67f")
                .header("Content-Type","application/json")
                .param("external_id", "DEMO_TEST002")
                .param("name", "Team Demo Test Station 002")
                .param("latitude", "44.44")
                .param("longitude", "-122.44")
                .param("altitude", "111")
                .post("/stations");
    }

    @When("^User requests for station details correct response is provided$")
    public void User_requests_for_station_details_correct_response_is_provided() throws Throwable {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        String body = response.getBody().asString();
        int status = response.getStatusCode();
        String statusLine = response.getStatusLine();
        //Printing the response
        System.out.println("Response Body is "+body);
        System.out.println("Status code is "+status);
        System.out.println("Status line is "+statusLine);
    }

    @When("^User deletes a station response code is 204$")
    public void User_deletes_a_station_response_code_is_204() throws Throwable {

        given()
                .header("key","7229a179ba899b4d9b5ad19bf8b2d67f")
                .header("Content-Type","application/json")
                .param("id", "DEMO_TEST001")
                .param("id", "DEMO_TEST001")
                .post("/delete/stations")
                .then().statusCode(401);
    }

    @When("^User requests a deleted station response code is 404$")
    public void User_requests_a_deleted_station_response_code_is_404() throws Throwable {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        String body = response.getBody().asString();
        int status = response.getStatusCode();
        String statusLine = response.getStatusLine();
        //Printing the response
        System.out.println("Response Body is "+body);
        System.out.println("Status code is "+status);
        System.out.println("Status line is "+statusLine);
    }
}
