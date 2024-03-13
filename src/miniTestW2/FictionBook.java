package miniTestW2;

public class FictionBook extends Book {
    private String category;

    public FictionBook() {
    }

    public FictionBook(String category) {
        this.category = category;
    }

    public FictionBook(int bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }

    @Override
    public double getAmount() {
        return getPrice() * 95 / 100;
    }

    @Override
    public void intro() {
        System.out.println("Đây là sách FictionBook.");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
