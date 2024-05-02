package steps;

import assessment.web.ui.pages.registrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class registration_page {
    @And("the user should see the sub header as {string}")
    public void theUserShouldSeeTheSubHeaderAs(String text) {
        new registrationPage().signUpPageSubHeader(text);
    }

    @And("user enters {string} as {string}")
    public void user_enter_personal_information(String input, String field) {
        new registrationPage().registrationDataInput(field, input);
    }

    @And("user selects {int} as year {string} as month {int} as date for {string}")
    public void user_select_date_of_birth(int year, String month, int date, String field) throws InterruptedException {
        new registrationPage().dobSelection(year, month, date);
    }


    @And("user adds {string} as {string}")
    public void user_enters_address(String input, String field) {
        new registrationPage().addressDetails(input, field);
    }


    @And("user clicks enter it manually option")
    public void userClicksEnterItManuallyOption() {
        new registrationPage().enterManualAddress();
    }

    @And("user validates the postcode")
    public void userValidatesThePostcode() {
        new registrationPage().validatePostcode();
    }


    @Then("user click on {string} button")
    public void userClickOnButton(String buttonName) {
        new registrationPage().nextBtnClick(buttonName);
    }

    @And("user validates the postcodes")
    public void userValidatesThePostcodes() {
        new registrationPage().validatePostcode();
    }
}
