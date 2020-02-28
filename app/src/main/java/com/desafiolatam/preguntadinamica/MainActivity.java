package com.desafiolatam.preguntadinamica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.desafiolatam.preguntadinamica.api.Api;
import com.desafiolatam.preguntadinamica.api.RetrofitClient;
import com.desafiolatam.preguntadinamica.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String primeraCosa, segundaCosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializo las vistas.


        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                primeraCosa = response.body().getResults().get(0).getQuestion();
                segundaCosa = response.body().getResults().get(0).getCartegory();
                initializeFragment(primeraCosa, segundaCosa);



            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Algo Fallo, intentelo despues", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initializeFragment(String cosa1, String cosa2){

        FristFragment firstFragment = FristFragment.newInstance(cosa1,cosa2);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, firstFragment, "FIRSTFRAGMENT")
                .commit();
    }

    }

