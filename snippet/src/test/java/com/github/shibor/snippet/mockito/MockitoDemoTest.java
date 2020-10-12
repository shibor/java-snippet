package com.github.shibor.snippet.mockito;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoDemoTest {

    @Test

    public void testGetValue() {

        Data dataMock = Mockito.mock(Data.class);

        Mockito.when(dataMock.getData()).thenReturn(100);
        MockitoDemo mockitoDemo = new MockitoDemo();
        mockitoDemo.setData(dataMock);

        int value = mockitoDemo.getValue();
        Mockito.verify(dataMock,Mockito.times(1)).getData();
        System.out.println(value);



    }
}
