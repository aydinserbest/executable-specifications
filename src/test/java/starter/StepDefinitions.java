package starter;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @When("I am greeted")
    public void i_am_greeted() {
        System.out.println("hi");
    }
    @Then("I should hear {string}")
    public void i_should_hear(String string) {
    }
}
