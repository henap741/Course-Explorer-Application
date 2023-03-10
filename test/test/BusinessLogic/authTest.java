package test.BusinessLogic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.BusinessLogic.Auth.auth;

public class authTest {

    @Test
    void testValidLoginAttempt() {
        auth loginLogic = new auth();
        Boolean result = loginLogic.attemptLogin("steve", "123");

        assertTrue(result);
    }

    void testInvalidLoginAttempt() {
        auth loginLogic = new auth();
        Boolean result = loginLogic.attemptLogin("null", "null");
        System.out.print(result);
        assertFalse(result);
    }

}
