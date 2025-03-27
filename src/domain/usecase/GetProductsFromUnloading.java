package domain.usecase;

import domain.entities.ProductsFromUnloading;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetProductsFromUnloading {
    public static ArrayList<ProductsFromUnloading> getProductsFromUnloading(String path, String fileName) throws IOException {
        File currentFile = new File(path, fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(currentFile, new TypeReference<>(){});
    }
}
