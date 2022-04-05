import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
class probaproba {
	
	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "/Users/adilagumdzija/Downloads/chromedriver");
		webDriver = new ChromeDriver(options);
		baseUrl = "https://fkzeljeznicar.ba";
		

	}


	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.close();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void searchingTest() throws InterruptedException{
		webDriver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,2300)", "");
		
		WebElement searchBar = webDriver.findElement(By.xpath("//*[@id=\"search\"]"));
		searchBar.sendKeys("futsal");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		
	}
	
	
	@Test
	void checkingHeader() throws InterruptedException{
		webDriver.get(baseUrl);
	
		WebElement historyButton = webDriver.findElement(By.xpath("//*[@id=\"menu-glavni-meni-2018\"]/li[6]/a"));
		historyButton.click();
		
		WebElement clubFounding = webDriver.findElement(By.xpath("//*[@id=\"post-container\"]/div[5]/ol/li[1]/strong/a"));
		clubFounding.click();
		
		String header = webDriver.findElement(By.xpath("//*[@id=\"post-container\"]/div[4]/h1")).getText();
		assertEquals("Osnivanje kluba", header);
		
	}
	
	
	@Test
	void contactUrlTest() throws InterruptedException{
		webDriver.get(baseUrl);
	
		WebElement contactButton = webDriver.findElement(By.cssSelector("#menu-item-25026 > a"));
		contactButton.click();
		
		String currentUrl = webDriver.getCurrentUrl();
		assertEquals("https://fkzeljeznicar.ba/klub/kontakt/",currentUrl);
	}
	
	
	@Test
	void titleTest() throws InterruptedException{
		webDriver.get(baseUrl);
	
		String title = webDriver.getTitle();
		System.out.println("Title: " + title);
		assertEquals("FK Željezničar – Zvanična internet stranica", title);
		Thread.sleep(10000);
	}
	
	@Test
	void goalkeeperNameTest() throws InterruptedException{
		webDriver.get(baseUrl);
		Thread.sleep(1000);
	
		WebElement firstSquad = webDriver.findElement(By.cssSelector(
				"#menu-glavni-meni-2018 > li.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-has-children.menu-item-25013 > a"
				));
		firstSquad.click();
		Thread.sleep(1000);
	
		WebElement players = webDriver.findElement(By.cssSelector("#menu-glavni-meni-2018 > "
				+ "li.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-has-children.menu-item-25013 > "
				+ "ul > li.menu-item.menu-item-type-post_type_archive.menu-item-object-igrac.menu-item-24932"));
		players.click();
		Thread.sleep(2000);
	
		WebElement gkButton = webDriver.findElement(By.xpath("//*[@id=\"category\"]/div[3]"));
		gkButton.click();
		Thread.sleep(5000);
	
		String gkName = webDriver.findElement(By.xpath("//*[@id=\"post-container\"]/div[2]/div[2]/div/div[2]")).getText();
		System.out.println(gkName);
		assertEquals("Josip Bender", gkName);
	}
	
	
	
	@Test
	void membershipStatusCheckTest() throws InterruptedException{
		webDriver.get(baseUrl);
	
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
	
		WebElement membershipButton = webDriver.findElement(By.xpath("//*[@id=\"menu-glavni-meni-2018\"]/li[7]/a"));
		membershipButton.click();
		Thread.sleep(1000);
	
		WebElement membershipStatusButton = webDriver.findElement(By.xpath("//*[@id=\"post-container\"]/div[5]/div[3]/div/a"));
		membershipStatusButton.click();
	
		WebElement membershipCardFirstName = webDriver.findElement(By.name("ime_korisnika"));
		membershipCardFirstName.sendKeys("Benjamin");
	
		WebElement membershipCardLastName = webDriver.findElement(By.name("prezme_korisnika"));
		membershipCardLastName.sendKeys("Ažman");
	
		WebElement membershipNumber = webDriver.findElement(By.name("broj_korisnika"));
		membershipNumber.sendKeys("387192106266");
		Thread.sleep(2000);
	
		WebElement checkButton = webDriver.findElement(By.cssSelector("#post-container > div.post-content > div.bottom-margin > form > button"));
		checkButton.click();
	
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);
	
		String membershipStatusMessage = webDriver.findElement(By.cssSelector("#post-container > div.post-content > div.col-12-pc > div > div"
				)).getText();
		System.out.println(membershipStatusMessage);
				
	}
	
	
	

