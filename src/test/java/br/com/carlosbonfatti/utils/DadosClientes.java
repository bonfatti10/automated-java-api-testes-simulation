package br.com.carlosbonfatti.utils;

import static br.com.carlosbonfatti.utils.Constant.CPF;
import net.datafaker.Faker;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DadosClientes {
    Faker faker = new Faker(new Locale("pt-BR"));
    public Map dadosClientes() {
        Map<String, Object> params = new HashMap<>();
        params.put("nome", faker.name().fullName());
        params.put("cpf", faker.cpf().valid().replace(".", "").replace("-", ""));
        params.put("email", faker.internet().emailAddress());
        params.put("valor", faker.number().numberBetween(1000, 40000));
        params.put("parcelas", faker.number().numberBetween(2, 48));
        params.put("seguro", true);
        return params;
    }

    public Map dadosDuplicados() {
        Map<String, Object> params = new HashMap<>();
        params.put("nome", faker.name().fullName());
        params.put("cpf", "97093236014");
        params.put("email", faker.internet().emailAddress());
        params.put("valor", faker.number().numberBetween(1000, 40000));
        params.put("parcelas", faker.number().numberBetween(2, 48));
        params.put("seguro", true);
        return params;
    }

    public Map atualizaDados() {
        Map<String, Object> params = new HashMap<>();
        params.put("nome", "Atualizando Cliente");
        params.put("cpf", CPF );
        params.put("email", faker.internet().emailAddress());
        params.put("valor", faker.number().numberBetween(1000, 40000));
        params.put("parcelas", faker.number().numberBetween(2, 48));
        params.put("seguro", true);
        return params;
    }

    public Map erroDados() {
        Map<String, Object> params = new HashMap<>();
        params.put("nome", "Atualizando Cliente");
        params.put("email", faker.internet().emailAddress());
        params.put("valor", faker.number().numberBetween(1000, 40000));
        params.put("parcelas", faker.number().numberBetween(2, 48));
        params.put("seguro", true);
        return params;
    }

}

