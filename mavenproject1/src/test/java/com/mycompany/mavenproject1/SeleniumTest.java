package com.mycompany.mavenproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://www.cypress.io/";
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Initialize ChromeDriver
        ChromeOptions options = new ChromeOptions();
        if (System.getenv("CI") != null || Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Maximize window
        driver.manage().window().maximize();
        
        System.out.println("Browser launched successfully");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }

    /**
     * Test: Navigate to base URL
     */
    @Test(priority = 1)
    public void testNavigateToBaseURL() {
        driver.navigate().to(BASE_URL);
        String title = driver.getTitle();
        
        Assert.assertNotNull(title, "Page title should not be null");
        Assert.assertFalse(title.isEmpty(), "Page title should not be empty");
        System.out.println("Page title: " + title);
    }

    /**
     * Test: Get current URL
     */
    @Test(priority = 2)
    public void testGetCurrentURL() {
        driver.navigate().to(BASE_URL);
        String currentURL = driver.getCurrentUrl();
        
        Assert.assertNotNull(currentURL, "URL should not be null");
        Assert.assertTrue(currentURL.contains("cypress.io"), "URL should contain cypress.io");
        System.out.println("Current URL: " + currentURL);
    }

    /**
     * Test: Find element by XPath
     */
    @Test(priority = 3)
    public void testFindElementByXPath() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.xpath("//*[@class='navbar']"));
            Assert.assertNotNull(element, "Element should be found");
            Assert.assertTrue(element.isDisplayed(), "Element should be displayed");
            System.out.println("Element found by XPath");
        } catch (Exception e) {
            System.out.println("Element not found by XPath: " + e.getMessage());
        }
    }

    /**
     * Test: Find element by CSS selector
     */
    @Test(priority = 4)
    public void testFindElementByCSS() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.cssSelector("button"));
            Assert.assertNotNull(element, "Button element should be found");
            System.out.println("Element found by CSS selector");
        } catch (Exception e) {
            System.out.println("Element not found by CSS: " + e.getMessage());
        }
    }

    /**
     * Test: Find element by ID
     */
    @Test(priority = 5)
    public void testFindElementByID() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id]"));
            Assert.assertTrue(elements.size() > 0, "Elements should exist on page");
            System.out.println("Found " + elements.size() + " elements with IDs");
        } catch (Exception e) {
            System.out.println("Failed to find elements: " + e.getMessage());
        }
    }

    /**
     * Test: Click on element
     */
    @Test(priority = 6)
    public void testClickElement() {
        driver.navigate().to(BASE_URL);
        try {
            // Find and click accept button if it exists
            List<WebElement> acceptButtons = driver.findElements(By.xpath("//*[contains(@class, 'osano-cm-accept')]"));
            if (acceptButtons.size() > 0) {
                acceptButtons.get(0).click();
                System.out.println("Element clicked successfully");
            }
        } catch (Exception e) {
            System.out.println("Failed to click element: " + e.getMessage());
        }
    }

    /**
     * Test: Get element text
     */
    @Test(priority = 7)
    public void testGetElementText() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement heading = driver.findElement(By.xpath("//h1"));
            String text = heading.getText();
            Assert.assertNotNull(text, "Text should not be null");
            Assert.assertFalse(text.isEmpty(), "Text should not be empty");
            System.out.println("Heading text: " + text);
        } catch (Exception e) {
            System.out.println("Failed to get element text: " + e.getMessage());
        }
    }

    /**
     * Test: Get element attribute
     */
    @Test(priority = 8)
    public void testGetElementAttribute() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement link = driver.findElement(By.xpath("//a"));
            String href = link.getAttribute("href");
            Assert.assertNotNull(href, "Href attribute should exist");
            System.out.println("Link href: " + href);
        } catch (Exception e) {
            System.out.println("Failed to get attribute: " + e.getMessage());
        }
    }

    /**
     * Test: Check element is displayed
     */
    @Test(priority = 9)
    public void testElementDisplayed() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.xpath("//body"));
            Assert.assertTrue(element.isDisplayed(), "Element should be displayed");
            System.out.println("Element is displayed");
        } catch (Exception e) {
            System.out.println("Failed to check display: " + e.getMessage());
        }
    }

    /**
     * Test: Check element is enabled
     */
    @Test(priority = 10)
    public void testElementEnabled() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> buttons = driver.findElements(By.xpath("//button"));
            if (buttons.size() > 0) {
                boolean isEnabled = buttons.get(0).isEnabled();
                System.out.println("Button is enabled: " + isEnabled);
            }
        } catch (Exception e) {
            System.out.println("Failed to check enabled: " + e.getMessage());
        }
    }

    /**
     * Test: Send keys to input field
     */
    @Test(priority = 11)
    public void testSendKeysToField() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> inputs = driver.findElements(By.xpath("//input[@type='text']"));
            if (inputs.size() > 0) {
                inputs.get(0).clear();
                inputs.get(0).sendKeys("Test Input");
                String value = inputs.get(0).getAttribute("value");
                Assert.assertEquals(value, "Test Input", "Input value should match");
                System.out.println("Text sent to input field");
            }
        } catch (Exception e) {
            System.out.println("Failed to send keys: " + e.getMessage());
        }
    }

    /**
     * Test: Find multiple elements
     */
    @Test(priority = 12)
    public void testFindMultipleElements() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> links = driver.findElements(By.xpath("//a"));
            Assert.assertTrue(links.size() > 0, "Should find at least one link");
            System.out.println("Found " + links.size() + " links on page");
        } catch (Exception e) {
            System.out.println("Failed to find multiple elements: " + e.getMessage());
        }
    }

    /**
     * Test: Navigate back
     */
    @Test(priority = 13)
    public void testNavigateBack() {
        driver.navigate().to(BASE_URL);
        String firstURL = driver.getCurrentUrl();
        
        try {
            // Navigate to another page
            List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
            if (links.size() > 0) {
                links.get(0).click();
                Thread.sleep(2000);
                
                // Navigate back
                driver.navigate().back();
                String backURL = driver.getCurrentUrl();
                System.out.println("Navigated back successfully");
            }
        } catch (Exception e) {
            System.out.println("Navigation failed: " + e.getMessage());
        }
    }

    /**
     * Test: Navigate forward
     */
    @Test(priority = 14)
    public void testNavigateForward() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
            if (links.size() > 0) {
                links.get(0).click();
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);
                driver.navigate().forward();
                System.out.println("Forward navigation executed");
            }
        } catch (Exception e) {
            System.out.println("Forward navigation failed: " + e.getMessage());
        }
    }

    /**
     * Test: Refresh page
     */
    @Test(priority = 15)
    public void testRefreshPage() {
        driver.navigate().to(BASE_URL);
        String urlBefore = driver.getCurrentUrl();
        
        driver.navigate().refresh();
        String urlAfter = driver.getCurrentUrl();
        
        Assert.assertEquals(urlBefore, urlAfter, "URL should remain same after refresh");
        System.out.println("Page refreshed successfully");
    }

    /**
     * Test: Get page source
     */
    @Test(priority = 16)
    public void testGetPageSource() {
        driver.navigate().to(BASE_URL);
        String pageSource = driver.getPageSource();
        
        Assert.assertNotNull(pageSource, "Page source should not be null");
        Assert.assertTrue(pageSource.length() > 0, "Page source should not be empty");
        System.out.println("Page source length: " + pageSource.length());
    }

    /**
     * Test: Get page title
     */
    @Test(priority = 17)
    public void testGetPageTitle() {
        driver.navigate().to(BASE_URL);
        String title = driver.getTitle();
        
        Assert.assertNotNull(title, "Title should not be null");
        Assert.assertFalse(title.isEmpty(), "Title should not be empty");
        System.out.println("Page title: " + title);
    }

    /**
     * Test: Get window handle
     */
    @Test(priority = 18)
    public void testGetWindowHandle() {
        driver.navigate().to(BASE_URL);
        String windowHandle = driver.getWindowHandle();
        
        Assert.assertNotNull(windowHandle, "Window handle should not be null");
        Assert.assertFalse(windowHandle.isEmpty(), "Window handle should not be empty");
        System.out.println("Window handle: " + windowHandle);
    }

    /**
     * Test: Get window handles
     */
    @Test(priority = 19)
    public void testGetWindowHandles() {
        driver.navigate().to(BASE_URL);
        java.util.Set<String> handles = driver.getWindowHandles();
        
        Assert.assertNotNull(handles, "Window handles should not be null");
        Assert.assertTrue(handles.size() > 0, "Should have at least one window handle");
        System.out.println("Number of windows: " + handles.size());
    }

    /**
     * Test: Mouse hover action
     */
    @Test(priority = 20)
    public void testMouseHover() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//a"));
            if (elements.size() > 0) {
                Actions actions = new Actions(driver);
                actions.moveToElement(elements.get(0)).perform();
                System.out.println("Mouse hover action performed");
            }
        } catch (Exception e) {
            System.out.println("Mouse hover failed: " + e.getMessage());
        }
    }

    /**
     * Test: Double click action
     */
    @Test(priority = 21)
    public void testDoubleClick() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//button"));
            if (elements.size() > 0) {
                Actions actions = new Actions(driver);
                actions.doubleClick(elements.get(0)).perform();
                System.out.println("Double click action performed");
            }
        } catch (Exception e) {
            System.out.println("Double click failed: " + e.getMessage());
        }
    }

    /**
     * Test: Right click action
     */
    @Test(priority = 22)
    public void testRightClick() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.xpath("//body"));
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
            System.out.println("Right click action performed");
        } catch (Exception e) {
            System.out.println("Right click failed: " + e.getMessage());
        }
    }

    /**
     * Test: Drag and drop
     */
    @Test(priority = 23)
    public void testDragAndDrop() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//*"));
            if (elements.size() > 1) {
                Actions actions = new Actions(driver);
                actions.dragAndDrop(elements.get(0), elements.get(1)).perform();
                System.out.println("Drag and drop action performed");
            }
        } catch (Exception e) {
            System.out.println("Drag and drop failed: " + e.getMessage());
        }
    }

    /**
     * Test: Explicit wait for element
     */
    @Test(priority = 24)
    public void testExplicitWait() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = wait.until(
                d -> d.findElement(By.xpath("//body"))
            );
            Assert.assertNotNull(element, "Element should be found with explicit wait");
            System.out.println("Explicit wait successful");
        } catch (Exception e) {
            System.out.println("Explicit wait failed: " + e.getMessage());
        }
    }

    /**
     * Test: Implicit wait
     */
    @Test(priority = 25)
    public void testImplicitWait() {
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        long startTime = System.currentTimeMillis();
        try {
            WebElement element = driver.findElement(By.xpath("//body"));
            long elapsedTime = System.currentTimeMillis() - startTime;
            Assert.assertNotNull(element, "Element should be found");
            Assert.assertTrue(elapsedTime <= 5000, "Wait should not exceed 5 seconds");
            System.out.println("Element found in " + elapsedTime + "ms");
        } catch (Exception e) {
            System.out.println("Implicit wait test failed: " + e.getMessage());
        }
    }

    /**
     * Test: Get browser name
     */
    @Test(priority = 26)
    public void testGetBrowserName() {
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        
        Assert.assertNotNull(browserName, "Browser name should not be null");
        Assert.assertTrue(browserName.toLowerCase().contains("chrome"), "Should be Chrome browser");
        System.out.println("Browser name: " + browserName);
    }

    /**
     * Test: Element size
     */
    @Test(priority = 27)
    public void testGetElementSize() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.xpath("//button"));
            org.openqa.selenium.Dimension size = element.getSize();
            Assert.assertTrue(size.getWidth() > 0, "Width should be greater than 0");
            Assert.assertTrue(size.getHeight() > 0, "Height should be greater than 0");
            System.out.println("Element size - Width: " + size.getWidth() + ", Height: " + size.getHeight());
        } catch (Exception e) {
            System.out.println("Failed to get element size: " + e.getMessage());
        }
    }

    /**
     * Test: Element location
     */
    @Test(priority = 28)
    public void testGetElementLocation() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.xpath("//button"));
            org.openqa.selenium.Point location = element.getLocation();
            Assert.assertTrue(location.getX() >= 0, "X coordinate should be non-negative");
            Assert.assertTrue(location.getY() >= 0, "Y coordinate should be non-negative");
            System.out.println("Element location - X: " + location.getX() + ", Y: " + location.getY());
        } catch (Exception e) {
            System.out.println("Failed to get element location: " + e.getMessage());
        }
    }

    /**
     * Test: Check page load time
     */
    @Test(priority = 29)
    public void testPageLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.navigate().to(BASE_URL);
        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
        
        Assert.assertTrue(loadTime > 0, "Load time should be greater than 0");
        System.out.println("Page load time: " + loadTime + "ms");
    }

    /**
     * Test: Scroll to element
     */
    @Test(priority = 30)
    public void testScrollToElement() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement element = driver.findElement(By.xpath("//footer"));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to element successfully");
        } catch (Exception e) {
            System.out.println("Scroll failed: " + e.getMessage());
        }
    }
}
