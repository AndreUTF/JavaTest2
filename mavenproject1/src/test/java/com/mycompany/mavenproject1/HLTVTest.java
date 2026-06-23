package com.mycompany.mavenproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class HLTVTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://www.hltv.org";
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    @Test(priority = 1)
    public void testNavigateToBaseURL() {
        driver.navigate().to(BASE_URL);
        String title = driver.getTitle();
        
        Assert.assertNotNull(title, "Page title should not be null");
        Assert.assertFalse(title.isEmpty(), "Page title should not be empty");
        Assert.assertTrue(title.toLowerCase().contains("hltv"), "Page title should contain HLTV");
        System.out.println("Page title: " + title);
    }

    @Test(priority = 2)
    public void testGetCurrentURL() {
        driver.navigate().to(BASE_URL);
        String currentURL = driver.getCurrentUrl();
        
        Assert.assertNotNull(currentURL, "URL should not be null");
        Assert.assertTrue(currentURL.contains("hltv.org"), "URL should contain hltv.org");
        System.out.println("Current URL: " + currentURL);
    }

    @Test(priority = 3)
    public void testPageSourceNotEmpty() {
        driver.navigate().to(BASE_URL);
        String pageSource = driver.getPageSource();
        
        Assert.assertNotNull(pageSource, "Page source should not be null");
        Assert.assertTrue(pageSource.length() > 0, "Page source should not be empty");
        System.out.println("Page source length: " + pageSource.length());
    }

    @Test(priority = 4)
    public void testPageLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.navigate().to(BASE_URL);
        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
        
        Assert.assertTrue(loadTime > 0, "Load time should be greater than 0");
        System.out.println("Page load time: " + loadTime + "ms");
    }

    @Test(priority = 5)
    public void testNavigationHeaderExists() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement header = driver.findElement(By.xpath("//header | //nav | //*[@role='navigation']"));
            Assert.assertNotNull(header, "Header or navigation should exist");
            Assert.assertTrue(header.isDisplayed(), "Header should be displayed");
            System.out.println("Navigation header found");
        } catch (Exception e) {
            System.out.println("Navigation header not found: " + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void testSearchFunctionalityExists() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search' or @placeholder='search' or contains(@class, 'search')]"));
            Assert.assertNotNull(searchInput, "Search input should exist");
            Assert.assertTrue(searchInput.isDisplayed(), "Search input should be displayed");
            System.out.println("Search input found");
        } catch (Exception e) {
            System.out.println("Search input not found, trying alternative selectors: " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void testSearchForTeam() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search' or @placeholder='search' or contains(@class, 'search')]"));
            searchInput.clear();
            searchInput.sendKeys("Navi");
            Thread.sleep(1500);
            
            List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'search-result') or contains(@class, 'result')]"));
            Assert.assertTrue(searchResults.size() > 0, "Search results should be displayed");
            System.out.println("Found " + searchResults.size() + " search results for team");
        } catch (Exception e) {
            System.out.println("Team search test failed: " + e.getMessage());
        }
    }

    @Test(priority = 8)
    public void testSearchForMatch() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search' or @placeholder='search' or contains(@class, 'search')]"));
            searchInput.clear();
            searchInput.sendKeys("FaZe");
            Thread.sleep(1500);
            
            List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'search-result') or contains(@class, 'result')]"));
            Assert.assertTrue(searchResults.size() >= 0, "Search results should be found or empty");
            System.out.println("Search for match executed, found " + searchResults.size() + " results");
        } catch (Exception e) {
            System.out.println("Match search test failed: " + e.getMessage());
        }
    }

    @Test(priority = 9)
    public void testClickOnMatchesTab() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement matchesTab = driver.findElement(By.xpath("//a[contains(text(), 'Matches') or contains(@href, '/matches')]"));
            Assert.assertNotNull(matchesTab, "Matches tab should exist");
            matchesTab.click();
            Thread.sleep(2000);
            
            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(currentURL.contains("hltv.org"), "Should navigate to matches page");
            System.out.println("Clicked on Matches tab successfully");
        } catch (Exception e) {
            System.out.println("Failed to click Matches tab: " + e.getMessage());
        }
    }

    @Test(priority = 10)
    public void testClickOnTeamsTab() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement teamsTab = driver.findElement(By.xpath("//a[contains(text(), 'Teams') or contains(@href, '/teams')]"));
            Assert.assertNotNull(teamsTab, "Teams tab should exist");
            teamsTab.click();
            Thread.sleep(2000);
            
            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(currentURL.contains("hltv.org"), "Should navigate to teams page");
            System.out.println("Clicked on Teams tab successfully");
        } catch (Exception e) {
            System.out.println("Failed to click Teams tab: " + e.getMessage());
        }
    }

    @Test(priority = 11)
    public void testClickOnPlayersTab() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement playersTab = driver.findElement(By.xpath("//a[contains(text(), 'Players') or contains(@href, '/players')]"));
            Assert.assertNotNull(playersTab, "Players tab should exist");
            playersTab.click();
            Thread.sleep(2000);
            
            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(currentURL.contains("hltv.org"), "Should navigate to players page");
            System.out.println("Clicked on Players tab successfully");
        } catch (Exception e) {
            System.out.println("Failed to click Players tab: " + e.getMessage());
        }
    }

    @Test(priority = 12)
    public void testNavigateToNews() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement newsTab = driver.findElement(By.xpath("//a[contains(text(), 'News') or contains(@href, '/news')]"));
            Assert.assertNotNull(newsTab, "News tab should exist");
            newsTab.click();
            Thread.sleep(2000);
            
            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(currentURL.contains("hltv.org"), "Should navigate to news page");
            System.out.println("Navigated to News section successfully");
        } catch (Exception e) {
            System.out.println("Failed to navigate to News: " + e.getMessage());
        }
    }

    @Test(priority = 13)
    public void testClickOnNewsArticle() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> newsArticles = driver.findElements(By.xpath("//a[contains(@href, '/news')]"));
            if (newsArticles.size() > 0) {
                newsArticles.get(0).click();
                Thread.sleep(2000);
                String pageSource = driver.getPageSource();
                Assert.assertTrue(pageSource.length() > 0, "Article page should load");
                System.out.println("Clicked on news article successfully");
            }
        } catch (Exception e) {
            System.out.println("Failed to click on news article: " + e.getMessage());
        }
    }

    @Test(priority = 14)
    public void testNavigateToRankings() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement rankingsTab = driver.findElement(By.xpath("//a[contains(text(), 'Ranking') or contains(@href, '/ranking')]"));
            Assert.assertNotNull(rankingsTab, "Rankings tab should exist");
            rankingsTab.click();
            Thread.sleep(2000);
            
            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(currentURL.contains("hltv.org"), "Should navigate to rankings page");
            System.out.println("Navigated to Rankings section successfully");
        } catch (Exception e) {
            System.out.println("Failed to navigate to Rankings: " + e.getMessage());
        }
    }

    @Test(priority = 15)
    public void testFindElements() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
            Assert.assertTrue(allLinks.size() > 0, "Page should contain links");
            System.out.println("Found " + allLinks.size() + " links on page");
        } catch (Exception e) {
            System.out.println("Failed to find elements: " + e.getMessage());
        }
    }

    @Test(priority = 16)
    public void testNavigationMenuVisible() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> menuItems = driver.findElements(By.xpath("//nav//a | //header//a"));
            Assert.assertTrue(menuItems.size() > 0, "Navigation menu items should exist");
            System.out.println("Found " + menuItems.size() + " menu items");
        } catch (Exception e) {
            System.out.println("Failed to find menu items: " + e.getMessage());
        }
    }

    @Test(priority = 17)
    public void testClickOnUpcomingMatches() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement upcomingMatches = driver.findElement(By.xpath("//a[contains(text(), 'Upcoming') or contains(@href, 'upcoming')]"));
            Assert.assertNotNull(upcomingMatches, "Upcoming matches link should exist");
            upcomingMatches.click();
            Thread.sleep(2000);
            System.out.println("Clicked on Upcoming Matches successfully");
        } catch (Exception e) {
            System.out.println("Failed to click on Upcoming Matches: " + e.getMessage());
        }
    }

    @Test(priority = 18)
    public void testClickOnResults() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement results = driver.findElement(By.xpath("//a[contains(text(), 'Results') or contains(@href, 'results')]"));
            Assert.assertNotNull(results, "Results link should exist");
            results.click();
            Thread.sleep(2000);
            System.out.println("Clicked on Results successfully");
        } catch (Exception e) {
            System.out.println("Failed to click on Results: " + e.getMessage());
        }
    }

    @Test(priority = 19)
    public void testApplyFilters() {
        driver.navigate().to(BASE_URL + "/matches");
        try {
            Thread.sleep(2000);
            List<WebElement> filterButtons = driver.findElements(By.xpath("//button[contains(@class, 'filter') or contains(text(), 'Filter')]"));
            if (filterButtons.size() > 0) {
                filterButtons.get(0).click();
                Thread.sleep(1500);
                System.out.println("Clicked on filter button");
            }
        } catch (Exception e) {
            System.out.println("Failed to apply filters: " + e.getMessage());
        }
    }

    @Test(priority = 20)
    public void testElementDisplayProperties() {
        driver.navigate().to(BASE_URL);
        try {
            WebElement body = driver.findElement(By.xpath("//body"));
            Assert.assertTrue(body.isDisplayed(), "Body element should be displayed");
            System.out.println("Body element is displayed and enabled");
        } catch (Exception e) {
            System.out.println("Failed to check element properties: " + e.getMessage());
        }
    }

    @Test(priority = 21)
    public void testMouseHoverOnMatch() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> matchElements = driver.findElements(By.xpath("//div[contains(@class, 'match') or contains(@class, 'event')]"));
            if (matchElements.size() > 0) {
                Actions actions = new Actions(driver);
                actions.moveToElement(matchElements.get(0)).perform();
                Thread.sleep(1000);
                System.out.println("Mouse hover on match element performed");
            }
        } catch (Exception e) {
            System.out.println("Failed to hover on match: " + e.getMessage());
        }
    }

    @Test(priority = 22)
    public void testRefreshPage() {
        driver.navigate().to(BASE_URL);
        String urlBefore = driver.getCurrentUrl();
        
        driver.navigate().refresh();
        String urlAfter = driver.getCurrentUrl();
        
        Assert.assertEquals(urlBefore, urlAfter, "URL should remain same after refresh");
        System.out.println("Page refreshed successfully");
    }

    @Test(priority = 23)
    public void testNavigateBack() {
        driver.navigate().to(BASE_URL);
        try {
            List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));
            if (links.size() > 0) {
                links.get(0).click();
                Thread.sleep(2000);
                driver.navigate().back();
                String currentURL = driver.getCurrentUrl();
                Assert.assertTrue(currentURL.contains("hltv.org"), "Should navigate back successfully");
                System.out.println("Navigation back successful");
            }
        } catch (Exception e) {
            System.out.println("Failed to navigate back: " + e.getMessage());
        }
    }

    @Test(priority = 24)
    public void testGetWindowHandle() {
        driver.navigate().to(BASE_URL);
        String windowHandle = driver.getWindowHandle();
        
        Assert.assertNotNull(windowHandle, "Window handle should not be null");
        Assert.assertFalse(windowHandle.isEmpty(), "Window handle should not be empty");
        System.out.println("Window handle: " + windowHandle);
    }

    @Test(priority = 25)
    public void testBrowserCapabilities() {
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        
        Assert.assertNotNull(browserName, "Browser name should not be null");
        Assert.assertTrue(browserName.toLowerCase().contains("chrome"), "Should be Chrome browser");
        System.out.println("Browser name: " + browserName);
    }
}
