package space.jsdn.karaoke_random;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Search_menu extends AppCompatActivity {
    TextView te;
    EditText ed;
    String searchda;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ed = findViewById(R.id.editText);
        te = findViewById(R.id.textView4);
        bt = findViewById(R.id.button4);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchda = ed.getText().toString();
                URL url = null;
                HttpURLConnection urlConnection = null;
                BufferedInputStream buf = null;
                try {

                    url= new URL("https://api.manana.kr/karaoke/singer/fripside/tj.json");


                    urlConnection = (HttpURLConnection) url.openConnection();


                    BufferedReader bufreader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
                    Log.d("line:",bufreader.toString());

                    String line = null;
                    String page = "";


                    while((line = bufreader.readLine())!=null){
                        Log.d("line:",line);
                        page+=line;
                    }
                    te.setText(page);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
