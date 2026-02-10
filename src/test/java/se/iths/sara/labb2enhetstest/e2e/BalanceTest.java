package se.iths.sara.labb2enhetstest.e2e;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("e2e")
public class BalanceTest {
    @Test
    void balansShouldBeZero() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true));

            Page page = browser.newPage();
            page.navigate("http://localhost:8080/balance");
            page.waitForSelector("#balance");
            String balanceText = page.textContent("#balance");

            assertTrue(balanceText.contains("0"));

        }
    }
}




