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

    private By btnAll = By.xpath("//a[@class='home-link2 services-pinned__item services-pinned__all']");
    private By btnMarket = By.xpath("//div[@class='scrollbar__inner']//div[text()='Маркет']");
    private By btnSearch = By.xpath("//button[@id='catalogPopupButton']//span[text()='Каталог']");
    private By allSmartPhone = By.xpath("//a[text()='Смартфоны']");
    private By pricePhone = By.xpath("(//div[@class='t-bah']//input[@class='_3qxDp'])[1]");
    private By diagonalScreen = By.xpath("(//div[@class='t-bah']//input[@class='_3qxDp'])[3]");
    private By smartPhone1 = By.xpath("(//div[@class='_2XVtn cia-vs cia-cs']//label[@class='_3YMut _2wsVV _3qPzI ymgpk eJg5j'])[1]");
    private By smartPhone2 = By.xpath("(//div[@class='_2XVtn cia-vs cia-cs']//label[@class='_3YMut _2wsVV _3qPzI ymgpk eJg5j'])[2]");
    private By smartPhone3 = By.xpath("(//div[@class='_2XVtn cia-vs cia-cs']//label[@class='_3YMut _2wsVV _3qPzI ymgpk eJg5j'])[3]");
    private By smartPhone4 = By.xpath("(//div[@class='_2XVtn cia-vs cia-cs']//label[@class='_3YMut _2wsVV _3qPzI ymgpk eJg5j'])[4]");
    private By smartPhone5 = By.xpath("(//div[@class='_2XVtn cia-vs cia-cs']//label[@class='_3YMut _2wsVV _3qPzI ymgpk eJg5j'])[5]");
    private By smartPhones = By.xpath("//article[@class='_2vCnw cia-vs cia-cs']");
    private By smartPhonesNums = By.xpath("//article[@class='_2vCnw cia-vs cia-cs']//span");
    private By search = By.xpath("//input[@id='header-search']");
    private By searchClick = By.xpath("//button[@type='submit']//span[text()='Найти']");
    private By cardRatings = By.xpath("//span[@data-auto='rating-badge-value']");

    @Test
    public void autorization() throws InterruptedException {
        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        driver.findElement(btnAll).click();
        driver.findElement(btnMarket).click();

        ArrayList<String> newTab = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

        driver.findElement(btnSearch).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allSmartPhone));

        driver.findElement(allSmartPhone).click();
        driver.findElement(pricePhone).sendKeys("20000");
        driver.findElement(diagonalScreen).sendKeys("3");

        driver.findElement(smartPhone1).click();
        driver.findElement(smartPhone2).click();
        driver.findElement(smartPhone3).click();
        driver.findElement(smartPhone4).click();
        driver.findElement(smartPhone5).click();

        List<WebElement> cards = driver.findElements(smartPhones);
        int countCard = (cards).size();
        Assert.assertEquals(countCard, 11);

        try {
            List<WebElement> cardsName = driver.findElements(smartPhonesNums);
            String numCardsName = cardsName.get(1).getText();

            driver.findElement(search).sendKeys(numCardsName);
            driver.findElement(searchClick).click();

        } catch (Exception e) {
            System.out.println("RUN IT AGAIN");
        }


        List<WebElement> cardRating = driver.findElements(cardRatings);
        String numCardsNameRating = cardRating.get(1).getText();
        System.out.println(numCardsNameRating);
        driver.quit();
    }

}
