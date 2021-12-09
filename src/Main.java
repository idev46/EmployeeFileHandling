import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main {
    private static final String FILE_NAME = "empData.txt";

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        int input;
        final String INPUT_MESSAGE = "Please Enter"
                + "\n1 for 'Add new Employee'"
                + "\n2 for 'Search in Employee'"
                + "\n3 for 'Exit '";
        do {
            String tempInput = JOptionPane.showInputDialog(INPUT_MESSAGE);
            input = Integer.parseInt(tempInput);

            if (input == 1) {
                addEmployee();
            } else if (input == 2) {
                String eId = JOptionPane.showInputDialog("Enter Id to search");
                searchEmployeeById(eId);
            } else if (input == 3) {
                JOptionPane.showMessageDialog(null, "GoodBye.");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "You've selected an invalid input");
            }

        } while (true);
    }

    public static void searchEmployeeById(String inputId) {

        try {
            String[] tokens;

            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            ArrayList<Employee> employeesList = new ArrayList<>();

            while (line != null) {
                tokens = line.split(",");

                Employee employee = new Employee();

                employee.setEmpId(tokens[0]);
                employee.setEmpName(tokens[1]);
                employee.setEmpDoB(tokens[2]);
                employee.setEmpQualf(tokens[3]);
                employee.setEmpExp(tokens[4]);
                employee.setEmpPScale(tokens[5]);

                employeesList.add(employee);
                line = br.readLine();

            }
            br.close();
            fr.close();

            if (employeesList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "File is empty");
                return;
            }

            boolean isFound = false;
            for (Employee employee : employeesList) {
                if (inputId.equals(employee.getEmpId())) {
                    JOptionPane.showMessageDialog(null, "Employee Details "
                            + " \n Id: " + employee.getEmpId()
                            + " \n Name: " + employee.getEmpName()
                            + " \n DOB: " + employee.getEmpDoB()
                            + " \n Qualification : " + employee.getEmpQualf()
                            + " \n Experience : " + employee.getEmpExp()
                            + " \n DOB : " + employee.getEmpPScale()
                    );
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                JOptionPane.showMessageDialog(null, "Employee not found.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void addEmployee() {
        try {
            Employee employee = new Employee();

            employee.setEmpId(JOptionPane.showInputDialog("Enter Id:"));
            employee.setEmpName(JOptionPane.showInputDialog("Enter Name:"));
            employee.setEmpDoB(JOptionPane.showInputDialog("Enter DOB(year): "));
            employee.setEmpQualf(JOptionPane.showInputDialog("Enter Qualification:"));
            employee.setEmpExp(JOptionPane.showInputDialog("Enter Employee Experience (in months): "));
            employee.setEmpPScale(JOptionPane.showInputDialog("Enter Employee Pay Scale (in number): "));

            FileWriter fw = new FileWriter(FILE_NAME, true);
            PrintWriter pw = new PrintWriter(fw);


            String line = employee.getEmpId() + ","
                    + employee.getEmpName() + ","
                    + employee.getEmpDoB() + ","
                    + employee.getEmpQualf() + ","
                    + employee.getEmpExp() + ","
                    + employee.getEmpPScale();
            pw.println(line);

            pw.flush();
            pw.close();
            fw.close();

            JOptionPane.showMessageDialog(null, "Employee is added.");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

}