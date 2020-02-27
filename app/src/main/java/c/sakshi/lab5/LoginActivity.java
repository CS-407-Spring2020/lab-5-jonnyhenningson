package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    String userNameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userNameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(userNameKey, "").equals("")) {
            String name = sharedPreferences.getString(userNameKey, "");
            Intent intent = new Intent(this, NotesActivity.class);
            intent.putExtra("message", name);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_login);
        }
    }

    public void clickFunction(View view) {
        EditText nameField = (EditText) findViewById(R.id.userName);
        String name = nameField.getText().toString();
        onButtonClick(name);
    }

    public void onButtonClick(String name) {
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra("message", name);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", name).apply();
        startActivity(intent);
    }
}
