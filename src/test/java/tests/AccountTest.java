package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createAccountTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80256379284");
        account.setDescription("nothing");
        account.setAccountOwner("ser sas");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName()),account.getPhone());
        accountListPage
                .clickOnAccountName(account.getAccountName());
        Assert.assertEquals(accountPage.getFieldValueByName("Account Name"), account.getAccountName());
        Assert.assertEquals(accountPage.getFieldValueByName("Website"), account.getWebSite());
        Assert.assertEquals(accountPage.getFieldValueByName("Type"), account.getType());
        Assert.assertEquals(accountPage.getDescriptionInAccount("Description"), account.getDescription());
        Assert.assertEquals(accountPage.getAccountOwnerInAccount("Account Owner", "ser sas"), account.getAccountOwner());
        Assert.assertEquals(accountPage.getPhoneInAccount("Phone"), account.getPhone());
    }
}
