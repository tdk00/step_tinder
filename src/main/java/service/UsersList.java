package service;

public class UsersList {

    private int user_id;
    private String first_name;
    private String last_name;
    private String img;

    public UsersList() { }

    public UsersList(int user_id, String first_name, String last_name, String img) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.img = img;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
