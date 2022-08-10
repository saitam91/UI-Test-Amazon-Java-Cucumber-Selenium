package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.AmazonPage;

public class AmazonSteps {

    AmazonPage amazon = new AmazonPage();
    
    @Given("^the user navigate to www.amazon.com$")
    public void navigatToAmazonPage(){

       //amazon.navigateToSecondpage();

        amazon.navigateToAmazon();

    }

    @And("^search for (.+)$")
    public void searchCriteria(String item){
        amazon.enterSearchCriteria(item);
        amazon.clickSearchButon();
    }

   @When("^navigate to page number (.+)$")
    public void goToSecondPage(String pageNumber){
        amazon.goToPage(pageNumber);
        //amazon.getItemsString();


    }

    @And("^select item (.+)$")
    public void selectThirdItem(int item){

        //amazon.selectThirdItem();
        amazon.selectThirdItem2(item);
   }

  @Then("^the user is able to add it to the cart$")
    public void addToCart(){
        amazon.addItemToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addToCartMessage());
    }
   }
    
   


    
   
  
    



