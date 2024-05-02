package steps;

import assessment.web.ui.pages.loginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class login_steps {

    @When("the user should see the header {string} on the page")
    public void enter_username(String headerName) {
       new loginPage().loginPageHeader(headerName);
    }

    @When("user click on the signup button")
    public void enter_password() {
        new loginPage().signUpBtnClick();
    }


}
