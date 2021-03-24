package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage_Librarians;
import com.cybertek.library.pages.LandingPage_Students;
import com.cybertek.library.pages.Login_Page;
import com.cybertek.library.utilities.ConfigReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StepDefinitions {

    Login_Page loginPage = new Login_Page();
    LandingPage_Students booksPage = new LandingPage_Students();
    LandingPage_Librarians landingPage_librarians = new LandingPage_Librarians();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @Then("Student should see below info in book categories dropdown")
    public void student_should_see_below_info_in_book_categories_dropdown(List<String> expectedCategories) {
        List<String> actualCategories = booksPage.getAllBookCategories();
        Assert.assertEquals(expectedCategories, actualCategories);
    }

    @Then("Student selects {string} from category dropdown")
    public void student_selects_from_category_dropdown(String category) {
        booksPage.selectCategory(category);
    }

    @Then("Student should see all the books from that category")
    public void student_should_see_all_the_books_from_that_category() {
        String actual = booksPage.getSelectedCategory();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(booksPage.listOfSelectedCategories.get(booksPage.listOfSelectedCategories.size()-1),actual));
        for (WebElement each : booksPage.listOfSelectedCategories) {
            Assert.assertEquals(each.getText(), actual);
        }
    }


    @Given("user login as a {string}")
    public void user_login_as_a(String role) {
        if (role.equalsIgnoreCase("student")){
            loginPage.email_input.sendKeys(ConfigReader.getProperty("student142Email"));
            loginPage.password_input.sendKeys(ConfigReader.getProperty("student142Password"));
            loginPage.sign_in_button.click();
        }else if (role.equalsIgnoreCase("librarian")){
            loginPage.email_input.sendKeys(ConfigReader.getProperty("librarian68"));
            loginPage.password_input.sendKeys(ConfigReader.getProperty("librarian68Password"));
            loginPage.sign_in_button.click();
        }
    }
    @Then("user should land on {string} module")
    public void user_should_land_on_module(String page) {
        wait.until(ExpectedConditions.urlContains(page));

        String url = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(url.contains(page));

    }

    @Given("user logs as a student")
    public void user_logs_as_a_student() {
        loginPage.login_as_student();
    }
    @Then("user should land on books page")
    public void user_should_land_on_books_page() {
        wait.until(ExpectedConditions.urlContains("books"));

        String url = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(url.contains("books"));
    }

    @Then("user should see dropdown value as {int}")
    public void user_should_see_dropdown_value_as(Integer defaultValue) {
        wait.until(ExpectedConditions.urlContains("books"));
        String defaultValueAsText = booksPage.getDefaultValueOfRecordsDropDown().getText();
        Integer actualDefaultValue= Integer.valueOf(defaultValueAsText);
        Assert.assertEquals(defaultValue, actualDefaultValue);
    }

    @Given("user logs as a librarian")
    public void user_logs_as_a_librarian() {
        loginPage.login_as_librarian();
    }
    @Then("user should land on {string} page")
    public void user_should_land_on_dashboard_page(String page) {
        wait.until(ExpectedConditions.urlContains(page));
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains(page));
    }
    @Then("librarian should see users count as {int}")
    public void librarian_should_see_users_count_as(Integer expected_users_count) {
        WebElement actual_user_count_UI = landingPage_librarians.user_count;
        Integer actual_user_count_as_int = Integer.valueOf(actual_user_count_UI.getText());
        Assert.assertEquals(expected_users_count,actual_user_count_as_int);

    }
    @Then("librarian should see books count as {int}")
    public void librarian_should_see_books_count_as(Integer expected_books_count) {
        WebElement actual_books_count_UI = landingPage_librarians.books_count;
        Integer actual_books_count_as_int = Integer.valueOf(actual_books_count_UI.getText());
        Assert.assertEquals(expected_books_count,actual_books_count_as_int);
    }
    @Then("librarian should see borrowed books count as {int}")
    public void librarian_should_see_borrowed_books_count_as(Integer expected_borrowed_books_count) {
        WebElement actual_borrowed_books_count_UI = landingPage_librarians.borrowed_books_count;
        Integer actual_borrowed_books_count_as_int = Integer.valueOf(actual_borrowed_books_count_UI.getText());
        Assert.assertEquals(expected_borrowed_books_count,actual_borrowed_books_count_as_int);
    }

}
