package br.com.carlosbonfatti.simulacoes;

import br.com.carlosbonfatti.utils.DadosClientes;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;

import static br.com.carlosbonfatti.utils.Constant.*;
import static br.com.carlosbonfatti.utils.Constant.CPFERROR;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class PutSimulacoesCpfTest {
    DadosClientes dados = new DadosClientes();

    @Test
    @DisplayName("Quando realizar atualização em um CPF ja cadastrado Então deve retornar 200 com body atualizado")
    public void atualizaSimulacaoPorCpf(){

        Map body = dados.atualizaDados();

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(BASE_URL + "simulacoes/" + CPF)
                .then()
                .statusCode(200)
                .body(containsString("Atualizando Cliente"));
    }

    @Test
    @DisplayName("Quando realizar tentar atualizar um CPF não cadastrado Então deve retornar 404 com mensagem CPF não encontrado")
    public void atualizaSimulacaoCpfNaoCadastrado(){

        Map body = dados.atualizaDados();

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(BASE_URL + "simulacoes/" + CPFERROR)
                .then()
                .statusCode(404)
                .body(containsString("CPF " + CPFERROR + " não encontrado"));
    }

}
