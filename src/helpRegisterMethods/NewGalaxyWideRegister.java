package helpRegisterMethods;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewGalaxyWideRegister {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// FirefoxProfile profile = new FirefoxProfile();
		// profile.setPreference("javascript.enabled", false);
		// profile.setPreference("flash.enabled", false);
		// driver = new FirefoxDriver(profile);
		driver = new FirefoxDriver();
		baseUrl = "test1.kovalenko.d.ukrtech.info";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	@Test
	public void test5Register() throws Exception {

		String sponsor_login_sample = new String();
		sponsor_login_sample = "testsponsor";

		String current_user_sample = new String();
		current_user_sample = "utestsponsor";

		String user_name = new String();
		user_name = "usernameAuto";

		int i = 1;
		int n = 3;

		// **************************************
		while (i < n) {
			driver.get("http://" + sponsor_login_sample + "." + baseUrl
					+ "/register/register/index");
			for (int second = 0;; second++) {
				if (second >= 60)
					fail("timeout");
				try {
					if (isElementPresent(By.id("sponsor_login")))
						break;
				} catch (Exception e) {
				}
				Thread.sleep(1000);
			}
			for (int second = 0;; second++) {
				if (second >= 60)
					fail("timeout");
				try {
					if (isElementPresent(By.id("sponsor_last_name")))
						break;
				} catch (Exception e) {
				}
				Thread.sleep(1000);
			}

			for (int second = 0;; second++) {
				if (second >= 60)
					fail("timeout");
				try {
					if (isElementPresent(By.id("sponsor_first_name")))
						break;
				} catch (Exception e) {
				}
				Thread.sleep(1000);
			}
			driver.findElement(By.id("Users_email")).click();
			driver.findElement(By.id("Users_email")).clear();
			driver.findElement(By.id("Users_email")).sendKeys(
					i + current_user_sample + "@mail.com");
			driver.findElement(By.id("Users_password")).click();
			driver.findElement(By.id("Users_password")).clear();
			driver.findElement(By.id("Users_password")).sendKeys("123456");
			driver.findElement(By.id("Users_password_confirm")).click();
			driver.findElement(By.id("Users_password_confirm")).clear();
			driver.findElement(By.id("Users_password_confirm")).sendKeys(
					"123456");
			driver.findElement(By.id("Users_finpassword")).click();
			driver.findElement(By.id("Users_finpassword")).clear();
			driver.findElement(By.id("Users_finpassword")).sendKeys("123456");
			driver.findElement(By.id("Users_finpassword_confirm")).click();
			driver.findElement(By.id("Users_finpassword_confirm")).clear();
			driver.findElement(By.id("Users_finpassword_confirm")).sendKeys(
					"123456");
			driver.findElement(By.id("Users_username")).click();
			driver.findElement(By.id("Users_username")).clear();
			driver.findElement(By.id("Users_username")).sendKeys(
					i + current_user_sample);
			driver.findElement(By.id("ProfileLang_first_name")).click();
			driver.findElement(By.id("Profile" + "Lang_first_name")).clear();
			driver.findElement(By.id("ProfileLang_first_name")).sendKeys(
					user_name);
			driver.findElement(By.id("Profile_form_agree")).click();
			driver.findElement(By.name("btn_register")).click();
			/*
			driver.findElement(
					By.cssSelector("[href='/office/default/paymenttype/activity/3']"))
					.click();
			*/
			driver.findElements(By.cssSelector(".btn.btn-green")).get(1).click(); //профи за 750
			driver.findElements(By.name("yt0")).get(1).click();
			driver.findElement(By.cssSelector("div.jq-selectbox__trigger")).click();
			//Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='mode_type-styler']/div[2]/ul/li[4]")).click();
		    //driver.findElement(By.cssSelector("li.selected.sel")).click();
		    driver.findElement(By.cssSelector("input.btn.w100")).click();
		    driver.findElement(By.name("reply_confirmed_pay")).click();
			driver.get(baseUrl + "/site/logout");
			driver.manage().deleteAllCookies();
			i++;
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
