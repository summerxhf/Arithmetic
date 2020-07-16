package JVM.jmm;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/7/16
 * Time: 10:43
 */
//关闭TLAB 时间边长 -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
public class TestTLAB {
    class User{
        int id;
        String name;

        public User(int id,String name){
            this.id = id;
            this.name = name;
        }
    }

    void alloc(int i){
        new User(i,"name " + i);
    }

    public static void main(String[] args) {
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
