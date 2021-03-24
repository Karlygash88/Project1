package com.cybertek.library.pages;

import com.cybertek.library.utilities.ConfigReader;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement email_input;

    @FindBy(id = "inputPassword")
    public WebElement password_input;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement sign_in_button;

    public void login_as_student(String username, String password){
        email_input.sendKeys(username);
        password_input.sendKeys(password);
        sign_in_button.click();
    }

    public void login_as_student(){
        email_input.sendKeys(ConfigReader.getProperty("student142Email"));
        password_input.sendKeys(ConfigReader.getProperty("student142Password"));
        sign_in_button.click();
    }

    public void login_as_librarian(){
        email_input.sendKeys(ConfigReader.getProperty("librarian68"));
        password_input.sendKeys(ConfigReader.getProperty("librarian68Password"));
        sign_in_button.click();
    }




}
