package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("Name");
        String Type = getIntent().getStringExtra("Types");
        String Price = getIntent().getStringExtra("Price");
        String Rating = getIntent().getStringExtra("Rating");
        String Description = getIntent().getStringExtra("Description");
        String Link =getIntent().getStringExtra("Link");
        int image = getIntent().getIntExtra("Image", 0);

        TextView nameTextView = findViewById(R.id.film_Title);
        TextView priceTextView = findViewById(R.id.film_price);
        TextView ratingTextView = findViewById(R.id.Film_rating);
        TextView typeTextView = findViewById(R.id.film_Types);
        TextView descriptionTextView = findViewById(R.id.film_Description);
        ImageView Film_image = findViewById(R.id.FilmName_Image);
        Log.d("", "onCreate: "+nameTextView.toString());
        typeTextView.setText(Type);
        nameTextView.setText(name);
        priceTextView.setText(Price);
        ratingTextView.setText(Rating);
        descriptionTextView.setText(Description);
        Film_image.setImageResource(image);

        String myURL ="https://www.youtube.com/embed/"+Link;
        String dataUrl = "<html><body><iframe width=\"400\"height=\"315\"src=\" "+myURL+ "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        WebView myWebView = findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest url) {
                return false;
            }
        });
        WebSettings webSettings =myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.loadData(dataUrl,"text/html","utf-8");
    }
}
