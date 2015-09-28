package learn;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import UiMap.HomePage;

public class firstScript {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws Exception {

		driver.get(HomePage.baseUrl);
		driver.findElement(HomePage.KeyWord).click();
		driver.findElement(HomePage.KeyWord).clear();
		driver.findElement(HomePage.KeyWord).sendKeys("test");
		driver.navigate().to(HomePage.baseUrl);
		driver.findElement(HomePage.Search).click();
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

}
