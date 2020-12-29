package com.example.enenrausuario;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class HistorialActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial);

        try{cargaDatos();

        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public void cargaDatos() throws JSONException {
        RequestQueue RQ = Volley.newRequestQueue(this);
        String url = "https://thingspeak.com/channels/614623/field/1.json";
        JsonObjectRequest JOR = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener <JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject channel = response.getJSONObject("channel");
                            TextView canal = (TextView) findViewById(R.id.txt_canal);
                            canal.setText(channel.getString("description"));
                            JSONArray lecturas = response.getJSONArray("feeds");
                            List lista = new ArrayList<String>();
                            ArrayAdapter adp = new ArrayAdapter(HistorialActivity.this, android.R.layout.simple_list_item_1, lista);
                            GridView grilla = (GridView) findViewById(R.id.grilla);
                            grilla.setAdapter(adp);
                            for (int i = lecturas.length() - 11; i < lecturas.length(); i++) {
                                JSONObject ob = lecturas.getJSONObject(i);
                                lista.add(ob.getString("created_at"));
                                lista.add(ob.getString("entry_id"));
                                lista.add(ob.getString("field1"));
                            }
                            adp.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        RQ.add(JOR);
    }
}

