package assessment.web.ui.pages;

import assessment.web.ui.utility.Constants;
import assessment.web.ui.utility.testBase;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class planSelectionPage extends testBase {

    public planSelectionPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
    }


    public void planSelection(String planName){
        By planSelectionTab = By.xpath("//p[contains(.,'" + planName + "')]");
        element = wait.until(ExpectedConditions.elementToBeClickable(planSelectionTab));
        element.click();
    }
}
