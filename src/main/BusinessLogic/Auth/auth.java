package main.BusinessLogic.Auth;

import main.DB.DB;
import main.DB.util.objects.userObject;

public class auth {

    public Boolean attemptLogin(String username, String password) {
        DB queryDB = new DB();
        userObject userFound = queryDB.getUser(username);
        if (userFound.getPassword() == password) {
            return true;
        }
        return false;
    }

    public Boolean signUp(String username, String password) {
        return null;
    }

}
