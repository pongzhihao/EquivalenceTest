import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeTest_v2 {

//    @Test
//    void test1() {
//        CalFee calFee = new CalFee("2023-10-22 15:28:20","2023-10-26 10:30:59");
//        long time = calFee.calculateTimeSpan();
//       String fee = calFee.calculateFee(time);
//        assertEquals("时限范围不对",fee);
//    }


    @ParameterizedTest
    @CsvFileSource(resources = "/fee_juecebiao.csv")
    void test(String starttime,String endtime,String expected){
        CalFee calFee = new CalFee(starttime,endtime);
        long time = calFee.calculateTimeSpan();
        String fee = calFee.calculateFee(time);
        assertEquals(expected,fee);
    }
}
