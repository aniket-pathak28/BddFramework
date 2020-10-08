
Feature: To check Exchange rates functionality.

 @Test1
 Scenario: Verify response for latest foreign exchange rates
  
   Given User contains the API for particular foreign exchange rates site
    When user enters API
    Then user able to see status code as 200
   Feature: To check Exchange rates functionality.


@Test2
  Scenario:  Verify response for latest foreign exchange rates
  
  
  Given : User having rates APi for foreign exchange rates
  When : user enters API
  Then : user will able to see success status of response
  
  
@Test3
  Scenario: Verify Specific rates foreign exchange rates
  
  
  Given : User contains rates API for foreign exchange rates
  When : user enters incorrect API
  Then : user can validate invaild status of response
  
   @Test4
  Scenario: Verify Specific date rates foreign exchange rates
  
  
  Given : User having rates APi for Specific date foreign exchange rates
  When : user enters API
  Then : user can able to see success status of response
  
  
 
@Test5
  Scenario: Verify Specific date rates foreign exchange rates
  
  
  Given : User having rates API with Specific date foreign exchange rates
  When : user enters API
  Then : user can able to see valid response
  
@Test6
  Scenario: Verify Specific date rates foreign exchange rates by selecting future date
  
  
  Given : User having particular rates API for Specific date foreign exchange 
  When : user enters API with future date
  Then : user can able to see response 
  
  
  
  
  
  
  
  
  
  