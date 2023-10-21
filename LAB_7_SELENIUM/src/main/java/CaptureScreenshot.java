
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	public static void takeScreenshot(WebDriver driver, String name) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String imageName = name + ".png";
            String screenshotPath = "./ScreenShots/" + imageName;
            File destiny = new File(screenshotPath);
            FileHandler.copy(source, destiny);
        } catch (Exception ex) {
            System.out.println("Đã xảy ra lỗi khi chụp màn hình!");
            ex.printStackTrace();
        }
    }
}