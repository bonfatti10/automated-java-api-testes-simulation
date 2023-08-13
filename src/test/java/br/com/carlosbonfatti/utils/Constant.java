package br.com.carlosbonfatti.utils;

import io.restassured.http.ContentType;
public interface Constant {

    String BASE_URL = "http://localhost:8080/api/v1/";
    String CPF = "66414919004";
    String CPFERROR = "66414919005";
    String ID = "12";
    String IDERROR = "150";
    ContentType CONTENT_TYPE = ContentType.JSON;
    Long MAXI_TIMEOUT = 500L;

    static String randomCPF() {
        int r = (int) (Math.random()*10);
        String CPF_RESTRITO = new String [] {"97093236014", "60094146012", "84809766080", "62648716050", "26276298085", "01317496094", "55856777050", "19626829001", "24094592008", "58063164083"}[r];
        return CPF_RESTRITO;
    }

};