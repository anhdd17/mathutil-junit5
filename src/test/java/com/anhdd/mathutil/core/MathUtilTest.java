/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.anhdd.mathutil.core;

import static com.anhdd.mathutil.core.MathUtil.*;
import java.lang.reflect.Executable;
//import static là dành riêng cho những hàm static
//gọi hàm mà bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author DUC ANH
 */
public class MathUtilTest {
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(24, getFactorial(4));
//    }
    
    //bắt ngoại lệ khi đưa data cà chớn!!!!
    //@Test(expected = tên ngoại lệ.classs, JUnit 4 hoy, Junit 5 ko xài vậy
    
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //xài biểu thức lambda
        //hàm nhận tham số thứ 2 là 1 cái bên object/có code implement cái functional interface tên là Excutable - có 1 hàm duy nhất ko code tên là execute();
        assertThrows( IllegalArgumentException.class, () -> getFactorial(-5));
    }
    
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 120},
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") // tên hàm cung cấp data và ngầm định thứ tự của các phần tử của mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
}
