package Exam_Advance_1.ra.businessImp;

import Exam_Advance_1.ra.business.IShop;

import java.util.List;
import java.util.Scanner;
import static Exam_Advance_1.ra.businessImp.Author.authorList;
public class Book implements IShop {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {

    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã sách:");
        this.bookId = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập tên sách:");
        this.bookName = scanner.nextLine();

        System.out.println("Nhập tiêu đề sách:");
        this.title = scanner.nextLine();

        System.out.println("Nhập số trang sách:");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập giá nhập sách:");
        this.importPrice = Float.parseFloat(scanner.nextLine());

        System.out.println("Nhập số lượng sách:");
        this.quantity = Integer.parseInt(scanner.nextLine());

        this.author = getInputAuthor(scanner);

        this.exportPrice = this.importPrice * IShop.RATE;

        System.out.println("Nhập trạng thái (true/false):");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    @Override
    public void displayData() {
        System.out.println("Thông tin sách:");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tên tác giả: " + author.getAuthorName());
        System.out.println("Giá bán sách: " + exportPrice);
        System.out.println("Số lượng sách: " + quantity);
        System.out.println("Trạng thái: " + (bookStatus ? "Còn hàng" : "Hết hàng"));
    }
    private Author getInputAuthor(Scanner scanner){
        System.out.println("Danh sach tác giả");
        for (int i = 0; i < authorList.size(); i++) {
            System.out.printf("| STT : %d | Name : %-15s |\n",i+1,authorList.get(i).getAuthorName());
        }
        while (true){
            System.out.println("Nhập vào tác giả của cuốn sách (theo STT)");
            int index = Integer.parseInt(scanner.nextLine());
            if (index>=1 && index<= authorList.size()){
                return authorList.get(index-1);
            }
            System.err.println("Vi tri nhap khong hơp lẹ, vui lòng chọn lại");
        }
    }
}
