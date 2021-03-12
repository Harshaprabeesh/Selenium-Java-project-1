package helper;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//mport utilities.FileUtils;

import java.io.File;

public class BaseTest {

    public WebDriver driver;
    PropertiesHelper propertiesHelper = new PropertiesHelper();

    public String userName = "";
    public String pwd = "";
    public String url = "";
    public String environment = "";
    protected ExtentHtmlReporter picreporter;
    protected ExtentReports picreport;
    protected JsonNode picOnboarding = null;
    protected  String jsonPath = "src/resources/data/happypath/";

    //initialize driver
    @BeforeSuite(alwaysRun = true)
    public void init() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\s4876564\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        environment = propertiesHelper.readProperty("Environment");
        setCredentials(environment);
        driver.get(url);
        driver.manage().window().maximize();

    }

    //environment = ENV.isEmpty() ? propertiesHelper.readProperty("ENVIRONMENT") : ENV;
    public void setCredentials(String env) {

        if (env.equalsIgnoreCase("IST")) {
            userName = propertiesHelper.readProperty("IST_USERID1");
            pwd = propertiesHelper.readProperty("IST_PASSWORD1");
            url = propertiesHelper.readProperty("IST_URL");
        }

//       else if(env.equalsIgnoreCase("DEV")){
//
//           USERID = propertiesHelper.readProperty("");
//           PASSWORD = propertiesHelper.readProperty("");
//           url = propertiesHelper.readProperty("");
//
//       }
//       else if(env.equalsIgnoreCase("UAT")){
//
//           USERID = propertiesHelper.readProperty("");
//           PASSWORD = propertiesHelper.readProperty("");
//           url = propertiesHelper.readProperty("");
//       }
        else {
            System.out.println("Unspported Environemnt.Set DEV/IST/UAT in environment file. Program will exit.");
            System.exit(-1);
        }




    }

//    public void extentReports(String jsonFileName){
//        picOnboarding =
//        picOnboarding = FileUtils.readTreeJson(jsonPath+jsonFileName).path("Data");
//        picreporter = new ExtentHtmlReporter(propertiesHelper.readProperty("PIC REGRESSION HAPPY PATH REPORT")+ jsonFileName.replace(".json", "") + ".html");
//        picreporter.config().setAutoCreateRelativePathMedia(true);
//
//        System.out.println("Report available at " + propertiesHelper.readProperty("PIC REGRESSION HAPPY PATH REPORT") + jsonFileName.replace(".json", "") + ".html");
//        picreport = new ExtentReports();
//        picreport.attachReporter(picreporter);
//
//    }

//        @AfterSuite
//        public void tearDown () {
//
//            driver.quit();
//        }

}
