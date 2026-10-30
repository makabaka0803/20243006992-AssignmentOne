package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get index passed from MainActivity
        int index = getIntent().getIntExtra("index", 0);

        // Bind UI elements, match ids in activity_detail.xml
        ImageView detailIcon = findViewById(R.id.detail_icon);
        TextView shortTitleTv = findViewById(R.id.short_title);
        TextView longTitleTv = findViewById(R.id.long_title);
        TextView contentTv = findViewById(R.id.content_text);
        
        // Short names for banner hard‑coded inside Java only (Facilities / Events / Clubs / Support)
        String[] bannerShortTitles = {"Facilities", "Events", "Clubs", "Support"};

        // Load original three arrays from your arrays.xml, NO adding new array resource
        String[] imageNameArray = getResources().getStringArray(R.array.string_array_images);
        String[] longTitleArray = getResources().getStringArray(R.array.string_array_titles);
        String[] contentArray = getResources().getStringArray(R.array.string_array_content);

        // Convert drawable string name to resource id
        String drawableName = imageNameArray[index].trim();
        int iconResId = getResources().getIdentifier(drawableName, "drawable", getPackageName());

        // Populate UI by index, NO if‑statement / switch‑case (assignment requirement)
        detailIcon.setImageResource(iconResId);
        shortTitleTv.setText(bannerShortTitles[index]);
        longTitleTv.setText(longTitleArray[index]);
        contentTv.setText(contentArray[index]);
    }
}
