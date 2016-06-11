package com.example.holmesvinn.info_display;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Holmes Vinn on 6/10/2016.
 */
public class activity_2 extends Activity {




    Date dateObj;
    public TextView named,doba,sexd,addressd,cityd,emaild,phoned;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);
        Intent intent = getIntent();
        String FullName = intent.getExtras().getString("FullName");
        named = (TextView) findViewById(R.id.named);
        named.setText(FullName);
        String Addressd = intent.getExtras().getString("Address");
        addressd = (TextView)findViewById(R.id.addressd);
        addressd.setText(Addressd);
        String Cityd = intent.getExtras().getString("CityWithPin");
        cityd = (TextView)findViewById(R.id.cityd);
        cityd.setText(Cityd);
        String EmailId = intent.getExtras().getString("EmailId");
        emaild = (TextView)findViewById(R.id.emaild);
        emaild.setText(EmailId);
        String PhoneNum = intent.getExtras().getString("PhoneNum");
        phoned = (TextView)findViewById(R.id.phoned);
        phoned.setText(PhoneNum);
        String Age = intent.getExtras().getString("age");
        doba = (TextView)findViewById(R.id.doba);
        doba.setText(Age);

        String sex  = intent.getExtras().getString("sex");
        sexd = (TextView) findViewById(R.id.sexd);
        sexd.setText(sex);
        String picturePath= intent.getExtras().getString("image");
        ImageView img = (ImageView) findViewById(R.id.imageup);
        img.setImageBitmap(BitmapFactory.decodeFile(picturePath));



    }


}