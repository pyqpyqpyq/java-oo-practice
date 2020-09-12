public class hotsearch {

    private String name;
    private int times;
    private boolean if_super;

    public hotsearch(String name, int times) {
        this.name=name;
        this.times=times;
        this.if_super=false;
    }

    public hotsearch(String name, int times, boolean if_super) {
        this.name=name;
        this.times=times;
        this.if_super=if_super;
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
}
