package br.com.movimentosmanuais;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class BaseTest {
    protected <T> T carregaDadosViaJson(T objeto, String jsonName) {
        InputStream resouceValue = null;
        try {
            resouceValue = new DefaultResourceLoader().getResource("classpath:" + jsonName + ".json").getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            objeto = (T) objectMapper.readValue(resouceValue, objeto.getClass());
            return objeto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
