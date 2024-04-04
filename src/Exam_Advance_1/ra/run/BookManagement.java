package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.businessImp.Author;
import Exam_Advance_1.ra.businessImp.Book;

import java.util.*;

import static Exam_Advance_1.ra.businessImp.Author.authorList;
public class BookManagement {
    static List<Book> bookList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập số tác giả và nhập thông tin các tác giả");
            System.out.println("2. Nhập số sách và nhập thông tin các sách");
            System.out.println("3. Sắp xếp sách theo giá xuất sách tăng dần ");
            System.out.println("4. Tìm kiếm sách theo tên tác giả sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputAuthors(scanner);
                    break;
                case 2:
                    inputBooks(scanner);
                    break;
                case 3:
                    sortBooksByExportPrice();
                    break;
                case 4:
                    searchBooksByAuthorName(scanner);
                    break;
                case 5:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 5);

    }

    //Nhập số tác giả và nhập thông tin các tác giả
    public static void inputAuthors(Scanner scanner){
        System.out.print("Nhập số tác giả: ");
        int numAuthors = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numAuthors; i++) {
            System.out.println("Nhập thông tin tác giả thứ "+(i+1)+" : ");
            Author author = new Author();
            author.inputData(scanner);
            authorList.add(author);
        }

    }

    //Nhập số sách và nhập thông tin các sách
    public static void inputBooks(Scanner scanner){
        System.out.print("Nhập số lượng sách muốn nhập thông tin: ");
        int numBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Nhập thông tin cuốn sách thứ "+(i+1)+" : ");
            Book book = new Book();
            book.inputData(scanner);
            bookList.add(book);
        }
    }

    //Sắp xếp sách theo giá xuất sách tăng dần
    public static void sortBooksByExportPrice() {
        bookList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Float.compare(o1.getExportPrice(), o2.getExportPrice());
            }
        });
        System.out.println("Danh sách sách sau khi sắp xếp:");
        for (Book book : bookList) {
            book.displayData();
        }
    }

    //Tìm kiếm sách theo tên tác giả sách
    public static void searchBooksByAuthorName(Scanner scanner) {
        System.out.print("Nhập tên tác giả cần tìm sách: ");
        String inputName = scanner.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getAuthor().getAuthorName().equalsIgnoreCase(inputName)) {
                book.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách của tác giả có tên là '" + inputName + "'.");
        }
    }

}
