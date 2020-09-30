package com.maindbcore;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.space.model.SpaceDAO;
import com.space.model.SpaceDAOInterface;
import com.space.model.SpaceVO;

//	import org.json.JSONArray;
//	import org.json.JSONException;
//	import org.json.JSONObject;

//private String spaceId;
//private String memId;
//private String empId;
//private String spaceAddress;
//private Double spaceLng;
//private Double spaceLat;
//private String spaceName;
//private String spaceType;
//private String spaceEquipment;
//private String spaceContain;
//private String spaceRule;
//private String spaceRefund;
//private String spaceStatus;
//private java.sql.Date spaceSignupDate;
//private java.sql.Date spaceOnsaleDate;
//private java.sql.Date spaceOffsaleDate;


public class JSONTestIt {
	
	
	SpaceDAOInterface dao = new SpaceDAO();
	
//	@Test
//	public void test1() throws Exception {
//		
//		SpaceVO spaceVO = new SpaceVO();
//		
//		spaceVO.setSpaceId("SPACE222222");
//		spaceVO.setMemId("mem33333");
//		
//		spaceVO.setEmpId("emp888888");
//		spaceVO.setSpaceAddress("ahahahaha");
//		spaceVO.setSpaceLng(54.24);
//		spaceVO.setSpaceLat(29.42);
//		spaceVO.setSpaceName("holaee");
//		spaceVO.setSpaceType("ddddd");
//		
//		spaceVO.setSpaceEquipment("SPACE_EQUMENT");
//		spaceVO.setSpaceContain("CONTAIN");
//		spaceVO.setSpaceRule("SPACE_RULE");
//		spaceVO.setSpaceRefund("SPACE_REFUND");
//		spaceVO.setSpaceStatus("T");
//		spaceVO.setSpaceSignupDate(java.sql.Date.valueOf("2020-09-11"));
//		spaceVO.setSpaceOnsaleDate(java.sql.Date.valueOf("2020-09-22"));
//		spaceVO.setSpaceOffsaleDate(java.sql.Date.valueOf("2020-09-13"));
//		//dao.insert(spaceVO);
//		
//		
//		// make jackson core
//		ObjectMapper mapper = new ObjectMapper();
//		
//		// transfer
//		String jsonData = mapper.writeValueAsString(spaceVO);
//		
//		System.out.println(jsonData);
//		
//		
//		
//		mapper.writeValue(new FileWriter("/Users/robert/Documents/program/JavaEE/testJSON.txt"),spaceVO);
//	}
	
	
	///////////////////////////////////////////
	
	




	

//		public static void main(String[] args) throws JSONException, ParseException {
//			String jsonStr = "";
//
//			// Data for testing
//			
//			SpaceVO spaceVO = new SpaceVO();
//			List<SpaceVO> spaceList = new ArrayList<SpaceVO>();
//			
//			spaceVO.setSpaceId("SPACE222222");
//			spaceVO.setMemId("mem33333");
//			
//			spaceVO.setEmpId("emp888888");
//			spaceVO.setSpaceAddress("ahahahaha");
//			spaceVO.setSpaceLng(54.24);
//			spaceVO.setSpaceLat(29.42);
//			spaceVO.setSpaceName("holaee");
//			spaceVO.setSpaceType("ddddd");
//			
//			spaceVO.setSpaceEquipment("SPACE_EQUMENT");
//			spaceVO.setSpaceContain("CONTAIN");
//			spaceVO.setSpaceRule("SPACE_RULE");
//			spaceVO.setSpaceRefund("SPACE_REFUND");
//			spaceVO.setSpaceStatus("T");
//			spaceVO.setSpaceSignupDate(java.sql.Date.valueOf("2020-09-11"));
//			spaceVO.setSpaceOnsaleDate(java.sql.Date.valueOf("2020-09-22"));
//			spaceVO.setSpaceOffsaleDate(java.sql.Date.valueOf("2020-09-13"));
			//dao.insert(spaceVO);
			
			
			
//			Book book1 = new Book("Java", 500, "John");
//			Book book2 = new Book("Android", 600, "Allen");
//			List<Book> bookList = new ArrayList<Book>();
//			bookList.add(book1);
//			bookList.add(book2);
//			OrderMaster order = new OrderMaster("111", "david", new Date(), bookList);

//			 Object to JSON
//			jsonStr = new JSONObject(book1).toString();
//			System.out.println("Object to JSON: " + jsonStr);
//			// JSON to Object
//			JSONObject jsonObj = new JSONObject(jsonStr);
//			String name = jsonObj.getString("name");
//			double price = jsonObj.getDouble("price");
//			String author = jsonObj.getString("author");
//			Book myBook = new Book(name, price, author);
//			myBook.show();
//			System.out.println();

//			// List to JSON
//			jsonStr = new JSONArray(bookList).toString();
//			System.out.println("List to JSON: " + jsonStr);
////			// JSON to List
//			List<Book> books = new ArrayList<Book>();
//			JSONArray jsonArray = new JSONArray(jsonStr);
//			for (int i = 0; i < jsonArray.length(); i++) {
//				JSONObject json_book = jsonArray.getJSONObject(i);
//				String book_name = json_book.getString("name");
//				double book_price = json_book.getDouble("price");
//				String book_author = json_book.getString("author");
//				Book book = new Book(book_name, book_price, book_author);
//				books.add(book);
//			}
//			for (Book book : books) {
//				book.show();
//			}
//			System.out.println();

			// Object (with List) to JSON
//			jsonStr = new JSONObject(order).toString();
//			System.out.println("Object (with List) to JSON: " + jsonStr);
////			// JSON to Object (with List)
//			JSONObject orderObj = new JSONObject(jsonStr);
//			String orderId = orderObj.getString("orderId");
//			String customer = orderObj.getString("customer");
//			// Locale.ENGLISH could be needed if current locale != ENGLISH 
//			// pattern letters refers to SimpleDateFormat in Javadoc
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
//					"EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
//			Date date = simpleDateFormat.parse(orderObj.getString("date"));
//			JSONArray jsonArray_books = orderObj.getJSONArray("bookList");
//			List<Book> myBookList = new ArrayList<Book>();
//			for (int i = 0; i < jsonArray_books.length(); i++) {
//				JSONObject json_book = jsonArray_books.getJSONObject(i);
//				String bookName = json_book.getString("name");
//				double bookPrice = json_book.getDouble("price");
//				String bookAuthor = json_book.getString("author");
//				Book book = new Book(bookName, bookPrice, bookAuthor);
//				myBookList.add((book));
//			}
//			OrderMaster myOrder = new OrderMaster(orderId, customer, date, myBookList);
//			myOrder.show();
		//}

	


}
