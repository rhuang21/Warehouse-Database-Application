package ca.ubc.cs304.delegates;

import ca.ubc.cs304.UI.InterfaceUI;

public interface LoginDelegate {
    void login(String username, String password);

    void returnToMainMenu(InterfaceUI ui);
}
