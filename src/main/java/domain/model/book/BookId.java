package domain.model.book;

public class BookId {
    private String id;

    public BookId(String id) {
        if(id == null){
            throw new NullPointerException();
        }
        if(id == ""){
            throw new RuntimeException("本のIDがゼロ文字です。");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
