package controller;

public abstract class ControllerUser {
    public abstract void addUser(String name, String firstname, String mail, String password);
    public abstract void connectUser(String mail, String password);
}
