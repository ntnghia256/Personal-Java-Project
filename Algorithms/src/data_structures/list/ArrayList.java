package data_structures.list;

import java.util.List;

public class ArrayList {
    /*
    - **Ưu điểm:** **Truy cập phần tử qua `get(index)` c**ực nhanh (độ phức tạp $O(1)$).
    - **Nhược điểm:** Thêm hoặc xóa ở giữa danh sách bị chậm vì Java phải dịch chuyển hàng loạt phần tử phía sau.
    - **Khi nào dùng:** Khi bạn cần **duyệt dữ liệu hoặc đọc dữ liệu** nhiều hơn là thay đổi cấu trúc danh sách.
     */
    public static void main(String[] args) {
        List<String> userList = new java.util.ArrayList<>();

        // Add data
        userList.add("Nguyen Van A");
        userList.add("Tran Thi B");
        userList.add("Nguyen Van A");

        // Insert
        userList.add(1, "Le Van C");

        // Get
        String firstUser = userList.get(0);
        System.out.println("User đầu tiên: " + firstUser);

        // Update
        userList.set(2, "Hoang Van D");

        userList.remove(1); // Delete by index
        userList.remove("Nguyen Van A"); // Delete by object (xóa cái đầu tiên nó tìm thấy)

        System.out.println("Số lượng User: " + userList.size());
        System.out.println("Có Tran Thi B không? " + userList.contains("Tran Thi B"));

        System.out.println("--- Danh sách User cuối cùng ---");
        userList.forEach(System.out::println);
    }
}
