/******************************************************************
 * LamdaExpression.java
 * Copyright 2017 by GNNT Company. All Rights Reserved.
 * CreateDate��2017��6��1��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.meek.realTest_2017_06.interFace.Beautiful;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��1��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LamdaExpression {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("--------------------------------qaq");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_lamda() {
		Beautiful b = () -> {System.out.println("��ΪʲôҪ��ҩ���������������ˣ�");return "�ó�ҩ�ˣ��������˴�ƿ��";};
		System.out.println(b.show());
//		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
	}
	
	@Test
	public void _02_event() {
		JButton show = new JButton("Show");
		show.addActionListener((e) -> {String x = e.getActionCommand();System.out.println("ddd" + x);});
	}
	
	@Test
	public void _03_foreach() {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach((em) -> System.out.println(em+"233"));
		features.forEach(System.out::println);
	}
	
	@Test
	public void _04_Predicate() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//		filter(languages,(str) -> str.startsWith("J"));
		filter2(languages, (str)->((String) str).startsWith("S"));
		List<String> l = filter3(languages, (str)->((String) str).startsWith("S"));
		l.forEach(System.out::println);
		filter4(languages);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param names
	 * @param object 
	 */
	private void filter4(List<String> names) {
		names.stream().filter((name) -> {
			if(null == name)
				return false;
			else if(name.startsWith("J"))
				return true;
			return false;
		}).forEach(filtedName -> System.out.println("filter4---------> " + filtedName));
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * תΪList����<br>
	 * </ul>
	 * @param names
	 * @param object 
	 * @return 
	 */
	private List<String> filter3(List<String> names, Predicate<String> cdn) {
		return names.stream().filter((name) -> cdn.test(name))
				.collect(Collectors.toList());
		
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����filter����<br/>
	 * </ul>
	 * @param languages
	 * @param object 
	 */
	private void filter2(List<String> languages, Predicate<String> condition) {
		languages.stream().filter(condition).forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t + " xxx");
			}
		});
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ԭ��filter
	 * </ul>
	 * @param names
	 * @param condition
	 */
	public static void filter(List<String> names, Predicate<String> condition) {
	    names.stream().filter( name -> condition.test(name) )
	    .forEach((name) -> {
	        System.out.println(name + " ");
	    });
	}
	
	
	@Test
	public void _05_SummaryStatistics() {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		DoubleSummaryStatistics sta = primes.stream().mapToDouble(x -> x).summaryStatistics();
		System.out.println(String.format("���:%1$s	��С:%2$s		ƽ��:%3$s", sta.getMax() , sta.getMin() , sta.getAverage() ));
	}
	
	
	
	
	
	
	
}
