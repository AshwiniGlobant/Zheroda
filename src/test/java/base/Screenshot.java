package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public String takesScreenshot(String testName, WebDriver driver) {
		File sourceScreenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScrrenshotFile=new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
	    try {
			FileUtils.copyFile(sourceScreenshotFile, destinationScrrenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return destinationScrrenshotFile.getAbsolutePath();
	}

}
