package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileDatabase {
    public ArrayList<JobOffer> ReadAll(Context context) throws IOException, ClassNotFoundException {
        try{
            FileInputStream fileInputStream = context.openFileInput("offers.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<JobOffer> result = (ArrayList<JobOffer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            return result;
        }catch (IOException ex){
            return new ArrayList<>();
        }

    }
    public void SaveAll(ArrayList<JobOffer> jobOffers, Context context) throws IOException {
        FileOutputStream fileOutputStream = context.openFileOutput("offers.dat", Context.MODE_PRIVATE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(jobOffers);
        objectOutputStream.close();
        fileOutputStream.close();
    }
    public ComparisonSetting ReadSetting(Context context) throws IOException, ClassNotFoundException {
        try{
            FileInputStream fileInputStream = context.openFileInput("setting.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ComparisonSetting result = (ComparisonSetting) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            return result;
        }catch (IOException ex){
            return new ComparisonSetting();
        }
    }
    public void SaveSetting(ComparisonSetting setting, Context context) throws IOException {
        FileOutputStream fileOutputStream = context.openFileOutput("setting.dat", Context.MODE_PRIVATE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(setting);
        objectOutputStream.close();
        fileOutputStream.close();
    }
    public void Clear(Context context) throws IOException{
        SaveAll(new ArrayList<JobOffer>(), context);
    }
}
