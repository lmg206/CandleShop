public class Fragrance{
    private String scent;
    private String category;

    public Fragrance(String s, String f){
        scent = s;
        category = f;
    }

    public String getScent(){
        return scent;
    }

    public String getCategory(){
        return category;
    }

    public String toString(){
        return scent;
    }
}