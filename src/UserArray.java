import java.util.ArrayList;

public class UserArray {

    private ArrayList<User> myUser;

    public UserArray() {
        myUser = new ArrayList<>();
    }

    public ArrayList<User> getMyUser() {
        return myUser;
    }

    public void setMyUser(ArrayList<User> myUser) {
        this.myUser = myUser;
    }

    public void AddToList(User person) {
        myUser.add(person);
    }
}
