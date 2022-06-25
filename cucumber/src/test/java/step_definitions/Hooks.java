package step_definitions;

//import cucumber.api.java.Before;
//import cucumber.api.java.Before;
//import org.junit.jupiter.api.AfterAll;
import cucumber.api.java.Before;
import org.testng.annotations.AfterSuite;
//import io.cucumber.java.Before;

public class Hooks {

    @Before("@DeletePlace")
    public  void beforeScenario() throws Exception {
        APIStepDefinitions m = new APIStepDefinitions();
        if(APIStepDefinitions.place_id==null) {

            m.add_Place_payload_with("AAVI", "English", "Pitt");
            m.user_call_with_http_request("addPlaceAPI", "POST");
            m.verify_place_id_created_map_to_using("AAVI", "getPlaceAPI");
        }

    }


}
