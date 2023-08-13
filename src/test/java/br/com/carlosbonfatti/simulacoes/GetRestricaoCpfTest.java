package br.com.carlosbonfatti.simulacoes;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static br.com.carlosbonfatti.utils.Constant.BASE_URL;
import static br.com.carlosbonfatti.utils.Constant.CPF;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class GetRestricaoCpfTest {

        @Test
        @DisplayName("Quando consultar uma simulação informando CPF Então deve retornar response body com a simulaçãos solicitada status 200 simulação encontrada")
        public void consultaSimulacaoPorCpf(){
            given()
                    .when()
                    .get(BASE_URL + "simulacoes/" + CPF)
                    .then()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/listarSimulacaoPorCpf.json"));
        }

        @Test
        @DisplayName("Quado consultar uma simulação informando CPF invalido  Então deve retornar status 404 cpf nao encontrado")
        public void consultaSimulacaoPorCpfInvalido(){
            given()
                    .when()
                    .get(BASE_URL + "simulacoes/" + 2023)
                    .then()
                    .statusCode(404)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/consultaSimulacaoCpfInvalido.json"));
        }
}
