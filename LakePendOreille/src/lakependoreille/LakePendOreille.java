/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lakependoreille;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ajayanilthorve
 */
public class LakePendOreille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int year,type;
        Scanner sc=new Scanner(System.in);
        System.out.println("Statistical Analysis on LPO Weather Data");
        System.out.println("Enter Year(2012-2015)");
        year=sc.nextInt();
        System.out.println("Enter option number(1/2):\n1.Air Temp\n2.Barometric Press");
        type=sc.nextInt();
        ArrayList<Double> data=getData(type,year);
        System.out.println("Mean:"+mean(data));
        System.out.println("Median:"+median(data));
        
    }
    
    public static double mean(ArrayList<Double> data){
        double sum=0,avg;
        int i=0;
        while(i<data.size()){
            sum+=data.get(i);
            i++;
        }
        avg=sum/data.size();
        return avg;
    }
    
    public static double median(ArrayList<Double> data){
        Collections.sort(data);
        double temp;
        if(data.size()/2*2!=data.size()){
            temp= data.get(data.size()/2);
        }else{
            temp=data.get(data.size()/2)+data.get(-11+(data.size()/2))/2;
        }
        return temp;
    }
    
    
    public static ArrayList<Double> getData(int type,int s) throws NumberFormatException, IOException{
        URL dataSource= new URL("https://raw.githubusercontent.com/lyndadotcom/LPO_weatherdata/master/Environmental_Data_Deep_Moor_"+s+".txt");
        ArrayList<Double> winData=new ArrayList<Double>();
        Scanner data=new Scanner(dataSource.openStream());
        String inputLine=data.nextLine();
        
        while(data.hasNextLine()){
            inputLine=data.nextLine();
            
            winData.add(Double.parseDouble(inputLine.substring(20,26)));
        }
        
        
        
        return winData;
    }
}
