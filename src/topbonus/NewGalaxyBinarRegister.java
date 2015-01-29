package topbonus;

import static org.junit.Assert.fail;

import java.util.ArrayList;
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

public class NewGalaxyBinarRegister {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	public ArrayList<mas_sponsor> mas = new ArrayList<mas_sponsor>();
	private int count = 0;
	private String username = "testlowedtope";
	
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

	public class mas_sponsor {
		String num_sp;
		int count;
		boolean has_sponsor = false;
	}

	@Test
	public void test5Register() throws Exception {

		mas_sponsor m;
		boolean flag = false;

		m = new mas_sponsor();
		m.num_sp = username;
		m.count = 0;
		m.has_sponsor = true;
		mas.add(m);

		// SimpleDateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
		// String ddd = dateFormat.format(new Date());

		for (int i = 1; i <= 14; i++) {
			m = new mas_sponsor();
			// m.num_sp = "poldestr" + ddd + i + 800;
			m.num_sp = "u3" + username + i + 800;
			m.count = 0;
			m.has_sponsor = false;
			mas.add(m);

		}

		flag = true;
		while (flag == true) {
			flag = false;
			for (int j = 0; j <= 14; j++) {
				if ((mas.get(j).count < 2) && (HasFreeDistrNum() == true)) {
					create_user(mas.get(j), j);
					flag = true;

				}
			}
		}
		System.out.println("сего создано " + count + "  дистрибьюторов.");
		for (int j = 0; j <= 14; j++) {
		}

	}

	public boolean HasFreeDistrNum() {

		boolean flag = false;
		for (int i = 0; i < mas.size(); i++) {
			if (mas.get(i).has_sponsor == false) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void create_user(mas_sponsor m, int cnt) throws Exception {
		String user_name = new String();
		user_name = "xautoregister";

		String NUM = "";
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < mas.size(); i++) {
				if (mas.get(i).has_sponsor == false) {
					NUM = mas.get(i).num_sp;
					mas.get(i).has_sponsor = true;
					break;
				}

			}
			m.count = m.count + 1;

			// **************************************
			driver.get("http://" + m.num_sp + "." + baseUrl
					+ "/register/register/index");
			driver.findElement(By.id("Users_email")).click();
			driver.findElement(By.id("Users_email")).clear();
			driver.findElement(By.id("Users_email"))
					.sendKeys(NUM + "@mail.com");
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
			driver.findElement(By.id("Users_username")).sendKeys(NUM);
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
			driver.findElements(By.cssSelector(".btn.btn-green")).get(0).click(); //профи за 750
			driver.findElements(By.name("yt0")).get(1).click();
			driver.findElement(By.cssSelector("div.jq-selectbox__trigger")).click();
			//Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='mode_type-styler']/div[2]/ul/li[4]")).click();
		    //driver.findElement(By.cssSelector("li.selected.sel")).click();
		    driver.findElement(By.cssSelector("input.btn.w100")).click();
		    driver.findElement(By.name("reply_confirmed_pay")).click();
			driver.get(baseUrl + "/site/logout");
			driver.manage().deleteAllCookies();
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
