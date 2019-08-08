package builder.employeeBuilder;

import empresa.empregados.*;
import empresa.empregados.comission.Comissioned;
import empresa.empregados.point.Hourly;
import empresa.sindicato.Union;
import facade.ExceptionCatch;
import java.util.*;

public class EmployeeEngineer {

    private EmployeeBuilder employeeBuilder;
    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();

    public EmployeeEngineer(EmployeeBuilder builder) {
        employeeBuilder = builder;
    }

    public void construct(ArrayList< Union > union, int total) {
        employeeBuilder.buildName();
        employeeBuilder.buildAdress();
        employeeBuilder.buildPMethod();
        employeeBuilder.buildSalary();
        employeeBuilder.buildSchedule();
        employeeBuilder.buildId(total);
        this.employeeBuilder.getEmployee().setUnionID(-1);
        employeeBuilder.buildUnion(union);

        System.out.println("\nEmpregado resgitrado com sucesso:\n" +
                "ID: " + this.employeeBuilder.getEmployee().getId());
        if(this.employeeBuilder.getEmployee().getUnionID() != -1){
            System.out.print("Union ID: " + this.employeeBuilder.getEmployee().getUnionID());
        }
    }

    public void update(ArrayList<Employee> list, ArrayList<Union> union, int id, int operation){

        if(list.get(id) instanceof Hourly){
            employeeBuilder = new HourlyBuilder();
        }else if(list.get(id) instanceof Comissioned){
            employeeBuilder = new ComissionedBuilder();
        }else {
            employeeBuilder = new SalariedBuilder();
        }

        employeeBuilder.setEmployee(list.get(id));

        switch (operation){
            case 1:
                employeeBuilder.buildName();
                System.out.println("Atualizado.\n");
                break;
            case 2:
                employeeBuilder.buildAdress();
                System.out.println("Atualizado.\n");
                break;
            case 3:
                Employee x = employeeBuilder.getEmployee();

                System.out.print("Tipo de empregado: (Digite o número)\n" +
                        "1. Horista\n" +
                        "2. Comissionado\n" +
                        "3. Assalariado\n");

                int type = except.numcheckException(1,3);

                if(type == 1){
                    employeeBuilder = (new HourlyBuilder());
                }else if(type == 2){
                    employeeBuilder = (new ComissionedBuilder());
                }else{
                    employeeBuilder = (new SalariedBuilder());
                }

                employeeBuilder.getEmployee().setName(x.getName());
                employeeBuilder.getEmployee().setAdress(x.getAdress());
                employeeBuilder.getEmployee().setPaymentMethod(x.getPaymentMethod());
                employeeBuilder.getEmployee().setId(x.getId());
                employeeBuilder.getEmployee().setUnionID(x.getUnionID());
                employeeBuilder.getEmployee().setFundo(x.getFundo());
                employeeBuilder.getEmployee().setSchedule(x.getSchedule());
                employeeBuilder.buildSalary();

                System.out.println("Atualizado.\n");
                break;
            case 4:
                employeeBuilder.buildPMethod();
                System.out.println("Atualizado.\n");
                break;
            case 5:
                employeeBuilder.buildUnion(union);
                System.out.println("Atualizado.\n");
                break;
            default:
                break;
        }

    }

    public void updateType(int id, ArrayList<Employee> list){

        System.out.print("Tipo de empregado: (Digite o número)\n" +
                "1. Horista\n" +
                "2. Comissionado\n" +
                "3. Assalariado\n");
        int type = except.numcheckException(1,3);

        if(type == 1){
            employeeBuilder = new HourlyBuilder();
        }else if(type == 2){
            employeeBuilder = new ComissionedBuilder();
        }else {
            employeeBuilder = new SalariedBuilder();
        }

        employeeBuilder.buildSalary();
    }

    public Employee getEmployee(){
        return this.employeeBuilder.getEmployee();
    }

}
