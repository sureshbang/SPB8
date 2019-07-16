package com.training.pom;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UsersPageRETC_76_POM {
	
	
	private WebDriver driver; 
	
	public UsersPageRETC_76_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='wp-menu-name'][contains(text(),'Users')]")
    private WebElement usersLink;
	
	@FindBy(xpath="//*[@id=\"menu-users\" ]/ul/li[3]/a")
	private WebElement addNew;
	
	@FindBy(xpath="//input[@name='user_login' and @id='user_login']")
	private WebElement	uName;
	
	@FindBy(xpath="//input[@name='email' and @id='email']")
	private WebElement newEmail;
	
	@FindBy(xpath="//input[@name='first_name' and @id='first_name']")
	private WebElement	fName;
	
	@FindBy(xpath="//input[@name='last_name' and @id='last_name']")
	private WebElement	lName;
		
	@FindBy(xpath="//input[@name='url' and @id='url']")
	private WebElement urlEnter;
	
	@FindBy(xpath="//select[@name='role' and @id='role']")
	private WebElement roleSelect;
	
	@FindBy(xpath="//button[text()='Show password'][@type='button']")
	private WebElement showPassword;
	
	@FindBy(xpath="//input[@name='pass1-text' and @id='pass1-text']")
	private WebElement	passwordTextEnter;
	
	@FindBy(xpath="//input[@name='pw_weak'and @type='checkbox']")
	private WebElement weakPassword;
	
	@FindBy(xpath="//span[text()='Hide']")
	private WebElement	hideButton;
	
	@FindBy(xpath="//span[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//input[@name='createuser' and @id='createusersub']")
	private WebElement newUserCreateButton;
			
	@FindBy(xpath="//div/p[text()='New user created. ']")
	private WebElement newUserCreated;
	
	// @FindBy(xpath="//*[@id='wpbody-content']/div[3]/div[2]/p[1]/strong")
	//	private WebElement errorText;
	@FindBy(xpath="//div[@class='error']//p[1]")
	private WebElement errorText;
	
	
	public void userLinkClick() {
		 //driver.switchTo().defaultContent();
		  //JavascriptExecutor js = (JavascriptExecutor)driver;
		 // js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		this.usersLink.click();
	}
	
	public void addNewclick() {
		this.addNew.click(); 
		
	}
	public void newUserName(String uName) {
		this.uName.clear();
		this.uName.sendKeys(uName);
	}
	public void newEmail(String newEmail) {
		this.newEmail.clear();
		this.newEmail.sendKeys(newEmail);
	}
	public void newFirstName(String fName) {
		this.fName.clear(); 
		this.fName.sendKeys(fName); 
	}
	
	public void newLastName(String lName) {
		this.lName.clear(); 
		this.lName.sendKeys(lName); 
		
		}
	public void newURL(String urlEnter) {
		this.urlEnter.clear(); 
		this.urlEnter.sendKeys(urlEnter); 
	}
	public void roleSelectBox() {
		Select role= new Select(this.roleSelect);
		role.selectByVisibleText("Agent");
	}
	
	
	public void showPasswordBtn() {
		this.showPassword.click(); 
	}
	public void newPassword(String passwordTextEnter) {
		this.passwordTextEnter.clear(); 
		this.passwordTextEnter.sendKeys(passwordTextEnter); 
	}
	public void weakPasswordClick() {
		this.weakPassword.click();
	}
	
	public boolean hideButton() {
		 boolean hid = this.hideButton.isDisplayed(); 
	return hid;
	}
	public boolean cancelButton() {
		 boolean cancl = this.cancelButton.isDisplayed(); 
	return cancl;
	}
	public void newUserCreateButtonClick() {
		this.newUserCreateButton.click(); 
	}
	
    public String  newUserCreatedMsg() {
		String message = this.newUserCreated.getText();
		return message;
	}
    public String  errorTextMsg() {
		String emessage = this.errorText.getText();
		return emessage;
	}
    
}
