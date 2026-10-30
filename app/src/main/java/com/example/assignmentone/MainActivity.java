package com.example.assignmentone;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // xml android:onClick="onClick"
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.ll_facilities){
            Toast.makeText(this,"Facilities clicked", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ll_events){
            Toast.makeText(this,"Events clicked", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ll_clubs){
            Toast.makeText(this,"Clubs clicked", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ll_support){
            Toast.makeText(this,"Support clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
