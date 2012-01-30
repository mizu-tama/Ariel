package com.gmail.mizuno.tamaki.binary_search_tree;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.Test;

public class BinarySearchTreeTest {

	private static BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
	
	@Test
	public void addTest() {
		assertThat(tree.toString(), is(""));
		tree.add(15, "15");
		assertThat(tree.toString(), is("15"));
		tree.add(6, "6");
		assertThat(tree.toString(), is("<6>15"));
		tree.add(3, "3");
		assertThat(tree.toString(), is("<<3>6>15"));
		tree.add(18, "18");
		assertThat(tree.toString(), is("<<3>6>15<18>"));
		tree.add(2, "2");
		assertThat(tree.toString(), is("<<<2>3>6>15<18>"));
		tree.add(4, "4");
		assertThat(tree.toString(), is("<<<2>3<4>>6>15<18>"));
		tree.add(20, "20");
		assertThat(tree.toString(), is("<<<2>3<4>>6>15<18<20>>"));
		tree.add(7, "7");
		assertThat(tree.toString(), is("<<<2>3<4>>6<7>>15<18<20>>"));
		tree.add(13, "13");
		assertThat(tree.toString(), is("<<<2>3<4>>6<7<13>>>15<18<20>>"));
		tree.add(17, "17");
		assertThat(tree.toString(), is("<<<2>3<4>>6<7<13>>>15<<17>18<20>>"));
		tree.add(9, "9");
		assertThat(tree.toString(), is("<<<2>3<4>>6<7<<9>13>>>15<<17>18<20>>"));
	}
	
	@Test
	public void addSameKeyTest() {
		tree.add(13, "13_2");
		assertThat(tree.toString(), is("<<<2>3<4>>6<7<<9>13<13_2>>>>15<<17>18<20>>"));
		tree.add(6, "6_2");
		assertThat(tree.toString(), is("<<<2>3<4>>6<<6_2>7<<9>13<13_2>>>>15<<17>18<20>>"));
	}
	
	@Test
	public void searchTest() {
		assertThat(tree.search(7), is("7"));
		assertThat(tree.search(15), is("15"));
		assertThat(tree.search(6), is("6"));
	}
	
	
	@Test
	public void deleteTest() {
		assertThat(tree.delete(6), is("6"));
		assertThat(tree.toString(), is("<<<2>3>4<<6_2>7<<9>13<13_2>>>>15<<17>18<20>>"));
		assertThat(tree.delete(3), is("3"));
		assertThat(tree.toString(), is("<<2>4<<6_2>7<<9>13<13_2>>>>15<<17>18<20>>"));
		assertThat(tree.delete(17), is("17"));
		assertThat(tree.toString(), is("<<2>4<<6_2>7<<9>13<13_2>>>>15<18<20>>"));
	}
	
	@Test
	public void iteratorTest() {
		tree.add(10, "10");
		
		Iterator<Integer> it = tree.iterator();

		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(2));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(4));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(6));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(7));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(9));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(10));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(13));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(13));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(15));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(18));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(20));
		assertThat(it.hasNext(), is(false));
	}
	
	@Test
	public void deleteTest2() {
		assertThat(tree.toString(), is("<<2>4<<6_2>7<<9<10>>13<13_2>>>>15<18<20>>"));
		assertThat(tree.delete(7), is("7"));
		assertThat(tree.toString(), is("<<2>4<6_2<<9<10>>13<13_2>>>>15<18<20>>"));
		assertThat(tree.delete(6), is("6_2"));
		assertThat(tree.toString(), is("<<2>4<<9<10>>13<13_2>>>15<18<20>>"));
		assertThat(tree.delete(10), is("10"));
		assertThat(tree.toString(), is("<<2>4<<9>13<13_2>>>15<18<20>>"));
	}
}
