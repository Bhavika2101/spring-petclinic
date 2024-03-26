// ********RoostGPT********
/*
Test generated by RoostGPT for test hsbc-rest-assured using AI Type Open AI and AI Model gpt-4

Test generated for /direct-debit-consents_post for http method type POST in rest-assured framework

RoostTestHash=a52d931828


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

public class directdebitconsentsPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {"version"};
      envList = dataloader.load("src/test/java/org/springframework/samples/RoostTest/direct-debit-consentsPostTest.csv", envVarsList);
    }

  
    @Test  
    public void directdebitconsentsPost_Test() {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty()) ? testData.get("BASE_URL"): "https://hsbcdeveloperportalpreprod.digitalapicraft.com:8085/https://sandbox.ob.business.hsbc.com.hk/mock/open-banking/v1.0/direct-debit";  
  
                Response responseObj = given()
				.header("Authorization", testData.get("Authorization") != null ? testData.get("Authorization") : "")
				.header("Content-Type", testData.get("Content-Type") != null ? testData.get("Content-Type") : "")
				.header("x-fapi-auth-date", testData.get("x-fapi-auth-date") != null ? testData.get("x-fapi-auth-date") : "")
				.header("x-fapi-customer-ip-address", testData.get("x-fapi-customer-ip-address") != null ? testData.get("x-fapi-customer-ip-address") : "")
				.header("x-fapi-interaction-id", testData.get("x-fapi-interaction-id") != null ? testData.get("x-fapi-interaction-id") : "")
				.header("Accept-Language", testData.get("Accept-Language") != null ? testData.get("Accept-Language") : "")
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"data\": \"" + (testData.get("data") != null ? testData.get("data") : "") + "\n" +
 				"}")
				.header("Authorization", "Bearer " + testData.get("bearer"))
                .when()
                .post("/direct-debit-consents")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else {  
                response = responseObj.jsonPath(); 
              }  
         
                if (responseObj.statusCode() == 201) {
					System.out.println("Description: Created");
      
              if (response.get("data") != null) {      
              if (response.get("data.consentId") != null) {  
                MatcherAssert.assertThat(response.get("data.consentId"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.consentId").length(), lessThanOrEqualTo(128));
  
                MatcherAssert.assertThat(response.getString("data.consentId").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("data.creationDate") != null) {  
                MatcherAssert.assertThat(response.get("data.creationDate"), instanceOf(String.class));  
          }
      
              if (response.get("data.status") != null) {  
                MatcherAssert.assertThat(response.get("data.status"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.status"), anyOf(equalTo("PendingAuthorise"), equalTo("Rejected"), equalTo("Authorised"), equalTo("Revoked")));
  
          }
      
              if (response.get("data.statusUpdateDate") != null) {  
                MatcherAssert.assertThat(response.get("data.statusUpdateDate"), instanceOf(String.class));  
          }
      
              if (response.get("data.permissions") != null) {      
                for (int i = 0; i < response.getList("data.permissions").size(); i++) {      
                  }    
                MatcherAssert.assertThat(response.getList("data.permissions"), instanceOf(List.class));
  
          }
      
              if (response.get("data.expirationDate") != null) {  
                MatcherAssert.assertThat(response.get("data.expirationDate"), instanceOf(String.class));  
          }
  
          }
      
              if (response.get("links") != null) {      
              if (response.get("links.self") != null) {  
                MatcherAssert.assertThat(response.get("links.self"), instanceOf(String.class));  
          }
      
              if (response.get("links.prev") != null) {  
                MatcherAssert.assertThat(response.get("links.prev"), instanceOf(String.class));  
          }
      
              if (response.get("links.next") != null) {  
                MatcherAssert.assertThat(response.get("links.next"), instanceOf(String.class));  
          }
  
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
					System.out.println("Description: Unauthorised");
				}
if (responseObj.statusCode() == 403) {
					System.out.println("Description: Forbidden");
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
					System.out.println("Description: Unsupported Media Type");
      
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
if (responseObj.statusCode() == 429) {
					System.out.println("Description: Too Many Requests");
      
              if (response.get("message") != null) {  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
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
if (responseObj.statusCode() == 503) {
					System.out.println("Description: Service Unavailable");
      
              if (response.get("message") != null) {  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
          }
				}
if (responseObj.statusCode() == 504) {
					System.out.println("Description: Gateway Timeout");
      
              if (response.get("message") != null) {  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
          }
				}
  
            }  
    }
}
