package com.sar.user.save_data_in_cache;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=findViewById(R.id.editText);
        TextView textView=findViewById(R.id.textView);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editText.getText().toString();
                File cache=getCacheDir();
                File file=new File(cache,"abcd.txt");
                try {
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(s.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        File cache=getFilesDir();
        StringBuilder stringBuilder=new StringBuilder();
        File file1=new File(cache,"abcd.txt");
        try {
            FileInputStream fileInputStream=new FileInputStream(file1);
            int n=0;
            while(fileInputStream.read()!=-1)
            {
                 char c= (char) fileInputStream.read();
                Log.i("jjj",String.valueOf(c));
                stringBuilder.append(c);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ss=stringBuilder.toString();
        if(ss.length()>0)
        {
            textView.setText(ss);
        }
    }
}
