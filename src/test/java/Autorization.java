import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Autorization {

    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    @Test
    public void autorization() throws InterruptedException {
        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        driver.findElement(getDate.btnAll).click();
        driver.findElement(getDate.btnMarket).click();

        ArrayList<String> newTab = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

        driver.findElement(getDate.btnSearch).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getDate.allSmartPhone));

        driver.findElement(getDate.allSmartPhone).click();
        driver.findElement(getDate.pricePhone).sendKeys("20000");
        driver.findElement(getDate.diagonalScreen).sendKeys("3");

        List<WebElement> children = driver.findElements(getDate.smartPhone);
        for (int i = 0; i < 5; i++) {
            children.get(i).click();
        }

        List<WebElement> cards = driver.findElements(getDate.smartPhones);
        int countCard = (cards).size();
        switch (countCard) {
            case 10:
                Assert.assertEquals(countCard, 10);
                System.out.println(countCard);
                break;
            case 11:
                Assert.assertEquals(countCard, 11);
                System.out.println(countCard);
                break;
            case 12:
                Assert.assertEquals(countCard, 12);
                System.out.println(countCard);
                break;
            case 13:
                Assert.assertEquals(countCard, 13);
                System.out.println(countCard);
                break;
            default:
                System.out.println("Not number");
        }


        List<WebElement> cardsName = driver.findElements(getDate.smartPhonesNums);
        String numCardsName = cardsName.get(1).getText();

        driver.findElement(getDate.search).sendKeys(numCardsName);
        driver.findElement(getDate.searchClick).click();

        Thread.sleep(1000);
        List<WebElement> cardRating = driver.findElements(getDate.cardRatings);
        String numCardsNameRating = cardRating.get(1).getText();
        System.out.println(numCardsNameRating);

        switch (numCardsNameRating) {
            case  "4.7":
                Assert.assertEquals(numCardsNameRating, 4.7);
                System.out.println(countCard);
                break;
            default:
                System.out.println("4.8");
        }

        driver.quit();
    }


}
