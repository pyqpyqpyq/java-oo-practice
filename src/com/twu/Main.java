import java.util.*;



public class Main {
    static Map<String, User> userName2User = new HashMap<>();
    static Map<String, Admin> adminName2User = new HashMap<>();
    static Map<String, hot_search> hot_search_list = new HashMap<>();
    static People currentPeople = null;

    public static void main(String[] args) {
        init();
    }
    public static void init() {
        greet();
        Model_choose();
    }

    public static void greet() {
        System.out.println("欢迎来到热搜榜，你是？");
        System.out.println("1.用户");
        System.out.println("2.管理员");
        System.out.println("3.退出");
    }

    public static void Model_choose() {
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        if (user == 1) {
            User.switch_to_user();
        } else if (user == 2) {
            Admin.switch_to_admin();
        }
    }

}
