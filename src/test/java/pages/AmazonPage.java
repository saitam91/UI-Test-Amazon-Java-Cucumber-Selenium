package pages;


public class AmazonPage extends BasePage {
    
    public AmazonPage(){
        super(driver);
    }

    private String searchField = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String pickThirdItem2="//div[@class='sg-col-inner']//div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";
    private String addToCart = "//input[@id='add-to-cart-button']";
    private String addToCartMsg = "//span[contains(text(),'Agregado al carrito')]";
    
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com/");
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
