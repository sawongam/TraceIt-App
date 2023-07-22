package np.com.sangamadhikari.traceit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
public class Main extends AppCompatActivity {

    private boolean isMinimized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ScreenSett
        WindowManager.LayoutParams layout = getWindow().getAttributes();
        layout.screenBrightness = 1.0f;                                        // Set screen brightness to maximum
        getWindow().setAttributes(layout);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // prevents the screen from turning off

        // FullScreenSett
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


    }

    protected void onResume() {
        super.onResume();
        if (isMinimized) {
            Intent intent = new Intent(Main.this, Intro.class);
            startActivity(intent);
            isMinimized = false;        // Reset the flag
        }
    }

    protected void onPause() {
        super.onPause();
        isMinimized = true;         // Set the flag when the app is minimized
    }
}
