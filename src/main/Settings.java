package main;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Settings {

    public int defaultWindowWidth;
    public int defaultWindowHeight;

    public double xCenter;
    public double yCenter;
    public double ringWidth;
    public double startRadius;
    public double part;
    public double moveablePart;
    public double blocksize;

    public void setSettings(){
        Gson gson = new Gson();
        String JSONstring = gson.toJson(this);
        try(PrintWriter pw = new PrintWriter("main.Settings.json")){
            pw.write(JSONstring);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Settings getSettings(){
        Gson gson = new Gson();
        Settings settings = null;
        try(Scanner sc = new Scanner(new File("main.Settings.json"))){
            String JSONstring = sc.nextLine();
            settings = gson.fromJson(JSONstring, Settings.class);
        }catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
        settings.blocksize = countBlockSize(settings.startRadius, settings.ringWidth, settings.part);
        return settings;
    }

    private static double countBlockSize(double startRadius, double ringWidth, double part){
        double S1 = Math.PI * Math.pow(startRadius, 2);
        double S2 = Math.PI * Math.pow(startRadius + ringWidth, 2);
        double S = S2 - S1;
        return S * part;
    }
}
