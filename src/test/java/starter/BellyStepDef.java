package starter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BellyStepDef {
    private Belly belly;

    @Given("I have {int} cukes in my belly")
    @DisplayName("Have cukes in belly")
    public void i_have_cukes_in_my_belly(int cukes) {
        belly = new Belly();
        belly.eat(cukes);
    }

    @When("I wait {int} hour")
    @DisplayName("Wait for some time")
    public void i_wait_hour(int hours) {
        belly.waitTime(hours);
    }

    @Then("my belly should growl")
    @DisplayName("Belly should growl")
    public void my_belly_should_growl() {
        assertEquals("Growl", belly.growl());
    }
}
