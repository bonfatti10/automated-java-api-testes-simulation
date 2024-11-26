package br.com.carlosbonfatti.simulacoes;

import br.com.carlosbonfatti.utils.DadosClientes;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Map;
import static br.com.carlosbonfatti.utils.Constant.BASE_URL;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;

public class PostSimulacaoTest {

    DadosClientes dados = new DadosClientes();

    @Test
    @DisplayName("Quando inserir um novo CPF valido sem restrição Então deve criar uma nova simulação e o status 201 com body enviado")
    public void simulacaoComSucesso() {
        Map body = dados.dadosClientes();

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(BASE_URL + "simulacoes")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    @DisplayName("Quando inserir um CPF ja cadastrado Entao o status deve ser 409 CPF já existente")
    public void cpfDuplicado() {
        Map body = dados.dadosDuplicados();

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(BASE_URL + "simulacoes")
                .then()
                .log().all()
                .statusCode(409)
                .body(containsString("CPF já existente"));
    }

    @Test
    @DisplayName("Quando não inserir um CPF para criar a simulacao  Entao o status é 400")
    public void simulacaoError() {
        Map body = dados.erroDados();

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(BASE_URL + "simulacoes")
                .then()
                .log().all()
                .statusCode(400);
    }
}

