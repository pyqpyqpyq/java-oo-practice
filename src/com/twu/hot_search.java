import java.util.*;
import java.util.stream.Collectors;

public class hot_search {

    private String name;
    private int times;
    private boolean if_super;

    public hot_search(String name, int times) {
        this.name = name;
        this.times = times;
        this.if_super = false;
    }

    public hot_search(String name, int times, boolean if_super) {
        this.name = name;
        this.times = times;
        this.if_super = if_super;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setIf_super(boolean if_super) {
        this.if_super = if_super;
    }

    public int getTimes() {
        return times;
    }

    public void addTimes() {
        times++;
    }

    public String getName() {
        return name;
    }

    public boolean isIf_super() {
        return if_super;
    }


    public static void show_hot_search(People people) {
//       show list
        Map<String, hot_search> hs = Main.hot_search_list;
        Set<Map.Entry<String, hot_search>> hsEntry = hs.entrySet();
        if (!hsEntry.isEmpty()) {
            List<hot_search> rankHs = hsEntry.stream()
                    .sorted((o1, o2) -> o2.getValue().getTimes() - o1.getValue().getTimes())
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
            for (hot_search item : rankHs) {
                System.out.print(item.getName());
                System.out.print("  ");
                System.out.println(item.getTimes());
            }
        }
        System.out.println("请输入您的昵称");
        Admin.Admin_choice(people);
    }

    public static void vote_hot_search(People people) {
        System.out.println(Main.hot_search_list);

    }

    public static void buy_hot_search(People people) {

    }

    public static void add_hot_search(People people) {
        System.out.println("请输入你要添加的热搜事件的名字");
        Scanner input = new Scanner(System.in);
        String hot_search = input.nextLine();
        if (Main.hot_search_list.containsKey(hot_search)) {
            Main.hot_search_list.get(hot_search).addTimes();
        } else {
            hot_search hs = new hot_search(hot_search, 1);
        }
        if (people instanceof Admin) {
            User.User_choice(people);
        } else {
            Admin.Admin_choice(people);
        }


    }

    public static void add_super_hot_search() {

    }
}
