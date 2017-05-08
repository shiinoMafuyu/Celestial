package com.celestial.misdirection.JunitPlay;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGenerateParams {
    private String greeting;  
    
    public TestGenerateParams(String greeting)  
    {  
        super();  
        this.greeting = greeting;  
    }  
   
    @Test  
    public void testParams()  
    {  
        System.out.println(greeting);  
    } 
    
    /** 
     * 这里的返回至少是二维数组 
     * @return 
     */  
    @Parameters  
    public static List<String[]> getParams()  
    {  
        return  
                Arrays.asList(new String[][]{{"hello"},   
                        {"hi"},   
                        {"good morning"},  
                        {"how are you"}});  
    }
}
/** 原文：
	
	在执行TestSuitMain --> “Run As JUnit Test"的时候会把ComplexFunctionTest和SimpleFunctionTest的用例全部执行一遍。
	Parameterized：Parameterized继承自Suit，从这个身世和名字应该可以猜到一些因果了。
	Parameterized是在参数上实现了Suit——修饰一个测试类，但是可以提供多组构造函数的参数用于测试不同场景。略微有点抽象，用代码说话：
 */

/** 总结：
	要测试一个类使用不同构造函数的运行结果，(可以引申为不同运行参数)
	可以在开头写上@RunWith(Parameterized.class)
	加上参数输入：
		@Parameters  
    	public static List<String[]> getParams()
	再在构造函数上写上：public TestGenerateParams(String greeting)
	
*/