package tests;

import objects.Account;
import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactsTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80256379284");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setSalutation("Mr.");
        contact.setContactFirstName("Sv");
        contact.setContactLastName("Serega");
        contact.setContactAccountName(account.getAccountName());
        contact.setDescription("nothing");
        contact.setPhone("80235462759");
        contact.setContactOwner("ssas");

        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactsModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactsListPage.openPage(CONTACT_LIST_URL);
        Assert.assertEquals(contactsListPage.getExistContactName(contact.getContactFirstName(),contact.getContactLastName()), contact.getFullName());
        Assert.assertEquals(contactsListPage.getExistPhoneNumberByContactName(contact.getContactFirstName(),contact.getContactLastName()),contact.getPhone());
        Assert.assertEquals(contactsListPage.getExistContactOwnerByContactName(contact.getContactFirstName(),contact.getContactLastName()),contact.getContactOwner());
    }

    @Test
    public void checkNewContactTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("website");
        account.setType("Investor");
        account.setPhone("80256379284");
        account.setDescription("nothing");

        Contact contact = new Contact();
        contact.setSalutation("Mr.");
        contact.setContactFirstName("Sv");
        contact.setContactLastName("Serega");
        contact.setContactAccountName(account.getAccountName());
        contact.setDescription("nothing");
        contact.setPhone("80235462759");
        contact.setContactOwner("ser sas");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage.openPage(NEW_ACCOUNT_MODAL_URL)
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        newContactsModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactsListPage.openPage(CONTACT_LIST_URL)
                .clickOnContactName(contact.getContactFirstName(),contact.getContactLastName());
        Assert.assertEquals(contactsPage.getFieldValueByNameContacts("Name"), contact.getNameWithSalutation());
        Assert.assertEquals(contactsPage.getAccountNameInContacts("Account Name",account.getAccountName()),contact.getContactAccountName());
        Assert.assertEquals(contactsPage.getDescriptionInContacts("Description"), contact.getDescription());
        Assert.assertEquals(contactsPage.getContactOwnerInContacts("Contact Owner"),contact.getContactOwner());
        Assert.assertEquals(contactsPage.getContactPhoneInContacts("Phone"), contact.getPhone());
    }
}
