package service;

public class LikedList {
    private int like_to;
    private int like_from;
    private String first_name;
    private String last_name;
    private String user_img;

    public int getLike_to() {
        return like_to;
    }

    public void setLike_to(int like_to) {
        this.like_to = like_to;
    }

    public int getLike_from() {
        return like_from;
    }

    public void setLike_from(int like_from) {
        this.like_from = like_from;
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

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public LikedList(int like_to, int like_from, String first_name, String last_name, String user_img) {
        this.like_to = like_to;
        this.like_from = like_from;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_img = user_img;
    }
}
