package sg.edu.np.mad.prac3ver1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private String TAG = "Main Activity 2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageActivityChange = findViewById(R.id.imageActivityChange);

        //when clicked, start queryProfile
        imageActivityChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Image Clicked");
                queryProfile();
            }
        });
    }
    //get random 6 digit number
    private int randomNum(){
        Random ran = new Random();
        //force 6 digit number ((max-min+1) + min)
        int value = ran.nextInt(999999-90000+1) + 90000;
        return value;
    }
    //generate query for profile viewer
    private void queryProfile() {
        //define builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //set description, cancelable
        builder.setMessage("lorem ipsum").setCancelable(true);
        //set positive response, go to profile viewer
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //create bundle to send random int to profile viewer
                Bundle extras = new Bundle();
                //input key, value into bundle
                extras.putInt("RandomInt", randomNum());
                //create intent to go to profile viewer
                Intent myIntent = new Intent(MainActivity2.this, MainActivity.class);
                //send extras
                myIntent.putExtras(extras);
                //goto profile viewer
                startActivity(myIntent);
            }
        });
        //set negative response, close query
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //closes query
                dialogInterface.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}