import org.checkerframework.checker.units.qual.C;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OUWSteps extends Steps {
    WebDriver driver = null;
    private OUWPage page = null;

    @BeforeScenario
    public void scenarioSetup() {
        driver = new ChromeDriver();
        page = new OUWPage(driver);
    }

    @Given("I am on the openunderwriter main page")
    public void givenOUWPage() {
        page.openPage();
    }

    @When("I log in as Adam")
    public void whenAdamLogsIn() throws InterruptedException {
        page.login("adam@openunderwriter.org", "adam");
    }

    @Then("I go to the sandpit")
    public void thenSandpit() {
        page.goToSandpit();
    }

    @Then("I pick the lifeplus quotation flow")
    public void thenLifeplus() throws InterruptedException {
        page.pickLifeplus();
    }

    @Then("I click Get A Quote")
    public void thenGetQuote() {
        page.clickGetQuote();
    }

    @Then("I enter my age as \"$age\"")
    public void thenAge(String age) throws InterruptedException {
        page.enterAge(age);
    }

    @Then("I enter my gender as \"$gender\"")
    public void thenEnterGenderMale(String gender) {
        page.enterGender(gender);
    }

    @Then("I enter my smoking status as \"$status\"")
    public void thenEnterSmokingStatus(String status) {
        page.enterSmoking(status);
    }

    @Then("I enter my regular exercise status as \"$status\"")
    public void thenEnterExerciseStatus(String status) {
        page.enterExercise(status);
    }

    @Then("I click quote")
    public void thenClickQuote() {
        page.clickQuote();
    }

    @Then("the System will say that there is no automated quotation")
    public void thenNoQuote() throws InterruptedException {
        page.noQuote();
    }

    @Then("the System will say that the price is \"$price\"")
    public void thenPrice(String price) throws InterruptedException {
        page.price(price);
    }

    @Then("I go to the policies page")
    public void thenGoToPolicies() {
        page.goToPolicies();
    }

    @Then("I select statuses \"$statuses\"")
    public void thenSelectStatuses(String statuses) throws InterruptedException {
        page.selectStatuses(List.of(statuses.split(", ")));
    }

    @Then("I select the product \"$product\"")
    public void thenSelectProduct(String product) throws InterruptedException {
        page.selectProduct(product);
    }

    @Then("I sort by \"$sortBy\"")
    public void thenSortBy(String sortBy) throws InterruptedException {
        page.sortBy(sortBy);
    }

    @Then("I click search")
    public void thenClickSearch() {
        page.clickSearch();
    }

    @Then("records are shown")
    public void thenRecordsAreShown() throws InterruptedException {
        page.recordsAreShown();
    }

    @Then("the following record IDs are shown \"$ids\"")
    public void thenIDsAreShown(String ids) throws InterruptedException {
        page.idsAreShown(List.of(ids.split(", ")));
    }

    @Then("no results are found")
    public void thenNoResultsAreFound() throws InterruptedException {
        page.noResultsAreFound();
    }

    @Given("I am on the travelplus quotation page")
    public void givenTravelplusPage() {
        page.openTravelPlusPage();
    }

    @Then("I fill the first page with valid information")
    public void thenFillFirstPage() {
        page.fillFirstPage();
    }

    @Then("I enter @ in the users name")
    public void thenEnterAtInUsersName() {
        page.enterInUsersName("@");
    }

    @Then("I enter a normal surname")
    public void thenEnterNormalSurname() {
        page.enterInUsersSurname("Pähkel");
    }

    @Then("I enter a normal age")
    public void thenEnterNormalAge() {
        page.enterInUsersAge("18");
    }

    @Then("I click Get a Quote")
    public void thenClickGetQuote() {
        page.clickGetQuote();
    }

    @Then("I should see the error message")
    public void thenErrorMessage() {
        page.errorMessage();
    }

    @Then("I enter a normal firstname")
    public void thenEnterNormalFirstname() {
        page.enterInUsersName("Paul");
    }

    @Then("I enter a invalid age")
    public void thenEnterInvalidAge() {
        page.enterInUsersAge("9999e9999");
    }

    @Then("I enter a sql injection")
    public void thenEnterSqlInjection() {
        page.enterInUsersName("' OR 1=1;");
    }

    @Then("I enter a firstname with an emoji")
    public void thenEnterEmoji() {
        page.enterInUsersName("\uD83E\uDDCD");
    }

    @Then("I enter a firstname with an symbol")
    public void thenEnterSymbol() {
        page.enterInUsersName("#");
    }

    @Then("I should be on the welcome page")
    public void thenWelcomePage() {
        page.welcomePage();
    }

    @When("I go to a protected route")
    public void whenGoToProtectedRoute() {
        page.goToProtectedRoute();
    }

    @Then("I redirected to the welcome page")
    public void thenRedirectedToWelcomePage() {
        page.welcomePage();
    }

    @Then("I search for a policy by id")
    public void thenSearchForPolicyById() {
        page.searchForPolicyById();
    }

    @Then("I will see that policy in the search results")
    public void thenSearchForPolicyByIdResult() {
        page.searchForPolicyByIdResult();
    }

    @AfterScenario
    public void afterScenario() {
        driver.quit();
    }
}
