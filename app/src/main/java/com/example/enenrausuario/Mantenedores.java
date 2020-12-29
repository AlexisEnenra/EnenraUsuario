package com.example.enenrausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Mantenedores extends AppCompatActivity {

    private ListView listView;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList =new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenedores);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Usuarios");
        listView = (ListView) findViewById(R.id.listViewMant);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);



        mDatabase.addChildEventListener(new ChildEventListener(){
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s){
                String value = dataSnapshot.getValue(DatosMantenedores.class).toString();
                arrayList.add(value);
                adapter.notifyDataSetChanged();
                
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s){

                String string = dataSnapshot.getValue(String.class);
                arrayList.remove(string);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot){
                String string = dataSnapshot.getValue(String.class);
                arrayList.remove(string);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s){

            }
            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }
}