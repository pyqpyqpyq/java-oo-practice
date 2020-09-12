public class User extends People{
    private String name;
    private int votes;
    public User(String name){
        this.name=name;
        this.votes=10;
    }
    public User(String name, int votes){
        this.name=name;
        this.votes=votes;
    }

    public String getName() {
        return name;
    }
}
