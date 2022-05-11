import javax.print.attribute.PrintJobAttribute;
import java.util.Date;
import java.util.Calendar;
public class WayPoint
{
    private String time;
    private String latitude;
    private String longitude;
    private String depth;
    private String totalLog;
    private String rudder;
    private String pitch;
    private String roll;
    private String heading;
    private String STW;
    private String COG;
    private String SOG;
    private String TWD;
    private String TWA;
    private String TWS;
    private String AWA;
    private String AWS;
    private String AWSmax;
    private String waterTemperature;
    private String RPM1;
    private String engineHours1;
    private String coolantTemperature1;
    private String water1;
    private String water2;
    private String battery1;
    private String battery2;

    public WayPoint(String time1, String latitude1, String longitude1, String depth1, String totalLog1, String rudder1, String pitch1, String roll1, String heading1, String STW1, String COG1, String SOG1, String TWD1, String TWA1, String TWS1, String AWA1, String AWS1, String AWSmax1, String waterTemperature1, String RPM11, String engineHours11, String coolantTemperature11, String water11, String water21, String battery11, String battery21)
    {
        time = time1;
        latitude = latitude1;
        longitude = longitude1;
        depth = depth1;
        totalLog = totalLog1;
        rudder = rudder1;  
        pitch = pitch1;
        roll = roll1;
        heading = heading1;
        STW = STW1;
        COG = COG1;
        SOG = SOG1;
        TWD = TWD1;
        TWA = TWA1;
        TWS = TWS1;
        AWA = AWA1;
        AWS = AWS1;
        AWSmax = AWSmax1;
        waterTemperature = waterTemperature1;
        RPM1 = RPM11;
        engineHours1 = engineHours11;
        coolantTemperature1 = coolantTemperature11;
        water1 = water11;
        water2 = water21;
        battery1 = battery11;
        battery2 = battery21;

    }

   
    
}