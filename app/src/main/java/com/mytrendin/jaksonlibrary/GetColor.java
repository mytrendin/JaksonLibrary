package com.mytrendin.jaksonlibrary;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GetColor {


    HttpURLConnection httpURLConnection;
    URL url;
    List<Model> modelList;



    public List<Model> data(){

        ObjectMapper mapper = new ObjectMapper();
       Color color;
        String data= getJSONfromurl();
        try {
            color = mapper.readValue(data,Color.class);
            Model model = new Model();
            modelList = new ArrayList<>();

            for (int i=0;i<color.getColorsArray().size();i++){
                String name = color.getColorsArray().get(i).getColorName();
                String hexvalue = color.getColorsArray().get(i).getHexValue();
                model.setColorName(name);
                model.setHexValue(hexvalue);
                modelList.add(model);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

      return modelList;

    }

    public String getJSONfromurl(){

        String url1 ="http://192.168.43.87/data/color.json";
        String jsondata = null;

        try {
            url = new URL(url1);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuffer buffer = new StringBuffer();
            while ((line=reader.readLine())!=null){

                buffer.append(line);
                 }
            jsondata = buffer.toString();

    } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

     return jsondata;
    }


}