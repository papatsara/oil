package rtc.papatsara.oiltraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.LiveFolders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit การประกาศตัวแปร
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        listView = (ListView) findViewById(R.id.livTraffic);
        button = (Button) findViewById(R.id.button);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
                        R.raw.dog);
                mediaPlayer.start();

                //Show Webview
                String url = "https://youtu.be/h2nIHSgQ2Bs";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);


            } // onClick
        });

        //ListView Controller
        //Get Value from Class
        MyConstant myConstant = new MyConstant();
        final int[] ints = myConstant.getInts();

        //Get Value Frome xml
        final String[] titleStrings = getResources().getStringArray(R.array.title);
        final String[] detailStrings = getResources().getStringArray(R.array.detail);

        //Create ListView
        TrafficAdapter trafficAdapter = new TrafficAdapter(MainActivity.this,
                titleStrings, detailStrings, ints);
        listView.setAdapter(trafficAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Image", ints[position]);
                intent.putExtra("Detail", detailStrings[position]);
                startActivity(intent);

            }
        });


    }   // Main Method

}   // Main Class นี่คือ คลาสหลัก
