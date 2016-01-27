package kingchatteam.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText _txt_username;
    private Button   _button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _txt_username = (EditText) findViewById(R.id.xml_username);
        _button_login = (Button) findViewById(R.id.xml_button_login);
        _button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionLogin();
            }
        });

    }

    private void FunctionLogin(){
        String _user = "admin";
        if(_txt_username.getText().toString().equals(_user) == true){
            Intent intent = new Intent(this, MenuMainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(getApplication(), "user của bạn không tồn tại!", Toast.LENGTH_SHORT).show();
        }

    }
}
