package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.WaitUtils;

import java.util.Map;
import java.util.function.Supplier;

public class DashBoardPage {
    private WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // WebElements using @FindBy
    @FindBy(xpath = "//p[normalize-space()='Time at Work']")
    private WebElement timeatwork;

    @FindBy(xpath = "//p[normalize-space()='My Actions']")
    private WebElement myactions;

    @FindBy(xpath = "//p[normalize-space()='Quick Launch']")
    private WebElement quickactions;

    @FindBy(xpath = "//p[normalize-space()='Buzz Latest Posts']")
    private WebElement buzzlatestposts;

    @FindBy(xpath = "//p[normalize-space()='Employees on Leave Today']")
    private WebElement employeesonleavetoday;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Sub Unit']")
    private WebElement employeedistributionbysubunit;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Location']")
    private WebElement employeedistributionbylocation;


    public String getSectionText(String sectionName) {
        switch (sectionName) {
            case "Time at Work":
                return timeatwork.getText();
            case "My Actions":
                return myactions.getText();
            case "Quick Launch":
                return quickactions.getText();
            case "Buzz Latest Posts":
                return buzzlatestposts.getText();
            case "Employees on Leave Today":
                return employeesonleavetoday.getText();
            case "Employee Distribution by Sub Unit":
                return employeedistributionbysubunit.getText();
            case "Employee Distribution by Location":
                return employeedistributionbylocation.getText();
            default:
                throw new IllegalArgumentException("Unknown section: " + sectionName);
        }
    }

    // Reusable text verification method
    public static void verifySectionText(String actualRaw, String expectedRaw) {
        String actual = cleanText(actualRaw);
        String expected = cleanText(expectedRaw);

        if (!actual.equals(expected)) {
            throw new AssertionError("Text mismatch:\nExpected: [" + expected + "]\nActual  : [" + actual + "]");
        }
    }

    private static String cleanText(String text) {
        if (text == null) return "";
        return text
                .replaceAll("[\\u00A0\\u200B-\\u200D\\uFEFF]", "") // Remove invisible characters
                .replaceAll("\\s+", " ") // Normalize all whitespace
                .trim();
    }

}
