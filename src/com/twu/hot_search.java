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

    public void setSuper() {
        if_super=true;
    }

    public void setTimes(int times) {
        this.times = times;
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
        if (people instanceof Admin) {
            Admin.Admin_choice(people);
        } else {
            User.User_choice(people);
        }
    }

    public static void vote_hot_search(User user) {
        System.out.println("请输入你要投票的热搜名称");
        Scanner input = new Scanner(System.in);
        String hot_search = input.nextLine();
        System.out.print("请输入你要投票的热搜票数：（你目前还有:");
        System.out.print(user.getVotes());
        System.out.println("票）");
        int votes = input.nextInt();
        if (user.getVotes()>=votes){
        user.setVotes(user.getVotes()-votes);
        Main.hot_search_list.get(hot_search).setTimes( Main.hot_search_list.get(hot_search).getTimes()+votes);}
        else{
            System.out.println("票数不足，投票失败。");
        }
        Admin.Admin_choice(user);

    }

    public static void buy_hot_search(People people) {
        System.out.println("请输入你要购买的的热搜事件的名字");
        Scanner input = new Scanner(System.in);
        String hot_search = input.nextLine();
        if (Main.hot_search_list.containsKey(hot_search)) {
            System.out.println("请输入你要购买的的热搜事件的排名");
            int ranking = input.nextInt();
            System.out.println("请输入你要购买的的热搜事件的金额");
            int money = input.nextInt();
        } else {
            System.out.println("热搜不存在。");
        }
        User.User_choice(people);
    }

    public static void add_hot_search(People people) {
        System.out.println("请输入你要添加的热搜事件的名字");
        Scanner input = new Scanner(System.in);
        String hot_search = input.nextLine();
        if (Main.hot_search_list.containsKey(hot_search)) {
            Main.hot_search_list.get(hot_search).addTimes();
        } else {
            hot_search hs = new hot_search(hot_search, 1);
            Main.hot_search_list.put(hs.getName(),hs);
        }
        if (people instanceof Admin) {
            Admin.Admin_choice(people);
        } else {
            User.User_choice(people);
        }


    }

    public static void add_super_hot_search(People people) {
        System.out.println("请输入你要添加的热搜事件的名字");
        Scanner input = new Scanner(System.in);
        String hot_search = input.nextLine();
        if (Main.hot_search_list.containsKey(hot_search)) {
            Main.hot_search_list.get(hot_search).setSuper();
        } else {
            hot_search hs = new hot_search(hot_search, 1);
            Main.hot_search_list.put(hs.getName(),hs);
        }
            Admin.Admin_choice(people);
    }
}
