package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class StackHistory {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập URL muốn truy cập");
            System.out.println("2. Quay lại");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập URL muốn truy cập: ");
                    String url = scanner.nextLine();
                    history.push(url);
                    break;
                case 2:
                    if (!history.isEmpty()) {
                        System.out.println("URL trên cùng của stack: " + history.pop());
                        if (!history.isEmpty()) {
                            System.out.println("URL tiếp theo: " + history.peek());
                        } else {
                            System.out.println("Không có URL tiếp theo.");
                        }
                    } else {
                        System.out.println("Lịch sử trống.");
                    }
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 3);
    }
}
