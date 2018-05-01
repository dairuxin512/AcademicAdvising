package csis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import cr.entity.*;
import cr.data.*;
import cr.util.KnowledgeSessionHelper;

public class TestCSOption {
	
	static KieContainer kieContainer;
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	
	static Major csMajor;
	static Course cs161;
	static Course cs162;
	static Course cs247;
	static Course cs248;
	static Course cs333;
	static Course cs225;
	static Course cs235;
	static Course ma166;
	static Course ma156;
	static Course ma236;
	static Course cs435;
	static Course cs379;
	static Course cs484;
	static Course cs343;
	static Course cs237;
	static Course cs630;
	static Course cs631;
	static Course cs634;
	static Course cs355;
	static Course cs429;
	static Course cb100;
	static Course cb300;
	
	
	Student csStudent;
	StudentRecords csStuRecords;
	CourseRecommendation csStuRecommends;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
		
		csMajor = new Major("Computer Science", "CSIS", "CS", 101);
		cs161 = new Course (161, "Programming I", "CSIS");
		cs162 = new Course (162, "Programming II", "CSIS");
		cs247 = new Course (247, "Introduction to Computer Networks", "CSIS");
		cs248 = new Course (248, "Operating Systems Programming", "CSIS");
		cs333 = new Course (333, "Database Managment Systems", "CSIS");
		cs225 = new Course (225, "Web Development", "CSIS");
		cs235 = new Course (235, "Object Oriented Programmin", "CSIS");
		ma156 = new Course (156, "Business Calculus", "MATH");
		ma166 = new Course (166, "Calculus I", "MATH");
		ma236 = new Course (236, "Discrete Mathematics", "MATH");
		cs435 = new Course (435, "Information Security", "CSIS");
		cs379 = new Course (379, "Internship in CSIS", "CSIS");
		cs484 = new Course (484, "Senior Capstone Seminar", "CSIS");
		cs343 = new Course (343, "Software Engineering", "CSIS");
		cs237 = new Course (237, "Data Structures and Algorithms", "CSIS");
		cs630 = new Course (630, "Enterprise and Cloud Computing", "CSIS");
		cs631 = new Course (631, "Distributed and Mobile Computing", "CSIS");
		cs634 = new Course (634, "Software Engineering and Design Patterns", "CSIS");
		cs355 = new Course (355, "Computer Organization and Assembly Language", "CSIS");
		cs429 = new Course (429, "Operating Systems", "CSIS");
		cb100 = new Course (100, "CBE First-Year Seminar", "CBE");
		cb300 = new Course (300, "CBE Professional Skills", "CBE");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		csStudent = new Student (1000000, "Jon", "Micheal"); 
		csStuRecords = new StudentRecords(csStudent, csMajor);
		csStuRecommends = new CourseRecommendation(csStudent);
	}

	@After
	public void tearDown() throws Exception {
		csStudent = null;
		csStuRecords = null;
		csStuRecommends = null;
	}

	@Test
	public void testTo162() {
		sessionStatefull = KnowledgeSessionHelper
				.getStatefulKnowledgeSessionWithCallBack(kieContainer, "ksession-csisrules");
		
		csStuRecords.addRecord("CSIS", 161, 2.0);
		csStuRecords.addRecord("MATH", 156, 2.0);
		csStuRecords.addRecord("CSIS", 162, 3.1);
		csStuRecords.addRecord("MATH", 236, 3.5);
		csStuRecords.addRecord("CSIS", 248, 3.0);
		csStuRecords.addRecord("CSIS", 355, 3.5);
		csStuRecords.addRecord("CSIS", 333, 3.5);
		csStuRecords.addRecord("CBE", 100, 3.5);
		/*
		csStuRecords.addRecord("CSIS", 225, 3.5);
		csStuRecords.addRecord("CSIS", 429, 3.5);
		csStuRecords.addRecord("CSIS", 247, 4.0);
		csStuRecords.addRecord("CSIS", 235, 3.5);
		csStuRecords.addRecord("CSIS", 237, 3.5);
		csStuRecords.addRecord("CSIS", 343, 3.5);

		
		
		csStuRecords.addRecord("MATH", 166, 2.1);
		
		csStuRecords.addRecord("CSIS", 435, 3.5);
		csStuRecords.addRecord("CSIS", 379, 3.5);
		csStuRecords.addRecord("CSIS", 484, 3.5);
		csStuRecords.addRecord("CSIS", 343, 3.5);
		csStuRecords.addRecord("CSIS", 355, 3.5);
		
		csStuRecords.addRecord("CSIS", 634, 3.5);
		csStuRecords.addRecord("CSIS", 630, 3.5);
		csStuRecords.addRecord("CSIS", 631, 3.5);
		*/
		sessionStatefull.insert(csStudent);
		sessionStatefull.insert(csStuRecords);
		sessionStatefull.insert(csStuRecommends);
		sessionStatefull.insert(csMajor);
		sessionStatefull.insert(cs161);
		sessionStatefull.insert(cs162);
		sessionStatefull.insert(cs247);
		sessionStatefull.insert(cs248);
		sessionStatefull.insert(cs333);
		sessionStatefull.insert(cs225);
		sessionStatefull.insert(cs235);
		sessionStatefull.insert(ma156);
		sessionStatefull.insert(ma166);
		sessionStatefull.insert(ma236);
		sessionStatefull.insert(cs435);
		sessionStatefull.insert(cs379);
		sessionStatefull.insert(cs484);
		sessionStatefull.insert(cs343);
		sessionStatefull.insert(cs237);
		sessionStatefull.insert(cs630);
		sessionStatefull.insert(cs631);
		sessionStatefull.insert(cs634);
		sessionStatefull.insert(cs355);
		sessionStatefull.insert(cs429);
		sessionStatefull.insert(cb100);
		sessionStatefull.insert(cb300);
		
		sessionStatefull.fireAllRules();

		System.out.println("**************************");
		csStuRecommends.display();
	}

}
