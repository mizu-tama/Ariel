package com.gmail.mizuno.tamaki.binary_search_tree;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
		assertThat(tree.toString(), is("<<<2>3<4>>6<<6_2>7<<9>13<13>>>>15<<17>18<20>>"));
	}
	
	@Test
	public void searchTest() {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void iteratorTest() {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void deleteTest() {
		// TODO Auto-generated method stub

	}
	
}
