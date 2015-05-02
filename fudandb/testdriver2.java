package fudandb;


import java.lang.*;
import java.sql.*;
import java.io.*;
import java.sql.Statement;

public class testdriver2 {

	/**
	 * @param args
	 */

	public static void printMenu(String[] menulist) {
		System.out.println("        Book Store Management System     ");
		int n = menulist.length;
		for (int i = 0; i < n; ++i) {
			System.out.println(Integer.toString(i + 1) + ". " + menulist[i]);
		}
		System.out.println("pleasse enter your choice:");
	}

	public static String readString(BufferedReader in) throws Exception {
		String result = null;
		try {
			while ((result = in.readLine()) == null && result.length() == 0) ;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in reading");
			throw(e);
		}
		return result;
	}

	public static int readInt(BufferedReader in) throws Exception{
		int result = 0;
		try{
            String str = readString(in);
			result = Integer.parseInt(str);
		}catch (Exception e){
			System.out.println("Invalid number");
		}
		return result;
	}

	public static void printResultSet(ResultSet resultset){

	}

	public static void register(BufferedReader in, Statement stmt) {
		try {
			String username;
			String password;
			System.out.println("please enter the username you want to register:");
			username = readString(in);
			User user = new User();
			while (!user.IsLegalNewUser(username, stmt)) {
				username = readString(in);
				System.out.println("The name is illegal. Please try again.");
			}
			System.out.println("please enter the password.");
			password = readString(in);
			while (!user.IsLegalPassword(password, stmt)) {
				password = readString(in);
				System.out.println("The password is illegal. Please try again");
			}
			user.CreateNewUser(username, password, stmt);
			System.out.println("register finished");
			userPage(username, stmt, in);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unsuccessfully to register.");
		}
	}

