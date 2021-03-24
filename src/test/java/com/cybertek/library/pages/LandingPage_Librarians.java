package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage_Librarians extends BasePage{

    @FindBy(id = "user_count")
    public WebElement user_count;

    @FindBy(id = "book_count")
    public WebElement books_count;

    @FindBy(id = "borrowed_books")
    public WebElement borrowed_books_count;



}
