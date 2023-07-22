package np.com.sangamadhikari.traceit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
public class Intro extends AppCompatActivity {

    private ImageView traceBtn;  //declaring the trace button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);   //do this to customize the default splash screen from android12
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //traceBtn
        traceBtn = findViewById(R.id.traceBtn);
        traceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                traceBtn.setVisibility(View.GONE);                  //hide the trace initial button(for animation purposes)
                Handler handler = new Handler();                    //for delay code
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Perform actions after the delay
                        Intent intent = new Intent(Intro.this, Main.class);
                        startActivity(intent);
                        traceBtn.setVisibility(View.VISIBLE);
                    }
                }, 69);                                   // Delay in milliseconds (500ms = 0.5s)
            }
        });


        //rateBtn
        ImageView rateBtn = findViewById(R.id.rateBtn);
            rateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                }
            });


        //ShareBtn
        ImageView shareBtn = findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String appLink = "https://play.google.com/store/apps/details?id=" + getPackageName();
                String message = "Download Trace It App:\n" + appLink;
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });


        //PlayBtn
        ImageView playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://search?q=pub:SanAdh");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }



}

