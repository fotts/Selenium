import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import org.testng.annotations.*;

public class TestNGGroups {
	
	@BeforeGroups("Login")
	public void LoginTest1() {
		System.out.println("setupLogin()");
	}
	
	//@BeforeClass
	//@org.testing.annotations.Parameters(value={"browser","version","platform"})
		
	@Test(groups = { "Login" }, priority=0)
	public void test1() {
		System.out.println("Login()");
    }
	
	@AfterGroups("Login")
	public void LoginTest2() {
		System.out.println("endLogin()");
	}
	
	@BeforeGroups("Search")
	public void SearchTest1() {
		System.out.println("setupSearch()");
	}
	
	@Test(groups = { "Search" }, priority=1, enabled=false)
	public void test2() {
		System.out.println("Search()");
    }
	
	@AfterGroups("Search")
	public void SearchTest2() {
		System.out.println("endSearch()");
	}
	
	@BeforeGroups("AddItem")
	public void AddItemTest1() {
		System.out.println("setupAddItem()");
	}
	
	@Test(groups = { "AddItem" }, priority=2)
	public void test3() {
		System.out.println("AddItem()");
    }
	
	@AfterGroups("AddItem")
	public void AddItemTest2() {
		System.out.println("endAddItem()");
	}
	
	@BeforeGroups("ModifyItem")
	public void ModifyItemTest1() {
		System.out.println("setupModifyItem()");
	}
	
	@Test(groups = { "ModifyItem" }, priority=3)
	public void test4() {
		System.out.println("ModifyItem()");
    }
	
	@AfterGroups("ModifyItem")
	public void ModifyItemTest2() {
		System.out.println("endModifyItem()");
	}
	
	@BeforeGroups("Checkout")
	public void CheckoutTest1() {
		System.out.println("setupCheckout()");
	}
	
	@Test(groups = { "Checkout" }, priority=4)
	public void test5() {
		System.out.println("Checkout()");
    }
	
	@AfterGroups("Checkout")
	public void CheckoutTest2() {
		System.out.println("endCheckout()");
	}
	
	@BeforeGroups("Confirm")
	public void ConfirmTest1() {
		System.out.println("setupConfirm()");
	}
	
	@Test(groups = { "Confirm" }, priority=5)
	public void test6() {
		System.out.println("Confirm()");
    }
	
	@AfterGroups("Confirm")
	public void ConfirmTest2() {
		System.out.println("endConfirm()");
	}
}
