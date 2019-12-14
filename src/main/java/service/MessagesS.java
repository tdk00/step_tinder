package service;

public class MessagesS {

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getUser_from() {
        return user_from;
    }

    public void setUser_from(int user_from) {
        this.user_from = user_from;
    }

    public int getUser_to() {
        return user_to;
    }

    public void setUser_to(int user_to) {
        this.user_to = user_to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MessagesS(int message_id, int user_from, int user_to, String content, String time) {
        this.message_id = message_id;
        this.user_from = user_from;
        this.user_to = user_to;
        this.content = content;
        this.time = time;
    }

    private int message_id;
    private int user_from;
    private int user_to;
    private String content;
    private String time;


}
