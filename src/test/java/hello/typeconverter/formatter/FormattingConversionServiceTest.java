package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService defaultFormattingConversionService = new DefaultFormattingConversionService();

        //컨버터 등록
        defaultFormattingConversionService.addConverter(new IpPortToStringConverter());
        defaultFormattingConversionService.addConverter(new StringToIpPortConverter());
        //포멧터 등록
        defaultFormattingConversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = defaultFormattingConversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        Number number = defaultFormattingConversionService.convert("1,000", Number.class);
        assertThat(number).isEqualTo(1000L);
    }
}
