package Assignment1_CSCN72040_Group16.domain;

public enum Orientation {
    FACE_UP(1, "Face Up"),
    FACE_DOWN(2, "Face Down"),
    PORTRAIT(3, "Portrait"),
    PORTRAIT_UPSIDE_DOWN(4, "Portrait Upside Down"),
    LANDSCAPE_LEFT(5, "Landscape Left"),
    LANDSCAPE_RIGHT(6, "Landscape Right");

    private final int code;
    private final String description;

    Orientation(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescriptionByCode(int code) {
        for (Orientation o : values()) {
            if (o.getCode() == code) {
                return o.getDescription();
            }
        }
        return "Unknown";
    }
}
