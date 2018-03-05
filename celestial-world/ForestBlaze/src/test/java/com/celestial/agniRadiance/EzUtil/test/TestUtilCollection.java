package com.celestial.agniRadiance.EzUtil.test;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.EzUtil.test.entity.Equip;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("rawtypes")
public class TestUtilCollection {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void _01_replaceList(){
		int start = 1,end =2;
		List<String> l = Arrays.asList(new String[]{"0","1","2","3","4","5","6","7","8","9"});
		System.out.println(l.get(start)+","+l.get(end));
		List re = UtilCollection.replaceList(l, start, end, Arrays.asList(new String[]{"love","shiino","mafuyu"}));
		System.out.println(re);
		Assert.assertEquals(re, Arrays.asList(new String[]{"0","1","love","shiino","mafuyu","2","3","4","5","6","7","8","9"}));
	}
	
	
	@Test
	public void _02_put(){
		Equip e = new Equip().setRepresentId("01").setName("真白");
		Equip[] eArr = new Equip[]{e,new Equip().setRepresentId("02").setName("真冬"),
									new Equip().setRepresentId("01").setName("真名"),
									new Equip().setRepresentId("02").setName("真霜")};
		List<Equip> l = new ArrayList<Equip>();for(Equip ei:eArr){l.add(ei);}
		List<Equip> l2 = new ArrayList<Equip>();l2.add(e);
		
		Map<String,List<Equip>> m = new HashMap<String,List<Equip>>();
		
		
		m.put("01", l2);
		try {
			for(Equip ei : l){
				UtilCollection.put2MapList(m, ei.getRepresentId(), ei);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Assert.assertEquals(m.get("02").size(), 2);
		Assert.assertEquals(m.get("01").size(), 3);
		
	}
	
	@Test
	public void _03_isIn(){
		String[] sArr = new String[]{"minori","kurise",null,"yuki"};
		Assert.assertTrue(UtilCollection.isIn(sArr,"yuki"));
		Assert.assertTrue(UtilCollection.isIn(sArr,null));
		Assert.assertFalse(UtilCollection.isIn(sArr,"lingos"));
	}
	
	@Test
	public void _04_listRemoveElem(){
		List<String> list = Arrays.asList(new String[]{"minori","kurise",null,"yuki"});
		List<String> l2 = UtilCollection.listRemoveElem(list, 0,2);
		Assert.assertTrue("kurise".equals(l2.get(0)) && "yuki".equals(l2.get(1)));
	}
	
	@Test
	public void _05_01_transListToArrm(){
		List<String> list = Arrays.asList(new String[]{"minori","kurise",null,"yuki"});
		
		
		String[] sArr = new String[]{};
		sArr = (String[])UtilCollection.transListToArr(list,sArr);
		for(int i = 0 ;i < list.size();i++){
			boolean b = UtilString.equal(list.get(i),sArr[i]);
			Assert.assertTrue(b);
		}
		
		List<File> fList = Arrays.asList(new File[]{new File("minori"),new File("kurise"),new File("null"),new File("yuki")});
		File[] fArr = new File[]{};
		fArr = (File[])UtilCollection.transListToArr(fList,fArr);
		for(int i = 0 ;i < list.size();i++){
			boolean b = UtilString.equal(list.get(i),sArr[i]);
			Assert.assertTrue(b);
		}
		
	}
	
	@Test
	public void _05_02_transListToArrm(){
		List<String> list = Arrays.asList(new String[]{"minori","kurise",null,"yuki"});
		String[] sArr = new String[]{};
		sArr = list.toArray(sArr);
		for(int i = 0 ;i < list.size();i++){
			boolean b = UtilString.equal(list.get(i),sArr[i]);
			Assert.assertTrue(b);
		}
		
		String temp = sArr[0];
		sArr[0] = sArr[1];
		sArr[1] = temp;
		Assert.assertEquals(sArr[0], "kurise");
		Assert.assertEquals(sArr[1], "minori");
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	@Test
	public void testSort() {
		List<Person> list = Arrays.asList(new  Person[]{
				new Person().setAge(2),
				new Person().setAge(12),
				new Person().setAge(6),
				new Person().setAge(0),
				new Person().setAge(4),
		});
		
		List<Person> resList = UtilCollection.sort(list, "age", UtilCollection.SortWay.ASC);
		Assert.assertTrue(resList.get(0).getAge().equals(0));
		Assert.assertTrue(resList.get(resList.size() - 1).getAge().equals(12));
		
		list = Arrays.asList(new  Person[]{
				new Person().setIQ((short)2),
				new Person().setIQ((short)12),
				new Person().setIQ((short)6),
				new Person().setIQ((short)0),
				new Person().setIQ((short)4),
		});
		resList = UtilCollection.sort(list, "IQ", UtilCollection.SortWay.ASC);
		Assert.assertTrue(resList.get(0).getIQ() == (short)0);
		Assert.assertTrue(resList.get(resList.size() - 1).getIQ() == (short)12);
		
		
		list = Arrays.asList(new  Person[]{
				new Person().setName("2"),
				new Person().setName("12"),
				new Person().setName("6"),
				new Person().setName("0"),
				new Person().setName("4"),
		});
		
		resList = UtilCollection.sort(list, "name", UtilCollection.SortWay.DESC);
		Assert.assertTrue(resList.get(0).getName().equals("12"));
		Assert.assertTrue(resList.get(resList.size() - 1).getName().equals("0"));
	}
	
	@Test
	public void testSortByTime() {
		long time = 0;
		List<Person> list = Arrays.asList(new  Person[]{
				new Person().setEndTime(new Timestamp(time+200)),
				new Person().setEndTime(new Timestamp(time+100)),
				new Person().setEndTime(new Timestamp(time)),
				new Person().setEndTime(new Timestamp(time)),
				new Person().setEndTime(new Timestamp(time+300))	
		});
		
		List<Person> resList = UtilCollection.sortByTime(list, "endTime", UtilCollection.SortWay.DESC);
		Assert.assertTrue(resList.get(4).equals(list.get(2)));
		Assert.assertTrue(resList.get(0).equals(list.get(4)));
		
		list = Arrays.asList(new  Person[]{
				new Person().setEndTime(new Timestamp(time+200)),
				new Person().setEndTime(new Timestamp(time+100)),
				new Person().setEndTime(null),
				new Person().setEndTime(new Timestamp(time+100)),
				new Person().setEndTime(new Timestamp(time+300))	
		});
		resList = UtilCollection.sortByTime(list, "endTime", UtilCollection.SortWay.DESC);
		Assert.assertTrue(resList.get(4).equals(list.get(2)));
		Assert.assertTrue(resList.get(0).equals(list.get(4)));
		
		
		/** date类型 */
		list = Arrays.asList(new  Person[]{
				new Person().setBirthday(new Date(time+2000)),
				new Person().setBirthday(new Date(time+1000)),
				new Person().setBirthday(new Date(time)),
				new Person().setBirthday(new Date(time)),
				new Person().setBirthday(new Date(time+3000))	
		});

		resList = UtilCollection.sortByTime(list, "birthday", UtilCollection.SortWay.DESC);
		Assert.assertTrue(resList.get(4).equals(list.get(2)));
		Assert.assertTrue(resList.get(0).equals(list.get(4)));

		list = Arrays.asList(new  Person[]{
				new Person().setBirthday(new Date(time+2000)),
				new Person().setBirthday(new Date(time+1000)),
				new Person().setBirthday(null),
				new Person().setBirthday(new Date(time+1000)),
				new Person().setBirthday(new Date(time+3000))	
		});
		resList = UtilCollection.sortByTime(list, "birthday", UtilCollection.SortWay.DESC);
		Assert.assertTrue(resList.get(4).equals(list.get(2)));
		Assert.assertTrue(resList.get(0).equals(list.get(4)));
		
		
		
		
	}
	
	
	
	class Person{
		private int age;
		private Double hight;
		private String name;
		private Date birthday;
		private Timestamp endTime;
		private short IQ;
		
		public Integer getAge() {
			return age;
		}
		public Double getHight() {
			return hight;
		}
		public String getName() {
			return name;
		}
		public Date getBirthday() {
			return birthday;
		}
		public short getIQ() {
			return IQ;
		}
		public Person setAge(Integer age) {
			this.age = age;
			return this;
		}
		public Person setHight(Double hight) {
			this.hight = hight;
			return this;
		}
		public Person setName(String name) {
			this.name = name;
			return this;
		}
		public Person setBirthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}
		public Person setIQ(short iQ) {
			IQ = iQ;
			return this;
		}
		
		public Timestamp getEndTime() {
			return endTime;
		}
		public Person setEndTime(Timestamp endTime) {
			this.endTime = endTime;
			return this;
		}
		public Person setAge(int age) {
			this.age = age;
			return this;
		}
		@Override
		public String toString() {
			return "Person [age=" + age + ", hight=" + hight + ", name=" + name
					+ ", birthday=" + birthday + ", endTime=" + endTime + ", IQ="
					+ IQ + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + IQ;
			result = prime * result + age;
			result = prime * result
					+ ((birthday == null) ? 0 : birthday.hashCode());
			result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
			result = prime * result + ((hight == null) ? 0 : hight.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (IQ != other.IQ)
				return false;
			if (age != other.age)
				return false;
			if (birthday == null) {
				if (other.birthday != null)
					return false;
			} else if (!birthday.equals(other.birthday))
				return false;
			if (endTime == null) {
				if (other.endTime != null)
					return false;
			} else if (!endTime.equals(other.endTime))
				return false;
			if (hight == null) {
				if (other.hight != null)
					return false;
			} else if (!hight.equals(other.hight))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
		
		
	}
	
	@Test
	public void testUtil_nullChoose(){
		Long val1 = 3L,val2 = null;
		
		Assert.assertTrue(val1.equals(UtilCollection.nullChoose(val2, val1)));
		Assert.assertTrue(val1.equals(UtilCollection.nullChoose(val2, val2,val1)));
		Assert.assertTrue(val1.equals(UtilCollection.nullChoose(val1, val2,val1)));
		Assert.assertTrue(val1.equals(UtilCollection.nullChoose(val2, val2,val2,val1)));
		
		Assert.assertTrue(val2 ==UtilCollection.nullChoose(val2, val2,val2,val2) );
	}
	
	@Test
	public void testDeepCopyArr() {
		String[] sarr = new String[]{"1","2","3"};
		String[] sarr2 = UtilCollection.deepCopyArr(sarr);
		sarr[1] = "我";
		Assert.assertTrue("我".equals(sarr[1]));
		Assert.assertTrue("2".equals(sarr2[1]));
	}
}
