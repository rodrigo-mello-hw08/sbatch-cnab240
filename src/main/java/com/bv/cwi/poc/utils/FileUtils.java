package com.bv.cwi.poc.utils;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

@UtilityClass
public class FileUtils {

    public static String getSqlFromResource(Resource resource) throws IOException {
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(bytes);
    }

}
