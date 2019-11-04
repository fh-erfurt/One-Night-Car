package de.ahmad.javalecture;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class HelloWorldTest {

    @Test
    public void should_gives_hello_world(){
        //given
        HelloWorld helloWorld = new HelloWorld();

        //when
        String hello = helloWorld.sayHello();

        //then
        assertEquals("Hello World", hello);

    }
}
