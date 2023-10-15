package com.example.myapplication234;



import static androidx.core.view.accessibility.AccessibilityEventCompat.setAction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class TestResorces3 extends AppCompatActivity {

    private boolean isSubscribed = false;
    private Button colorChangeButton;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_resorces3);


        String profileName = "@Alexandar_man";
        setTitle("Профиль пользователя" + profileName);

        Button buttonSub = findViewById(R.id.buttonSubscribe);

        buttonSub.setOnClickListener(view -> {

            if(isSubscribed){
                Snackbar snackbar = Snackbar.make(view, "Вы точно хотите отписаться от" + profileName + "?", Snackbar.LENGTH_LONG ).setAction( "Да, отписаться",
                     v ->{
                         buttonSub.setBackgroundColor(getResources().getColor(R.color.notSubscribe_button_color));
                         buttonSub.setText("Подписаться");

                         isSubscribed = !isSubscribed;

                     });

             snackbar.show();
            }else {
                buttonSub.setBackgroundColor(getResources().getColor(R.color.Subscribe_button_color));
                buttonSub.setText("Отписаться");

                Toast toast = Toast.makeText(getApplicationContext(), "Вы подписались на "
                        + profileName, Toast.LENGTH_SHORT);
                toast.show();

                isSubscribed = !isSubscribed;
            }
        });

    }

    private void changeBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        mainLayout.setBackgroundColor(color);

    }
}

