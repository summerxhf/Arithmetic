package jmh;
import thread.JMH.PS;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * Created by IntelliJ IDEA.
 * User: XINGHAIFANG
 * Date: 2020/6/19
 * Time: 18:12
 */
public class JMH_Test {
    @Benchmark
    public void testForEach(){
        PS.foreach();
    }
}
