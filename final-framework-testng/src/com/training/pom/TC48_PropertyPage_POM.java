package com.training.pom;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class TC48_PropertyPage_POM {


		private WebDriver driver; 
		
		public TC48_PropertyPage_POM(WebDriver driver) {
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
		
		
		@FindBy(xpath="//div[@class='wp-menu-name'][contains(text(),'Properties')]")
		private WebElement propertiesLink;
		
		@FindBy(xpath="//div[text()='Properties']")
		private WebElement propertyMenuItem;
		
		@FindBy(xpath="//a[@class='page-title-action'][contains(text(),'Add New')]")
		private WebElement addNewButton;
		@FindBy(xpath="//a[@class='current'][contains(text(),'Add New')]")
		private WebElement addNewMenuLink;
		
		
		@FindBy(xpath="//div[@class='cmb-td']//textarea[@class='cmb2_textarea' and @name='_price']")
		private WebElement priceTextArea;
		
		@FindBy(xpath="//div[@class='cmb-td']//input[@class='regular-text' and @name='_price_per']")
		private WebElement pricePerSft;
		
		@FindBy(xpath="//a[@class ='ui-tabs-anchor' and text()='Main Details']")
		private WebElement mainDetailsTab;
		
		@FindBy(xpath="//input[@id='_status']")
		private WebElement statusInMainDetails;
		
		@FindBy(xpath="//input[@id='_location']")
	    private WebElement locationInMainDetails;
	    
        @FindBy(xpath="//input[@id='_possession']")
        private WebElement  possessionInMainDetails;
        
        @FindBy(xpath="//a[@class ='ui-tabs-anchor' and text()='Location']")
        private WebElement locationTab;
        
        @FindBy(xpath="//input[@id='_friendly_address']")
        private WebElement addressfriendly;
        
        
        @FindBy(xpath="//input[@id='_address']")
        private WebElement addressID;
        
        @FindBy(xpath="//input[@id='_geolocation_lat']")
        private WebElement	geolocationLat;					
        				
        @FindBy(xpath="//input[@id='_geolocation_long']")
        private WebElement	geolocationLong;							
        
        @FindBy(xpath="//a[@class ='ui-tabs-anchor' and text()='Details']")
        private WebElement detailsTab;  
        
       @FindBy(xpath="//input[@id='_storage_room']")
       private WebElement storageRoomText;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@FindBy(xpath="//li//a[text()='Features']")
		private WebElement featureMenuItem;
		
		@FindBy(xpath="//input[@name='tag-name' and @type='text']")
		private WebElement nameTextBox;
		
		@FindBy(xpath="//input[@name='slug' and @id='tag-slug']")
		private WebElement slugTextBox;
		
		
		@FindBy(xpath="//select[@name='parent' and @id='parent']")
		private WebElement parentFeatureSelection;
		
		
		
		@FindBy(xpath="//textarea[@name='description' and @id='tag-description']")
		private WebElement descriptionTextArea;
		
		
		
		
		@FindBy(id="submit")
		private WebElement addNewFeatureBtn;
		
		
		
		
		
		
		
		@FindBy(xpath="//div//a[@id='region-add-toggle'][contains(text(),'Add New Region')]")
		private WebElement addNewRegionLink;
		
		
		@FindBy(xpath="//input[@id='newregion' and @class='form-required']")
		private WebElement addText;
		
	    @FindBy(xpath="//select[@id='newregion_parent' and @class='postform']")
		private WebElement	parentType;	
		
	   
		@FindBy(xpath="//input[@id='region-add-submit' and @type='button']")
		private WebElement addNewRegionButton;
		
		
		@FindBy(xpath="//input[@name='post_title' and @type='text']") 
		private WebElement enterTitle;
		
		@FindBy(xpath="//textarea[@class='wp-editor-area' and @id='content']")
	     private WebElement textArea;
		
		@FindBy(xpath="//input[@value='452' and @type='checkbox'][@id='in-region-452']")
		private WebElement RegionChkBox;	
	  	  
	  
	 
	  
	  @FindBy(xpath="//input[@name='publish'and @type='submit']") 
	  private  WebElement publishButton;
	  
	  
	  @FindBy(xpath="//a[contains(text(),'Move to Trash')]")
	  private  WebElement moveToTrash;
	 
	  @FindBy(xpath="//a[contains(text(),'Trash ')]")
	  private WebElement trashLink;

		
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
		public void propertiesLinkclick() {
			this.propertiesLink.click(); 
		}
		public void propertyMenuItemClick() {
			Actions act = new Actions(driver);
			act.moveToElement(this.propertyMenuItem).build().perform();
			
			//this.propertyMenuItem.click(); 
		}
		
		
		public void featuresMenuItemLinkclick() {
			Actions act = new Actions(driver);
			act.moveToElement(this.featureMenuItem).click().build().perform();
			//this.featureMenuItem.click(); 
		}
		public void nameTextBoxEnterValue(String nameTextBox) {
			this.nameTextBox.clear();
			this.nameTextBox.sendKeys(nameTextBox);
			}
		public void slugTextBoxEnterValue(String slugTextBox) {
			this.slugTextBox.clear();
			this.slugTextBox.sendKeys(slugTextBox);
			}
		
		public void parentFeatureSelectionDropdown(String parentRegion) {
		       Select pp = new Select(this.parentFeatureSelection);
				pp.selectByVisibleText(parentRegion);
			}
	
		public void descriptionTextAreaEnter(String descriptionTextArea) {
			this.slugTextBox.clear();
			this.slugTextBox.sendKeys(descriptionTextArea);
			}
		public void addNewfeatureButtonClick() {
			this.addNewFeatureBtn.click(); 
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void addNewButtonclick() {
			this.addNewButton.click(); 
			
		}
	
	  public void enterTileText(String enterTitle) 
	  { 
		  this.enterTitle.clear();
	  this.enterTitle.sendKeys(enterTitle);
	  
	  } 
	  public void textAreaBox(String textArea) 
	  { 
		  this.textArea.clear();
	  this.textArea.sendKeys(textArea);
	  
	  } 
	  
	  public void regionCheckkBox() 
	  {
		  this.RegionChkBox.click();
	  
	  } 
	  
	  public void publishButtonClick() { driver.switchTo().defaultContent();
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	  this.publishButton.click();
	  
	  }
	 
		
		public void addNewRegionLinkClick() {
			this.addNewRegionLink.click();			
			
		}
		public void addTextInTextBox(String addText) {
			this.addText.sendKeys(addText);;			
			
		}
		public void parentTypeDropDown() {
			Select s = new Select(this.parentType);
			s.selectByVisibleText("   North Bangalore");
			
		}
		
		
		public void addNewRegionButtonClick() {
			this.addNewRegionButton.click();
			
		}
		public void moveToTrashLink() {
			this.moveToTrash.click();
			
		}	
		
		public  void  clickTrashLink() {
			this.trashLink.click();
		}
		
		
	}



