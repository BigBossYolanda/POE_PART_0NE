import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.*;

public class testClass {

    //Registration: Username tests
    @Test
    public void testValidUserName() {
        Registration reg = new Registration();
        assertTrue(reg.checkuserName("abc_"));//too long
    }

    @Test
    public void testInvalidUserNameTooLong() {
        Registration reg = new Registration();
        assertFalse(reg.checkuserName("abcdef_"));//too long
    }

    @Test
    public void testInvalidUserNameNoUnderScore(){
        Registration reg = new Registration();
        assertFalse(reg.checkuserName("abcd"));//its missing
    }

    //registration: Password tests
    @Test
    public void testValidPassword(){
        Registration reg = new Registration();
        assertTrue(reg.checkPassword("Password"));//have uppercase, digit, special
    }

    @Test
    public void testInvalidPasswordTooShort(){
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Pw1"));//too short
    }

    @Test
    public void testInvalidPasswordNoUpperCase(){
        Registration reg = new Registration();
        assertTrue(reg.checkPassword("password1!"));//no uppercase
    }

    @Test
    public void testInvalidPasswordNoDigit(){
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password!"));//no digit
    }

    @Test
    public void testInvalidPasswordNoSpecialCharacter(){
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password1"));//no special character
    }

    //Registration: Phone number
    @Test
    public void testValidPhoneNumberLocal(){
        Registration reg = new Registration();
        assertTrue(reg.checkphoneNumber("0987654321"));//starts with 0 + 9 digits
    }

    @Test
    public void testValidPhoneNumberInternational() {
        Registration reg = new Registration();
        assertTrue(reg.checkphoneNumber("+27987654321")); // starts with +27 + 9 digits
    }

    @Test
    public void testInvalidPhoneNumberTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkphoneNumber("12345")); // too short
    }

    @Test
    public void testInvalidPhoneNumberWrongPrefix() {
        Registration reg = new Registration();
        assertFalse(reg.checkphoneNumber("9987654321")); // wrong prefix
    }

    // ✅ Login: Successful login
    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("user123", "pass123", "Yolanda", "Maholwana");
        String result = login.LoginUser("user123", "pass123");
        assertTrue(result.startsWith("Welcome Yolanda Maholwana "));
    }

    // ✅ Login: Failed login
    @Test
    public void testFailedLogin() {
        Login login = new Login("user123", "pass123", "Yolanda", "Maholwana");
        String result = login.LoginUser("wrongUser", "wrongPass");
        assertEquals("Username or Password incorrect. Please try again.", result);
    }
}

