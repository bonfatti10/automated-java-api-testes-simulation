package br.com.carlosbonfatti.suite;

import br.com.carlosbonfatti.simulacoes.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PostSimulacaoTest.class,
        PutSimulacoesCpfTest.class,
        GetRestricaoCpfTest.class,
        GetRestricaoTest.class,
        GetSimulacaosTest.class,
        DeleteSimulacaoTest.class
})
public class TestSuite {
}
