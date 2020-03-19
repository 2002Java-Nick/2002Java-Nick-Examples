package com.revature.test;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.util.SessionFactoryUtil;

public class SessionFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		SessionFactoryUtil.setConfigFileLocationToTest();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SessionFactory sf = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
		assertNotNull(sf);
	}

}
