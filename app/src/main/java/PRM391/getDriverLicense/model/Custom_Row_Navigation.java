package PRM391.getDriverLicense.model;

public class Custom_Row_Navigation {
    private String title;
    private boolean color;

    public Custom_Row_Navigation(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}

