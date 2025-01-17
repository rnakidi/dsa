package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * The Class Student.
 */
class Student {

 /** The id. */
 private int id;
 
 /** The first name. */
 private String firstName;
 
 /** The last name. */
 private String lastName;
 
 /** The age. */
 private int age;
 
 /** The gender. */
 private String gender;
 
 /** The departmant name. */
 private String departmantName;
 
 /** The joined year. */
 private int joinedYear;
 
 /** The city. */
 private String city;
 
 /** The rank. */
 private int rank;

 /**
  * Instantiates a new employee.
  *
  * @param id the id
  * @param firstName the first name
  * @param lastName the last name
  * @param age the age
  * @param gender the gender
  * @param departmantName the departmant name
  * @param joinedYear the joined year
  * @param city the city
  * @param rank the rank
  */
 public Student(int id, String firstName, String lastName, int age, String gender, String departmantName,
   int joinedYear, String city, int rank) {
  super();
  this.id = id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.age = age;
  this.gender = gender;
  this.departmantName = departmantName;
  this.joinedYear = joinedYear;
  this.city = city;
  this.rank = rank;
 }

 /**
  * Gets the id.
  *
  * @return the id
  */
 public int getId() {
  return id;
 }

 /**
  * Sets the id.
  *
  * @param id the new id
  */
 public void setId(int id) {
  this.id = id;
 }

 /**
  * Gets the first name.
  *
  * @return the first name
  */
 public String getFirstName() {
  return firstName;
 }

 /**
  * Sets the first name.
  *
  * @param firstName the new first name
  */
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 /**
  * Gets the last name.
  *
  * @return the last name
  */
 public String getLastName() {
  return lastName;
 }

 /**
  * Sets the last name.
  *
  * @param lastName the new last name
  */
 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 /**
  * Gets the age.
  *
  * @return the age
  */
 public int getAge() {
  return age;
 }

 /**
  * Sets the age.
  *
  * @param age the new age
  */
 public void setAge(int age) {
  this.age = age;
 }

 /**
  * Gets the gender.
  *
  * @return the gender
  */
 public String getGender() {
  return gender;
 }

 /**
  * Sets the gender.
  *
  * @param gender the new gender
  */
 public void setGender(String gender) {
  this.gender = gender;
 }

 /**
  * Gets the departmant name.
  *
  * @return the departmant name
  */
 public String getDepartmantName() {
  return departmantName;
 }

 /**
  * Sets the departmant name.
  *
  * @param departmantName the new departmant name
  */
 public void setDepartmantName(String departmantName) {
  this.departmantName = departmantName;
 }

 /**
  * Gets the joined year.
  *
  * @return the joined year
  */
 public int getJoinedYear() {
  return joinedYear;
 }

 /**
  * Sets the joined year.
  *
  * @param joinedYear the new joined year
  */
 public void setJoinedYear(int joinedYear) {
  this.joinedYear = joinedYear;
 }

 /**
  * Gets the city.
  *
  * @return the city
  */
 public String getCity() {
  return city;
 }

 /**
  * Sets the city.
  *
  * @param city the new city
  */
 public void setCity(String city) {
  this.city = city;
 }

 /**
  * Gets the rank.
  *
  * @return the rank
  */
 public int getRank() {
  return rank;
 }

 /**
  * Sets the rank.
  *
  * @param rank the new rank
  */
 public void setRank(int rank) {
  this.rank = rank;
 }

 /**
  * To string.
  *
  * @return the string
  */
 @Override
 public String toString() {
  return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
    + ", gender=" + gender + ", departmantName=" + departmantName + ", joinedYear=" + joinedYear + ", city="
    + city + ", rank=" + rank + "]";
 }

}
public class TestStreams {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
			    new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
			    new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
			    new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
			    new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
			    new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
			    new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
			    new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
			    new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
			    new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
			    new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
		
		// 1- Find list of students whose first name starts with alphabet A
		List<Student> students = list.stream().filter(x -> x.getFirstName().startsWith("A")).collect(Collectors.toList());
		System.out.println(students);
		
		// 2- Group The Student By Department Names
		Map<String, List<Student>> sMap = list.stream().collect(Collectors.groupingBy(x -> x.getDepartmantName()));
		System.out.println(sMap);
		
		// 3- Find the total count of student using stream
		long count = list.stream().count();
		System.out.println(count);
		
		// 4- Find the max age of student
		OptionalInt maxAge = list.stream().mapToInt(x -> x.getAge()).max();
		System.out.println(maxAge.getAsInt());
		int mAge = list.stream().mapToInt(x -> x.getAge()).max().getAsInt();
		System.out.println(mAge);
		mAge = list.stream().map(x -> x.getAge()).max(Integer::compareTo).orElseGet(() -> -1);
		System.out.println(mAge);
		
