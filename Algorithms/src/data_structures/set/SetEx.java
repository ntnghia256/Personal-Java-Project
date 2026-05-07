package data_structures.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
    /*
    - **Không trùng lặp (No Duplicates):** Nếu bạn thêm một phần tử đã tồn tại, `Set` sẽ từ chối phần tử đó (không báo lỗi nhưng không thêm vào).
    - **Không truy cập qua Index:** Vì một số loại `Set` không duy trì thứ tự, bạn không thể dùng `set.get(5)` như `List`. Bạn phải dùng vòng lặp hoặc `Iterator`.
     */
    public static void main(String[] args) {
        // 1. HashSet: Không thứ tự, tốc độ cao
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");
        roles.add("EDITOR");
        roles.add("ADMIN"); // Thử thêm trùng lặp

        System.out.println("HashSet (Không thứ tự): " + roles);
        // Kết quả: [EDITOR, USER, ADMIN] (thứ tự ngẫu nhiên)

        // 2. TreeSet: Tự động sắp xếp
        Set<Integer> scores = new TreeSet<>();
        scores.add(85);
        scores.add(10);
        scores.add(50);

        System.out.println("TreeSet (Đã sắp xếp): " + scores);
        // Kết quả: [10, 50, 85]

        // 3. Kiểm tra sự tồn tại (Cực nhanh với Set)
        if (roles.contains("ADMIN")) {
            System.out.println("Người dùng có quyền ADMIN");
        }
    }
}
