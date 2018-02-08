package books.effective_java.ch3.item12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComparableTest {
    private ComparableTest(){}

    public static void main(String[] args) {
        List<EmployeeComparableExample> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeComparableExample("john", 20, "CTO"));
        employeeList.add(new EmployeeComparableExample("john", 21, "CTO"));
        employeeList.add(new EmployeeComparableExample("john", 20, "CEO"));
        employeeList.add(new EmployeeComparableExample("john", 22, "CEO"));
        employeeList.add(new EmployeeComparableExample("mary", 20, "CSO"));
        employeeList.add(new EmployeeComparableExample("mary", 30, "CTO"));
        employeeList.add(new EmployeeComparableExample("mary", 20, "CBO"));
        employeeList.add(new EmployeeComparableExample("sean", 15, "CMO"));
        employeeList.add(new EmployeeComparableExample("ann", 48, "COO"));

        Collections.sort(employeeList);
        String sortedList = employeeList.stream()
                .map(EmployeeComparableExample::toString).collect(Collectors.joining(System.lineSeparator()));
        System.out.println("sorted : \r\n" + sortedList);

        Collections.reverse(employeeList);
        String reverseList = employeeList.stream()
                .map(EmployeeComparableExample::toString).collect(Collectors.joining(System.lineSeparator()));
        System.out.println("reverse : \r\n" + reverseList);


    }
}
