package lat.pam.biodataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lat.pam.biodataapp.helper.Helper;

public class EditorActivity extends AppCompatActivity {

    private EditText editname,editemail;
    private Button btnSave;
    private Helper db = new Helper(this);
    private String id,name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editname = findViewById(R.id.edit_name);
        editemail = findViewById(R.id.edit_email);
        btnSave = findViewById(R.id.btn_save);

        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");

        if(id == null || id.equals("")){
            setTitle("Tambah Biodata");
        }else{
            setTitle("Edit Biodata");
            editname.setText(name);
            editemail.setText(email);
        }
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    if(id==null||id.equals("")){
                        save();
                    }else{
                        edit();
                    }
                }catch (Exception e){
                    Log.e("Saving", e.getMessage());
                }
            }
        });
    }

    private void save(){
        if(String.valueOf(editname.getText()).equals("") || String.valueOf(editemail.getText()).equals("")){
            Toast.makeText(getApplicationContext(),"Silahkan isi semua data",Toast.LENGTH_SHORT).show();
        }else{
            db.insert(editname.getText().toString(), editemail.getText().toString());
            finish();
        }
    }

    private void edit(){
        if(String.valueOf(editname.getText()).equals("") || String.valueOf(editemail.getText()).equals("")){
            Toast.makeText(getApplicationContext(),"Silahkan isi semua data",Toast.LENGTH_SHORT).show();
        }else{
            db.update(Integer.parseInt(id),editname.getText().toString(), editemail.getText().toString());
            finish();
        }
    }

}