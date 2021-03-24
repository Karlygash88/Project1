package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LandingPage_Students extends BasePage{

    @FindBy (name = "tbl_books_length")
    public WebElement records_dropdown;

    @FindBy(id="book_categories")
    public WebElement selectBookCategories;

    @FindBy(xpath = "//table//tr//td[5]")
    public List<WebElement> listOfSelectedCategories;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> header;

    @FindBy (xpath = "//th[@data-name='B.name']")
    public List<WebElement> listBookName;

    @FindBy(xpath = "//a[@href='tpl/add-book.html']")
    public WebElement buttonAddBook;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputBookName;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement inputBookISBN;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement inputBookYear;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement inputBookAuthor;

    @FindBy(id = "description")
    public WebElement inputBookDescription;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement buttonBookSaveChanges;

    @FindBy (id = "book_group_id")
    public WebElement selectBookCategoriesAddBook;

    @FindBy (className = "modal-content")
    public WebElement addBookWindow;

    @FindBy(linkText = "Books" )
    public WebElement booksPageLink;

    public List<String> getAllBookCategories(){
        List<String> categories = new ArrayList<>();
        Select select = new Select(selectBookCategories);
        select.getOptions().forEach(p -> categories.add(p.getText()));
        return categories;
    }

    public void selectCategory(String category){
        Select select = new Select(selectBookCategories);
        BrowserUtils.clickOn(selectBookCategories, 10);
        select.selectByVisibleText(category);
    }

    public String getSelectedCategory(){
        Select select = new Select(selectBookCategories);
        return select.getFirstSelectedOption().getText();
    }

    public WebElement getDefaultValueOfRecordsDropDown(){
        Select select = new Select(records_dropdown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        return firstSelectedOption;
    }


}
