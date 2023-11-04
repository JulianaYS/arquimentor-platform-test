package com.arquimentor.platform.test.step;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreatePublicationResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.PublicationResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
public class PublicationStepDefinitions {

    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int randomServerPort;
    private String endpointPath;
    private ResponseEntity<String> responseEntity;
    @Given("the endpoint {string} is available")
    public void theEndpointIsAvailable(String endpointPath) {
        this.endpointPath = String.format(endpointPath, randomServerPort);
        testRestTemplate = new TestRestTemplate();
    }

    @When("a POST Request is sent with values {string}, {string}, {string}, {long}")
    public void aPOSTRequestIsSentWithValues(String title, String description, List<String> image, Long mentorId) {
        CreatePublicationResource resource = new CreatePublicationResource(title,description,image,mentorId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreatePublicationResource> request = new HttpEntity<>(resource,headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath,request,String.class);

    }
    @Then("a Response is received with Status {int}")
    public void aResponseIsReceivedWithStatus(int expectedStatusCode) {
        int actualStatusCode = responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }

    @And("a Publication resource is included in Response Body with values {string}, {string}, [{string}, {string}], {string}, {int}")
    public void aPublicationResourceIsIncludedInResponseBodyWithValues(String arg0, String arg1, String arg2, String arg3, String arg4, int arg5) {
        /*PublicationResource expectedResource = new PublicationResource()
                .withTitle()
                .withAge(age)
                .withAddress(address);
        String value = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        StudentResource actualResource;
        try {
            actualResource = mapper.readValue(value, StudentResource.class);

        } catch (JsonProcessingException | NullPointerException e) {
            actualResource = new StudentResource();
        }
        expectedResource.setId(actualResource.getId());
        assertThat(expectedResource).usingRecursiveComparison().isEqualTo(actualResource);*/
    }

    @Given("a publication resource with values {string}, {string}, [{string}, {string}], {string}, {int} is already stored")
    public void aPublicationResourceWithValuesIsAlreadyStored(String arg0, String arg1, String arg2, String arg3, String arg4, int arg5) {
    }

    @When("a POST Request is sent values {string}, {string}, [{string}, {string}], {string}, {int}")
    public void aPOSTRequestIsSentValues(String arg0, String arg1, String arg2, String arg3, String arg4, int arg5) {
    }

    @And("a Message is included in Response Body, with the message {string}")
    public void aMessageIsIncludedInResponseBodyWithTheMessage(String arg0) {
    }


}

