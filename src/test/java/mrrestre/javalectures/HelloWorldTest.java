package mrrestre.javalectures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    public void should_give_hello_world(){
        //Given
        HelloWorld helloWorld = new HelloWorld();

        //When
        String hello = helloWorld.sayHello();

        //Then
        assertEquals("Hello World", hello);
    }
}
