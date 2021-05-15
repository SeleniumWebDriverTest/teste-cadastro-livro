package com.fatec.cap09;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ01MantemLivrosTests {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
      System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
      driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void TestCadastroComSucesso() {

	    driver.get("https://ts-scel.herokuapp.com/login");
	    driver.manage().window().setSize(new Dimension(550, 697));
	    driver.findElement(By.cssSelector(".form")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("jose");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("123");
	    driver.findElement(By.cssSelector("button")).click();
	    awaitSeconds();
	    driver.findElement(By.linkText("Livros")).click();
	    driver.findElement(By.id("isbn")).click();
	    driver.findElement(By.id("isbn")).sendKeys("5697");
	    awaitSeconds();
	    driver.findElement(By.id("autor")).click();
	    driver.findElement(By.id("autor")).sendKeys("jose salamagro");
	    awaitSeconds();
	    driver.findElement(By.id("titulo")).click();
	    driver.findElement(By.id("titulo")).click();
	    {
	      WebElement element = driver.findElement(By.id("titulo"));
	      Actions builder = new Actions(driver);
	      builder.doubleClick(element).perform();
	    }
	    awaitSeconds();
	    driver.findElement(By.id("titulo")).sendKeys("pogramacao vol 2");
	    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	    awaitSeconds();
	    driver.findElement(By.linkText("Excluir")).click();

  }
  
  public void awaitSeconds() {
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
}
