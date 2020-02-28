package com.desafiolatam.preguntadinamica.api;



import com.desafiolatam.preguntadinamica.model.RespuestaApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

        //aca le digo que tiene que hacer, a que entpoint tiene que ir
    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<RespuestaApi> getQuestion();
}
