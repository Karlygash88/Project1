package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LandingPage_Students extends BasePage{

    @FindBy (name = "tbl_books_length")
    public WebElement records_dropdown;

    public WebElement getDefaultValueOfRecordsDropDown(){
        Select select = new Select(records_dropdown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return firstSelectedOption;
    }


}
