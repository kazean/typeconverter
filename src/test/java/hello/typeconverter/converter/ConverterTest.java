package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    void stringToInteger() throws Exception{
        //given
        StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();
        //when
        Integer result = stringToIntegerConverter.convert("10");
        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void integerToString() throws Exception{
        //given
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        //when
        String result = integerToStringConverter.convert(10);
        //then
        assertThat(result).isEqualTo("10");
    }
    
    @Test
    public void stringToIpPort() throws Exception{
        //given
        StringToIpPortConverter stringToIpPortConverter = new StringToIpPortConverter();
        //when
        IpPort result = stringToIpPortConverter.convert("127.0.0.1:8080");
        //then
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    public void ipPortToString() throws Exception{
        //given
        IpPortToStringConverter ipPortToStringConverter = new IpPortToStringConverter();
        //when
        String result = ipPortToStringConverter.convert(new IpPort("127.0.0.1", 8080));
        //then
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

}
