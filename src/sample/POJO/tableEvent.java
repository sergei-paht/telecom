package sample.POJO;

public class tableEvent {
    public int idUsers;
    private String event;


    public tableEvent(String event) {
        this.event = event;
    }

    public tableEvent() {
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

