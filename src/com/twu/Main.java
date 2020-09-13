import java.util.*;



public class Main {
    static Map<String, User> userName2User = new HashMap<>();
    static Map<String, Admin> adminName2User = new HashMap<>();
    static Map<String, hot_search> hot_search_list = new HashMap<>();
    static Map<Integer, hot_search> rank_money = new HashMap<>();
    static People currentPeople;
    static boolean if_admin;

    public static void main(String[] args) {
        init();
    }
    public static void init() {
        greet();
        Model_choose();
        currentPeople = null;
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
            if_admin=false;
            User.switch_to_user();
        } else if (user == 2) {
            if_admin=true;
            Admin.switch_to_admin();
        }
    }

}
