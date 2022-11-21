package xyz.kacperm.account;

public interface Account {

    boolean validate(String username, String password);
    void register(String username, String password);

}
