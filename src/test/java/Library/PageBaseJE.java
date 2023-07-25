package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBaseJE extends PageBase{


        private final long WAIT_TIME = 5L;
        private static final int DEF_MAX_TRIALS = 10;
        private static final int REATTEMPT_DELAY = 500;
        protected static final int MENU_SELECTION_DELAY = 1000;

        public PageBaseJE(WebDriver driver)
        {
            super(driver);
        }


        public Object execJS(By locator, String command){


            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME))
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(locator));

            if (element != null) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                return executor.executeScript(command , element);
            }
            else {
                System.out.println("Element is null " + locator.toString());
            }

            return null;
        }
        public void ClickJS(By locator) {

            execJS(locator, "arguments[0].click();");

        }

        public void sendKeysJS(By locator, String text){

            execJS(locator, "arguments[0].value='"+text+"';");
        }

        public String getTextJS(By locator){
            String innerText = execJS(locator, " return document.documentElement.innerText;").toString();
            return innerText;
        }




    }
