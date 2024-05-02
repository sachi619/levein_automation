package assessment.web.ui.pages;

import assessment.web.ui.utility.Constants;
import assessment.web.ui.utility.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class registrationPage extends testBase {
    public static Actions actions = new Actions(driver);

    By dobField = By.xpath("//input[@name='dob']");
    By confirmBtn = By.xpath("//p[contains(.,'Confirm')]");
    By subHeader = By.xpath("//div[@id='app']/div[2]/div[2]/div/div/div/div/div[2]/div/form/div/p");
    By NoLbl = By.xpath("//p[contains(.,'Mobile phone number')]");
    By addressLbl = By.linkText("Enter it manually");
    By lookupBtn = By.xpath("//button[contains(.,'Look up')]");


    public registrationPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
    }

    public void signUpPageSubHeader(String text) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(subHeader));
        Assert.assertEquals(element.getText(), text, "Sub header text is different");
    }

    public void registrationDataInput(String field, String input) {
        switch (field.toLowerCase()) {
            case "first name" -> {
                field = "//input[@id='signup/create-account/first-name']";
            }
            case "last name" -> {
                field = "//input[@id='signup/create-account/last-name']";
            }
            case "email" -> {
                Random random = new Random();
                int no = random.nextInt(100);
                field = "//input[@id='signup/create-account/email']";
                String[] splitEmail = input.split("@");
                input = splitEmail[0] + no + "@" + splitEmail[1];

            }
            case "password" -> {
                field = "//input[@id='signup/create-account/password']";
            }
            case "mobile no" -> {
                field = "//input[@id='signup/create-account/phone']";
            }
        }
        By fieldElement = By.xpath(field);
        WebElement inputField = driver.findElement(fieldElement);
        actions.moveToElement(inputField).perform();
        inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldElement));
        inputField.sendKeys(input);
    }

    public void dobSelection(int year, String month, int date) throws InterruptedException {
        WebElement dateOfBirth = driver.findElement(dobField);
        actions.moveToElement(dateOfBirth).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dobField));
        dateOfBirth.click();
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
        WebElement yearSelection = driver.findElement(By.xpath("//div[contains(@class, 'MuiPickersYear-root') and text()='" + year + "']"));

        while (!yearSelection.isDisplayed()) {
            actions.moveToElement(yearSelection).perform();
        }
        yearSelection.click();
        Thread.sleep(3000);

        String[] monthValues = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


        WebElement currentMonthElement = driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/div/div/div/p"));
        String currentMonthYear = currentMonthElement.getText();
        String[] currentMonthYearArray = currentMonthYear.split(" ");
        String currentMonth = currentMonthYearArray[0];
        int currentMonthIndex = 0;
        for (int i = 0; i < monthValues.length; i++) {
            if (monthValues[i].equals(currentMonth)) {
                currentMonthIndex = i;
                break;
            }
        }
        int inputMonthIndex = 0;
        for (int i = 0; i < monthValues.length; i++) {
            if (monthValues[i].equals(month)) {
                inputMonthIndex = i;
                break;
            }
        }
        int difference = inputMonthIndex - currentMonthIndex;

        if (difference < 0) {
            for (int i = 0; i < Math.abs(difference); i++) {
                Thread.sleep(2000);
                WebElement leftButton = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]"));
                leftButton.click();
                Thread.sleep(1000);
            }
        } else if (difference > 0) {
            for (int i = 0; i < Math.abs(difference); i++) {
                Thread.sleep(2000);
                WebElement rightButton = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]"));
                rightButton.click();
                Thread.sleep(1000);
            }
        }
        Thread.sleep(3000);
        WebElement dateElement = driver.findElement(By.xpath("//p[text()='" + date + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(dateElement));
        dateElement.click();


    }

    public void enterManualAddress() {
        element = wait.until(ExpectedConditions.elementToBeClickable(NoLbl));
        element.click();
        actions.moveToElement(element).sendKeys(org.openqa.selenium.Keys.END).build().perform();
        element = wait.until(ExpectedConditions.elementToBeClickable(addressLbl));
        element.click();
    }

    public void addressDetails(String text, String field) {
        switch (field.toLowerCase()) {
            case "postcode" -> {
                field = "//input[@id='signup/create-account/post-code']";
            }
            case "building name" -> {
                field = "//input[@id='signup/create-account/building-name']";
            }
            case "building number" -> {
                field = "//input[@id='signup/create-account/building-number']";
            }
            case "address 1" -> {
                field = "//input[@id='signup/create-account/address-line-1']";
            }
            case "address 2" -> {
                field = "//input[@id='signup/create-account/address-line-2']";
            }
            case "town or city" -> {
                field = "//input[@id='signup/create-account/town-city']";
            }
            case "county" -> {
                field = "//input[@name='state']";
            }
        }
        By fieldElement = By.xpath(field);
        WebElement inputField = driver.findElement(fieldElement);
        actions.moveToElement(inputField).perform();
        inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldElement));
        inputField.sendKeys(text);
    }

    public void validatePostcode(){
        element = wait.until(ExpectedConditions.elementToBeClickable(lookupBtn));
        element.click();
    }

    public void nextBtnClick(String buttonName){
        By nextBtn = By.xpath("//p[contains(.,'"+buttonName+"')]");
        element = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        element.click();
    }
}
