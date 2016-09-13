package FileReaderandWriter;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by DELL on 2016/7/19.
 */
public class InputStreamTest {
    public static void main(String args[]){
        Employee[] stuff = new Employee[3];
        stuff[0] = new Employee("Carl",75000,1987,12,15);
        stuff[1] = new Employee("Harry",50000,1989,10,1);
        stuff[2] = new Employee("Tony",40000,1990,3,15);


        PrintWriter out = null;


//        out = new PrintWriter("Employee.dat","UTF-8");


        writeData(stuff,out);

    }

    private static void writeData(Employee[] employees,PrintWriter out){
        out.println(employees.length);

        for(Employee e : employees){
            writeEmployee(e,out);
        }
    }

    private static void writeEmployee(Employee employee,PrintWriter out){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(employee.getHireDay());

        out.println(employee.getName()+"|"+ employee.getSalary()+"|"+calendar.get(Calendar.YEAR)+"|"+
                (calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
    }


}
