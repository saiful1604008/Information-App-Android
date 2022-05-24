package com.example.firstappattachmentproject.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstappattachmentproject.R;
import com.example.firstappattachmentproject.model.Student;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> arrayListStudents;

    public CustomAdapter(Context context, ArrayList<Student> arrayListStudents) {
        this.context = context;
        this.arrayListStudents = arrayListStudents;
    }

    @Override
    public int getCount() {
        return arrayListStudents.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View custom_layout = inflater.inflate(R.layout.item_layout_custom, null);
        TextView textViewUsername = (TextView) custom_layout.findViewById(R.id.textViewUsernameLayout);
        TextView textViewCGPA = (TextView) custom_layout.findViewById(R.id.textViewCGPALayout);
        ImageView callIcon = custom_layout.findViewById(R.id.imageViewPhoneLayout);


        textViewUsername.setText("Username: "+arrayListStudents.get(i).getName());
        textViewCGPA.setText("CGPA: "+arrayListStudents.get(i).getCgpa());


        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String uri = arrayListStudents.get(i).getContact();
                intent.setData(Uri.parse("tel:"+uri));
                context.startActivity(intent);

            }
        });

        custom_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String student = "Username: " +arrayListStudents.get(i).getName()+ "\n"
                        + "CGPA: "+arrayListStudents.get(i).getCgpa()+ "\n"
                        + "Email: "+arrayListStudents.get(i).getEmail()+ "\n"
                        + "Contact Number: "+arrayListStudents.get(i).getContact();

                new AlertDialog.Builder(context)
                        .setTitle("Student Details")
                        .setMessage(student)
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });



        return custom_layout;
    }
}
