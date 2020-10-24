package com.example.DotaMarketPlace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.DotaMarketPlace.R;

public class MainActivity extends Activity implements Serializable{

    TextView txt;
    Button btn;

    EditText user , pass;

    //public ArrayList<User> lUser = new ArrayList<>();

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        user = (EditText) findViewById(R.id.txtUsername);
        pass = (EditText) findViewById(R.id.txtPassword);

        String pw = pass.getText().toString();

        btn = (Button) findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(user.getText())) {

                    user.setError("First name must be filled");
                    user.requestFocus();

                } else if (TextUtils.isEmpty(pass.getText())) {

                    pass.setError("Last name must be filled");
                    pass.requestFocus();

                } else if(arrList() == false ){

                    user.setError("Your username not registered");
                    pass.setError("Your Password not registered");

                    user.requestFocus();
                    pass.requestFocus();

                } else {

                    User.setPassword(pw);

                    Intent inted = new Intent(MainActivity.this, MenuForm.class);
                    inted.putExtra("username" , user.getText().toString());
                    startActivity(inted);

                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    finish();

                }

            }
        });

        txt = (TextView) findViewById(R.id.goToRegister);
        txt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }

        });

    }

    public boolean  arrList(){

        //boolean status = true;

        user = (EditText) findViewById(R.id.txtUsername);
        pass = (EditText) findViewById(R.id.txtPassword);

        String luser = user.getText().toString();
        String lpass = pass.getText().toString();

        Log.d(TAG, "User: Login Page: Username :  " + luser );
        Log.d(TAG, "User: Login Page: Password : " + lpass );

       // ArrayList<User> myUser = new ArrayList<>();
        //myUser = (ArrayList<User>)getIntent().getSerializableExtra("ArrayListUser");

        Intent myUser = getIntent();
        String nameUser = myUser.getStringExtra("Username");
        String wordPass = myUser.getStringExtra("Password");

            Log.d(TAG, " ");
            Log.d(TAG, " On Intent ~ Login Username  : " + nameUser);
            Log.d(TAG, " On Intent ~ Login Password  : " + wordPass);

        //Toast.makeText(MainActivity.this, "Hasil arrList to VARIABLE : " + satu , Toast.LENGTH_SHORT).show();

        if( !(luser.equals(nameUser))){
            return false;
        } else if(!(lpass.equals(wordPass))){
            return false;
        }else{
            return true;
        }

    } //  Close func boolean arrlist()

}

/*
    Reference :
     https://stackoverflow.com/questions/13601883/how-to-pass-arraylist-of-objects-from-one-to-another-activity-using-intent-in-an
 */
