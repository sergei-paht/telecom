package sample.POJO;

public class tableWindowUsers {
    public int idUsers;
    private String fio;
    private String pol;
    private String birthday;
    private String numTelef;
    private String email;
    private String adressPropis;
    private String adressProgivania;
    private String sernomPasport;
    private String kodPodrazd;
    private String kemVidan;
    private String dataVidachi;
    private String numDogovora;
    private String datazakluchDog;
    private String tipDog;
    private String prichinaRastorg;
    private String licovShet;
    private String service;
    private String sernumDevice;


    public tableWindowUsers(String fio, String numTelef, String licovShet, String service) {
        this.fio = fio;
        this.numTelef = numTelef;
        this.licovShet = licovShet;
        this.service = service;
    }

    public tableWindowUsers() {}

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getNumTelef() {
        return numTelef;
    }

    public void setNumTelef(String numTelef) {
        this.numTelef = numTelef;
    }
    public String getLicovShet() {
        return licovShet;
    }

    public void setLicovShet(String licovShet) {
        this.licovShet = licovShet;
    }
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
