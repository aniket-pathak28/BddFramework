package testrunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.core.StringContains;
import org.jsoup.select.Evaluator.ContainsOwnText;
import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StepDefination {

	
	
	String baseuri="https://api.ratesapi.io";
	RequestSpecification requestspec;
	Response response;
	String uri="https://api.ratesapi.io/api/2010-01-12";
	Scenario scn;
	
	
	//**********************************1st scenario*****************************
	@Given("^User contains the API of foreign exchange rates$")
	public void user_contains_the_API_of_foreign_exchange_rates() throws Throwable {
	Response response= RestAssured.given().get(); 	
	}

	@When("^user enters API$")
	public void user_enters_API() throws Throwable {
	  response=requestspec.when().get("/api/latest");
	  System.out.println("Response is:"+ response.asString());
	}

	@Then("^user able to see status code as (\\d+)$")
	public void user_able_to_see_status_code_as(int arg1) throws Throwable {
	   ValidatableResponse code=response.then().statusCode(200);
	   Assert.assertEquals(code, 200);
	}

	
	
	//**********************************2nd scenario**********************
	@Given("^: User having rates APi for foreign exchange rates$")
	public void user_having_rates_APi_for_foreign_exchange_rates() throws Throwable {
	   Response res= RestAssured.given().get();
	}

	@When("^: user enters valid API$")
	public void user_enters_valid_API() throws Throwable {
	   response=requestspec.when().get("https://api.ratesapi.io/api/latest");
	}

	@Then("^: user will able to see success status of response$")
	public void user_will_able_to_see_success_status_of_response() throws Throwable {
		ValidatableResponse statuscode=response.then()
						.statusCode(200)
						.assertThat()
						.body("base.rates.HKD" ,equalTo("11.2301"));
						Assert.assertEquals(statuscode, 200);
		 					
		 
	}
	
	//********************************3rd scenario*****************************
	@Given("^: User having rates APi for Specific foreign exchange rates$")
	public void user_having_rates_APi_for_Specific_foreign_exchange_rates() throws Throwable {
	    Response res=RestAssured.given().get();
	}

	@When("^: user enters incorrect API$")
	public void user_enters_incorrect_API() throws Throwable {
	response=requestspec.when()
				.get(" https://api.ratesapi.io/api/");
	}

	@Then("^: user can validate invaild status of response$")
	public void user_can_validate_invaild_status_of_response() throws Throwable {
	   response.then()
	   			.statusCode(400)
	   			.assertThat()
	   			.body("error", equalTo("time data 'api' does not match format '%Y-%m-%d'"));
	}
	
	
	
//******************************4th Scenario***************************
	@Given("^: User having rates APi for Specific date foreign exchange rates$")
	public void user_having_rates_APi1_for_Specific_date_foreign_exchange_rates() throws Throwable {

		Response res=RestAssured.given().get();
	}
	
	@When("^: user enters correct API$")
	public void user_enters_correct_API1() throws Throwable {
	response=requestspec.when()
				.get(" https://api.ratesapi.io/api/2010-01-12");
	}

	@Then("^: user can able to see success status of response$")
	public void user_can_able_to_see_success_status_of_response1() throws Throwable {
	
		  ValidatableResponse httpstatus= response.then()
		   					.statusCode(200);
		   					Assert.assertEquals(httpstatus, 200);
		   			
		   			
	}
	
	
	//*************************5th scenario*****************************
	@Given("^: User having rates APi for Specific date foreign exchange rates$")
	public void user_having_rates_APi_for_Specific_date_foreign_exchange_rates() throws Throwable {

		Response res=RestAssured.given().get();
	}
	
	@When("^: user enters correct API$")
	public void user_enters_correct_API() throws Throwable {
	response=requestspec.when()
				.get(" https://api.ratesapi.io/api/2010-01-12");
	}

	@Then("^: user can able to see valid response$")
	public void user_can_able_to_see_success_status_of_response() throws Throwable {
	Response response1 = null;
		  Response httpstatus= response.then()
		   					.statusCode(200)
		   					.extract().response();
		  					String validresponse=response1.asString();
		  					Assert.assertEquals(validresponse,containsString("AUD"),true);


		   					
		   			
		   			
	}
	
	
	//****************************6th Scenario*****************************
	@Given("^: User having rates APi for Specific date foreign exchange rates$")
	public void user_having_rates_API_for_Specific_date_foreign_exchange_rates() throws Throwable {

		Response res=RestAssured.given().get();
	}
	
	@When("^: user enters API with future date$")
	public void user_enters_correct_API2() throws Throwable {
	response=requestspec.when()
				.get(" https://api.ratesapi.io/api/2020-10-15");
	}

	@Then("^: user can able to see response$")
	public void user_can_able_to_see_success_status_of_responseValid() throws Throwable {
	
   ValidatableResponse response1=response.then()
		   					.statusCode(200)
		   					.assertThat()
		   					.body("base.rates.GBP", equalTo("0.91413"));
		   					
		   			
		   			
	}
	
	
	
	
	
}
