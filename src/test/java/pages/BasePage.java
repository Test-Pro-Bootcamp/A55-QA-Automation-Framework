package pages;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    // Timeouts for different wait operations
    private static final int DEFAULT_TIME_OUT_IN_SECONDS = 10; // Default timeout
    private static final int LONG_TIME_OUT_IN_SECONDS = 30; // Long timeout
    private static final int SHORT_TIME_OUT_IN_SECONDS = 5; // Short timeout
    private static final int DEFAULT_TIMEOUT_FOR_PAGE_LOAD = 20; // Page load timeout

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    // Constructor to initialize WebDriver, WebDriverWait, and Actions
    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS));
        action = new Actions(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    /* Wait Methods */

    // Wait until the element is visible
    public WebElement waitForPresence(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until all elements are visible
    public List<WebElement> waitForPresenceOfAllElements(WebElement element, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    // Wait until the element is visible with custom timeout
    public WebElement waitForVisibility(WebElement element, int timeout) {
        System.out.println("Wait element will be visible");
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until all elements are visible (default timeout)
    public List<WebElement> waitUntilAllElementsLocatedByAreVisible(WebElement element) {
        System.out.println("Wait until all elements will be visible");
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    // Wait until all elements are visible with custom timeout
    public List<WebElement> waitUntilAllElementsLocatedByAreVisible(WebElement element, int timeout) {
        System.out.println("Wait until all elements will be visible");
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    // Wait until all elements are invisible (default timeout)
    public boolean waitUntilRequiredElementsAreInvisible(List<WebElement> elements) {
        System.out.println("Wait until all elements will be invisible");
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    // Wait until all elements are invisible with custom timeout
    public boolean waitUntilRequiredElementsAreInvisible(List<WebElement> elements, int timeout) {
        System.out.println("Wait until all elements will be invisible");
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    // Wait until the element is visible (default timeout)
    public WebElement waitForVisibility(WebElement element) {
        return waitForVisibility(element, DEFAULT_TIME_OUT_IN_SECONDS);
    }

    // Wait until the element is clickable
    public WebElement waitForClickable(WebElement element) {
        System.out.println("Wait element will be clickable");
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait until the element is clickable with custom timeout
    public WebElement waitForClickable(WebElement element, int timeout) {
        System.out.println("Wait element will be clickable");
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait until the element is invisible with a long timeout
    public boolean waitForInvisibility(WebElement element) {
        System.out.println("Wait until the element is invisible");
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait until the element is invisible with page load timeout
    public boolean waitForInvisibilityWithPageLoadTimeout(WebElement element) {
        System.out.println("Wait until the element is invisible");
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_FOR_PAGE_LOAD))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait until the element is invisible with a short timeout
    public boolean waitForInvisibilityShortTimeout(WebElement element) {
        System.out.println("Wait until the element is invisible");
        return new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait until an attribute of the element has a specific value
    public void waitUntilAttributeGetsValue(WebElement element, String attributeName, String expectedValue) {
        System.out.println(String.format("Wait until %s attribute gets %s value", attributeName, expectedValue));
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.attributeToBe(element, attributeName, expectedValue));
    }

    // Wait until an attribute of the element has a specific value with custom timeout
    public void waitUntilAttributeGetsValue(WebElement element, String attributeName, String expectedValue, int seconds) {
        System.out.println(String.format("Wait until %s attribute gets %s value", attributeName, expectedValue));
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.attributeToBe(element, attributeName, expectedValue));
    }

    // Wait until an attribute of the element is not empty
    public void waitAttributeValueIsNotEmpty(WebElement element, String attribute) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    // Wait until text is not present in the element (default timeout)
    public void waitTextNotToBePresentInElement(WebElement element, String text) {
        waitTextNotToBePresentInElement(element, text, DEFAULT_TIME_OUT_IN_SECONDS);
    }

    // Wait until text is not present in the element with custom timeout
    public void waitTextNotToBePresentInElement(WebElement element, String text, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    // Wait until text is present in the element
    public void waitTextToBePresentInElement(WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // Wait until an attribute contains a specific value (default timeout)
    public void waitNeedValueAttributeContaining(WebElement element, String attribute, String value) {
        waitNeedValueAttributeContainingWithTimeout(element, attribute, value, DEFAULT_TIMEOUT_FOR_PAGE_LOAD);
    }

    // Wait until an attribute contains a specific value with custom timeout
    public void waitNeedValueAttributeContainingWithTimeout(WebElement element, String attribute, String value, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    // Wait for the element to be visible after a page refresh
    public void waitForVisibilityAfterScreenRefresh(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(element)));
    }

    // Wait for the element to become stale (i.e., no longer attached to the DOM)
    public void waitStalenessOfElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until(ExpectedConditions.stalenessOf(element));
    }

    // Wait until the element is enabled
    public void waitForEnabled(WebElement element) {
        System.out.println(String.format("Wait until element be enabled %s", element.toString()));
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS))
                .until((Function<WebDriver, Boolean>) localWebDriver -> element.isEnabled());
    }

    /* Actions */

    // Click on the element after ensuring it is clickable
    public void click(WebElement element) {
        waitForClickable(element).click();
    }

    // Try to click on the element after ensuring it is visible
    public void tryClick(WebElement element) {
        waitForVisibility(element).click();
    }

    // Double-click on the element
    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(waitForClickable(element)).perform();
    }

    // Hover over the element and then click on it
    public void mouseOverAndClick(WebElement element) {
        new Actions(driver).moveToElement(element).click().build().perform();
    }
}