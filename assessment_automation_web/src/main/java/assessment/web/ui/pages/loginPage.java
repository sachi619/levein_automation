package assessment.web.ui.pages;

import assessment.web.ui.utility.Constants;
import assessment.web.ui.utility.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class loginPage extends testBase {

    By signUpBtn = By.xpath("//a[contains(text(),'Sign up here!')]");
    By loginPageLabel = By.xpath("//p[contains(.,'Log in')]");

    public loginPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
    }

    public void loginPageHeader(String headerName) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageLabel));
        Assert.assertEquals(element.getText(), headerName, "login page header different");
    }

    public void signUpBtnClick() {
        element = wait.until(ExpectedConditions.elementToBeClickable(signUpBtn));
        element.click();
    }
}
