package libary;

public class Catogray {

    private int catid;
    private String catograyName;

    public Catogray() {
    }

    public Catogray(int catid) {
        this.catid = catid;
    }

    public Catogray(String catogayName) {
        this.catograyName = catograyName;
    }

    public Catogray(int catid, String catogayName) {
        this.catid = catid;
        this.catograyName = catograyName;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getCatograyName() {
        return catograyName;
    }

    public void setCatograyName(String catograyName) {
        this.catograyName = catograyName;
    }

}
