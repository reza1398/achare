package Models;

public class OrderModel {

    private int id;
    private String img,title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public static class Keys{
        public static final String img = "img";
        public static final String title = "title";
        public static final String id = "id";

        public static final String[] ALL_KEYS = {id,img,title};
    }
}
