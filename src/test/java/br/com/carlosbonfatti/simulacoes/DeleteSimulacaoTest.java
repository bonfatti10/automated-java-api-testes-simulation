package br.com.carlosbonfatti.simulacoes;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static br.com.carlosbonfatti.utils.Constant.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class DeleteSimulacaoTest {

    @Test
    @DisplayName("Quando solicitar mocao de simulacao por CPF  Então deve retornar 204")
    public void removeSimulacao(){
        given()
                .when()
                .delete(BASE_URL + "simulacoes/" + ID)
                .then()
                .statusCode(204);
    }

    @Test
    @DisplayName("Quando solicitar mocao de simulacao por CPF não cadastrado Então deve retornar 404")
    public void removerSimulacaoNaoEncontrada(){

        given()
                .when()
                .delete(BASE_URL + "simulacoes/" + IDERROR)
                .then()
                .statusCode(404)
                .body(containsString("Simulação não encontrada"));
    }
}

