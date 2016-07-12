package com.example.test.lecture10net;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NetFetchTask extends AsyncTask<String,Void,String> {

    private onPostExecuteDoneListener listener;
    Integer rescode=0;

    public NetFetchTask(onPostExecuteDoneListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url=new URL(params[0]);
            HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
            urlConn.setConnectTimeout(10000);
            urlConn.setReadTimeout(20000);
            urlConn.connect();
            rescode=urlConn.getResponseCode();
            if(rescode!=200)
            {
                String r="Response code is: "+ rescode;
                return r;
            }

           InputStream stream=urlConn.getInputStream();

            BufferedReader reader=new BufferedReader(new InputStreamReader(stream));

            StringBuilder buffer=new StringBuilder();

            String data="";

            while((data = reader.readLine()) != null)
            {
             buffer.append(data).append("\n");

            }



            return buffer.toString();










        }  catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.onPostExecuteDone(s);
    }

    public interface onPostExecuteDoneListener
    {
        void onPostExecuteDone(String s);

    }

}
