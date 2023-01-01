import org.openqa.selenium.By;

public class Data {
    public  String getUrl = "https://ya.ru/";
    public By cardRatings = By.xpath("//article[@data-autotest-id='product-snippet']//span[@data-auto='rating-badge-value']");
    public By btnAll = By.xpath("//a[@class='home-link2 services-pinned__item services-pinned__all']");
    public By btnMarket = By.xpath("//div[@class='scrollbar__inner']//div[text()='Маркет']");
    public By btnSearch = By.xpath("//button[@id='catalogPopupButton']//span[text()='Каталог']");
    public By allSmartPhone = By.xpath("//a[text()='Смартфоны']");
    public By pricePhone = By.xpath("(//div[@class='t-bah']//input[@class='_3qxDp'])[2]");
    public By diagonalScreen = By.xpath("(//div[@class='t-bah']//input[@class='_3qxDp'])[3]");
    public By smartPhone = By.xpath("(//div[@class='_2XVtn cia-vs cia-cs']//label[@class='_3YMut _2wsVV _3qPzI ymgpk eJg5j'])");
    public By smartPhones = By.xpath("//article[@class='_2vCnw cia-vs cia-cs']");
    public By smartPhonesNums = By.xpath("//article[@class='_2vCnw cia-vs cia-cs']//span[@data-tid='2e5bde87']");
    public By search = By.xpath("//input[@id='header-search']");
    public By searchClick = By.xpath("//button[@type='submit']//span[text()='Найти']");

}
