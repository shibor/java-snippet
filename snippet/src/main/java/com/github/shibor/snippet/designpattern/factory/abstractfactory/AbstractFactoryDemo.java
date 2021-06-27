package com.github.shibor.snippet.designpattern.factory.abstractfactory;

import java.util.Scanner;

/**
 *
 * 抽象工厂
 *
 *
 * <p>
 * 提供一个接口，用于创建**相关的或依赖对象的家族**，而不需要明确指定具体类。
 * </p>
 *
 * <p>
 * 抽象工厂模式的起源或者最早的应用，是用于创建分属于不同操作系统的视窗构建。
 * 比如：命令按键（Button）与文字框（Text)都是视窗构建，在UNIX操作系统的视窗环境和Windows操作系统的视窗环境中，这两个构建有不同的本地实现，它们的细节有所不同
 * </p>
 *
 * @author shibor
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入加密包（AES,XXX）：");
        String type = in.next();
        SecurityFacfory securityFacfory;
        if ("AES".equals(type)) {
            securityFacfory = new AESSecurityFacfory();
        } else if ("XXX".equals(type)) {
            securityFacfory = new XXXSecurityFacfory();
        } else {
            System.out.println("不支持");
            return;
        }

        Encryptor encryptor = securityFacfory.getEncryptor();
        Decipherer decipherer = securityFacfory.getDecipherer();
        encryptor.encrypt("abcdef");
        decipherer.decipher("secret");
    }
}


interface SecurityFacfory {

    /**
     * 获得加密器
     *
     * @return
     */
    Encryptor getEncryptor();

    /**
     * 获得解密器
     *
     * @return
     */
    Decipherer getDecipherer();
}

interface Encryptor {
    /**
     * 加密
     *
     * @param text
     */
    void encrypt(String text);
}

interface Decipherer {
    /**
     * 解密
     */
    void decipher(String text);
}


class AESencryptor implements Encryptor {

    @Override
    public void encrypt(String text) {
        System.out.println("AES加密");
    }
}

class AESdecipherer implements Decipherer {
    @Override
    public void decipher(String text) {
        System.out.println("AES解密");
    }
}

class AESSecurityFacfory implements SecurityFacfory {

    @Override
    public Encryptor getEncryptor() {
        return new AESencryptor();
    }

    @Override
    public Decipherer getDecipherer() {
        return new AESdecipherer();
    }
}


class XXXencryptor implements Encryptor {

    @Override
    public void encrypt(String text) {
        System.out.println("XXX加密");
    }
}

class XXXdecipherer implements Decipherer {
    @Override
    public void decipher(String text) {
        System.out.println("XXX解密");
    }
}

class XXXSecurityFacfory implements SecurityFacfory {

    @Override
    public Encryptor getEncryptor() {
        return new XXXencryptor();
    }

    @Override
    public Decipherer getDecipherer() {
        return new XXXdecipherer();
    }
}

