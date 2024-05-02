package assessment.web.ui.pages;

import assessment.web.ui.utility.Constants;
import assessment.web.ui.utility.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class pointPage extends testBase {

    By headerLbl = By.xpath("//p[contains(.,'Every point matters')]");
    By nextBtn = By.xpath("//div[@id='app']/div[2]/div[2]/div/div/div/div/div[3]/div/div/button/p");
    public pointPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
    }

    public void pointPageHeader(String text ){
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLbl));
        Assert.assertEquals(element.getText(), text, "header text is different");
    }

    public void nextBtnClick(){
        element = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        element.click();
    }

}
