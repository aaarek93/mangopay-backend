package org.example.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdeasUtils {

    private static final ModelMapper MAPPER = new ModelMapper();

    public <T> T makeInstanceFromObject(Object dataSource, Class<T> targetInstanceClass) {
        return MAPPER.map(dataSource, targetInstanceClass);
    }

    public <T> Iterable<T> makeInstancesFromObjects(Iterable<?> dataSource, Class<T> targetInstanceClass) {
        List<T> targetInstances = new ArrayList<>();
        for (Object element : dataSource) {
            targetInstances.add(MAPPER.map(element, targetInstanceClass));
        }
        return targetInstances;
    }

    public String generateStringOfLength(int targetStringLength) {
        return RandomString.make(targetStringLength);
    }

}
