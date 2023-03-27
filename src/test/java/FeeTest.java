import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeTest {
    @Test
    void test1() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230102000000","20230101000000");
        assertEquals("时间错误，时限范围不对！",fee);
    }
    @Test
    void test2() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230326031050","20230326013030");
        assertEquals("时间错误，时限范围不对！",fee);
    }
    @Test
    void test3() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20231105025830","20231105014059");
        assertEquals("时间错误，时限范围不对！",fee);
    }
    @Test
    void test4() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230303201501","20230303201530");
        assertEquals("0.05",fee);
    }
    @Test
    void test5() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230326015959","20230326030030");
        assertEquals("0.05",fee);
    }
    @Test
    void test6() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20231105025959","20231105020030");
        assertEquals("0.05",fee);
    }
    @Test
    void test7() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230303121500","20230303122530");
        assertEquals("0.55",fee);
    }
    @Test
    void test8() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230326015559","20230326031530");
        assertEquals("1.00",fee);
    }
    @Test
    void test9() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20231105025959","20231105021030");
        assertEquals("0.55",fee);
    }
    @Test
    void test10() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230404050505","20230404151515");
        assertEquals("60.10",fee);
    }
    @Test
    void test11() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230326000000","20230326050000");
        assertEquals("23.00",fee);
    }
    @Test
    void test12() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20231105025950","20231105040000");
        assertEquals("11.10",fee);
    }
    @Test
    void test13() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230303030303","20230304232303");
        assertEquals("时间错误，时限范围不对！",fee);
    }
    @Test
    void test14() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20230326000000","20230330000000");
        assertEquals("时间错误，时限范围不对！",fee);
    }
    @Test
    void test15() {
        TelFee telFee = new TelFee();
        String fee = telFee.get_telFee("20231105000000","20231106222222");
        assertEquals("时间错误，时限范围不对！",fee);
    }
}
