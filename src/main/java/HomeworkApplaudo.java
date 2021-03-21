import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HomeworkApplaudo {
 public static WebDriver driver;
	 
	 private static void navigateToBrowser(String navegador) {
	       if (navegador == "GoogleChrome") {
	           System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	           driver = new ChromeDriver();
	       }

	       else if (navegador== "Firefox") {
	           System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
	           driver = new FirefoxDriver();
	       }

	       else if (navegador == "Explorer") {
	           //System.out.println("HW: Add the Explorer driver...");
	    	   System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
	           driver = new InternetExplorerDriver();
	       }
	       
	       goToTheHomeworkPage();
	   }
	 
	  public static void goToTheHomeworkPage() {
	       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	       driver.manage().window().maximize();
	       
	       //Find & print Logo
	       WebElement logo = driver.findElement(By.tagName("img"));
	       System.out.println(logo.getAttribute("src"));
	       logo = driver.findElement(By.className("logoClass"));
		   System.out.println(logo.getAttribute("src"));
		   logo = driver.findElement(By.xpath("//header/a[1]/img[1]"));
		   System.out.println(logo.getAttribute("src"));
		   
		    //Find & print Logo
	       
	       driver.quit();
	   }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Change to: GoogleChrome, Firefox or Explorer
		
		Scanner sc = new Scanner(System.in);

        System.out.println("Browsers available for testing");
        System.out.println("1-Google Chrome \n 2-Firefox \n 3-Internet Explorer \n");
        System.out.print("Choose an option: ");
        int op = sc.nextInt();
        sc.close();
        
        switch (op) {
            case 1:
            	navigateToBrowser("GoogleChrome");
                break;
            case 2:
            	navigateToBrowser("Firefox");

                break;
            case 3:
            	navigateToBrowser("Explorer");

                break;
            default:
                System.out.println("Select a correct option (1-3)");
                break;
        }
        
		
      
	      
	}

}
