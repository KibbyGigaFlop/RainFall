import javax.swing.JOptionPane;//for displaying and taking user input
/**

Timothy Bain
COSC220
11/29/18

The purpose of this program is to take user input and calculate
the yearly rainfall, what month had the most and least amount of rainfall,
and the average of the rainfall yearly.
*/

public class RainFall{ //class header

  public static void main(String[] args){//main method
  
  final int MONTH_NUM = 12;//month limit
  String[] months = {"January", "February", "March", "April",
  "May", "June", "July", "August", "September", "October", "November", "December"}; //month names
  double[] rainfallData = new double[MONTH_NUM];//array that holds the rainfall data
  
  calculations(months, rainfallData); //passes the months and rainfallData array to calculations
  GreaterandLeast(rainfallData, months); //passes the rainfallData and month array to GreaterandLeast after calculations
  
  }
  /**
  
  The Calculations method
  Array data is passed from main for user
  to fill data
  
  @param accepts data from the main for user input
  
  */
  private static void calculations(String[] monthNames, double[] rainData){//accepts references to the months and rainfallData arrays

  double avgRain; // holds the average rain
  double totalRain; //holds the total rain
  
  String userInput; //accepts user input
  double sum = 0; //collects the sum of the data
  boolean validation =  true; //used to validate the user entry

   while(validation){//loops exception throwing if user enters invalid characters
            
      try{ //tries the risky code which is the user input
         
         for (int index = 0; index < monthNames.length; index++){

            userInput = JOptionPane.showInputDialog(null, "Enter in the amount of rainfall for " + monthNames[index] + " (in inches).");
            
            //parses the user input and passes it to the rainData array
            sum = Integer.parseInt(userInput);
            rainData[index] = sum;
            
            if(index == 11){//input validation stops when the array is finished
            
            validation = false;//sets validation boolean to false to stop the while-loop
            
            }
            
           }               
         
         }catch (Exception e){//throws exception if something invalid was entered
         
         System.out.println("Invalid input.");//error message
         
         }
            
      }
      
      totalRain = totalRainfall(rainData);//calls the totalRainfall method and passes the array
      avgRain = averageRainfall(rainData);//calls the averageRainfall method and passes the array
      
      System.out.println("The total rainfall for this year is " + totalRain + " inches.");
      System.out.println("The average rainfall for this year is " + avgRain + "inches.");
      
  }
  /**
  
  The totalRainfallMethod
  @return the double to calculations
  
  */
  private static double totalRainfall(double[] data1){//references to the rainData array
  
  double total = 0;
  
      for(int index = 0; index < data1.length; index++){
      
         total = total + data1[index]; //calculates the total
   
      }
      
      return total;//returns the total to totalRain in calculations method
  
  }
  /**
  
  The averageRainfall method
  @return the double to calculations method
  
  */
  private static double averageRainfall(double[] data2){//references to rainData array
  
  double total2 = 0;
  
      for(int index = 0; index < data2.length; index++){
      
      total2 = total2 + data2[index];//calculates the total
   
      }
      
      return total2 / data2.length;//calculates and returns the average to avgRain in calculations method
  
  }
  /**
  
  The GreaterandLeast method
  compares elemenets in the array to find the greatest
  and least amount of rainfall then displays the months for them.
  
  @param accepts data from the main
  
  */
  private static void GreaterandLeast(double[] data3, String[] names){//accepts references of rainfallData and months arrays
  
  double greatest = data3[0]; //sets greatest to the first element of the array
  String greaterMonth = names[0];//sets greaterMonth to the first elemenet of the array
  
  double least = data3[0]; //sets least to the first element of the array
  String leastMonth = names[0];//sets leastMonth to the first element of the array

      for(int index = 0; index < data3.length; index++){
      
         if(data3[index] > greatest){//if the next element is greater than the last, greater is then replaced and so is the month name
        
         greatest = data3[index];
         greaterMonth = names[index];
         
         }
      
      }

      for(int index = 0; index < data3.length; index++){
      
         if(data3[index] < least){//if the next element is lesser than the last, least is then replaced and so is the month name
         
         least = data3[index];
         leastMonth = names[index];
         
         }
   
      }
           //displays the months with the greatest and least rainfall
   System.out.println("The month(s) with the most rainfall are " + greaterMonth + "."); 
   System.out.println("The month(s) with the least rainfall are " + leastMonth + ".");
   
  }
  
}