		// 5- Find all departments names
		List<String> deptNames = list.stream().map(x -> x.getDepartmantName()).distinct().collect(Collectors.toList());
		System.out.println(deptNames);
		
		 // 6- Find the count of student in each department
		Map<String, Long> depCounts = list.stream().collect(Collectors.groupingBy(x -> x.getDepartmantName(), Collectors.counting()));
		System.out.println(depCounts);
		
		// 7- Find the list of students whose age is less than 30
		students = list.stream().filter(x -> x.getAge() < 30).collect(Collectors.toList());
		System.out.println(students);
		
		// 8- Find the list of students whose rank is in between 50 and 100
		students = list.stream().filter(x -> x.getRank() > 50 && x.getRank() < 100).collect(Collectors.toList());
		System.out.println(students);
		
		// 9- Find the average age of male and female students
		Map<String, Double> genderMap = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		System.out.println(genderMap);
		
		// 10- Find the department who is having maximum number of students
		Map.Entry<String, Long> maximum = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
			.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(maximum);
		
		// 11- Find the Students who stays in Delhi and sort them by their names
		List<Student> delhiStudents = list.stream().filter(x -> "Delhi".equalsIgnoreCase(x.getCity())).sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
		System.out.println(delhiStudents);
		
		// 12- Find the average rank in all departments
		Map<String, Double> depAvgRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
		System.out.println(depAvgRank);
		
		// 13- Find the highest rank in each department
		Map<String, Optional<Student>> depHighRank = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));
		System.out.println(depHighRank);
		
		// 14- Find the list of students and sort them by their rank
		List<Student> sortByRank = list.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
		System.out.println(sortByRank);
		
		// 15- Find the student who has second rank
		Student st = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
		System.out.println(st);
	}
}

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringUtil {
	public String removeDuplicateChars(String str) {
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		//HashSet<Character> set = new HashSet<>(); // Order not guaranteed
		for (char ch : str.toCharArray()) {
			//if (set.contains(ch)) {
				//set.remove(ch);
			//}
			
			set.add(ch);
		}
		
		String ans = "";
		for (char ch : set) {
			ans += ch;
		}
		
		return ans;
	}
	
	public String removeDuplicate(String str) {
		String ans = "";
		for (char ch : str.toCharArray()) {
			if (ans.indexOf(ch) == -1) {
				ans += ch;
			}
		}
		
		return ans;
	}
	
	public void  removeDuplicateUsingStream(String str) {
		str.chars().distinct().forEach(x -> System.out.print((char) x));
		System.out.println();
		str.chars().sorted().forEach(x -> System.out.print((char) x));
		System.out.println();
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		int x = list.stream().max(Integer::compareTo).orElseGet(() -> -1);
		System.out.println(x);
		x = list.stream().min(Integer::compareTo).orElseGet(() -> -1);
		System.out.println(x);
		long y = list.stream().count();
		System.out.println(y);
		list.stream().limit(5).forEach(System.out::print);
		List<String> names = List.of("Test", "Get", "put", "post");
		List<String>  res = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(res);
		str.chars().limit(3).forEach(z -> System.out.print((char) z));
		List<Integer> dup = List.of(1, 1, 2, 1, 2, 3, 4, 4, 5);
		System.out.println();
		dup.stream().distinct().forEach(System.out::print);
		System.out.println(dup.stream().mapToInt(Integer::intValue).sum());
		IntSummaryStatistics  iss = dup.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println();
		System.out.println(iss.getCount());
		System.out.println(iss.getAverage());
		System.out.println(iss.getSum());
		System.out.println(iss.getMax());
		System.out.println(iss.getMin());
		long cnt = Optional.ofNullable(dup).get().stream().count();
		System.out.println("Count=" + cnt);
		dup.stream().filter(t -> t == 1).mapToInt(Integer::intValue).forEach(System.out::print);
		System.out.println();
		List<List<Integer>> listOfList = new ArrayList<>();

		listOfList.add(dup);
		listOfList.add(List.of(90, 100, 200, 300, 400));
		int max = listOfList.stream().flatMap(a -> a.stream()).max((a,b) -> a-b).orElseGet(() -> -1);
		System.out.println(max);
		max = listOfList.stream().flatMap(a -> a.stream()).max((a,b) -> a-b).orElseGet(() -> -1);
		System.out.println(max);
		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
		int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
		System.out.println("sum=" + sum);
	}
}
public class MyString {

	public static void main(String[] args) {
		StringUtil util = new StringUtil();
		String ans = util.removeDuplicateChars("geeksforgeeks");
		System.out.println(ans);
		ans = util.removeDuplicate("geeksforgeeks");
		System.out.println(ans);
		
		util.removeDuplicateUsingStream("geeksforgeeks");
	}

}



https://medium.com/@mehar.chand.cloud/java-stream-coding-interview-questions-part-1-dc39e3575727
