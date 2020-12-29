package com.example.enenrausuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MonitorizaciondeHumo extends AppCompatActivity {

    Button button_volvermenu2;
    LineChart mpLineChart;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    //LineDataSet lineDataSet = new LineDataSet(null,null);
    //ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    //LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitorizacionde_humo);


            //funcion botones
        button_volvermenu2=(Button)findViewById(R.id.button_volvermenu2);
        button_volvermenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MonitorizaciondeHumo.this,Menu.class);
                startActivity(intent);
            }
        });
        //Grafico lineal
        mpLineChart=(LineChart) findViewById(R.id.line_chart2);
        LineDataSet lineDataSet1= new LineDataSet(dataValues1(),"Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

        //Codigo para leer datos desde firebase a grafico
         //   firebaseDatabase = FirebaseDatabase.getInstance();
           // myRef= firebaseDatabase.getReference("Nombre en la base de datos o nodo EJEMPLO :   SENSORES/HUMO");
                // lineDataSet.setLineWidth(4);
            //mostrarDatos();
    }

   // private void mostrarDatos() {
     //   myRef.addValueEventListener(new ValueEventListener() {
       //     @Override
         //   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           //     ArrayList<Entry> dataVals = new ArrayList<Entry>();
             //   if(dataSnapshot.hasChildren()){
               //     for(DataSnapshot myDataSnapshot : dataSnapshot.getChildren()){
                 //       Datapoint datapoint = myDataSnapshot.getValue(Datapoint.class);
                   //     dataVals.add(new Entry(datapoint.getxValue(), datapoint.getyValue()));
                 //   }
                   // showChart(dataVals);
                //}else{
                 //   mpLineChart.clear();
                  //  mpLineChart.invalidate();
              //  }
           // }

            //@Override
            //public void onCancelled(@NonNull DatabaseError error) {

            //}
        //});

    // }

   // private void showChart(ArrayList<Entry> dataVals) {

            //lineDataSet.setValues(dataVals);
            //lineDataSet.setLabel("DataSet1 Prueba");
            //iLineDataSets.clear();
            //iLineDataSets.add(lineDataSet);
           // lineData = new LineData(iLineDataSets);
         //   mpLineChart.clear();
       //     mpLineChart.setData(lineData);
     //       mpLineChart.invalidate();
   // }

    private ArrayList<Entry> dataValues1 ()
    {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,20));
        dataVals.add(new Entry(0,24));
        dataVals.add(new Entry(2,2));
        dataVals.add(new Entry(3,10));
        dataVals.add(new Entry(4,28));

        return dataVals;

    }
}