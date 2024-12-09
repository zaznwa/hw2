package com.geeks.hw2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Button loginButton;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        // Инициализация элементов интерфейса
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        container = findViewById(R.id.container);

        // Проверка и включение/отключение кнопки на основе данных
        //TextWatcher: Этот интерфейс отслеживает изменения в тексте полей EditText. В данном случае используется для проверки данных после того, как пользователь вводит данные в поля email и пароль.
        //onTextChanged: Вызывается каждый раз, когда изменяется текст в поле. Мы вызываем метод checkCredentials(), чтобы проверять, введены ли email и пароль.
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkCredentials();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                checkCredentials();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.equals("admin") && password.equals("admin")) {
                container.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Логин и пароль правильные", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "НЕВЕРНЫЙ ПАРОЛЬ ИЛИ ЛОГИН!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkCredentials() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        loginButton.setEnabled(!(email.isEmpty() && password.isEmpty()));
    }

}
