package com.example.firstappattachmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



import com.example.firstappattachmentproject.adapter.CustomAdapter;
import com.example.firstappattachmentproject.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword, editTextEmail, editTextCGPA, editTextContactNumber;
    ListView listviews;
    ArrayList<Student> arrayListStudents;
    //ArrayAdapter<Student> adapter;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextCGPA = (EditText) findViewById(R.id.editTextCGPA);
        editTextContactNumber = (EditText) findViewById(R.id.editTextContactNumber);
        listviews = (ListView) findViewById(R.id.listviews);

        arrayListStudents = new ArrayList<>();
        //adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item_layout, arrayListStudents);
        adapter = new CustomAdapter(MainActivity.this, arrayListStudents);
        listviews.setAdapter(adapter);



    }




    /* validating fields username, password, email,cgpa, contact */

    public void savedata(View view) {
        boolean error = false;
        Student std = new Student();
        String username = editTextUsername.getText().toString().trim();
        if(username.isEmpty()){
            editTextUsername.setError("Username is missing!");
            error = true;
        } else{
            if(username.length() < 6){
                editTextUsername.setError("Username is too short");
                error = true;
            }else{
                std.setName(username);
            }
        }

        String password = editTextPassword.getText().toString();
        if(password.isEmpty()){
            editTextPassword.setError("Password must be filled");
            error = true;
        } else if (password.length() < 8){
            editTextPassword.setError("Password is too short");
            error = true;
        } else{
            std.setPassword(password);
        }

        if(editTextCGPA.getText().toString().isEmpty()){
            editTextCGPA.setError("CGPA is missing!");
            error = true;
        } else{
            Float cgpa = Float.parseFloat(editTextCGPA.getText().toString());
            if (cgpa <= 4.0 && cgpa >= 2.0){
                std.setCgpa(cgpa);
            } else{
                editTextCGPA.setError("CGPA should be in range of 2.0 to 4.0");
                error = true;
            }
        }

        String contact = editTextContactNumber.getText().toString().trim();
        if(contact.isEmpty()){
            editTextContactNumber.setError("Contact number is missing!");
            error = true;
        } else if (contact.length() == 11){
            if(contact.startsWith("015")|| contact.startsWith("016")|| contact.startsWith("017")||
                contact.startsWith("018")|| contact.startsWith("019")|| contact.startsWith("013")){
                std.setContact(contact);
            }
            else{
                editTextContactNumber.setError("Contact number is not valid");
                error = true;
            }
        } else {
            editTextContactNumber.setError("Contact number be in in 11 digits");
            error = true;
        }

        String email = editTextEmail.getText().toString();
        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            std.setEmail(email);

        } else if (email.isEmpty()){
            editTextEmail.setError("Email can't be empty");
            error = true;
        } else{
            editTextEmail.setError("Invalid Email");
            error = true;
        }

        if(error){
            Toast.makeText(MainActivity.this, "Data is not saved", Toast.LENGTH_LONG).show();
        } else{
            arrayListStudents.add(std);
            adapter.notifyDataSetChanged();
            //Toast.makeText(MainActivity.this, std.toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void CancelData(View view){
        editTextUsername.setText(null);
        editTextCGPA.setText(null);
        editTextPassword.setText(null);
        editTextEmail.setText(null);
        editTextContactNumber.setText(null);
    }
}

