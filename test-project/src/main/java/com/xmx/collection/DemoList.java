package com.xmx.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author xmx 2017年5月8日上午10:46:22
 */
public class DemoList {

	/**
	 * 1.如果只是遍历集合或者数组，用foreach好些，快些。
	 * 2.如果对集合中的值进行修改，就要用for循环了。其实foreach的内部原理其实也是Iterator,
	 * 但它不能像Iterator一样可以人为的控制，而且也不能调用iterator.remove()；更不能使用下标来访问每个元素，所以不能用于增加，
	 * 删除等复杂的操作。
	 * 
	 * @author xmx 2017年5月8日上午10:54:32
	 */
	public static void foreach() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		// foreach循环
		for (String str : list) {
			System.out.println(str);
		}

		// for循环
		System.out.println("--------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// Iterator循环
		System.out.println("--------------------");
		Iterator<String> str = list.iterator();
		while (str.hasNext()) {
			System.out.println(str.next());
		}
	}

	/**
	 * 集合转数组
	 * 
	 * @author xmx 2017年5月8日上午10:56:53
	 */
	public static void listToArray() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");

		System.out.println("--------------------");
		Object s[] = list.toArray();
		//遍历数组
		for (Object x : s) {
			System.out.println(x.toString());
		}
	}

	public static void main(String[] args) {
//		foreach();
//		listToArray();
		 //实例化arrayList  
        List<Integer> arrayList = new ArrayList<Integer>();  
        //实例化linkList  
        List<Integer> linkList = new LinkedList<Integer>();  
      
        //插入10万条数据  
        for (int i = 0; i < 100000; i++) {  
            arrayList.add(i);  
            linkList.add(i);  
        }  
          
        int array = 0;  
        //用for循环arrayList  
        long arrayForStartTime = System.currentTimeMillis();  
        for (int i = 0; i < arrayList.size(); i++) {  
            array = arrayList.get(i);  
        }  
        long arrayForEndTime = System.currentTimeMillis();  
        System.out.println("用for循环arrayList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");  
          
        //用foreach循环arrayList  
        long arrayForeachStartTime = System.currentTimeMillis();  
        for(Integer in : arrayList){  
            array = in;  
        }  
        long arrayForeachEndTime = System.currentTimeMillis();  
        System.out.println("用foreach循环arrayList 10万次花费时间：" + (arrayForeachEndTime - arrayForeachStartTime ) + "毫秒");  
          
        //用for循环linkList  
        long linkForStartTime = System.currentTimeMillis();  
        int link = 0;  
        for (int i = 0; i < linkList.size(); i++) {  
            link = linkList.get(i);  
        }  
        long linkForEndTime = System.currentTimeMillis();  
        System.out.println("用for循环linkList 10万次花费时间：" + (linkForEndTime - linkForStartTime) + "毫秒");  
          
        //用froeach循环linkList  
        long linkForeachStartTime = System.currentTimeMillis();  
        for(Integer in : linkList){  
            link = in;  
        }  
        long linkForeachEndTime = System.currentTimeMillis();  
        System.out.println("用foreach循环linkList 10万次花费时间：" + (linkForeachEndTime - linkForeachStartTime ) + "毫秒"); 
	}

}
