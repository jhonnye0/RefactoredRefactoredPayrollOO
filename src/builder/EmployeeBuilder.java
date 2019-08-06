package builder;

import empresa.empregados.Employee;
import empresa.sindicato.Union;
import java.util.ArrayList;

public interface EmployeeBuilder {

    void buildId(int total);

    void buildName();

    void buildSchedule();

    void buildSalary();

    void buildUnion(ArrayList<Union> union);

    void buildAdress();

    void buildPMethod();

    Employee getEmployee();

}
