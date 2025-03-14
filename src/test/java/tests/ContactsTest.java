package tests;

import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest{

    @Test
    public void createContactTest() {
        Contact contact = new Contact();
        contact.setSalutation("Mr.");
        contact.setContactFirstName("Sv");
        contact.setContactLastName("Serega");
        contact.setContactAccountName("acc");
        contact.setDescription("nothing");
        contact.setPhone("80235462759");
        loginPage.openPage(LOGIN_URL)
                .login(username, password);
        newContactsModalPage.openPage(NEW_CONTACT_MODAL_URL)
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactsListPage.openPage(CONTACT_LIST_URL);
      Assert.assertEquals(contactsListPage.getExistContactName(contact.getContactFirstName(),contact.getContactLastName()), contact.getFullName());
      Assert.assertEquals(contactsListPage.getExistPhoneNumberByContactName(contact.getContactFirstName(),contact.getContactLastName()),contact.getPhone());
        contactsListPage
                .clickOnContactName(contact.getContactFirstName(),contact.getContactLastName());
        Assert.assertEquals(contactsPage.getFieldValueByNameContacts("Name"), contact.getNameWithSalutation());
    }
}
