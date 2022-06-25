package step_definitions;




import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
public class PrintStepDefinitions {

    @Given("^I go to school$")
    public void i_go_to_school() throws Throwable {
        System.out.println("I go to school");
    }

    @When("^I seat in the bench$")
    public void i_seat_in_the_bench() throws Throwable {
        System.out.println("I seat in the bench");
    }

    @Then("^I see the board$")
    public void i_see_the_board() throws Throwable {
        System.out.println("I see the board");
    }

    @Then("^I came back to home$")
    public void i_came_back_to_home() throws Throwable {
        System.out.println("I came back to home");
    }

}