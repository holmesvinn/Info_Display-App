package com.example.holmesvinn.info_display;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

   public Calendar calendar;
   public TextView name,dob,address,city,email,phone;
    public EditText namea,addressa,ciya,emaila,phonea;
    public String sex;

    public EditText doba;
    public RadioButton male,female;

    public ImageView img;
    SimpleDateFormat dateFormatter;
    Date d;
    String fullname,addressstr,citywithpin,emailid,phonenum,age;
    String picture;

    public Button submit,upload;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView)findViewById(R.id.name);
        dob = (TextView) findViewById(R.id.dob);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);

        address = (TextView) findViewById(R.id.address);
        city = (TextView) findViewById(R.id.City);
        email = (TextView)findViewById(R.id.email);
        phone = (TextView)findViewById(R.id.phone);

        namea = (EditText)findViewById(R.id.namea);
        addressa = (EditText) findViewById(R.id.adda);
        ciya = (EditText)findViewById(R.id.citya);
        emaila = (EditText)findViewById(R.id.emaila);
        phonea =(EditText)findViewById(R.id.phonea);
        doba= (EditText)findViewById(R.id.doba);

        submit = (Button) findViewById(R.id.submit);
        upload = (Button) findViewById(R.id.upload);

        fullname= namea.getText().toString();
        addressstr = addressa.getText().toString();
        citywithpin = ciya.getText().toString();
        emailid = emaila.getText().toString();



        upload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);

            picture = picturePath;

            cursor.close();

            ImageView img = (ImageView) findViewById(R.id.imageup);
            img.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }


    }

    public void onradiobuttonclicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();


        switch(view.getId()) {
            case R.id.male:
                if (checked)

                    break;
            case R.id.female:
                if (checked)

                    break;
        }


    }


    public void submit(View view){
        Intent intent = new Intent (this,activity_2.class);
        fullname = namea.getText().toString();
        addressstr = addressa.getText().toString();
        citywithpin = ciya.getText().toString();
        emailid = emaila.getText().toString();

        phonenum = phonea.getText().toString();
        age = doba.getText().toString();


        intent.putExtra("FullName", fullname);
        intent.putExtra("Address", addressstr);
        intent.putExtra("CityWithPin",citywithpin);
        intent.putExtra("EmailId",emailid);
        intent.putExtra("PhoneNum", phonenum);
        intent.putExtra("age", age);

        if(male.isChecked())
        {
            sex="Male";
        }
        else
        {
          sex = "Female";
        }

        intent.putExtra("sex",sex);
        intent.putExtra("image", picture);
        startActivity(intent);
    }


}
