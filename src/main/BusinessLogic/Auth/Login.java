package main.BusinessLogic.Auth;

import main.DB.DB;

public class Login {

    public boolean attemptLogin(String username, String password) {
        DB queryDB = new DB();
        boolean loginFound = queryDB.createAccount();
        return loginFound;
    }
}
