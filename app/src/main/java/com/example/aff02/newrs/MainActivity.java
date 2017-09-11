package com.example.aff02.newrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnsave,btnshow;
    private EditText edtname,edtrupees,edtdesc;
    DatabaseHelper databaseHelper;
    String name,rupees,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = (Button)findViewById(R.id.btn_save);
        //btnshow = (Button)findViewById(R.id.btnshowlist);

        edtname = (EditText)findViewById(R.id.edtname);
        edtdesc = (EditText)findViewById(R.id.edtdesc);
        edtrupees =(EditText)findViewById(R.id.edtrupees);

        databaseHelper = new DatabaseHelper(this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = edtname.getText().toString();
                desc = edtdesc.getText().toString();
                rupees = edtrupees.getText().toString();

                if (name.isEmpty() && desc.isEmpty() && rupees.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please Fill Details",Toast.LENGTH_LONG).show();
                }

                else
                {
                    databaseHelper.insertData(name,rupees,desc);

                    edtname.setText("");
                    edtdesc.setText("");
                    edtrupees.setText("");
                    Intent intent = new Intent(MainActivity.this,RecycleviewActivity.class);
                    startActivity(intent);
                }
            }
        });

//        btnshow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(MainActivity.this,RecycleviewActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
