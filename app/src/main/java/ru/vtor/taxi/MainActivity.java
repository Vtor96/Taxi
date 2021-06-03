package ru.vtor.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPref;

    final String keyTelephone = "my_saved_text";
    final String keyName = "my_saved_text2";
    final String keySurname = "my_saved_text3";

    private EditText tel, name, surname;

    private Button btn;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        loadText();

        Log.d(TAG, "Запущено первое активити (Main)");

        tel.addTextChangedListener(new TextWatcher() {
            String savedTelephone = tel.getText().toString();
            String savedName = name.getText().toString();
            String savedSurname = surname.getText().toString();

            @Override
            public void afterTextChanged(Editable s) {
                if ((tel.getText().toString().equals(savedTelephone)) || (name.getText().toString().equals(savedName)) || (surname.getText().toString().equals(savedSurname)))
                    btn.setText("Log in");
                else btn.setText("Registrations");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    public void initViews() {
        tel = findViewById(R.id.Telephone);
        name = findViewById(R.id.Name);
        surname = findViewById(R.id.Surname);
        btn = findViewById(R.id.rgt);
    }

    public void onButtonClick (View v) {
        Intent intent = new Intent(this, ActivitySecond.class);
        intent.putExtra("Telephone", tel.getText().toString());
        intent.putExtra("Name", name.getText().toString());
        intent.putExtra("Surname", surname.getText().toString());
        startActivity(intent);
    }

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        //добавление сохраненных данных
        editor.putString(keyTelephone, tel.getText().toString());
        editor.putString(keyName, name.getText().toString());
        editor.putString(keySurname, surname.getText().toString());
        editor.commit(); //сохранение данных
        Toast.makeText(this, "Text saved", Toast.LENGTH_LONG).show();
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        //извлечение сохраненных данных
        String savedText = sPref.getString(keyTelephone, "");
        String savedText2 = sPref.getString(keyName, "");
        String savedText3 = sPref.getString(keySurname, "");
        tel.setText(savedText);
        name.setText(savedText2);
        surname.setText(savedText3);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_LONG).show();

        btn.setText("Log in");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onClearMenuClick (MenuItem item) {
        tel.setText("");
        name.setText("");
        surname.setText("");
    }

    public void onExitMenuClick (MenuItem item) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity:onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity:onDestroy");

        saveText();
    }
}
