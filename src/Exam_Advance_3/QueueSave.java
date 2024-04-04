package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class QueueSave {
    public static void main(String[] args) {
        Queue<String> customerQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên khách hàng chờ mua vé xem phim");
            System.out.println("2. Khách tiếp theo");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên khách hàng chờ mua vé: ");
                    String customerName = scanner.nextLine();
                    customerQueue.add(customerName);
                    System.out.println("Đã thêm '" + customerName + "' vào hàng chờ.");
                    break;
                case 2:
                    if (!customerQueue.isEmpty()) {
                        String nextCustomer = customerQueue.poll();
                        System.out.println("Khách tiếp theo: " + nextCustomer);
                    } else {
                        System.out.println("Không có khách hàng nào trong hàng chờ.");
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
