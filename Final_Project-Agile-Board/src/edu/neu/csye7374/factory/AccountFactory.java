package edu.neu.csye7374.factory;

import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.Role;

public class AccountFactory {
    public static AccountFactory instance = new AccountFactory();

    private AccountFactory() {
    }

    public Account getAccount(Role role, int id, String username, String password, String displayName) {
        return new Account(role, 1, username, password, displayName);
    }
}
