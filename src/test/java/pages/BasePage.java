package pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;    


public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    //private static Actions action;
    
 
    static{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeoptions = new ChromeOptions();
        driver = new ChromeDriver(chromeoptions);
        wait = new WebDriverWait(driver,30);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,30);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    //CERRAR INSTANCIA DEL BROWSER

    public static void closeBrowser(){
        driver.quit();    
    }
    
    private WebElement Find (String locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); 
    }

    //WEB ELEMENTS ACTIONS//

    //WEB ELEMENTS ACTIONS// CLICK ELEMENT GOOGLE BUTTON

    public void clickElement (String locator){
        Find(locator).click();
    }

    //WEB ELEMENTS ACTIONS// WRITE TEXT

    public void write (String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    //WEB ELEMENTS ACTIONS// SELECT FROM DROPDOWN

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect); 
    }

    //WEB ELEMENTS ACTIONS// CLICK CHECKBOX

    public void clicKCheckbox (String locator){
        Find(locator).click();
    }
    
    //WEB ELEMENTS ACTIONS// DOUBLE CLICK BUTTON

    Actions act = new Actions (driver);

    public void doubleClick(String locator){
        act.doubleClick(Find(locator)).perform();
   }

   //WEB ELEMENTS ACTIONS// RIGHT CLICK BUTTON

    public void rightClick (String locator){
      act.contextClick(Find(locator)).perform();
    }

    //WEB ELEMENTS ACTION// CLICK LINK TEXT

    public void goToLinkText(String link){
        driver.findElement(By.linkText(link)).click();;
    }

     //WEB ELEMENTS ACTIONS// HOVER OVER
    
    public void hoverOver(String locator){
        act.moveToElement(Find(locator)).perform();
    }

    //WEB ELEMENTS ACTIONS// GET VALUE FROM GRID AND ASSERT EQUALS

    public String getValueFromTable (String locator, int row, int column){
        String cellINeed=locator+"table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }

    //WEB ELEMENTS ACTIONS// SET VALUE ON GRID

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill=locator+"table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    //WEB ELEMENTS ACTIONS// SWITCH TO FRAME

    public void switchToIFrame (int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    //WEB ELEMENTS ACTIONS// SWITCH TO PARENT FRAME

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    //WEB ELEMENTS ACTIONS// CLOSE ALERT

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //ASSERTIONS// ASSERT EQUALS

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    //ASSERTIONS// ASSERT TRUE/FALSE IS DISPLAYED

    public boolean elementIsDisplay (String locator){
        return Find(locator).isDisplayed();
    }

    //ASSERTIONS// ASSERT TRUE/FALSE IS SELECTED

    public boolean elementIsSelected (String locator){
        return Find(locator).isSelected();
    }
    
    //ASSERTIONS// ASSERT TRUE/FALSE IS ENABLED

    public boolean elementIsEnabled(String locator){
        return Find(locator).isEnabled();
    }

    //ASSERTIONS// ASSERT LIST WITH LOOP //XPATH

    public List<WebElement>bringMeAllElementsXPath(String locator){
        return driver.findElements(By.xpath(locator));
    } 

    //ASSERTIONS// ASSERT LIST WITH LOOP //CLASSNAME

        public List<WebElement>bringMeAllElementsClassName(String locator){
            return driver.findElements(By.className(locator));
        }

        //FUNCION DE PATO//
        public void selectItems(String locator, int index){
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
        }





}
