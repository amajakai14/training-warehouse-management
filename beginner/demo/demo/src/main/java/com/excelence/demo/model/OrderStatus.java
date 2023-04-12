package com.excelence.demo.model;

import java.util.stream.Stream;

//Enum(列挙型)とは、複数の定数をひとつにまとめておくことができる型のことです。
//Enumで定義する定数のことを列挙子と呼びます。
public enum OrderStatus {
    PENDING,
    COMPLETED,
    CANCELLED;

    //staticメソッド
    //Javaの通常メソッドは、クラスをインスタンス化してから使います。
    //しかし、staticメソッドの場合、インスタンス化せずに使用できます。
    public static boolean validOf(String text) {
        return Stream.of(values())
                .map(OrderStatus::name)
                .anyMatch(text::equals);
    }
}
