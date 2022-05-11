import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
public class BoatLog
{
	private double[] path;

    public static void main(String[] args)
	{
		try
		{
			List<List<String> > data = new ArrayList<>();//list of lists to store data
			String filePath = "test.csv";//file path
			File file = new File(filePath); 
			Scanner s = new Scanner(file);			
			//run until out of lines
			while(s.hasNextLine())
			{
				List<String> lineData = Arrays.asList(s.nextLine().split(","));//splitting lines
				data.add(lineData);
			}	
	
			//printing the fetched data
			String time;
			String latitude;
			String longitude;
			String depth;
			String totalLog;
			String rudder;
			String pitch;
			String roll;
			String heading;
			String STW;
			String COG;
			String SOG;
			String TWD;
			String TWA;
			String TWS;
			String AWA;
			String AWS;
			String AWSmax;
			String waterTemperature;
			String RPM1;
			String engineHours1;
			String coolantTemperature1;
			String water1;
			String water2;
			String battery1;
			String battery2;
			ArrayList<WayPoint> waypoints = new ArrayList<>(); 
			for(List<String> list : data)
			{
				int c = 0;
				for(String str : list) 
				{
					System.out.print(str + " ");
					if(!str.contains("Time"))
					{
						switch(c) 
						{
							case 0:
								time = str;
							case 1:
								latitude = str;
							case 2:
								longitude = str;
							case 3:
								depth = str;
							case 4:
								totalLog = str;
							case 5:
								rudder = str;
							case 6:
								pitch= str;
							case 7: 
								roll = str;
							case 8:
								heading = str;
							case 9:
								STW = str;
							case 10:
								COG = str;
							case 11:
								SOG = str;
							case 12:
								TWD = str;
							case 13:
								TWA = str;
							case 14:
								TWS = str;
							case 15:
								AWA = str;
							case 16:
								AWS = str;
							case 17:
								AWSmax = str;
							case 18:
								waterTemperature = str;
							case 19:
								RPM1 = str;
							case 20:
								engineHours1 = str;
							case 21:
								coolantTemperature1 = str;
							case 22:
								water1 = str;
							case 23:
								water2 = str;
							case 24:
								battery1 = str;
							case 25:
								battery2 = str;

							default :
							   System.out.println("something is broken");
						 }
						
						
						c++;
					}
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					WayPoint wayp = new WayPoint(time, latitude, longitude, depth, totalLog, rudder, pitch, roll, heading, STW, COG, SOG, TWD, TWA, TWS, AWA, AWS, AWSmax, waterTemperature, RPM1, engineHours1, coolantTemperature1, water1, water2, battery1, battery2)
					
				}
					System.out.println();
			}
			s.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
