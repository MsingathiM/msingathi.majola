package featureSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class TestDogbreeds {

    final static String
            url = "https://dog.ceo/api/";

    @Given("^I open the dog api endpoint$")
    public void iOpenTheDogApiEndpoint() {

        String url = "https://dog.ceo/api/";

    }

    @When("^I search for a non-existing dog breed an error must be returned$")
    public void iSearchForANonExistingDogBreedAnErrorMustBeReturned() {
        String breedName = "testBreed";

        System.out.println("===============Returning Error if incorrect Breed Type is parsed==================");


        given()
                .when()
                .get(url + "breed/"+breedName+"/images")
                .then()
                .log()
                .body();
    }

    @And("^I verify that a bulldog exist from the list of all dogs$")
    public void iVerifyThatABulldogExistFromTheListOfAllDogs() {

        boolean foundBulldog = false;
        String bullTypes[] = {"boston", "english", "french"};
        System.out.println("===============Finding Bulldog from list of breeds==================");


        if(foundBulldog == false) {

            for(int x = 0; x < bullTypes.length; x++){
                given()
                        .get(url + "breeds/list/all")
                        .then()
                        .statusCode(200)
                        .assertThat()
                        .body("message.bulldog", hasItem(bullTypes[x]));

                foundBulldog = true;
            }


        }

        System.out.println("Displays " + foundBulldog + " since it found all bulldog types");

    }

    @Then("^I retrieve all sub-breeds for bulldogs and their respective images$")
    public void iRetrieveAllSubBreedsForBulldogsAndTheirRespectiveImages() {

        System.out.println("===============Finding Bulldog types from list of sub-breeds==================");

        given()
                .get(url + "breed/bulldog/images")
                .then()
                .log()
                .body();
    }
}
