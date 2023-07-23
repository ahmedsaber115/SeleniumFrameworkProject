package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistrationTestCucumber extends TestBase {
	HomePage homeobject;
	UserRegistrationPage  registobject ;
	LoginPage loginobject;

	@When("he click in register link from home page")
	public void he_click_in_register_link_from_home_page() {
		homeobject= new HomePage(drive);
		homeobject.openUserRegistrationPage();
	}

	@When("entered {string} , {string} ,{string} ,{string}")
	public void entered(String firstname, String lastname, String email, String password) {
		registobject = new UserRegistrationPage(drive);
		registobject.userRegistration(firstname, lastname, email, password);
	}

	@When("click register button from register page and check registration complete")
	public void click_register_button_from_register_page_and_check_registration_complete() {
		Assert.assertTrue(drive.findElement(registobject.successMessage).getText().contains("Your registration completed"));
	}

	@When("click Log in link and insert {string} and {string} and click confirm button")
	public void click_log_in_link_and_insert_and_and_click_confirm_button(String email, String password) {
		homeobject.openLoginPage();
		loginobject = new LoginPage(drive);
		loginobject.UserLogin(email, password);
	}

	@Then("ckeck if log out is displayed and log out")
	public void ckeck_if_log_out_is_displayed_and_log_out() {
		
		registobject.UserLogout();
	}



}
