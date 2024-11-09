package page;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
public class CovidTrackingPage extends BasePage {

    @FindBy(css = ".data-filter-input")
    WebElement stateDropdown;

    @FindBy(xpath = "//*[@class='scatterlayer mlayer']/*[name()='g']") 
    List<WebElement> chartPoints;
    
    @FindBy(xpath = "//*[@class='scatterlayer mlayer']/*[name()='g']//ancestor::*[name()='svg']/following-sibling::*[name()='svg'][2]//*[name()='text'][2]") 
    WebElement mousehovertxt;
    
    @FindBy(css = ".resultCard>h2") 
    WebElement pgheadingtxt;
    
    @FindBy(xpath = "//div[@class=\"display-data\"]/p") 
    List<WebElement>  totalcount;
    
    public CovidTrackingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectState(String stateName) {
        selectState(stateDropdown, stateName);
    }
    public void verifyselectedState(String stateName) {
    	System.out.println(pgheadingtxt.getText());
        assertEquals("Results for "+stateName, pgheadingtxt.getText());
    }
    public void getcovidstatuscount(String stateName) {
    	System.out.println(pgheadingtxt.getText());
        assertEquals("Results for "+stateName, pgheadingtxt.getText());
    }
    
    public List<Float> getStatuscountValue() {
    	 List<Float> value = new ArrayList<>(); // ArrayList to store tooltip values
         for (WebElement numb : totalcount) {
             String txt = numb.getText();
             String[] parts = txt.split(":");
             float fValue = Float.parseFloat(parts[1]);
             value.add(fValue);
         }
         return value;
    }

    public List<Float> printLineChartValues() {
    	String val;
    	Actions actions = new Actions(driver);
        List<Float> tooltipValues = new ArrayList<>(); // ArrayList to store tooltip values
        for (WebElement point : chartPoints) {
            actions.moveToElement(point).build().perform();
            String value = mousehovertxt.getText();
            String[] parts = value.split(",");
            if (parts[1].contains("k"))
        		{val = parts[1].replace("k"," ").replace(")"," ");
	            float floatValue = Float.parseFloat(val);
	            String va = Float.toString(floatValue*1000);
	            String v = va.replace(".0"," ");
	            float fValue = Float.parseFloat(v);
	            tooltipValues.add(fValue);
        	}else {
            	val = parts[1].replace(")"," ");
	            float fValue = Float.parseFloat(val);
	            tooltipValues.add(fValue);
        	}
        }
        return tooltipValues;
    }

	public void verifystatuscount(List<Float> getcovidstatuscount, List<Float> status) {
	    Collections.sort(getcovidstatuscount);
	    Collections.sort(status);
		if (getcovidstatuscount.containsAll(status)) {
            System.out.println("count matches");
        } else {
            System.out.println("count not matches");
        }		
	}
}
