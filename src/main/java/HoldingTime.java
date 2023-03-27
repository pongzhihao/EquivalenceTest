import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HoldingTime {
    private String startingTime;
    private String endingTime;
    private long minute;
    public Date startT;
    public Date endT;
    public  HoldingTime(String startingTime,String endingTime){
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.startT = StrToDate(this.startingTime);
        this.endT = StrToDate(this.endingTime);
    }

    public Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public String DateFormate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sdate = format.format(date);
        return sdate;
    }
    public long getHoldingTime(){
        long between;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startT);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endT);

        between = cal2.getTime().getTime()-cal1.getTime().getTime();
        if(between<0)
            minute =( (cal2.getTime().getTime()-cal1.getTime().getTime())/1000)/60;
        else
            minute = (between/1000+59)/60;

        if((cal1.get(Calendar.MONTH) ==Calendar.MARCH  && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY))
        {

            if(cal1.get(Calendar.HOUR_OF_DAY)<2 && cal2.get(Calendar.HOUR_OF_DAY)>=3)
                minute -=60;
        }else{
            if((cal2.get(Calendar.MONTH) ==3 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY))

            {
                if(cal2.get(Calendar.HOUR_OF_DAY)>3 )
                    minute -=60;
            }
        }

        if(cal1.get(Calendar.MONTH) ==Calendar.NOVEMBER && cal1.get(Calendar.DATE) >= 1 && cal1.get(Calendar.DATE) <= 8 && cal1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
        {
            if(cal1.get(Calendar.HOUR_OF_DAY) ==2){
                minute +=60;
            }
        }else{
            if(cal2.get(Calendar.MONTH) ==Calendar.NOVEMBER && cal2.get(Calendar.DATE) >= 1 && cal2.get(Calendar.DATE) <= 8 && cal2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
            {
                if(cal2.get(Calendar.HOUR_OF_DAY)==2)
                {
                    minute +=60;
                }
            }
        }
        if(minute>1800 || minute <0){
            return -1;
        }else{

            return minute;
        }
    }
}