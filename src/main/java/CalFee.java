import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;

public class CalFee {
    private String startingTime;
    private String endingTime;


    public CalFee(String startingTime, String endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public LocalDateTime StrToLocalDateTime(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = null;

        try {
            ldt = format.parse(str).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return ldt;
    }

    public long calculateTimeSpan() {
        LocalDateTime starttime = StrToLocalDateTime(startingTime);
        LocalDateTime endtime = StrToLocalDateTime(endingTime);
        Duration duration = Duration.between(starttime,endtime);
        Long time = duration.toMillis();
        Long minute = null;
        if(time > 0 && time / 1000 < 60 || time % 60000 > 0) {
            minute = duration.toMinutes() + 1;
        } else {
            minute = duration.toMinutes();
        }
        if(isDaylightTime(starttime,ZoneId.of("America/New_York")) && !isDaylightTime(endtime,ZoneId.of("America/New_York"))){
            minute += 60;
        } else if(!isDaylightTime(starttime,ZoneId.of("America/New_York")) && isDaylightTime(endtime,ZoneId.of("America/New_York"))) {
            minute -= 60;
        }
        return minute;
    }

    public boolean isDaylightTime(LocalDateTime localDateTime,ZoneId zoneId) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZoneRules rules = zoneId.getRules();
        return rules.isDaylightSavings(zonedDateTime.toInstant());
    }

    public String calculateFee(Long timelast) {
        double fee = 0;
        DecimalFormat df = new DecimalFormat("######0.00");
        if(timelast < 0 || timelast > 1800) {
            return "time error";
        }
        else if(timelast <= 20) {
            fee = 0.05*timelast;
        } else {
            fee = 1.00 + (timelast - 20)*0.1;
        }
        return df.format(fee);
    }

}
