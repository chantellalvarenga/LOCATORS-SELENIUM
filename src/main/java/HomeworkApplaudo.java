import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	       System.out.println("-------- a. Logo --------");
	       //tagName
	       WebElement logo = driver.findElement(By.tagName("img"));
	       System.out.println("tagName: " + logo.getAttribute("src"));
	       //className
	       logo = driver.findElement(By.className("logoClass"));
		   System.out.println("className: " +logo.getAttribute("src"));
		   //XPATH
		   logo = driver.findElement(By.xpath("//header/a[1]/img[1]"));
		   System.out.println("xpath: " +logo.getAttribute("src"));
		   
		   //Find & print Menu
		   //XPATH
		   List<WebElement> menu = driver.findElements(By.xpath("//header/div[1]"));
		   List<WebElement> buttons = menu.get(0).findElements(By.tagName("button"));
		   
		   //Create a String list for save each button text
		   ArrayList<String> sortedButtons = new ArrayList<String>(); 
		   //Save each button text in sortedButtons
		   int n = buttons.size();
		   for(int i=0; i<n; i++) {
			   sortedButtons.add( (buttons.get(i).getAttribute("innerHTML")) );
		   }
		   
		   //Sort the list by alphabetical order and print
		   Collections.sort(sortedButtons);
		   System.out.println("Xpath: " + sortedButtons);
		   
		   //CSS SELECTOR
		   menu = driver.findElements(By.cssSelector(" body > header > div [class = 'btn btn-primary']"));
		   sortedButtons.clear();
		   n = menu.size();
		   for(int j=0; j<n; j++) {
			   sortedButtons.add( (menu.get(j).getAttribute("innerHTML")) );
		   }
		   //Sort the list by alphabetical order and print
		   Collections.sort(sortedButtons);
		   System.out.println("cssSelector: " + sortedButtons);
		  
		   //Find & print title
		   
		   WebElement title = driver.findElement(By.tagName("title"));
		   System.out.println(title.getAttribute("innerHTML"));
		   title = driver.findElement(By.xpath("//head//title"));
		   System.out.println(title.getAttribute("innerHTML"));
		   title = driver.findElement(By.cssSelector("head > title"));
		   System.out.println(title.getAttribute("innerHTML"));
		   
		   // Find & print radiobuttons
		   
		   	//xpath
		   List<WebElement> rdofieldset = driver.findElements(By.xpath("//body/div[1]/div[1]/fieldset[1]"));
		   List<WebElement> rdobuttons = rdofieldset.get(0).findElements(By.tagName("input"));
		   n = rdobuttons.size();
		   for(int j=0; j<n; j++) {
			   System.out.println(rdobuttons.get(j).getAttribute("value"));
		   }
		   
		   	//CSS Selector
		  
		   rdobuttons = driver.findElements(By.cssSelector(" #radio-btn-example > fieldset [type = 'radio']"));
		   n = rdobuttons.size();
		   for(int j=0; j<n; j++) {
			   System.out.println(rdobuttons.get(j).getAttribute("value"));
		   }
		   
		   //Name
		   
		   rdobuttons = driver.findElements(By.name("radioButton"));
		   n = rdobuttons.size();
		   for(int j=0; j<n; j++) {
			   System.out.println(rdobuttons.get(j).getAttribute("value"));
		   }
		   
		   
		   // Find & print input countries
		   WebElement inputCountries = driver.findElement(By.id("autocomplete"));
		   System.out.println(inputCountries.getAttribute("placeholder"));
		   inputCountries = driver.findElement(By.cssSelector("input#autocomplete"));
		   System.out.println(inputCountries.getAttribute("placeholder"));
		   inputCountries = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		   System.out.println(inputCountries.getAttribute("placeholder"));
		   
		   // Find & print input dropdown 
		   
		
		   // Find & print checkbox number three
		   
		   WebElement chkThree = driver.findElement(By.id("checkBoxOption3"));
		   System.out.println(chkThree.getAttribute("value"));
		   chkThree = driver.findElement(By.name("checkBoxOption3"));
		   System.out.println(chkThree.getAttribute("value"));
		   chkThree = driver.findElement(By.cssSelector("input#checkBoxOption3"));
		   System.out.println(chkThree.getAttribute("value"));

		   // Find & print button open window
		   
		   WebElement btnOpen = driver.findElement(By.id("openwindow"));
		   System.out.println(btnOpen.getText());
		   btnOpen = driver.findElement(By.cssSelector("button#openwindow"));
		   System.out.println(btnOpen.getText());
		   btnOpen = driver.findElement(By.xpath("//button[@id='openwindow']"));
		   System.out.println(btnOpen.getText());
		   
		   // Find & print label "Element Displayed Example"
		   
		   WebElement lblDisplayEx = driver.findElement(By.xpath("//legend[contains(text(),'Element Displayed Example')]"));
		   System.out.println(lblDisplayEx.getText());
		   lblDisplayEx = driver.findElement(By.cssSelector("body > div:nth-child(5) > div.right-align > fieldset:nth-child(1) > legend"));
		   System.out.println(lblDisplayEx.getText());
		   //IDEA colocar los resultados en una lista , recorrerla y validar que la posicion coincida con Element Display y luego imprimir
		   //List<WebElement> lblDisplayExa = driver.findElements(By.tagName("legend"));
		   //System.out.println(lblDisplayExa);
		   
		   //Find & print login
		   WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		   System.out.println(btnLogin.getText());
		   btnLogin = driver.findElement(By.cssSelector("body > header > div > button:nth-child(3)"));
		   System.out.println(btnLogin.getText());
		   
		   
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
