package sample.POJO;

public class tableWorker {
    public int idWorker;
    private String fio;


    public tableWorker(String fio) {
        this.fio = fio;

    }

    public tableWorker() {
    }

    public Integer getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}

