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
     * ����ķ��������Ƕ�ά���� 
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
/** ԭ�ģ�
	
	��ִ��TestSuitMain --> ��Run As JUnit Test"��ʱ����ComplexFunctionTest��SimpleFunctionTest������ȫ��ִ��һ�顣
	Parameterized��Parameterized�̳���Suit�����������������Ӧ�ÿ��Բµ�һЩ����ˡ�
	Parameterized���ڲ�����ʵ����Suit��������һ�������࣬���ǿ����ṩ���鹹�캯���Ĳ������ڲ��Բ�ͬ��������΢�е�����ô���˵����
 */

/** �ܽ᣺
	Ҫ����һ����ʹ�ò�ͬ���캯�������н����(��������Ϊ��ͬ���в���)
	�����ڿ�ͷд��@RunWith(Parameterized.class)
	���ϲ������룺
		@Parameters  
    	public static List<String[]> getParams()
	���ڹ��캯����д�ϣ�public TestGenerateParams(String greeting)
	
*/