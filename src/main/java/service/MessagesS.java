package service;

public class MessagesS {


    public MessagesS(int message_id, int user_from, int user_to, String content, String sender, String receiver, String senderImg, String receiverImg, String time) {
        this.message_id = message_id;
        this.user_from = user_from;
        this.user_to = user_to;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.senderImg = senderImg;
        this.receiverImg = receiverImg;
        this.time = time;
    }

    private int message_id;
    private int user_from;
    private int user_to;
    private String content;
    private String sender;
    private String receiver;
    private String senderImg;
    private String receiverImg;
    private String time;

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


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSenderImg() {
        return senderImg;
    }

    public void setSenderImg(String senderImg) {
        this.senderImg = senderImg;
    }

    public String getReceiverImg() {
        return receiverImg;
    }

    public void setReceiverImg(String receiverImg) {
        this.receiverImg = receiverImg;
    }


}
