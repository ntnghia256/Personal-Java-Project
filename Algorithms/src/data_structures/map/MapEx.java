package data_structures.map;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        Map<Integer, String> employeeMap = new HashMap<>();

        // Add data
        employeeMap.put(1, "Java Developer");
        employeeMap.put(2, "Spring MVC");
        employeeMap.put(3, "Frontend Developer");

        // Get data
        String emp = employeeMap.get(2);
        System.out.println("Employee code 2 is: " + emp);

        // Overwrite data
        employeeMap.put(1, "Senior Developer");

        // Check if exists
        System.out.println("Co ID 1 ton tai khong? " + employeeMap.containsKey(1));
        System.out.println("Co ai ten 'Senior Developer'? " + employeeMap.containsValue("Senior Developer"));

        // Fetch map
        System.out.println("DANH SACH NHAN VIEN");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + "| Name: " + entry.getValue());
        }

        // Fast fetch by Lambda
        System.out.println("Fast fetch list employee");
        employeeMap.forEach((id, name) -> System.out.println("ID: " + id + "| Name: " + name));
    }
}
