package practicacalificada.guevara.pe.practicacalificada3.Acticities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import practicacalificada.guevara.pe.practicacalificada3.Adapters.UserAdapter;
import practicacalificada.guevara.pe.practicacalificada3.Models.User;
import practicacalificada.guevara.pe.practicacalificada3.R;
import practicacalificada.guevara.pe.practicacalificada3.Repositories.UserRepository;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    private EditText usernameInput;
    private EditText passwordInput;

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = findViewById(R.id.username_input);
        passwordInput= findViewById(R.id.password_input);

    }

    public void agregar(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }



    public void callLogin(View view){
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Completar los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login logic
        User user = UserRepository.login(username, password);

        if(user == null){
            Toast.makeText(this, "Usuario invalido", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Bienvenido " + user.getFullname(), Toast.LENGTH_SHORT).show();
        goCatalogo();
    }

    private void goCatalogo(){
        startActivity(new Intent(this, CatalogoActivity.class));
        finish();
    }

}



