// ********RoostGPT********
/*
Test generated by RoostGPT for test hsbc-rest-assured using AI Type Open AI and AI Model gpt-4

Test generated for /status/instructions_post for http method type POST in rest-assured framework

RoostTestHash=01ecada2fa


*/

// ********RoostGPT********
package org.springframework.samples.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class statusInstructionsPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {"version"};
      envList = dataloader.load("src/test/java/org/springframework/samples/RoostTest/status_instructionsPostTest.csv", envVarsList);
    }

  
    @Test  
    public void statusInstructionsPost_Test() throws JSONException {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty()) ? testData.get("BASE_URL"): "https://hsbcdeveloperportalpreprod.digitalapicraft.com:8085/https://sandbox.ob.business.hsbc.com.hk/mock/open-banking/v1.0/direct-debit";  
  
                Response responseObj = given()
				.header("Authorization", testData.get("Authorization") != null ? testData.get("Authorization") : "")
				.header("x-fapi-customer-ip-address", testData.get("x-fapi-customer-ip-address") != null ? testData.get("x-fapi-customer-ip-address") : "")
				.header("x-fapi-auth-date", testData.get("x-fapi-auth-date") != null ? testData.get("x-fapi-auth-date") : "")
				.header("x-fapi-interaction-id", testData.get("x-fapi-interaction-id") != null ? testData.get("x-fapi-interaction-id") : "")
				.header("x-idempotency-key", testData.get("x-idempotency-key") != null ? testData.get("x-idempotency-key") : "")
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"merchantInstructionIdentification\": \"" + (testData.get("merchantInstructionIdentification") != null ? testData.get("merchantInstructionIdentification") : "") + "\",\n" +
					"  \"creditorAccount\": \"" + (testData.get("creditorAccount") != null ? testData.get("creditorAccount") : "") + "\n" +
 				"}")
                .when()
                .post("/status/instructions")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              if (testData.get("statusCode") != null) {
                MatcherAssert.assertThat(responseObj.statusCode(),
                    equalTo(Integer.parseInt(testData.get("statusCode"))));
              }
             else{
                 List<Integer> expectedStatusCodes = Arrays.asList(201,400,401,403,404,405,406,415,500);
              MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
                 }
              
        switch(responseObj.statusCode()){
        
          case 201:
         
          case 400:
         
          case 401:
         
          case 403:
         
          case 404:
         
          case 405:
         
          case 406:
         
          case 415:
         
          case 500:
         
           MatcherAssert.assertThat(contentType, equalTo("application/json"));
           break;
        
    }
      
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else if(contentType.contains("application/json")){  
                response = responseObj.jsonPath(); 
              } else {
                System.out.println("Response content type found: "+contentType+", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
                continue;
              }
         
                if (responseObj.statusCode() == 201) {
					System.out.println("Description: Created");
      
              if (response.get("paymentInformationStatus") != null) {  
                MatcherAssert.assertThat(response.get("paymentInformationStatus"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("paymentInformationStatus"), anyOf(equalTo("ACSC"), equalTo("RJCT"), equalTo("ACCP"), equalTo("ACSP")));
  
                MatcherAssert.assertThat(response.getString("paymentInformationStatus").length(), lessThanOrEqualTo(4));
  
          }
      
              if (response.get("processResult") != null) {      
              if (response.get("processResult.responseCode") != null) {  
                MatcherAssert.assertThat(response.get("processResult.responseCode"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("processResult.responseCode"), anyOf(equalTo("00"), equalTo("99")));
  
                MatcherAssert.assertThat(response.getString("processResult.responseCode").length(), lessThanOrEqualTo(4));
  
          }
      
              if (response.get("processResult.rejectReasonList") != null) {        
                  for (int i = 0; i < response.getList("processResult.rejectReasonList").size(); i++) {      
              if (response.get("processResult.rejectReasonList["+ i +"].rejectReasonCode") != null) {  
                MatcherAssert.assertThat(response.get("processResult.rejectReasonList["+ i +"].rejectReasonCode"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("processResult.rejectReasonList["+ i +"].rejectReasonCode").length(), lessThanOrEqualTo(10));
  
          }
      
              if (response.get("processResult.rejectReasonList["+ i +"].rejectReasonInfomation") != null) {  
                MatcherAssert.assertThat(response.get("processResult.rejectReasonList["+ i +"].rejectReasonInfomation"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("processResult.rejectReasonList["+ i +"].rejectReasonInfomation").length(), lessThanOrEqualTo(105));
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("processResult.rejectReasonList"), instanceOf(List.class));
  
          }
  
          }
      
              if (response.get("transactionIdentification") != null) {  
                MatcherAssert.assertThat(response.get("transactionIdentification"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("transactionIdentification").length(), lessThanOrEqualTo(35));
  
          }
				}
if (responseObj.statusCode() == 400) {
					System.out.println("Description: Bad Request");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 401) {
					System.out.println("Description: Authorisation failure");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 403) {
					System.out.println("Description: Authentication failure");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 404) {
					System.out.println("Description: Not Found");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 405) {
					System.out.println("Description: Method Not Allowed");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 406) {
					System.out.println("Description: Not Acceptable");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 415) {
					System.out.println("Description: Media Not Supported");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 500) {
					System.out.println("Description: Internal Server Error");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
  
            }  
    }
}
