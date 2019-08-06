package facade;

import builder.EmployeeEngineer;
import builder.HourlyBuilder;
import empresa.empregados.Employee;
import empresa.empregados.Hourly;
import empresa.sindicato.Union;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    static Scanner input = new Scanner(System.in);
    ExceptionCatch except = new ExceptionCatch();


    public void add(ArrayList<Employee> list, ArrayList<Union> union, int id, int total){

        EmployeeEngineer employeeEngineer;

        System.out.print("Tipo de empregado: (Digite o número)\n" +
                "1. Horista\n" +
                "2. Comissionado\n" +
                "3. Assalariado\n");

        int type = except.numcheckException(1,3);

        if(type == 1){
            HourlyBuilder hourlyBuilder = new HourlyBuilder();
            employeeEngineer = new EmployeeEngineer(hourlyBuilder);
        }else if(type == 2){

        }else{

        }
    }

    public void remove(ArrayList<Employee> list, ArrayList<Union> union, int id, int total) {

        if(union.get(id).isUnion()) {
            union.get(id).setUnion(false); // unionID
            union.get(id).setUnionTax(0);
        }
        list.remove(id);
        System.out.println("Empregado removido com sucesso..");
    }
}
