package br.com.carlosbonfatti.suite;

import br.com.carlosbonfatti.simulacoes.*;
import org.junit.jupiter.api.Test;

class TestSuite {

    @Test
    void postSimulacaoTest() {
        new PostSimulacaoTest().simulacaoComSucesso();
    }

    @Test
    void putSimulacoesCpfTest() {
        new PutSimulacoesCpfTest().atualizaSimulacaoPorCpf();
    }

    @Test
    void getRestricaoCpfTest() {
        new GetRestricaoCpfTest().consultaSimulacaoPorCpf();
    }

    @Test
    void getRestricaoTest() {
        new GetRestricaoTest().consultaCpfRestrito();
    }

    @Test
    void getSimulacoesTest() {
        new GetSimulacaosTest().consultaCpfRestrito();
    }

    @Test
    void deleteSimulacaoTest() {
        new DeleteSimulacaoTest().removeSimulacao();
    }
}