	public static void login(BufferedReader in, Statement stmt)
	{
		try {
			String username;
			String password;
			System.out.println("please enter your username:");
			username = readString(in);
			System.out.println("please enter your password:");
			password = readString(in);
			User user = new User();
			if (user.UserCheck(username, password, stmt)) {
				userPage(username, stmt, in);
			}else {
				System.out.println("unvalid username or password.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("Unable to read.");
		}
	}

	public static void bookBrowser(Statement stmt, BufferedReader in) {
		System.out.println("please enter your condition:");
		try {
			String condition = readString(in);
			Book book = new Book();
			ResultSet rs = book.searchByCondition(condition, stmt);
			printResultSet(rs);
		}catch (Exception e){
			System.out.println("Unsuccessful to browse.");
		}
	}

	public static void searchUsefulFeedback(Statement stmt, BufferedReader in) {
		System.out.println("please enter a book which you want the feedbacks for:");
		try {
			String bookname = readString(in);
			Feedback feedback = new Feedback();
			ResultSet rs = feedback.SearchUsefulFeedbackForBook(bookname, stmt);
			printResultSet(rs);
		}catch (Exception e){
			System.out.println("Unsuccessful to search.");
		}
	}

	public static void calculateDegreeOfAuthors(Statement stmt, BufferedReader in) {
		System.out.println("please enter an author name:");
		String author1 = null;
		String author2 = null;
		try {
			author1 = readString(in);
			System.out.println("please enter another author name:");
			author2 = readString(in);
			System.out.print("The degree of author " + author1 + " and " + author2 + " is ");
			Author author = new Author();
			int r = author.calculateDegree(author1, author2, stmt);
			if (r < 0){
				System.out.println("more than 2.");
			}else{
				System.out.println(Integer.toString(r) + ".");
			}
		}catch (Exception e){
			System.out.println("Invalid input.");
		}
	}

	public static void order(String username, Statement stmt, BufferedReader in) {
		Order order = new Order();
		int order_num = order.newOrder(username, stmt);
		String menu[] = {"order a book", "modify the quantity of a book in the order", "book browsing", "finish this order"};
		String choice;
		int c = 0;
		String book;
		int q = 0;
		while (true){
			printMenu(menu);
			try {
                choice = readString(in);
				c = Integer.parseInt(choice);
			} catch (Exception e) {
				continue;
			}
			switch (c){
				case 1:
					System.out.println("please enter the ISBN of the book you want:");
					try {
						book = readString(in);
						order.addABook(order_num, book, stmt);
					} catch (Exception e){
					}
					break;
				case 2:
					System.out.println("please enter the ISBN of the book you want more:");
					try{
                        book = readString(in);
                        System.out.println("please enter the quantity you want of book " + book +":");
                        String quan = readString(in);
                        q = Integer.parseInt(quan);
                        order.increaseQuantity(order_num, book, q, stmt);
					} catch (Exception e){
						System.out.println("Invalid increasing operation.");
					}
					break;
				case 3:
					bookBrowser(stmt, in);
					break;
				case 4:
					return;
				default:
			}
		}
	}

	public static void giveFeedback(String username, Statement stmt, BufferedReader in) {
		try {
			Feedback fb = new Feedback();
			System.out.println("which book you want to give feedback to:");
			String book = readString(in);
			System.out.println("give a score to book " + book + ":");
			String score = readString(in);
			int s = readInt(in);
			System.out.println("please give your comment about this book:");
			String comment = readString(in);
            fb.giveFeedback(username, book, s, comment, stmt);
            System.out.println("Successful to add your feedback");
		} catch (Exception e){
			System.out.println("Invalid Feedback.");
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public static void rateForFeedback(String username, Statement stmt, BufferedReader in) {
		Feedback fb = new Feedback();
		try {
			System.out.println("enter the ISBN of the book you want to rate feedback to:");
			String book = readString(in);
			System.out.println("Here is all the Feedback of this book:");
			ResultSet rs = fb.feedbackOfABook(book, stmt);
			printResultSet(rs);
			System.out.println("enter the id of feedback you want to rate for:");
			int fid = readInt(in);
			System.out.println("enter the rate you want to give to feedback No." + Integer.toString(fid) + ":");
			int rate = readInt(in);
            fb.rateForFeedback(username, fid, rate, stmt);
            System.out.println("Successful to rate.");
		}catch (Exception e){
			System.out.println("Unvalid rate.");
		}
	}

	public static void scoreForUser(String username, Statement stmt, BufferedReader in) {
		UserRate ur = new UserRate();
		try {
			System.out.println("enter the user you want to rate for:");
			String user = readString(in);
			System.out.println("enter the score you want to rate for user " + user + ":");
			int r = readInt(in);
			ur.rateForUser(username, user, r, stmt);
			System.out.println("Successful to rate for " + user + ".");
		} catch (Exception e){
			System.out.println("Unsuccessful to rate.");
		}
	}

	public static void buyingSuggestion(String username, Statement stmt) {
		User user = new User();

	}

	public static void insertBookRecord(Statement stmt, BufferedReader in)
	{

	}

	public static void increaseBookAmout(Statement stmt, BufferedReader in) {

	}

	public static void searchPopularBookPerSemester(Statement stmt, BufferedReader in) {

	}

	public static void searchPopularAuthorPerSemester(Statement stmt, BufferedReader in) {

	}

	public static void searchPopularPublisherPerSemester(Statement stmt, BufferedReader in) {

	}

	public static void searchTrustedUser(Statement stmt) {

	}

	public static void searchUsefulUser(Statement stmt) {

	}

	public static void userPage(String username, Statement stmt, BufferedReader in) {
		String[] menu = {"order a book", "book browsing", "give feedback to a book", "rate for a feedback", "give trust score to a user",
				"search the top n most useful feedback for a book", "get buying suggestion", "calculate the degree of two authos",
				"logout"};
		String choice;
		int c = 0;
		while (true) {
//			displayUserMenu(username);
			printMenu(menu);
			System.out.println("          Welcome, " + username);
			try {
                choice = readString(in);
				c = Integer.parseInt(choice);
			} catch (Exception e) {
				continue;
			}
			/*
				1. order a book
				2. book browser
				3. give feedback to a book
				4. rate for a feedback
				5. give trust score to a user
				6. top n most useful feedback for a book
				7. buying suggestion
				8. degrees of authors
				9. logout
			 */
			switch (c) {
				case 1:
					order(username, stmt, in);
					break;
				case 2:
					bookBrowser(stmt, in);
					break;
				case 3:
					giveFeedback(username, stmt, in);
					break;
				case 4:
					rateForFeedback(username, stmt, in);
					break;
				case 5:
					scoreForUser(username, stmt, in);
					break;
				case 6:
					searchUsefulFeedback(stmt, in);
					break;
				case 7:
					buyingSuggestion(username, stmt);
					break;
				case 8:
					calculateDegreeOfAuthors(stmt, in);
					break;
				case 9:
					return;
				default:
					continue;
			}
		}
	}

	public static void managerPage(Statement stmt, BufferedReader in)
	{
		String choice;
		String menu[] = {"insert a new book record", "arrival of new copies", "book browsing", "search the top n most useful feedback for a book",
						"calculate the degree of two authors", "search the top m most popular books in a semester", "search the top m most popular authors in a semester",
						"search the top m most popular publisher in a semester", "search the m most trusted users", "search the m most useful users",
						"exit manager menu"};
		int c = 0;
		while (true) {
			printMenu(menu);
			try {
                choice = readString(in);
				c = Integer.parseInt(choice);
			} catch (Exception e) {
				continue;
			}
			/*
				1. insert a new book record
				2. arrival of new copies
				3. book browsing
				4. top n most useful feedback for a book
				5. degree of authors
				6. m most popular books in a semester
				7. m most popular authors
				8. m most popular publisher
				9. m most trusted user
				10. m most useful user
				11. exit manager menu
			 */
			switch (c) {
				case 1:
					insertBookRecord(stmt, in);
					break;
				case 2:
					increaseBookAmout(stmt, in);
					break;
				case 3:
					bookBrowser(stmt, in);
					break;
				case 4:
					searchUsefulFeedback(stmt, in);
					break;
				case 5:
					calculateDegreeOfAuthors(stmt, in);
					break;
				case 6:
					searchPopularBookPerSemester(stmt, in);
					break;
				case 7:
					searchPopularAuthorPerSemester(stmt, in);
					break;
				case 8:
					searchPopularPublisherPerSemester(stmt, in);
					break;
				case 9:
					searchTrustedUser(stmt);
					break;
				case 10:
					searchUsefulUser(stmt);
					break;
				case 11:
					System.out.println(".........Exit manager menu.......");
					return;
				default:
					continue;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Example for cs5530");
		Connector con=null;
		String choice;
        String sql=null;
        int c=0;
         try {
			 con = new Connector();
			 System.out.println("Database connection established");

			 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			 String menu[] = {"Register", "Login", "Enter to the manage page", "book browsing", "search the top n most useful feedback for a book",
					 "Calculate the degree of two authors", "exit"};

			 while (c != 7) {
				 printMenu(menu);
				 choice = readString(in);
				 try {
					 c = Integer.parseInt(choice);
				 } catch (Exception e) {
					 continue;
				 }
				 /*
				 	1. register
				 	2. login
				 	3. manager
				 	4. book browser
				 	5. top n useful feedback for a book
				 	6. degree of authors
				 	7. exit
				  */
				 switch (c) {
					 case 1:
						 register(in, con.stmt);
						 break;
					 case 2:
						 login(in, con.stmt);
						 break;
					 case 3:
						 managerPage(con.stmt, in);
						 break;
					 case 4:
						 bookBrowser(con.stmt, in);
						 break;
					 case 5:
						 searchUsefulFeedback(con.stmt, in);
						 break;
					 case 6:
						 calculateDegreeOfAuthors(con.stmt, in);
						 break;
					 case 7:
						 System.out.println("Remeber to pay us!");
						 con.stmt.close();
						 break;
					 default:
						 continue;
				 }
			 }
		 }
         catch (Exception e) {
			 e.printStackTrace();
			 System.err.println("Cannot connect to database server");
		 }
         finally {
			 if (con != null) {
				 try {
					 con.closeConnection();
					 System.out.println("Database connection terminated");
				 } catch (Exception e) { /* ignore close errors */ }
			 }
		 }
	}
}
