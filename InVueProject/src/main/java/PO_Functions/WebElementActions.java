package PO_Functions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementActions extends BaseClass {

	protected Logger log = Logger.getLogger(WebElementActions.class);
	public static WebDriverWait wait;
	@SuppressWarnings("unused")
	private WebElement dropdown = null;
	private Select selectList = null;
	Actions action;

	/**
	 * clicks on Element Using Actions Class
	 * 
	 * @throws Exception
	 */
	public void mouseHoverAndClickOnElement(WebElement element) {
		waitForElementVisible(element, 20);
		try {
			if (isElementDisplayed(element) && isElementEnabled(element)) {
				action = new Actions(driver);
				action.moveToElement(element).click().build().perform();
				log.info("Click action performed on this element");
			}
		} catch (Exception e) {
			System.out.println(element + " Element is not clicked");
			e.printStackTrace();
		}
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = visibilityOf element)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementVisible(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = elementToBeClickable)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementClickable(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = presenceof element)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementToBePresent(String locatorXpath) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorXpath)));
	}

	/**
	 * Checks if element is displayed
	 */
	public static boolean isElementDisplayed(WebElement element) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		try {
			if(element.isDisplayed()) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		}
	}

	/**
	 * Checks if element is enabled
	 */
	public static boolean isElementEnabled(WebElement element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(element.isEnabled()) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	}

	/**
	 * Wrapper method for clickOnMenu
	 *
	 * //@param element //@param timeInSecondsx
	 */

	public void selectListValue(String clickMenu, List<WebElement> selectMenu) throws Exception {
		for (WebElement li : selectMenu) {
                        System.out.println("DropDown-list:"+li.getText()+":");
			System.out.println("Actual:"+clickMenu+":");
			if (li.getText().equalsIgnoreCase(clickMenu)) {
				mouseHoverAndClickOnElement(li);
				log.info("Click action performed on element");
				break;
			}
		}
	}

	public void clickListContainValue(String clickMenu, List<WebElement> selectMenu) throws Exception {
		for (WebElement li : selectMenu) {
			System.out.println("checking: " + li.getText());
			if (li.getText().contains(clickMenu)) {
				System.out.println("checking1: " + li.getText());
				clickOnElement(li);
				log.info("Click action performed on element");
				break;
			}
		}
	}

	/**
	 * clicks On Element
	 * 
	 * @throws Exception
	 */
	public void clickOnElement(WebElement element) {
		waitForElementVisible(element, 5);
		waitForElementClickable(element, 10);
		element.click();
	}

	/**
	 * Get the text present on Web element
	 * 
	 * @param element
	 * @return Text
	 */
	public String getElementText(WebElement element) {
		waitForElementVisible(element, 20);
		waitForElementClickable(element, 10);
		return element.getText().trim();
	}

	public String getElementsText(String clickMenu, List<WebElement> selectMenu) {

		for (WebElement li : selectMenu) {
			waitForElementVisible(li, 50);
			if (li.getText().equalsIgnoreCase(clickMenu)) {
				log.info("Verified send value is " + clickMenu);
				break;
			}
		}
		return clickMenu;
	}

	/**
	 * Enter the text in any text input element
	 * 
	 * @param text
	 * @param element
	 */
	public void sendTextToElement(String text, WebElement element) {
		waitForElementVisible(element, 50);
		waitForElementClickable(element, 10);
		element.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
//		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Enter the text in any text input element
	 * 
	 * @param text
	 * @param element
	 */
	public void clickEnter(WebElement element) {

		waitForElementVisible(element, 50);
		element.sendKeys(Keys.RETURN);

	}

	/**
	 * This method will clear the text from provided text box element
	 * 
	 * @param element
	 */
	public void clearTextBox(WebElement element) {
		element.clear();
	}

	@SuppressWarnings("unused")
	public void verifyElementFromDropdown(String bytype, WebElement option) {
		selectList = new Select(option);
		List<WebElement> elementCount = selectList.getOptions();
		for (int i = 0; i < elementCount.size(); i++) {
			if (bytype.equalsIgnoreCase(elementCount.get(i).getText()))
				;
			log.info("Verified send value is " + bytype);
			break;
		}
	}

	public void verifyListValue(String clickMenu, List<WebElement> selectMenu) {
		for (WebElement li : selectMenu) {

			if (li.getText().equalsIgnoreCase(clickMenu)) {
				break;
			}
		}
	}

	/**
	 * Select value by text from drop-down list
	 * 
	 * @param element
	 * @param text
	 */
	public void selectValueByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * get first Selected value from drop-down list
	 * 
	 * @param element
	 * @param text
	 */
	public String getFirstSelectedText(WebElement element) {
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return option.getAttribute("innerText");
	}

	public void typeInField(WebElement element, String text) {
		waitTime(2000);
		waitForElementClickable(element, 50);
		element.clear();

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			element.sendKeys(Character.toString(c));
			waitTime(300);
		}
	}

	/**
	 * This method sends key to web element
	 * 
	 * @param textToSend string which sending to the text field
	 * @param element    name of the on which we are sending the text/data
	 * @throws InterruptedException
	 */
	public void sendTexttoField(String strText, WebElement ele) {
		try {
			if (ele.isEnabled()) {
				ele.clear();
				ele.sendKeys(strText);
				// log.info("Text " + strText + " sent to element" + ele);
			}
		} catch (Exception e) {
			log.error(e.getStackTrace());
		}
	}

	/**
	 * scrolls up
	 */
	public void scrollup() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0, -250);");
	}

	/**
	 * scrolls down
	 */
	public void scrollDown() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0, 2500);");
	}

	/**
	 * scrolls in to view
	 */
	public void scrollIntoView(WebElement Element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	/**
	 * clicks on element
	 */
	public void javascriptClick(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Switch to tab
	 */
	public void switchTo(String window) {
		String currentWindow = driver.getWindowHandle();
		
		if(window == "newTab") {
		openNewTab();
		}else if(window == "previousTab") {
			log.info("Do not open new tab");
		}

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window Handles are : " + windowHandles);
		System.out.println(windowHandles.size());

		for (String handle : windowHandles) {

			if (!handle.equals(currentWindow)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
			}

		}

	}

	/**
	 * Open new tab
	 */
	public void openNewTab() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
	}
	
	/**
	 * refresh browser
	 */
	public void refreshBrowser() {
		driver.navigate().refresh();
	}
	
	/**
	 * Generate unique String
	 * 
	 * @return String
	 */
	
	public String getUniqueData() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyHmm");
		Date date = new Date();
		String unique = formatter.format(date).toString();
		return unique;
	}
	
	

}
