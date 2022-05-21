import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class BoatLog 
{
    // default Output file used when testing 
	private final static String defaultOutputFileName = "output.gpx";
    private Trip[] trips;
    // all the waypoints / trackpoints in the trip(have essentially the same info but just have different headings)
    private static ArrayList<WayPoint> waypoints = new ArrayList<>(); 
    private static ArrayList<Track> trackPoints = new ArrayList<>();
    // the trip output file
    private static PrintWriter tripOutputFile;
    // creates a gpx file from the imported csv file takes in the start and end of the trip and 
    private static void createGPX(int start, int end, LocalDate dateName) throws IOException
    {
        // creates the name specific output name
        String outputfileName = "trip on " + dateName + ".gpx";
        // opens a new output file
        PrintWriter outputFile = new PrintWriter(new FileWriter(outputfileName));
        int count = 0;
        double startLog = 0;
        double endLog = 0;
        double log = 0;
        // Starts off the file with the correct heading 
        outputFile.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><gpx xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.1\" creator=\"Yacht Devices NMEA 0183 Wi-Fi Gateway - www.yachtd.com\" xmlns=\"http://www.topografix.com/GPX/1/1\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd\"><metadata><time>2021-07-25T19:31:00.000Z</time></metadata>");
        //print all of the waypoints to the output file
        for(int x = start; x <= end; x++)
		{
            count++;
            WayPoint waypnts = waypoints.get(x);
		    outputFile.println();
			outputFile.println(waypnts);
			outputFile.println();
            if(x==start)
            {
                startLog = waypnts.getTotalLog();
            }
            if(x==end)
            {
                endLog = waypnts.getTotalLog();
                log = startLog - endLog;
            }
		}
        // heading for trackpoints
		outputFile.println("<trk><name>Track 1 - " + dateName + " - 152</name><trkseg>");
        // print all of the trackpoints to the outputfile
		for(int x = start; x <= end; x++)
		{
			Track trckpnts = trackPoints.get(x);
			outputFile.println();
			outputFile.println(trckpnts);
			outputFile.println();
		}
        // close out the tackpoints and gpx file
		outputFile.println("</trkseg></trk></gpx>");
		outputFile.close();
        System.out.println("File created: " + outputfileName + " num of points: " + count);

        // Add entry to trip output file
        tripOutputFile.print("{\"name\": \"" + "Trip on " + dateName + "\",");
        tripOutputFile.print("\"gpxfile\": \"" + outputfileName + "\",");
        String logDistance = String.format("%.1f", log);
        tripOutputFile.print("\"distance\": \"" + logDistance + "\",");
        tripOutputFile.print("\"comments\": \"\",");
        tripOutputFile.print("\"crew\": \"\"}");
    }


    public static void main(String[] args)
	{
		try
		{   
            // opens up csv file and reads it in  
			List<List<String>> data = new ArrayList<>();
            //Scanner input = new Scanner(System.in);  // Create a Scanner object
            //System.out.println("Enter csv file name");
            //storing input file name as a trie
            //Trie inputName  = new Trie(input.nextLine());

			//String filePath = inputName.toString();
            String filePath ="test1.csv";
			File file = new File(filePath); 
			Scanner s = new Scanner(file);			
			// run until out of lines
			if(s.hasNextLine())
			{
				s.nextLine();
			}
			//System.out.println("Value in:");
            // the values in
			while(s.hasNextLine())
			{
				
				List<String> lineData = Arrays.asList(s.nextLine().split(","));
				//System.out.println(lineData);
				data.add(lineData);
			}	
	
			// printing the fetched data
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
			int i = 0; 
			// goes through and stores all of the 
            for(List<String> list : data)
            {
                int c = 0;
                // Start after the first line
                if(i>0) 
                {

                for(String str : list) 
                {
                    //System.out.println("Working on: " + str);
                    //System.out.print(str + " ");

                        //System.out.println("c = " + c);
                        if(c == 0 || c == 1)
                        {
                            //gets the time as a one string in stead of coming out as two(time comes in as date then time need it to be in one string for logic to work)
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
                            //System.out.println("Lat = " + latitude);
                        }
                        else if(c == 3)
                        {
                            longitude = str;
                            //System.out.println("Lon = " + longitude);
                        }
                        else if(c == 4)
                        {
                            depth = str;
                            //System.out.println("depth = " + depth);
                        }
                        else if(c == 5)
                        {
                            totalLog = str;
                            //System.out.println("totalLog = " + totalLog);
                        }
                        else if(c == 6)
                        {
                            rudder = str;
                            //System.out.println("rudder = " + rudder);
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
                            //System.out.println("battery2 = " + battery2);
                        }
                        c++;
                    }
					//creates waypoints and trackpoints from collected data
                    if(!time.equals(""))
                    {
                        WayPoint wayp = new WayPoint(time, latitude, longitude, depth, totalLog, rudder, pitch, roll, heading, STW, COG, SOG, TWD, TWA, TWS, AWA, AWS, AWSmax, waterTemperature, RPM1, engineHours1, coolantTemperature1, fuel, water1, water2, battery1, battery2);
                        waypoints.add(wayp);
                        Track trck = new Track(time, latitude, longitude, depth, totalLog, rudder, pitch, roll, heading, STW, COG, SOG, TWD, TWA, TWS, AWA, AWS, AWSmax, waterTemperature, RPM1, engineHours1, coolantTemperature1, fuel, water1, water2, battery1, battery2);
                        trackPoints.add(trck);
                    }
                }
                i++; 
            }
            System.out.println("num of points in input file: " + waypoints.size());

            // Create output file for list of trips
            String tipOutputfileName = "trips.js";
            tripOutputFile = new PrintWriter(new FileWriter(tipOutputfileName));
            tripOutputFile.print("data = '[");


            //loop through and look at dates to identify trips
            LocalDate prevDate = null;
            int start = 0;
            int count = 0;
            for(WayPoint waypnt: waypoints)
			{
                //use Java's chrono Units class to compare dates in order to create trips
                LocalDate curDate = waypnt.getConvertedDate();
                if(prevDate != null)
                {
                    long daysBtwn = ChronoUnit.DAYS.between(curDate, prevDate);
                    if(daysBtwn > 2)
                    {
                        // time to start a new trip
                        // create a gpx file from index start to index count - 1
                        createGPX(start, count-1, prevDate);

                        // Add comma to trip outputfile
                        tripOutputFile.print(",");

                        // set new start
                        start = count;
                        //System.out.println("prevDate: " + prevDate + " curDate: " + curDate);
                        //System.out.println("DaysBtwn: " + daysBtwn);
                    }
                }
                count++;
                prevDate = curDate;
            }
            if(start<count)
            {
               createGPX(start, count-1, prevDate);
            }
			
            //close files
            tripOutputFile.println("]';");
            tripOutputFile.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
