# Test Amazon Web Java-Cucumber-Selenium

## Resume:
* This automated UI test framework was created based on BDD carrying out the best testing practices.
* To achieve this test framework, test cases in Amazon web page following this steps were created:

  **1. Navigate to Amazon web page.**

  **2. Search a product.**
  
  **3. Navigate to page number 2 of the result search.**
  
  **4. Select the third item from the result search.**
  
  **5. Validate the item previously selected was add to the cart.**
 
-----------------------  

* In order to automate these test cases, the following classes and files were created:

  ***1. build.gradle file***  to define the build configurations that will be applied to all the modules in the project.

  ***2. Runner java class***  to execute scenario we want and how we want cucumber to run.
  
  ***3. Feature file***  in gherkin language where to declare the scenearios and declare in a parameterized way the items criteria to perform the search, the page number and the item to select from the result search.
  
  ***4. Base page java class*** where a single instance of the webdriver is created, and different methods to interact with the web elements, the other pages will inherit these functionalities.
  
  ***5. Step java class***  where the methods to be reproduced by the gherkin scenarios are implemented.
  
  ***6. Page java class***  where we will inherit the functionalities from the base page for interact with web elements.
  
------------------------
  
  ## Technologies used:

   - Language: JAVA

   - Building Tool: Gradle

   - Libraries: Selenium-Cucumber 

* Enviroment Configuration:

  - Download and set JAVA environment variables (JAVA_HOME and PATH):JDK (17.0.2)

  - Download and installation IDE (IntelliJ IDEA)

* Cucumber Reports:

  - test-output/HtmlReport/ExtentHtml.html
  
  
 * Run Tests:

   - gradle clean
   
   - gradle clean test -D cucumber.options="--tags '@Amazon'"

