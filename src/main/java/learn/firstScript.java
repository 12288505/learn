package learn;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstScript {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {

		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws Exception {

		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("test");
		driver.findElement(By.id("su")).click();
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

}
