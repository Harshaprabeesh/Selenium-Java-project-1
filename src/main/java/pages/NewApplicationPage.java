package pages;

import helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SINGenerator;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by s4876564 on 10/06/2019.
 */
public class NewApplicationPage extends HelperMethods {

private WebDriver driver;

    @FindBy(id = "201805091510380709106227")
    WebElement ApplicationPageLogo;

    @FindBy(css = "[data-test-id='LastName']")
    WebElement lastName;

    @FindBy(css = "[data-test-id='FirsttName']")
    WebElement firstName;

    @FindBy(css = "[data-test-id='SIN']")
    WebElement SIN;



    public NewApplicationPage(WebDriver driver){
//    this.driver = driver;
//        PageFactory.initElements(driver,this);

        super(driver);

}

    public void verifyAccountPage(){

    getText(ApplicationPageLogo);

 }

    public void enterFirstName (String firstName1) {
        webDriverWait.until(visibilityOf(this.firstName));
        firstName.clear();
        firstName.sendKeys(firstName1);


    }

    public void enterLastName (String lastName1) {
        webDriverWait.until(visibilityOf(this.lastName));
        firstName.clear();
        firstName.sendKeys(lastName1);

    }

   public void enterSinNumber(){

   String siNumber = SINGenerator.generateSIN();
   SIN.sendKeys(siNumber);


   }
    public String confirmULP(){

    String logo = ApplicationPageLogo.getText();
   return confirmULP().toString();
  }



}
