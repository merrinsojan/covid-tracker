package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

	public void selectState(WebElement stateDropdown, String stateName) {
	    Select select = new Select(stateDropdown);
	    select.selectByVisibleText(stateName);
	}
}