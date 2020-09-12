public class Admin extends People{
    private String name;
    private String pwd;
    public Admin(String name, String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }
}
