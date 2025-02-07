package Assignment1_CSCN72040_Group16;

public class Data {
    
    private Integer position;
    private Double x;
    private Double y;
    private Double z;

    public Data() {
        this.position = 0;
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public Data(Integer position, Double x, Double y, Double z) {
        this.position = position;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }
}
