package DS.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetTest {
    public Map<Integer, List<Employee>> map = new HashMap<>();
    public void addNewSubordinate(Employee manager, Employee subordinate){
        List<Employee> empList = new ArrayList<>();
        empList.add(subordinate);
        if(map.containsKey(manager.managerId)){
            List<Employee> existingEmpList = map.get(manager.managerId);
            empList.addAll(existingEmpList);
        }
        map.put(manager.managerId, empList);
    }

    public static class Employee{
        public int id;
        public String name;
        public String department;
        public int managerId;

        public Employee(int id, String name, String department, int managerId) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.managerId = managerId;
        }


    }
}
