package pages;

import helper.HelperMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by s4876564 on 10/06/2019.
 */
public class NewAccounSetUpPage extends HelperMethods {


  protected WebDriver driver;

  @FindBy(id="ButtonCreateNewApplication")
    WebElement createNewApplicationButton;


  public NewAccounSetUpPage(WebDriver driver){

//      driver = this.driver;
//      PageFactory.initElements(driver,this);

        super(driver);

  }

  public void createNewApplication(){

    click(createNewApplicationButton);
  }


}
