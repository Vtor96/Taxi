package ru.vtor.taxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ActivityThird extends AppCompatActivity {

    EditText street1;
    EditText house1;
    EditText flat1;
    EditText street2;
    EditText house2;
    EditText flat2;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.d(TAG, "Запущено третье активити");

        street1 = findViewById(R.id.Street1);
        house1 = findViewById(R.id.House1);
        flat1 = findViewById(R.id.Flat1);
        street2 = findViewById(R.id.Street2);
        house2 = findViewById(R.id.House2);
        flat2 = findViewById(R.id.Flat2);
    }

    public void onButtonClick (View v) {
        Intent intent = new Intent();
        intent.putExtra("Street1", street1.getText().toString());
        intent.putExtra("House1", house1.getText().toString());
        intent.putExtra("Flat1", flat1.getText().toString());
        intent.putExtra("Street2", street2.getText().toString());
        intent.putExtra("House2", house2.getText().toString());
        intent.putExtra("Flat2", flat2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onClearMenuClick (MenuItem item) {
        street1.setText("");
        house1.setText("");
        flat1.setText("");
        street2.setText("");
        house2.setText("");
        flat2.setText("");
    }

    public void onExitMenuClick (MenuItem item) {
        finish ();
    }
}
