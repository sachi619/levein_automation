package steps;

import assessment.web.ui.pages.pointPage;
import io.cucumber.java.en.And;

public class points_steps {

    @And("the user should see the header as {string} in points page")
    public void theUserShouldSeeTheHeaderAsInPointsPage(String text) {
        new pointPage().pointPageHeader(text);
    }


}
