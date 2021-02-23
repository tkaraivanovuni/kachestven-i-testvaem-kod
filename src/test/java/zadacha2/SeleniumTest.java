package zadacha2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * This class is for the second assignment.
 */
public class SeleniumTest {
	
	WebDriver driver;
	
	/**
	 * This class sets the properties for the driver.
	 */
	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	}
	
	/**
	 * This class opens a new driver before each test.
	 */
	@Before
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
	}
	
	/**
	 * This class closes the driver after each test.
	 */
	@After
	public void after() {
		driver.close();
	}
	
	/**
	 * This test checks if clicking the Breakingviews tab loads the correct page.
	 */
	@Test
	public void checkIfClickingBreakingViewsLoadsCorrectPage() {
		driver.get("https://www.reuters.com/");
		
		WebElement acceptButton = driver.findElement(By.id("accept-recommended-btn-handler"));
		acceptButton.click();
		WebElement homeLogo = driver.findElement(By.linkText("Breakingviews"));
		homeLogo.click();
		
		final String expectedUrl = "https://www.reuters.com/breakingviews";
		final String actualUrl = driver.getCurrentUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}
	
	/**
	 * This test checks if the Breakingviews text is displayed on the header of the Breakingviews page.
	 */
	@Test
	public void checkIfBreakingviewsHeaderIsDisplayedOnBreakingViewsPage() {
		driver.get("https://www.reuters.com/breakingviews");
		
		WebElement acceptButton = driver.findElement(By.id("accept-recommended-btn-handler"));
		acceptButton.click();
		
		WebElement header = driver.findElement(By.className("module-header"));
		final String actualHeaderText = header.getText();
		final String expectedHeaderText = "BREAKINGVIEWS";
		
		assertEquals(expectedHeaderText, actualHeaderText);
	}
	
	/**
	 * This test checks if the clicking the logo loads the home page.
	 */
	@Test
	public void checkIfClickingTheLogoLoadsTheHomePage() {
		driver.get("https://www.reuters.com/breakingviews");
		
		WebElement acceptButton = driver.findElement(By.id("accept-recommended-btn-handler"));
		acceptButton.click();
		WebElement logo = driver.findElement(By.className("reuters-logo"));
		logo.click();
		
		final String expectedUrl = "https://www.reuters.com/";
		final String actualUrl = driver.getCurrentUrl();
		
		assertEquals(expectedUrl, actualUrl);
	}
	
	/**
	 * This method tests if clicking the search button brings up the search input field.
	 */
	@Test
	public void checkIfClickingSearchDisplaysSearchInput() {
		driver.get("https://www.reuters.com/");
		
		WebElement acceptButton = driver.findElement(By.id("accept-recommended-btn-handler"));
		acceptButton.click();
		
		WebElement searchButton = driver.findElement(By.className("search-icon"));
		searchButton.click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(5))
				  .pollingEvery(Duration.ofSeconds(1))
				  .ignoring(Exception.class);
		WebElement searchField = wait.until(new Function<WebDriver, WebElement>() {
			  public WebElement apply(WebDriver driver) {
				    return driver.findElement(By.id("searchForm"));
				  }
		});
		assertTrue(searchField.isDisplayed());
	}
	
	/**
	 * This method tests if the correct search results are displayed upon searching.
	 */
	@Test
	public void checkIfSearchingForTermDisplaysSearchResults() {
		driver.get("https://www.reuters.com/");
		
		WebElement acceptButton = driver.findElement(By.id("accept-recommended-btn-handler"));
		acceptButton.click();
		
		WebElement searchButton = driver.findElement(By.className("search-icon"));
		searchButton.click();
		WebElement searchInput = driver.findElement(By.id("searchfield"));
		searchInput.sendKeys("NASA");
		WebElement searchSubmitButton = driver.findElement(By.id("search-submit-button"));
		searchSubmitButton.click();
		
		final String actualText = driver.findElement(By.className("search-txt")).getText();
		final String expectedText = "Search Results for “NASA”";
		
		assertEquals(expectedText, actualText);
	}
	
}
