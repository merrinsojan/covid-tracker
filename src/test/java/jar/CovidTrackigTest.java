package jar;

import java.util.List;

import org.testng.annotations.Test;

import page.CovidTrackingPage;

public class CovidTrackigTest  extends baseClass{

	@Test
	public void testStateSelection() throws InterruptedException {
        CovidTrackingPage covidTrackingPage = new CovidTrackingPage(driver);
		covidTrackingPage.selectState("Gujarat");
		Thread.sleep(3000);
		covidTrackingPage.verifyselectedState("Gujarat");
		
    }
	@Test
	public void testprintlinechartvalue() throws InterruptedException {
        CovidTrackingPage covidTrackingPage = new CovidTrackingPage(driver);
		covidTrackingPage.selectState("Gujarat");
		Thread.sleep(3000);
		covidTrackingPage.verifyselectedState("Gujarat");
		List<Float>  getcovidstatuscount = covidTrackingPage.getStatuscountValue();
        List<Float> statuscount = covidTrackingPage.printLineChartValues();

		covidTrackingPage.verifystatuscount(getcovidstatuscount, statuscount);


        
    }
	

}
