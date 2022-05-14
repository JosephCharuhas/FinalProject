import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
public class BoatLog
{
	private final static String defaultOutputFileName = "output.gpx";

    public static void main(String[] args)
	{


		try
		{
			PrintWriter outputFile = new PrintWriter(new FileWriter(defaultOutputFileName));
			List<List<String> > data = new ArrayList<>();
			String filePath = "test.csv";//file path
			File file = new File(filePath); 
			Scanner s = new Scanner(file);			
			//run until out of lines
			if(s.hasNextLine())
			{
				s.nextLine();
			}
			System.out.println("Value in:");
			while(s.hasNextLine())
			{
				
				List<String> lineData = Arrays.asList(s.nextLine().split(","));
				System.out.println(lineData);
				data.add(lineData);
			}	
	
			//printing the fetched data
			String time = "";
			String latitude = "";
			String longitude = "";
			String depth = "";
			String totalLog = "";
			String rudder = "";
			String pitch = "";
			String roll = "";
			String heading = "";
			String STW = "";
			String COG = "";
			String SOG = "";
			String TWD = "";
			String TWA = "";
			String TWS = "";
			String AWA = "";
			String AWS = "";
			String AWSmax = "";
			String waterTemperature = "";
			String RPM1 = "";
			String engineHours1 = "";
			String coolantTemperature1 = "";
			String fuel = "";
			String water1 = "";
			String water2 = "";
			String battery1 = "";
			String battery2 = "";
			ArrayList<WayPoint> waypoints = new ArrayList<>(); 
			ArrayList<Track> trackPoints = new ArrayList<>();
			int i = 0; 
			
            for(List<String> list : data)
            {
                int c = 0;
                //int i = 0; // keeps resetting to 0
                System.out.println("Line: " + i);

                //if(i>5)
                if(i>0) // Start after the first line
                {

                for(String str : list) 
                {
                    //System.out.println("Working on: " + str);
                    //System.out.print(str + " ");

                        //System.out.println("c = " + c);
                        if(c == 0 || c == 1)
                        {
                            if(c == 0)
                            {
                                time = str;
                            }
                            else
                            {
                                time = time + ", " + str;
                            }
                            //System.out.println("Time = " + time);
                        }
                        else if(c == 2)
                        {
                            latitude = str;
                            System.out.println("Lat = " + latitude);
                        }
                        else if(c == 3)
                        {
                            longitude = str;
                            System.out.println("Lon = " + longitude);
                        }
                        else if(c == 4)
                        {
                            depth = str;
                            System.out.println("depth = " + depth);
                        }
                        else if(c == 5)
                        {
                            totalLog = str;
                            System.out.println("totalLog = " + totalLog);
                        }
                        else if(c == 6)
                        {
                            rudder = str;
                            System.out.println("rudder = " + rudder);
                        }
                        else if(c == 7)
                        {
                            pitch= str;
                        }
                        else if(c == 8)
                        {
                            roll = str;
                        }
                        else if(c == 9)
                        {
                            heading = str;
                        }
                        else if(c == 10)
                        {
                            STW = str;
                        }
                        else if(c == 11)
                        {
                            COG = str;
                        }
                        else if(c == 12)
                        {
                            SOG = str;
                        }
                        else if(c == 13)
                        {
                            TWD = str;
                        }
                        else if(c == 14)
                        {
                            TWA = str;
                        }
                        else if(c == 15)
                        {
                            TWS = str;
                        }
                        else if(c == 16)
                        {
                            AWA = str;
                        }
                        else if(c == 17)
                        {
                            AWS = str;
                        }
                        else if(c == 18)
                        {
                            AWSmax = str;
                        }
                        else if(c == 19)
                        {
                            waterTemperature = str;
                        }
                        else if(c == 20)
                        {
                            RPM1 = str;
                        }
                        else if(c == 21)
                        {
                            engineHours1 = str;
                        }
                        else if(c == 22) 
                        {
                            coolantTemperature1 = str;
                        }
                        else if(c == 23) 
                        {
                            fuel = str;
                        }
                        else if(c == 24)
                        {
                            water1 = str;
                        }
                        else if(c == 25)
                        {
                            water2 = str;
                        }
                        else if(c == 26)
                        {
                            battery1 = str;
                        }
                        else if(c == 27)
                        {
                            battery2 = str;
                            System.out.println("battery2 = " + battery2);
                        }
                        c++;
                    }
					
                    if(!time.equals(""))
                    {
                        WayPoint wayp = new WayPoint(time, latitude, longitude, depth, totalLog, rudder, pitch, roll, heading, STW, COG, SOG, TWD, TWA, TWS, AWA, AWS, AWSmax, waterTemperature, RPM1, engineHours1, coolantTemperature1, fuel, water1, water2, battery1, battery2);
                        waypoints.add(wayp);
                        Track trck = new Track(time, latitude, longitude, depth, totalLog, rudder, pitch, roll, heading, STW, COG, SOG, TWD, TWA, TWS, AWA, AWS, AWSmax, waterTemperature, RPM1, engineHours1, coolantTemperature1, fuel, water1, water2, battery1, battery2);
                        trackPoints.add(trck);
                    }
                }
                i++; // make sure i++ happens at the end of this loop

                    //System.out.println();
            }

			/*
			outputFile.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><gpx xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.1\" creator=\"Yacht Devices NMEA 0183 Wi-Fi Gateway - www.yachtd.com\" xmlns=\"http://www.topografix.com/GPX/1/1\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd\"><metadata><time>2021-07-25T19:31:00.000Z</time></metadata>");
			for(WayPoint waypnts: waypoints)
			{
				//Thread.sleep(1);
				outputFile.println();
				outputFile.println(waypnts);
				System.out.println(waypnts);
				outputFile.println(); 

			}
			outputFile.println("<trk><name>Track 1 - 7/25/2021 - 152</name><trkseg>");
			for(Track trckpnts: trackPoints)
			{
				//Thread.sleep(1);
				outputFile.println();
				outputFile.println(trckpnts);
				System.out.println(trckpnts);
				outputFile.println();

			}
			outputFile.println("</trkseg></trk></gpx>");
			*/outputFile.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}



	}
}
