package helper;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {

    public WebDriver driver;
    protected WebDriverWait webDriverWait;

    public HelperMethods(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);//This calls constructor of the respective Page Class object

    }

    public void waitForVisibilityAndEnterData(WebElement element, String data) {
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        try {
            wait1.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (StaleElementReferenceException e) {
            wait2.until(ExpectedConditions.visibilityOf(element)).click();
        }
        element.sendKeys(data);
    }

    public void inputData(WebElement input, String data) {

        input.sendKeys(data);
    }

    public void click(WebElement element) {

        element.click();
    }


    public void selectValueFromDropdown(WebElement select, String value) throws InterruptedException {
        WebDriverWait waitForDropdown = new WebDriverWait(driver, 30);
        Select dropdown = null;
        try {
            waitForDropdown.until(ExpectedConditions.visibilityOf(select));
            dropdown = new Select(select);
            dropdown.selectByVisibleText(value);
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element exception caught during selection of dropdown value:" + value + ", on element:" + select.toString());
            Thread.sleep(3000);
            dropdown = new Select(select);
            dropdown.selectByVisibleText(value);
        } catch (NoSuchElementException nse) {
            System.out.println("Could not select " + value + " from dropdown:" + select.toString());
        } catch (Exception ex) {
            System.out.println("Exception caught during selection of dropdown value:" + value + ", on element:" + select.toString());
            dropdown = new Select(select);
            dropdown.selectByVisibleText(value);
        }

    }

    public void getText(WebElement value) {
        String headerName = value.getText();
        System.out.println("The current page is " + headerName);

    }

}
