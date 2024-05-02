package steps;

import assessment.web.ui.pages.planSelectionPage;
import assessment.web.ui.pages.pointPage;
import io.cucumber.java.en.And;

public class plan_selection_steps {


    @And("user select plan as {string}")
    public void userSelectPlanAs(String planName) {
        new planSelectionPage().planSelection(planName);
    }
}
