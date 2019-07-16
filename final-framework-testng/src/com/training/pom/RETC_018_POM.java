
package com.training.pom;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

public class RETC_018_POM 

{
	private WebDriver driver; 


public RETC_018_POM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[contains(text(),' Log In / Register')]")
private WebElement loginLink;

@FindBy(id="user_login")
private WebElement userName; 

@FindBy(id="user_pass")
private WebElement password;

@FindBy(name="login")
private WebElement loginBtn; 

//div[@class='wp-menu-name

@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[3]")  
private WebElement postsLink; 



@FindBy(xpath="//a[contains(@href,'edit-tags.php?taxonomy=category')]")
private WebElement categoriesLink;

@FindBy(id="tag-name")  //*[@id="tag-name"]
private WebElement nameText; 

@FindBy(id="tag-slug")
private WebElement slugText;

@FindBy(id="tag-description")
private WebElement tagDescription;


@FindBy(id="submit")
private WebElement submitButton;


		





public void loginlinkclick()
{
	this.loginLink.click();
}
public void sendUserName(String userName) {
	this.userName.clear();
	this.userName.sendKeys(userName);
}

public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
}

public void clickLoginBtn() {
	this.loginBtn.click(); 
	
	}

public  void postLink() {
	this.postsLink.click();
	
           }

public  void CategorieLink() {
	this.categoriesLink.click();
	
           }
public void nameTextCon(String nameText) {
	this.nameText.clear();
	this.nameText.sendKeys(nameText);
}
public void slugTextCon(String slugText) {
	this.slugText.clear();
	this.slugText.sendKeys(slugText);
}

public void tagDescTextCon(String tagDescription) {
	this.tagDescription.clear();
	this.tagDescription.sendKeys(tagDescription);
}
public  void submitButtonClick() {
	this.submitButton.click();
	
           }

}
