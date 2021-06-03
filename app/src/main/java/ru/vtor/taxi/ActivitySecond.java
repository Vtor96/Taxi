package ru.vtor.taxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySecond extends AppCompatActivity {

    TextView name;
    TextView number;
    TextView vyvod;

    Button btn;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "Запущено второе активити");

        name = findViewById(R.id.Name);
        number = findViewById(R.id.Number);
        vyvod = findViewById(R.id.vyvod_dannyx);
        btn = findViewById(R.id.vyzov);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        String Surname = intent.getStringExtra("Surname");
        String Number = intent.getStringExtra("Telephone");

        name.setText("Your name is: " + Name + " " + Surname);
        number.setText("Your number is: " + Number);
    }

    public void onButtonClick (View v) {
    Intent intent = new Intent("android.intent.action.ActivityThird");
    startActivityForResult(intent,1);
    }

    public void onClick (View v) {
        Toast toast = Toast.makeText(this, "Wait for Taxi. Good Luck!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (data == null) return;
        String street1 = data.getStringExtra("Street1");
        String house1 = data.getStringExtra("House1");
        String flat1 = data.getStringExtra("Flat1");
        String street2 = data.getStringExtra("Street2");
        String house2 = data.getStringExtra("House2");
        String flat2 = data.getStringExtra("Flat2");
        vyvod.setText("Taxi will arrive at " + street1 + ", " + house1 + ", " + flat1 + " in 5 minutes and take you in " +
        street2 + ", " + house2 + ", " + flat2 + ". If you are agree click Call Taxi.");
        btn.setEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onClearMenuClick (MenuItem item) {
    }

    public void onExitMenuClick (MenuItem item) {
        finish ();
    }
}
