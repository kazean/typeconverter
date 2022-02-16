package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        Integer intValue = Integer.valueOf(source);
        log.info("intValue={}",intValue);
        return intValue;
    }
}
