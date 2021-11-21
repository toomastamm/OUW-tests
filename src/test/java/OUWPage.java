import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OUWPage {

    private String DEFAULT_URL = "http://65.108.50.84:8080/";
    private String SANDPIT_EXTENSION = "web/ou/sandpit";
    private String POLICIES_EXTENSION = "web/ou/policies";
    private String PROTECTED_ROUTE_EXTENSION = "web/ou/sandpit";
    private String TRAVEL_PLUS_EXTENSION = "/web/travelplus/get-a-quote";

    private WebDriver driver;
    private WebElement element;

    public OUWPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void openPage() {
        driver.get(DEFAULT_URL);
    }


    public void login(String username, String password) throws InterruptedException {
        element = driver.findElement(By.id("_58_login"));
        element.clear();
        element.sendKeys(username);
        element = driver.findElement(By.id("_58_password"));
        element.sendKeys(password);
        element = driver.findElements(By.tagName("button")).get(0);
        element.click();
    }

    public void goToSandpit() {
        driver.get(DEFAULT_URL + SANDPIT_EXTENSION);
    }


    public void pickLifeplus() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("selectedProduct")));
        select.selectByValue("AIL.Demo.LifePlus");
        select = new Select(driver.findElement(By.id("selectedPageFlow")));
        select.selectByValue("QuotationPageFlow");
    }

    public void clickGetQuote() {
        element = driver.findElement(By.id("Quote"));
        element.click();
    }

    public void enterAge(String s) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        element = driver.findElement(By.xpath("//input[@name='L2Fzc2V0W2lkPSdhc3NldCddL2F0dHJpYnV0ZVtpZD0nYWdlJ10']"));
        element.sendKeys(s);
    }

    public void enterGender(String s) {
        Select select = new Select(driver.findElement(By.name("L2Fzc2V0W2lkPSdhc3NldCddL2F0dHJpYnV0ZVtpZD0nZ2VuZGVyJ10")));
        select.selectByValue(s);
    }

    public void enterSmoking(String status) {
        Select select = new Select(driver.findElement(By.name("L2Fzc2V0W2lkPSdhc3NldCddL2F0dHJpYnV0ZVtpZD0nc21va2VyJ10")));
        select.selectByValue(status);
    }

    public void enterExercise(String status) {
        Select select = new Select(driver.findElement(By.name("L2Fzc2V0W2lkPSdhc3NldCddL2F0dHJpYnV0ZVtpZD0nZXhlcmNpc2UnXQ")));
        select.selectByValue(status);
    }

    public void clickQuote() {
        element = driver.findElement(By.id("OQ0-1-1-0"));
        element.click();
    }

    public void noQuote() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        String bodyText = driver.findElement(By.id("OQ0-3-0-not")).getText();
        Assert.assertTrue("No quote text found!", bodyText.contains("our online system is unable to offer you an automated quotation"));
    }

    public void price(String price) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        String bodyText = driver.findElement(By.id("OQ0-2-0")).getText();
        Assert.assertTrue(String.format("Price %s not found!", price), bodyText.contains(price));
    }

    public void goToPolicies() {
        driver.get(DEFAULT_URL + POLICIES_EXTENSION);
    }

    public void selectStatuses(List<String> statuses) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        Select select = new Select(driver.findElements(By.className("gwt-ListBox")).get(1));

        select.deselectAll();

        for (String status : statuses) {
            select.selectByValue(status);
        }
    }

    public void sortBy(String sortBy) throws InterruptedException {
        Select select = new Select(driver.findElements(By.className("gwt-ListBox")).get(2));
        select.selectByValue(sortBy);
        TimeUnit.SECONDS.sleep(2);
    }

    public void clickSearch() {
        element = driver.findElements(By.className("gwt-Button")).get(2);
        element.click();
    }

    public void recordsAreShown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        // Element exists, assume records shown.
        element = driver.findElement(By.id("gui-POLICYSEARCH-advancedsearch-results"));
    }

    public void idsAreShown(List<String> split) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);

        element = driver.findElement(By.id("gui-POLICYSEARCH-advancedsearch-results"));
        String bodyText = element.getText();

        for (String id : split) {
            Assert.assertTrue(String.format("ID %s not found!", id), bodyText.contains(id));
        }
    }

    public void selectProduct(String product) {
        Select select = new Select(driver.findElements(By.className("gwt-ListBox")).get(0));
        select.selectByValue(product);
    }

    public void noResultsAreFound() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        element = driver.findElement(By.id("gui-POLICYSEARCH-advancedsearch-results"));
        String bodyText = element.getText();
        Assert.assertTrue("No results found!", bodyText.contains("No Results Found"));
    }

    public void openTravelPlusPage() {
        driver.get(DEFAULT_URL + TRAVEL_PLUS_EXTENSION);
    }

    public void fillFirstPage() {
        Select select = new Select(driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div/div[1]/div[2]/div/div[2]/select")));
        select.selectByValue("i18n_policy_type_single_trip_option");

        select = new Select(driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div/div[3]/div[2]/div/div[2]/select")));
        select.selectByValue("i18n_destination_europe_option");

        select = new Select(driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div/div[4]/div[2]/div/div[2]/select")));
        select.selectByValue("i18n_party_type_individual_option");

        element = driver.findElement(By.xpath("//*[@id=\"Next\"]"));
        element.click();
    }

    public void enterInUsersName(String toEnter) {
        element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/input"));
        element.sendKeys(toEnter);
    }

    public void enterInUsersSurname(String toEnter) {
        element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/input"));
        element.sendKeys(toEnter);
    }

    public void enterInUsersAge(String s) {
        element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div[2]/div/div/div[2]/div[3]/div/div[2]/input"));
        element.sendKeys(s);
    }

    public void errorMessage() {
        element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div[2]/section/div/div/div/div/div/div/form/div[1]/div[2]/div/div/div[2]/div[4]/div/div[2]/div"));
        String bodyText = element.getText();
        Assert.assertTrue("Error message not found!", bodyText.contains("Please enter a valid first name"));
    }

    public void welcomePage() {
        Assert.assertTrue("Welcome page not found!", driver.getCurrentUrl().contains("/welcome"));
    }

    public void goToProtectedRoute() {
        driver.get(DEFAULT_URL + PROTECTED_ROUTE_EXTENSION);
    }

    public void searchForPolicyById() {
        element = driver.findElements(By.tagName("input")).get(3);
        element.sendKeys("16280");
    }

    public void searchForPolicyByIdResult() {
        element = driver.findElement(By.id("gui-POLICYSEARCH-advancedsearch-results"));
        String bodyText = element.getText();
        Assert.assertTrue("ID not found!", bodyText.contains("16280"));
    }
}
