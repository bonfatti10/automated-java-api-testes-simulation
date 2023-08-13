package br.com.carlosbonfatti.simulacoes;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static br.com.carlosbonfatti.utils.Constant.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
public class GetRestricaoTest {
    String cpfRestrito = randomCPF();

    @Test
    @DisplayName("Quando consultar CPF sem restrição Então deve retornar status 204 Não possui restrição")
    public void consultarCpfSemRestricao() {
        given()
                .when()
                .get(BASE_URL + "restricoes/" + CPF)
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    @DisplayName("Quando consultar CPF com restrição Então deve retornar status 200 O CPF possui restrição")
    public void consultaCpfRestrito() {
        given()
                .when()
                .get(BASE_URL + "restricoes/" + cpfRestrito)
                .then()
                .statusCode(200)
                .body(containsString("O CPF " + cpfRestrito + " possui restrição"));
    }
}

