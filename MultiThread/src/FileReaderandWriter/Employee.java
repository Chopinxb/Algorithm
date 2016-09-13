package FileReaderandWriter;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by DELL on 2016/7/19.
 */
public class Employee {

        private String name;
        private int salary;
        private Date hireDay;
        public Employee(String name,int salary,int year,int month,int day){
            this.name = name;
            this.salary = salary;
            this.hireDay = new GregorianCalendar(year,month-1,day).getTime();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public Date getHireDay() {
            return hireDay;
        }

        public void setHireDay(Date hireDay) {
            this.hireDay = hireDay;
        }
}
