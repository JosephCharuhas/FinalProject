public class Track 
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
    private String fuel;
    private String water1;
    private String water2;
    private String battery1;
    private String battery2;

    public Track(String time1, String latitude1, String longitude1, String depth1, String totalLog1, String rudder1, String pitch1, String roll1, String heading1, String STW1, String COG1, String SOG1, String TWD1, String TWA1, String TWS1, String AWA1, String AWS1, String AWSmax1, String waterTemperature1, String RPM11, String engineHours11, String coolantTemperature11, String fuel1, String water11, String water21, String battery11, String battery21)
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
        fuel = fuel1;
        water1 = water11;
        water2 = water21;
        battery1 = battery11;
        battery2 = battery21;

    }


    public String toString() 
    {
        String str;
        str = "<trkpt lat=\"" + latitude + "\" lon=\"" + longitude + "\"><name>" + time + "</name><ele>-2.51</ele><cmt>\n";
        str += "Depth: " + depth + " ft\n";
        str += "Total Log: " + totalLog + " nm\n";
        str += "Rudder: " + rudder + "°\n";
        str += "Roll / Pitch: " + roll + " / " + pitch + "\n";
        str += "Heading / STW: " + heading + " / " + STW + " knots\n";
        str += "COG / SOG: " + COG + "° / " + SOG + " knots\n";
        str += "TWD:" + TWD + "°\n";
        str += "AWA / AWS: " + AWA + "° / " + AWS + " knots\n";
        str += "AWS (max): " + AWSmax + " knots\n";
        str += "Water Temperature: " + waterTemperature + "°C\n";
        str += "RPM: " + RPM1 + "\n";
        str += "Engine hours: " + engineHours1 + "\n";
        str += "Coolant Temp.: " + coolantTemperature1 + "°C\n";
        str += "Fuel #1: " + fuel + "%\n";
        str += "Water, %: " + water1 + " / " + water2 + "\n";         
        str += "</cmt></trkpt>";
        return (str);
    }    
}
