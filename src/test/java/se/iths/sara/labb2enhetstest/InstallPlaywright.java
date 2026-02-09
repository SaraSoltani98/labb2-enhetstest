import com.microsoft.playwright.Playwright;


public class InstallPlaywright {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            System.out.println("Playwright ready");
        }
    }
}
