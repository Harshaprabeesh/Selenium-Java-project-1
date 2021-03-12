package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fasterxml.jackson.databind.JsonNode;
import helper.BaseTest;
import helper.PropertiesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewAccounSetUpPage;
import pages.NewApplicationPage;


public class LoginTest extends BaseTest  {

    public WebDriver driver;
    PropertiesHelper propertiesHelper = new PropertiesHelper();

    public String userName = "bbb";
    public String pwd = "bbb";
    public String url = "";
    public String environment = "";
    protected ExtentHtmlReporter picreporter;
    protected ExtentReports picreport;
    protected JsonNode picOnboarding = null;
    protected  String jsonPath = "src/resources/data/happypath/";
    LoginPage loginPage = new LoginPage(driver);
//    NewAccounSetUpPage newAccounSetUpPage = new NewAccounSetUpPage(driver);
//    NewApplicationPage newApplicationPage = new NewApplicationPage(driver);


//    @BeforeClass
//     public void init() {
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\s4876564\\Drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        environment = propertiesHelper.readProperty("Environment");
//        setCredentials(environment);
//        driver.get(url);
//        driver.manage().window().maximize();
//
//    }
//    @Test(description="Browser settings",priority=1)
//    //environment = ENV.isEmpty() ? propertiesHelper.readProperty("ENVIRONMENT") : ENV;
//    public void setCredentials(String env) {
//
//        if (env.equalsIgnoreCase("IST")) {
//            userName = propertiesHelper.readProperty("IST_USERID1");
//            pwd = propertiesHelper.readProperty("IST_PASSWORD1");
//            url = propertiesHelper.readProperty("IST_URL");
//        }
//
////       else if(env.equalsIgnoreCase("DEV")){
////
////           USERID = propertiesHelper.readProperty("");
////           PASSWORD = propertiesHelper.readProperty("");
////           url = propertiesHelper.readProperty("");
////
////       }
////       else if(env.equalsIgnoreCase("UAT")){
////
////           USERID = propertiesHelper.readProperty("");
////           PASSWORD = propertiesHelper.readProperty("");
////           url = propertiesHelper.readProperty("");
////       }
//        else {
//            System.out.println("Unspported Environemnt.Set DEV/IST/UAT in environment file. Program will exit.");
//            System.exit(-1);
//        }
//
//
//
//
//    }
//
//

    @Test(description="Login Method",priority=2)
    public void validLogin() {


    loginPage.userLogin(userName,pwd);


//      Assert.assertEquals("SCOTIA BANK","SCOTIA BANK","FAILED.....]");


//}
//    @Test(description="ULP Page",priority=3)
//    public void newAccountPage(){
//    newAccounSetUpPage.createNewApplication();
//    Assert.assertTrue(true,"");
//
//
//}
//
//    @Test(description="New Application Page",priority=4)
//
//   public void newApplicationPage(){
//   newApplicationPage.enterFirstName(firstName);

   }
}
