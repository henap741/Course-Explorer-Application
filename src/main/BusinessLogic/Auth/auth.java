package main.BusinessLogic.Auth;

import main.DB.DB;
import main.DB.util.objects.userObject;

public class auth {

    public Boolean attemptLogin(String username, String password) {
        try {
            DB queryDB = new DB();
            userObject userFound = queryDB.getUser(username);
            if (userFound.getPassword() == password) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error logging in - auth.java");
            return false;
        }

    }

    public Boolean signUp(String username, String password) {

        try {
            DB queryDB = new DB();
            userObject userFound = queryDB.getUser(username);
            if (userFound != null) {
                System.out.println("Username already exists");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error signing up - auth.java");
            return false;
        }

        try {
            DB queryDB = new DB();
            queryDB.createUser(username, password, null, null, null);

        } catch (Exception e) {
            System.out.println("Error signing up - auth.java");
            return false;
        }

        return true;
    }

}
