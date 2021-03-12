package pages;


import helper.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HelperMethods   {

    public  WebDriver driver;


    @FindBy(xpath="//input[@id='txtUserID']")
    WebElement userId;

    @FindBy(id="txtPassword")
    WebElement userPassword;

    @FindBy(id ="sub")
    WebElement loginButton;

    @FindBy(xpath = "//img[@class='logo']")
    WebElement header;

   //Constructor
    public LoginPage(WebDriver driver) {

//     this.driver =driver;
//     PageFactory.initElements(driver,this);
        super(driver);
    }

    public void userLogin(String user,String password  ) {


      //waitForVisibilityAndEnterData(userId,user);
      inputData(userId,user);
      waitForVisibilityAndEnterData(userPassword,password);
      click(loginButton);
    //  userId.click();

//         driver.findElement(By.id("txtUserID")).sendKeys("PICPA2@BNS");
//         inputData(userPassword,password);
//         click(loginButton);



    }

}


