package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    ImageView im2, im3, im4, im5, im6, im7, im8, im9, im10, im11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recognize image ids-------------------------------
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);
        im5 = findViewById(R.id.im5);
        im6 = findViewById(R.id.im6);
        im7 = findViewById(R.id.im7);
        im8 = findViewById(R.id.im8);
        im9 = findViewById(R.id.im9);
        im10 = findViewById(R.id.im10);
        im11 = findViewById(R.id.im11);
        //button----------------------------------------------
        Button ref = findViewById(R.id.ref);
        final Button btnNext1 = findViewById(R.id.btnNext1);
        Button btnNext2 = findViewById(R.id.btnNext2);
        Button btnNext3 = findViewById(R.id.btnNext3);
        Button btnNext5 = findViewById(R.id.btnNext5);
        Button btnNext6 = findViewById(R.id.btnNext6);
        final Button btn1 = findViewById(R.id.btn1);
        final Button btn2 = findViewById(R.id.btn2);
        final Button btn3= findViewById(R.id.btn3);
        final Button btn4 = findViewById(R.id.btn4);
        //txtView---------------------------------------------
        final TextView txtTemp = findViewById(R.id.txtTemp);
        final TextView low = findViewById(R.id.low);
        final TextView high = findViewById(R.id.high);
        final TextView humidity = findViewById(R.id.humidity);
        final TextView describe = findViewById(R.id.describe);
        final TextView txtLoc = findViewById(R.id.txtLoc);
        final TextView wind = findViewById(R.id.wind);
        final TextView degree = findViewById(R.id.degree);
        final TextView txtT1 = findViewById(R.id.txtT1);
        final TextView txtT2 = findViewById(R.id.txtT2);
        final TextView txtT3 = findViewById(R.id.txtT3);
        final TextView txtT4 = findViewById(R.id.txtT4);
        final TextView day1 = findViewById(R.id.day1);
        final TextView day2 = findViewById(R.id.day2);
        final TextView day3 = findViewById(R.id.day3);
        final TextView day4 = findViewById(R.id.day4);
        final TextView day5 = findViewById(R.id.day5);
        final EditText editSearch = findViewById(R.id.edtSearch);
        //----------------------------------------------------
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = "Tehran";
                city = editSearch.getText().toString();
                txtLoc.setText(city);
                final String address = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=902e7a86eeda9b601fed684e78c02daf";
                AsyncHttpClient client = new AsyncHttpClient();
                client.get(address, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try {
                            String name = "";
                            JSONArray obj = new JSONArray(response.getString("list"));
                            for (int i = 0; i <=0; i++) {
                                JSONObject jsonobject = obj.getJSONObject(i);
//                                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$obj="+i);
                                name = jsonobject.getString("main");
//                                break;
                            }

            //first main temperature----------------------------------------------------------------
                            JSONObject obj3 = new JSONObject(name);
                            String t = obj3.getString("temp");
                            double T = Double.valueOf(t);
                            T = T - 275;
                            T = Math.round(T);
                            String temp2 = Double.toString(T);
                            txtTemp.setText(temp2);
                            btn1.setText("   "+temp2);
             //first min temp-----------------------------------------------------------------------
                            JSONObject obj4 = new JSONObject(name);
                            String t1 = obj4.getString("temp_min");
                            double T2 = Double.valueOf(t1);
                            T2 = T2 - 275;
                            T2 = Math.round(T2);
                            String t2 = Double.toString(T2);
                            low.setText(t2);
            //first high temp-----------------------------------------------------------------------
                            JSONObject obj5 = new JSONObject(name);
                            String temp3 = obj5.getString("temp_max");
                            double T3 = Double.valueOf(temp3);
                            T3 = T3 - 275;
                            T3 = Math.round(T3);
                            String t3 = Double.toString(T3);
                            high.setText(t3);
            //humidity==============================================================================
                            JSONObject obj6 = new JSONObject(name);
                            String temp5 = obj6.getString("humidity");
                            double humid = Double.valueOf(temp5);
                            String t4 = Double.toString(humid);
                            humidity.setText(t4);
            //describe==============================================================================
                            JSONArray obj_1 = new JSONArray(response.getString("list"));
                            String name1 = "";
                            JSONArray obj_2 = null;
                            for (int i = 0; i < obj_1.length(); i++) {
                                JSONObject jsonobject = obj_1.getJSONObject(i);
                                String array1 = jsonobject.getString("weather");
                                obj_2 = new JSONArray(array1);
                                break;
                            }
                            for (int j = 0; j < obj_2.length(); j++) {
                                JSONObject jsonobject2 = obj_2.getJSONObject(j);
                                name1 = jsonobject2.getString("description");
                                break;
                            }
                            describe.setText(name1);
                            String icon="";
                            for (int j = 0; j < obj_2.length(); j++) {
                                JSONObject jsonobject2 = obj_2.getJSONObject(j);
                                icon = jsonobject2.getString("icon");
                            }
                            Map<String, Integer> pic=new HashMap<>();
                            pic.put("01d",R.drawable.a01d);
                            pic.put("02d",R.drawable.a02d);
                            pic.put("03d",R.drawable.a03d);
                            pic.put("04d",R.drawable.a04d);
                            pic.put("09d",R.drawable.a09d);
                            pic.put("10d",R.drawable.a10d);
                            pic.put("11d",R.drawable.a11d);
                            pic.put("13d",R.drawable.a13d);
                            pic.put("50d",R.drawable.a50d);
                            pic.put("01n",R.drawable.a01n);
                            pic.put("02n",R.drawable.a02n);
                            pic.put("03n",R.drawable.a03n);
                            pic.put("04n",R.drawable.a04n);
                            pic.put("09n",R.drawable.a09n);
                            pic.put("10n",R.drawable.a10n);
                            pic.put("11n",R.drawable.a11n);
                            pic.put("13n",R.drawable.a13d);
                            pic.put("50n",R.drawable.a50d);
                            //image view .set imager resorce(pic.get(icon));
                            im3.setImageResource(pic.get(icon));
                            im4.setImageResource(pic.get(icon));
                            im5.setImageResource(pic.get(icon));
                            im6.setImageResource(pic.get(icon));
                            im7.setImageResource(pic.get(icon));
            //speed=================================================================================
                            JSONArray obj_3 = new JSONArray(response.getString("list"));
                            for (int i = 0; i < obj_3.length(); i++) {
                                JSONObject jsonobject = obj_3.getJSONObject(i);
                                name = jsonobject.getString("wind");
                                break;
                            }
                            JSONObject j = new JSONObject(name);
                            name1 = j.getString("speed");

                            wind.setText(name1);
            //=====degree===========================================================================
                            JSONObject j2 = new JSONObject(name);
                            name1 = j2.getString("deg");
                            double degre = Double.valueOf(name1);
                            degre=Math.round(degre);
                            String t5 = Double.toString(degre);
                            degree.setText(t5);
            //--------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
                            btnNext1.setText("  "+T);
            //second get in a day===================================================================
                            JSONArray obg = new JSONArray(response.getString("list"));
                           String nam="";
                            for (int i = 0; i <=1; i++) {
                                JSONObject jsonobject = obg.getJSONObject(i);
                                nam = jsonobject.getString("main");
//                                break;
                            }
                            System.out.println(nam);
                            JSONObject j1 = new JSONObject(nam);
                            String n1 = j1.getString("temp");
                            double m1= Double.valueOf(n1);
                            m1=m1-275;
                            m1=Math.round(m1);
                            String g1=Double.toString(m1);
                            btn2.setText("   "+g1);
                            //----------
                            String nam2="";
                            for (int i = 0; i <=2; i++) {
                                JSONObject jsonobject = obg.getJSONObject(i);
                                nam2 = jsonobject.getString("main");
                            }
                            JSONObject j4 = new JSONObject(nam2);
                            String n2 = j4.getString("temp");
                            double m2= Double.valueOf(n2);
                            m2=m2-275;
                            m2=Math.round(m2);
                            String g2=Double.toString(m2);
                            btn3.setText("   "+g2);
                            //-----------------------------
                            String nam3="";
                            for (int i = 0; i <=3; i++) {
                                JSONObject jsonobject = obg.getJSONObject(i);
                                nam3 = jsonobject.getString("main");
                            }
                            JSONObject j5 = new JSONObject(nam3);
                            String n3 = j5.getString("temp");
                            double m3= Double.valueOf(n3);
                            m3=m3-275;
                            m3=Math.round(m3);
                            String g3=Double.toString(m3);
                            btn4.setText("   "+g3);
                            //--------------------------------------------------------------
                            String nam4="";
                            JSONArray obg4 = new JSONArray(response.getString("list"));
                            for (int i = 0; i <=0; i++) {
                                JSONObject jsonobject = obg4.getJSONObject(i);
                                nam4 = jsonobject.getString("dt");
                            }
                            long unixSeconds = Long.parseLong(nam4);
// convert seconds to milliseconds
                            Date date = new java.util.Date(unixSeconds*1000L);
// the format of your date
                            SimpleDateFormat sdf = new java.text.SimpleDateFormat("h:mm a");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate = sdf.format(date);
                            txtT2.setText(formattedDate);
                            //-------------------

                            // strin day
                            String nam5="";
                            for (int i = 0; i <=1; i++) {
                                JSONObject jsonobject0 = obg.getJSONObject(i);
                                nam5 = jsonobject0.getString("dt");
                            }
                            long unixSeconds1 = Long.parseLong(nam5);
// convert seconds to milliseconds
                            Date date1 = new java.util.Date(unixSeconds1*1000L);
// the format of your date
                            SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("h:mm a");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf1.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate1 = sdf1.format(date1);
                            txtT3.setText(formattedDate1);
                            //--------------------------
                            String nam6="";
                            for (int i = 0; i <=2; i++) {
                                JSONObject jsonobject10 = obg.getJSONObject(i);
                                nam6 = jsonobject10.getString("dt");
                            }
                            long unixSeconds2 = Long.parseLong(nam6);
// convert seconds to milliseconds
                            Date date2 = new java.util.Date(unixSeconds2*1000L);
// the format of your date
                            SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("h:mm a");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf2.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate2 = sdf2.format(date2);
                            txtT4.setText(formattedDate2);
        //----------------------------------DAY 1------------------------------------------------------
                             int i=0;
                            String nam7="";
                            for (i=0;i<=0;i++){
                                JSONObject jsonobject10 = obg.getJSONObject(i);
                                nam7 = jsonobject10.getString("dt");
                            }
                            long unixSeconds3 = Long.parseLong(nam7);
// convert seconds to milliseconds
                            Date date3 = new java.util.Date(unixSeconds3*1000L);
// the format of your date
                            SimpleDateFormat sdf3 = new java.text.SimpleDateFormat("E");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf3.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate3 = sdf3.format(date3);
                            day1.setText(formattedDate3);
        //----------------------------------DAY 2------------------------------------------------------
                            String namee="";
                            i=0;
                            String formattedDate33;
                            do {
                                i++;
                                JSONObject jsonobject11 = obg.getJSONObject(i);
                                namee = jsonobject11.getString("dt");
                            long unixSeconds33 = Long.parseLong(namee);
                            Date date33 = new java.util.Date(unixSeconds33*1000L);
                            SimpleDateFormat sdf33 = new java.text.SimpleDateFormat("E");
                            sdf33.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                             formattedDate33 = sdf33.format(date33);
                            }while (formattedDate3==namee);
// convert seconds to milliseconds
// the format of your date
// give a timezone reference for formatting (see comment at the bottom)
                            day2.setText(formattedDate33);
        //----------------------------------DAY 3------------------------------------------------------
                            String nameee="";
                            for ( i = 0; i <=2; i++) {
                                JSONObject jsonobject13 = obg.getJSONObject(i);
                                nameee = jsonobject13.getString("dt");
                            }
                            long unixSeconds333 = Long.parseLong(nameee);
// convert seconds to milliseconds
                            Date date333 = new java.util.Date(unixSeconds333*1000L);
// the format of your date
                            SimpleDateFormat sdf333 = new java.text.SimpleDateFormat("E");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf333.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate333 = sdf333.format(date333);
                            day2.setText(formattedDate333);
        //----------------------------------DAY 4------------------------------------------------------
                            String Name="";
                            for ( i = 0; i <=2; i++) {
                                JSONObject jsonobject13 = obg.getJSONObject(i);
                                nameee = jsonobject13.getString("dt");
                            }
                            long unixSeconds4 = Long.parseLong(nameee);
// convert seconds to milliseconds
                            // convert seconds to milliseconds
                            Date date4 = new java.util.Date(unixSeconds4*1000L);
// the format of your date
                            SimpleDateFormat sdf4 = new java.text.SimpleDateFormat("E");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf4.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate4 = sdf4.format(date4);
                            day3.setText(formattedDate4);
        //----------------------------------DAY 5------------------------------------------------------
                            String Name1="";
                            for ( i = 0; i <=4; i++) {
                                JSONObject jsonobject10 = obg.getJSONObject(i);
                                Name1 = jsonobject10.getString("dt");
                            }
                            long unixSeconds5 = Long.parseLong(Name1);
// convert seconds to milliseconds
                            Date date5 = new java.util.Date(unixSeconds5*1000L);
// the format of your date
                            SimpleDateFormat sdf5 = new java.text.SimpleDateFormat("E");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf5.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate5 = sdf5.format(date5);
                            day4.setText(formattedDate5);
//---------------------------------------DAY 5-------------------------------------------------------
                            String Name2="";
                            for ( i = 0; i <=5; i++) {
                                JSONObject jsonobject17  = obg.getJSONObject(i);
                                Name2 = jsonobject17.getString("dt");
                            }
                            long unixSeconds6 = Long.parseLong(Name2);
// convert seconds to milliseconds
                            Date date6 = new java.util.Date(unixSeconds6*1000L);
// the format of your date
                            SimpleDateFormat sdf6 = new java.text.SimpleDateFormat("E");
// give a timezone reference for formatting (see comment at the bottom)
                            sdf6.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
                            String formattedDate6 = sdf6.format(date6);
                            day5.setText(formattedDate6);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                });
            }
        });
    }
}
