package kingchatteam.com.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import kingchatteam.com.LoginActivity;
import kingchatteam.com.R;

public class SplashScreenActivity extends AppCompatActivity {

    private Button _button_check;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        _button_check = (Button) findViewById(R.id.xml_button_check);
        //Gọi function
        isCheckConnectionSever();
        isConnectionServer();
        _button_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isConnectionServer();
            }
        });

    }

    //Kết nối
    private void isConnectionServer(){


        if(!isCheckConnectionSever()) {
            _button_check.setVisibility(View.VISIBLE);
            Toast.makeText(getBaseContext(), R.string.string_text_toast_check, Toast.LENGTH_SHORT).show();
           // Snackbar.make(view, R.string.string_text_toast_check, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
        }else{
            //  isConnectionSever();
            // Khoi tao class Handler de lang nghe va chuyen qua man hinh login trong vong vong 3s
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(isCheckConnectionSever() == true){
                        Start_activity();
                        finish();
                    }
                }
            }, 3000);
        }

    }

    private void Start_activity(){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    // Kiem tra xem dien thoai da duoc ket noi den server chua
    private boolean isCheckConnectionSever(){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

       // Log.e("isCheckConnectionSever", Boolean.toString(networkInfo.isConnected()));

        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        return false;
    }
}
