package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AmazonPage extends BasePage {
    
    public AmazonPage(){
        super(driver);
    }

    private String searchField = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String pickThirdItem = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]";
    private String pickThirdItem2="//div[@class='sg-col-inner']//div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
    private String addToCart = "//input[@id='add-to-cart-button']";
    private String addToCartMsg = "//span[contains(text(),'Agregado al carrito')]";
    
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com/");
    }
    public void navigateToSecondpage(){
        navigateTo("https://www.amazon.com/s?k=mac&page=2&crid=2AL2ATT90H7IB&qid=1651882495&sprefix=ma%2Caps%2C374&ref=sr_pg_2");
    }

    public void enterSearchCriteria (String criteria){
        write(searchField, criteria);
    }

    public void clickSearchButon(){
        clickElement(searchButton);
    }

    public void goToPage(String pageNumber){
        goToLinkText(pageNumber);
    }

    public List<String> getItemsString() {
        List<WebElement>list = bringMeAllElementsXPath(pickThirdItem2);
        List <String>stringsFromList2 = new ArrayList<String>();
        for(WebElement e:list){
            stringsFromList2.add(e.getText());
        }
        return stringsFromList2;
    }

    /*public void selectThirdItem(){
        clickElement(pickThirdItem);
    }*/

    public void selectThirdItem2(int index){
        selectItems(pickThirdItem2,index);
    }

    public void addItemToCart(){
        clickElement(addToCart);
        }

    public String addToCartMessage(){
        return textFromElement(addToCartMsg);
    }


}
