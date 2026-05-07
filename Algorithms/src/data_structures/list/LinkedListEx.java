package data_structures.list;

import java.util.LinkedList;

public class LinkedListEx {
    /*
    - **Ưu điểm:** Thêm hoặc xóa ở đầu/cuối cực nhanh vì chỉ cần thay đổi địa chỉ trỏ (độ phức tạp $O(1)$).
    - **Nhược điểm:** Truy cập `get(index)` chậm vì Java phải chạy từ đầu danh sách để đếm (độ phức tạp $O(n)$).
    - **Khi nào dùng:** Khi ứng dụng của bạn **thường xuyên phải thêm/xóa dữ liệu ở hai đầu** (ví dụ làm hàng đợi Queue).
     */
    public static void main(String[] args) {
        // Lưu ý: Ta có thể dùng kiểu biến là Deque hoặc Queue nếu muốn dùng như hàng đợi
        LinkedList<String> history = new LinkedList<>();

        // 1. Add element into end
        history.add("google.com");
        history.add("facebook.com");

        // 2. Add element to first (O(1))
        history.addFirst("github.com");

        // 3. Thêm vào CUỐI danh sách
        history.addLast("stackoverflow.com");

        System.out.println("Lịch sử hiện tại: " + history);

        // 4. Get first and last element but not delete
        System.out.println("Trang web đầu tiên: " + history.getFirst());
        System.out.println("Trang web cuối cùng: " + history.getLast());

        // 5. Handle like (Queue) - Get and delete
        String polledPage = history.pollFirst();
        System.out.println("Đã đóng trang: " + polledPage);
        System.out.println("List: " + history);

        // 6. Fetch reverse list
        System.out.println("--- Duyệt ngược lịch sử ---");
        var iterator = history.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
