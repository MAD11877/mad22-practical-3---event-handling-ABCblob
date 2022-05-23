package sg.edu.np.mad.prac3ver1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        //define buttons
        Button group1 = findViewById(R.id.group1);
        Button group2 = findViewById(R.id.group2);
        Fragment TextFragment = new TextFragment();
        Fragment ImageFragment = new ImageFragment();

        //when clicked
        group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //define fragment transaction
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                //set fragment layout to selected fragment
                if (!TextFragment.isAdded()){
                    ft.add(R.id.fragmentLayout, TextFragment);
                }
                if (ImageFragment.isAdded()){
                    ft.remove(ImageFragment);
                }
                ft.show(TextFragment);
                //initialize
                ft.commit();
            }
        });

        //when clicked
        group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //define fragment transaction
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (!ImageFragment.isAdded()){
                    ft.add(R.id.fragmentLayout, ImageFragment);
                }
                if (TextFragment.isAdded()){
                    ft.remove(TextFragment);
                }
                ft.show(ImageFragment);
                //initialize
                ft.commit();
            }
        });
    }
}