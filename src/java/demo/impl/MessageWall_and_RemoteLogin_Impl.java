package demo.impl;

import demo.spec.Message;
import demo.spec.MessageWall;
import demo.spec.RemoteLogin;
import demo.spec.UserAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageWall_and_RemoteLogin_Impl implements RemoteLogin, MessageWall {

    private List<Message> messages;
    private HashMap<String, String> userList;

    public MessageWall_and_RemoteLogin_Impl() {
        this.messages = new ArrayList<Message>();
        this.userList = new HashMap<String, String>();
        userList.put("test", "test");
        userList.put("admin", "admin");
        userList.put("user", "user");
    }

    @Override
    public UserAccess connect(String usr, String passwd) {
        if(userList.containsKey(usr)){
            if(userList.get(usr).equals(passwd)){
                return new UserAccess_Impl(this, usr);
            }
            return null;
        }
        return null;
    }

    @Override
    public void put(String user, String msg) {
        messages.add(new Message_Impl(user,msg));
    }

    @Override
    public boolean delete(String user, int index) {
        if(user.equals(messages.get(index).getOwner())){
            return messages.remove(messages.get(index));
        }
        return false;
    }

    @Override
    public Message getLast() {
        if(messages.size()>0){
            return messages.get(messages.size() - 1);
        }else{
            return new Message_Impl("TEST", "Not message yet !");
        }
    }

    @Override
    public int getNumber() {
        return messages.size();
    }

    @Override
    public List<Message> getAllMessages() {
        return messages;
    }

}
