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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	           DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	       }
	       
	       goToTheHomeworkPage();
	   }
	 
	  public static void goToTheHomeworkPage() {
	       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	       driver.manage().window().maximize();
	       System.out.println("\n");
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
		   System.out.println("\n");
		   
		   //Find & print Menu
		   
		   System.out.println("-------- b. Menu --------");
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
		   System.out.println("\n");
		  
		   //Find & print title
		   System.out.println("-------- c. Title --------");
		   WebElement title = driver.findElement(By.tagName("title"));
		   System.out.println("tagName: " + title.getAttribute("innerHTML"));
		   title = driver.findElement(By.xpath("//head//title"));
		   System.out.println("xpath: " + title.getAttribute("innerHTML"));
		   title = driver.findElement(By.cssSelector("head > title"));
		   System.out.println("cssSelector: " + title.getAttribute("innerHTML"));
		   System.out.println("\n");
		   
		   // Find & print radiobuttons
		   System.out.println("-------- d. Radiobuttons --------");
		   	//xpath
		   List<WebElement> rdofieldset = driver.findElements(By.xpath("//body/div[1]/div[1]/fieldset[1]"));
		   List<WebElement> rdobuttons = rdofieldset.get(0).findElements(By.tagName("input"));
		   n = rdobuttons.size();
		   System.out.println("xpath: ");
		   
		   for(int j=0; j<n; j++) {
			   System.out.println(rdobuttons.get(j).getAttribute("value"));
		   }
		   System.out.println("\n");
		   	//CSS Selector
		  
		   rdobuttons = driver.findElements(By.cssSelector(" #radio-btn-example > fieldset [type = 'radio']"));
		   n = rdobuttons.size();
		   
		   System.out.println("cssSelector: ");
		   for(int j=0; j<n; j++) {
			   System.out.println(rdobuttons.get(j).getAttribute("value"));
		   }
		   System.out.println("\n");
		   //Name
		   
		   rdobuttons = driver.findElements(By.name("radioButton"));
		   n = rdobuttons.size();
		   System.out.println("Name: ");
		   
		   for(int j=0; j<n; j++) {
			   System.out.println(rdobuttons.get(j).getAttribute("value"));
		   }
		   System.out.println("\n");
		   
		   // Find & print input countries
		   System.out.println("-------- e. Input countries --------");
		   WebElement inputCountries = driver.findElement(By.id("autocomplete"));
		   System.out.println("id: " + inputCountries.getAttribute("placeholder"));
		   inputCountries = driver.findElement(By.cssSelector("input#autocomplete"));
		   System.out.println("cssSelector: " + inputCountries.getAttribute("placeholder"));
		   inputCountries = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		   System.out.println("xpath: " + inputCountries.getAttribute("placeholder"));
		   System.out.println("\n");
		  
		   // Find & print input dropdown 
		   
		   System.out.println("-------- f. Dropdown --------");
		   
		   	//xpath
		   List<WebElement> dpd = driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));
		 
		   n = dpd.size();
		   System.out.println("xpath: ");
		   
		   for(int j=0; j<n; j++) {
			   System.out.println(dpd.get(j).getAttribute("innerHTML"));
		   }
		   System.out.println("\n");
		   	// CSS Selector
		  
		   dpd = driver.findElements(By.cssSelector("#dropdown-class-example > option "));
		   n = dpd.size();
		   System.out.println("cssSelector: ");
		   
		   for(int j=0; j<n; j++) {
			   System.out.println(dpd.get(j).getAttribute("innerHTML"));
		   }
		   System.out.println("\n");
		   
		   	//tagName
		   
		   dpd = driver.findElements(By.tagName("option"));
		   n = dpd.size();
		   System.out.println("tagName: ");
		   
		   for(int j=0; j<n; j++) {
			   System.out.println(dpd.get(j).getAttribute("innerHTML"));
		   }
		   
		   System.out.println("\n");
		   
		   // Find & print checkbox number three
		   System.out.println("-------- g. Checkbox number three --------");
		   
		   WebElement chkThree = driver.findElement(By.id("checkBoxOption3"));
		   System.out.println("id: " + chkThree.getAttribute("value"));
		   chkThree = driver.findElement(By.name("checkBoxOption3"));
		   System.out.println("name: " + chkThree.getAttribute("value"));
		   chkThree = driver.findElement(By.cssSelector("input#checkBoxOption3"));
		   System.out.println("cssSelector: " + chkThree.getAttribute("value"));
		   System.out.println("\n");

		   // Find & print button open window
		   System.out.println("-------- h. Button open window --------");
		   
		   WebElement btnOpen = driver.findElement(By.id("openwindow"));
		   System.out.println("id: " + btnOpen.getText());
		   btnOpen = driver.findElement(By.cssSelector("button#openwindow"));
		   System.out.println("cssSelector: " + btnOpen.getText());
		   btnOpen = driver.findElement(By.xpath("//button[@id='openwindow']"));
		   System.out.println("xpath: " + btnOpen.getText());
		   System.out.println("\n");
		   
		   // Find & print table "The web Table example"
		   
		   System.out.println("-------- i. Web table example --------");
		   System.out.println("\n-------- Using ID Locator --------");
		   	//ID
		   WebElement table = driver.findElement(By.id("product"));
		   List<WebElement> rows = table.findElements(By.tagName("td")); //From 0 To n rows
		   
		   n = rows.size();
		   String price = "0";
		   
		   //Verify each column price of every row
		   //The first column price start at column 2 and step by 3
		   for(int j=2; j<n; j=j+3) {
			   price =  rows.get(j).getAttribute("innerHTML"); //get column price of every row
			   if(price.equals("25") ) //If price == 25
			   {   //Print the Name, Course and Price when price == 25
				   System.out.println( rows.get(j-2).getAttribute("innerHTML") + " | " + "Course is " + rows.get(j-1).getAttribute("innerHTML") + " | " + price);
			   }
			  
		   }
		   
		
		   	//Name
		   System.out.println("\n-------- Using Name Locator --------");
		   table = driver.findElement(By.name("courses"));
		   rows = table.findElements(By.tagName("td")); //From 0 To n rows
		   n = rows.size();
		   price = "0";
		   
		   //Verify each column price of every row
		   //The first column price start at column 2 and step by 3
		   for(int j=2; j<n; j=j+3) {
			   price =  rows.get(j).getAttribute("innerHTML"); //get column price of every row
			   if(price.equals("25") ) //If price == 25
			   {   //Print the Name, Course and Price when price == 25
				   System.out.println( rows.get(j-2).getAttribute("innerHTML") + " | " + "Course is " + rows.get(j-1).getAttribute("innerHTML") + " | " + price);
			   }
		   }
		   
		   	//CSS selector
		   
		   System.out.println("\n-------- Using css Selector--------");
		   table = driver.findElement(By.cssSelector("#product"));
		   rows = table.findElements(By.tagName("td")); //From 0 To n rows
		   
		   n = rows.size();
		   price = "0";
		   
		   //Verify each column price of every row
		   //The first column price start at column 2 and step by 3
		   for(int j=2; j<n; j=j+3) {
			   price =  rows.get(j).getAttribute("innerHTML"); //get column price of every row
			   if(price.equals("25") ) //If price == 25
			   {   //Print the Name, Course and Price when price == 25
				   System.out.println( rows.get(j-2).getAttribute("innerHTML") + " | " + "Course is " + rows.get(j-1).getAttribute("innerHTML") + " | " + price);
			   }
			  
		   }
		   System.out.println("\n");
		   
		   // Find & print label "Element Displayed Example"
		   System.out.println("-------- j. Element Display  --------");
		   
		   WebElement lblDisplayEx = driver.findElement(By.xpath("//legend[contains(text(),'Element Displayed Example')]"));
		   System.out.println("xpath: " + lblDisplayEx.getText());
		   lblDisplayEx = driver.findElement(By.cssSelector("body > div:nth-child(5) > div.right-align > fieldset:nth-child(1) > legend"));
		   System.out.println("cssSelector: " + lblDisplayEx.getText());
		   //IDEA colocar los resultados en una lista , recorrerla y validar que la posicion coincida con Element Display y luego imprimir
		   //List<WebElement> lblDisplayExa = driver.findElements(By.tagName("legend"));
		   //System.out.println(lblDisplayExa);
		   
		   System.out.println("\n");
		   // Find & print iframe
		   System.out.println("-------- k. iframe --------");
		   
		   WebElement iframe = driver.findElement(By.id("courses-iframe"));
		   System.out.println("id: " + iframe.getAttribute("src"));
		   
		   iframe = driver.findElement(By.tagName("iframe"));
		   System.out.println("tagName: " + iframe.getAttribute("src"));
		   
		   iframe = driver.findElement(By.cssSelector("#courses-iframe"));
		   System.out.println("cssSelector: " + iframe.getAttribute("src"));
		   
		   System.out.println("\n");	   		   	   
		   //Find & print login
		   System.out.println("-------- l. Login element --------");
		   WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		   System.out.println("xpath: " + btnLogin.getText());
		   btnLogin = driver.findElement(By.cssSelector("body > header > div > button:nth-child(3)"));
		   System.out.println("cssSelector: " + btnLogin.getText());
		   
		   
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
