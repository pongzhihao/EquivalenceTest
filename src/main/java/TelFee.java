import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class TelFee {
    public String get_telFee(String sd1,String sd2) {
        double telFee;
        HoldingTime holdingTime = new HoldingTime(sd1,sd2);
        DecimalFormat df = new DecimalFormat("######0.00");
        long minute = holdingTime.getHoldingTime();
        if(minute == -1) {
            return "时间错误，时限范围不对！";
        }
        else if(minute <= 20) {
            telFee = 0.05*minute;
        } else {
            telFee = 1.00 + (minute - 20)*0.1;
        }
        return df.format(telFee);
    }

}  