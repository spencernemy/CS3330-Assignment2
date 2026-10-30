package assignment2;

import java.util.List;

public class HelpDeskUtils {
    public static <T> void printAll(List<T> items){

        for (int i = 0; i < items.size(); i++) {
             System.out.println(items.get(i).toString() + "/n");
      
        }
    }

    public static int sumPoints(List<? extends Technician> technicians){
        int total =0;
        
        for(int i =0; i<technicians.size(); i++ ){
            total+= technicians.get(i).getServicePoints();
        }

    return total;
    }
}
