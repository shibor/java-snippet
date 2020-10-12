package com.github.shibor.snippet.mockito;

/**
 * 验证mockito
 * @author shibor
 */
public class MockitoDemo {


    private Data data;

    public MockitoDemo() {
        this.data = new Data();
    }

    public int getValue() {
        return this.data.getData();
    }

    public void setData(Data data) {
        this.data = data;
    }
}


class Data {

    public int getData() {
        return 0;
    }
}