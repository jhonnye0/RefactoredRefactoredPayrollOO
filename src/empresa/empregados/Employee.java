package empresa.empregados;

public abstract class Employee {

    private int id;
    private int unionID;
    private String name;
    private String adress;
    private double fundo;

    public abstract Employee makeCopy();

    public abstract double calcSalary();

    public abstract void registerSale();

    public abstract void registerPoint();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnionID() {
        return unionID;
    }

    public void setUnionID(int unionID) {
        this.unionID = unionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getFundo() {
        return fundo;
    }

    public void setFundo(double fundo) {
        this.fundo = fundo;
    }
}