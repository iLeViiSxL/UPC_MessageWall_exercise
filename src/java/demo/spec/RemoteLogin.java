package demo.spec;

public interface RemoteLogin {
    UserAccess connect(String usr, String passwd);
    UserAccess register(String usr, String passwd);
}
