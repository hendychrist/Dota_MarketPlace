package com.example.DotaMarketPlace;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.DotaMarketPlace.R;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuForm  extends AppCompatActivity implements Serializable {

   TextView lbUser;
    ListView listView;

    String mTitle[] = {"Chitin Shoulder Guard","Chestplate of the Hierophant", "Foliage of Eldritch Gnarl","Mantle of the Blood ","Tahlin Occult Dagger"};
    String mDescription[] = {"Stock : 54"," Stock : 43"," Stock : 108"," Stock : 120"," Stock : 200"};
    String mPrice[] = {"Rp 35.022.","Rp 50.000","Rp 234.351","Rp 23.432","Rp 74.232","Rp 84.322"};

    int mImage[] = { R.drawable.satu , R.drawable.dua , R.drawable.tiga , R.drawable.empat , R.drawable.lima };

    int uBalance = 100000;

 //   public ArrayList<Stock> mStock = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuform);

//   Untuk nampilin Username

            lbUser = (TextView) findViewById(R.id.lbUsername);
            Intent mUser = getIntent();
            String labell = mUser.getStringExtra("username");

               lbUser.setText(labell);

//  End

        listView = findViewById(R.id.listView);

        // Create adapter Class
        MyAdapter adapter = new MyAdapter( this , mTitle , mDescription , mPrice, mImage);
        listView.setAdapter(adapter);

        // Now set item click on List View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if(position == 0){

                       //  Toast.makeText( MenuForm.this , " Position 0 " , Toast.LENGTH_SHORT).show();

                        // This intent put our 0 index image to another activity
                        Intent intent = new Intent(getApplicationContext(), buyItem.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("image" , mImage[0]);
                        intent.putExtras(bundle);

                        intent.putExtra("stock0", 54);
                        intent.putExtra("balance" , 35022);
                        intent.putExtra("userBalance", uBalance);

                        // Now put title and description to another activity
                        intent.putExtra("title", mTitle[0]);
                        intent.putExtra("stock" , mDescription[0]);
                        intent.putExtra("price" , mPrice[0]);

                        // Also put your position
                        intent.putExtra("position" , ""+0);
                        startActivity(intent);
                        finish();

                    }
                    if(position == 1){

                     //   Toast.makeText( MenuForm.this , "Position 1" , Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), buyItem.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("image" , mImage[1]);
                        intent.putExtras(bundle);

                        intent.putExtra("stock0", 43);
                        intent.putExtra("balance" , 50000);
                        intent.putExtra("userBalance", uBalance);

                        // Now put title and description to another activity
                        intent.putExtra("title", mTitle[1]);
                        intent.putExtra("stock" , mDescription[1]);
                        intent.putExtra("price" , mPrice[1]);

                        // Also put your position
                        intent.putExtra("position" , ""+1);
                        startActivity(intent);
                        finish();

                    }
                    if(position == 2){

                      //  Toast.makeText( MenuForm.this , "Position 2" , Toast.LENGTH_SHORT).show();

                        // This intent put our 0 index image to another activity
                        Intent intent = new Intent(getApplicationContext(), buyItem.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("image" , mImage[2]);
                        intent.putExtras(bundle);

                        intent.putExtra("stock0", 108);
                        intent.putExtra("balance" , 243351);
                        intent.putExtra("userBalance", uBalance);

                        // Now put title and description to another activity
                        intent.putExtra("title", mTitle[2]);
                        intent.putExtra("stock" , mDescription[2]);
                        intent.putExtra("price" , mPrice[2]);

                        // Also put your position
                        intent.putExtra("position" , ""+2);
                        startActivity(intent);
                        finish();

                    }

                    if(position == 3){

                      //  Toast.makeText( MenuForm.this , " Position 3" , Toast.LENGTH_SHORT).show();

                        // This intent put our 0 index image to another activity
                        Intent intent = new Intent(getApplicationContext(), buyItem.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("image" , mImage[3]);
                        intent.putExtras(bundle);

                        intent.putExtra("stock0", 120);
                        intent.putExtra("balance" , 23432);
                        intent.putExtra("userBalance", uBalance);

                        // Now put title and description to another activity
                        intent.putExtra("title", mTitle[3]);
                        intent.putExtra("stock" , mDescription[3]);
                        intent.putExtra("price" , mPrice[3]);

                        // Also put your position
                        intent.putExtra("position" , ""+3);
                        startActivity(intent);
                        finish();

                    }
                    if(position == 4){

                   //    Toast.makeText( MenuForm.this , "Position 4" , Toast.LENGTH_SHORT).show();

                        // This intent put our 0 index image to another activity
                        Intent intent = new Intent(getApplicationContext(), buyItem.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("image" , mImage[4]);
                        intent.putExtras(bundle);

                        intent.putExtra("stock0", 200);
                        intent.putExtra("balance" , 74232);
                        intent.putExtra("userBalance", uBalance);

                        // Now put title and description to another activity
                        intent.putExtra("title", mTitle[4]);
                        intent.putExtra("stock" , mDescription[4]);
                        intent.putExtra("price" , mPrice[4]);

                        // Also put your position
                        intent.putExtra("position" , ""+4);
                        startActivity(intent);
                        finish();

                    }

                    }

            });

    } // Close on create

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        String rPrice[];
        int rImgs[];

        Button goButton;

        MyAdapter (Context c, String title[], String description[],String price[], int imgs[]){
            super(c, R.layout.row , R.id.textView1 , title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rPrice = price;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View row = layoutInflater.inflate(R.layout.row , parent, false);

//           Row Xml
                ImageView images = row.findViewById(R.id.Vimage);

                TextView myTitle = row.findViewById(R.id.textView1);
                TextView myDescription = row.findViewById(R.id.textView2);
                TextView myPrice = row.findViewById(R.id.textView3);

                    images.setImageResource(rImgs[position]);

                    myTitle.setText(rTitle[position]);
                    myDescription.setText(rDescription[position]);
                    myPrice.setText(rPrice[position]);

              return row ;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {

            case R.id.idTopUp:

                Toast.makeText( MenuForm.this , "Top Up has pressed" , Toast.LENGTH_SHORT).show();

                Intent iii = new Intent(MenuForm.this , topUpForm.class);
                iii.putExtra("userDefault",uBalance);
                startActivity(iii);

                return true;

            case R.id.idLogOut:

                Toast.makeText( MenuForm.this , "Log Out has pressed" , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MenuForm.this, MainActivity.class);
                startActivity(intent);

                return true;

            case R.id.idHistory:

                Toast.makeText( MenuForm.this , "History has pressed" , Toast.LENGTH_SHORT).show();

                Intent bbb = new Intent(MenuForm.this, historyForm.class);
                startActivity(bbb);

                return true;

            default:
        }
        return super.onOptionsItemSelected(item);
    }
}

/*
https://youtu.be/SD2t75T5RdY
https://youtu.be/5Tm--PHhbJo
*/