//	
	@Test
	void fanshopLogin() throws InterruptedException{
		webDriver.get(baseUrl);
		
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement fanshopButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-32931\"]/a"));
		fanshopButton.click();
		Thread.sleep(5000);
		
		WebElement myAccountButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-60\"]/a"));
		myAccountButton.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		WebElement email = webDriver.findElement(By.name("username"));
		email.sendKeys("adi.lagumdzija@stu.ibu.edu.ba");
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("Testtest123!");
		Thread.sleep(2000);
		
		//Show password
		WebElement showPasswordButton = webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span"));
		showPasswordButton.click();
		Thread.sleep(2000);
		
		WebElement hidePasswordButton = webDriver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span"));
		hidePasswordButton.click();
		
		WebElement keepMeLoggedIn = webDriver.findElement(By.name("rememberme"));
		keepMeLoggedIn.click();
		Thread.sleep(2000);
		
		WebElement signIn = webDriver.findElement(By.name("login"));
		signIn.click();
		Thread.sleep(2000);
		
		JavascriptExecutor dzs = (JavascriptExecutor) webDriver;
		dzs.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
				
	}
	@Test
	void addtocart() throws InterruptedException{
		webDriver.get(baseUrl);
		
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement fanshopButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-32931\"]"));
		fanshopButton.click();
		
		WebElement saleButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-964\"]/a"));
		saleButton.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);

		WebElement mrOsimShirtButton = webDriver.findElement(By.xpath("//*[@id=\"post-960\"]/div/div/div/ul/li[5]/a[2]"));
		mrOsimShirtButton.click();
		JavascriptExecutor dzs = (JavascriptExecutor) webDriver;
		dzs.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);

		WebElement pickSize = webDriver.findElement(By.xpath("//*[@id=\"pa_velicina\"]"));
		pickSize.click();
		Thread.sleep(1000);

		WebElement mSize = webDriver.findElement(By.xpath("//*[@id=\"pa_velicina\"]/option[2]"));
		mSize.click();	
		
		WebElement somewhere = webDriver.findElement(By.xpath("//*[@id=\"product-12064\"]/div[2]/h1"));
		somewhere.click();
		
		WebElement addToCart = webDriver.findElement(By.cssSelector("#product-12064 > div.summary.entry-summary > form > div >"
				+ " div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button"));
		addToCart.click();
		Thread.sleep(3000);
				
	}
	
	@Test
	void addDeliveryAddress() throws InterruptedException{
		webDriver.get(baseUrl);
		
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement fanshopButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-32931\"]"));
		fanshopButton.click();
		
		WebElement myAccountButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-60\"]/a"));
		myAccountButton.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
		
		WebElement email = webDriver.findElement(By.name("username"));
		email.sendKeys("adi.lagumdzija@stu.ibu.edu.ba");
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("Testtest123!");
		
		WebElement signIn = webDriver.findElement(By.name("login"));
		signIn.click();
		
		WebElement address = webDriver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[4]/a"));
		address.click();
		JavascriptExecutor dzs = (JavascriptExecutor) webDriver;
		dzs.executeScript("window.scrollBy(0,400)", "");
		
		WebElement deliveryAddress = webDriver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/div[2]/div[2]/header/a"));
		deliveryAddress.click();
		
		WebElement name = webDriver.findElement(By.name("shipping_first_name"));
		name.sendKeys("Adi");
		
		WebElement lastName = webDriver.findElement(By.name("shipping_last_name"));
		lastName.sendKeys("Lagumdzija");
		
		WebElement company = webDriver.findElement(By.name("shipping_company"));
		company.sendKeys("IBU");
		
		
		// this part was used when I triggered this first time.
		// WebElement country = webDriver.findElement(By.xpath("//*[@id=\"select2-shipping_country-container\"]/span"));
		// country.click();
		// Thread.sleep(1000);
		
		WebElement countrySelect = webDriver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		countrySelect.sendKeys(Keys.DOWN);
		countrySelect.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
	 
		WebElement shippingAddress = webDriver.findElement(By.name("shipping_address_1"));
		shippingAddress.sendKeys("Francuske Revolucije bb");
		Thread.sleep(6000);

		WebElement zipCode = webDriver.findElement(By.name("shipping_postcode"));
		zipCode.sendKeys("71000");
		Thread.sleep(6000);

		WebElement city = webDriver.findElement(By.name("city"));
		city.sendKeys("Sarajevo");
		Thread.sleep(6000);

		WebElement canton = webDriver.findElement(By.name("shipping_state"));
		canton.sendKeys("Sarajevo");
		Thread.sleep(6000);

		WebElement submit = webDriver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/form/div/p/button"));
		submit.click();
		Thread.sleep(6000);
		
				
	}
	
	@Test
	void proceedToCheckout() throws InterruptedException{
		webDriver.get(baseUrl);
		
		webDriver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement fanshopButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-32931\"]"));
		fanshopButton.click();
		
		
		WebElement myAccountButton = webDriver.findElement(By.xpath("//*[@id=\"menu-item-60\"]/a"));
		myAccountButton.click();
		
		WebElement email = webDriver.findElement(By.name("username"));
		email.sendKeys("adi.lagumdzija@stu.ibu.edu.ba");
		
		WebElement password = webDriver.findElement(By.name("password"));
		password.sendKeys("Testtest123!");
		
		WebElement signIn = webDriver.findElement(By.name("login"));
		signIn.click();
		
		WebElement cartButton = webDriver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a/span[2]"));
		cartButton.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,1300)", "");
		
		WebElement checkoutButton = webDriver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div/div/a"));
		checkoutButton.click();

		WebElement name = webDriver.findElement(By.name("billing_first_name"));
		name.sendKeys("Adi");
		
		WebElement lastName = webDriver.findElement(By.name("billing_last_name"));
		lastName.sendKeys("Lagumdzija");
		
		
		String url = webDriver.getCurrentUrl();
		assertEquals("https://shop.fkzeljeznicar.ba/placanje/",url);
		
		//up to this 
//		WebElement shippingAddress = webDriver.findElement(By.name("billing_address_1_field"));
//		shippingAddress.sendKeys("Francuske Revolucije bb");
		
		
		
//		WebElement zipCode = webDriver.findElement(By.name("shipping_postcode"));
//		zipCode.sendKeys("71000");
//		
//		WebElement city = webDriver.findElement(By.name("billing_city"));
//		city.sendKeys("71000");
//		
//		WebElement canton = webDriver.findElement(By.name("billing_state"));
//		canton.sendKeys("Sarajevo");
//		
//		WebElement phoneNum = webDriver.findElement(By.name("billing_phone"));
//		phoneNum.sendKeys("+38761234567");
//		
//		WebElement submit = webDriver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/form/div/p/button"));
//		submit.click();
		
		
	}
	
	
	

	
	

}
