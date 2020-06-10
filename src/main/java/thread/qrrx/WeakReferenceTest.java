package thread.qrrx;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.lang.ref.WeakReference;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/10
 * Time: 11:06
 * 弱引用;只要gc就会回收;
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        //只要遭遇垃圾回收就会被回收
        System.out.println(m.get());

        ThreadLocal<M> t1 =new ThreadLocal<>();
        t1.set(new M());
        System.out.println(t1.get());
        t1.remove();

    }
}
