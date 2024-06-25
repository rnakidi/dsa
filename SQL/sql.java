https://github.com/RachelPengmkt/SQL-Practice/blob/master/Leetcode-178.%20Rank%20Scores.sql

https://github.com/ChenglongChen/LeetCode-3/blob/master/MySQL/consecutive-numbers.sql

https://leetcode.com/problems/combine-two-tables/?envType=list&envId=e97a9e5mSELECT p.firstName, p.lastName, a.city, a.state from Person p LEFT OUTER JOIN Address a on p.personId = a.personId

https://leetcode.com/problems/second-highest-salary/?envType=list&envId=e97a9e5m
SELECT salary as SecondHighestSalary FROM Employee e1WHERE 1 = (SELECT COUNT(DISTINCT salary) FROM Employee e2WHERE e2.salary > e1.salary)

SELECT max(Salary) as SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT max(Salary) FROM Employee)

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N,1
  );
END

https://leetcode.com/problems/rank-scores/?envType=list&envId=e97a9e5m
Method 1:

SELECT Score, DENSE_RANK() OVER (PARTITION BY Score ORDER BY Score DESC) AS Rank
FROM Scores


Method 2:
SELECT S2.Score, (SELECT COUNT(DISTINCT S1.Score) FROM Scores S1 WHERE S1.Score >= S2.Score ) AS Rank
FROM Scores S2
ORDER BY Rank

Department Highest Salary
https://leetcode.com/problems/department-highest-salary/?envType=list&envId=e97a9e5m
SELECT Department.Name AS Department, e1.Name AS Employee, e1.Salary AS SalaryFROM Department JOIN Employee e1 ON Department.Id = e1.DepartmentIdWHERE e1.Salary = (SELECT Max(Salary) FROM Employee e2 WHERE e2.DepartmentId = e1.DepartmentId)

Consecutive Numbers
https://leetcode.com/problems/consecutive-numbers/?envType=list&envId=e97a9e5m
select l1.num as ConsecutiveNums from Logs l1, Logs l2, Logs l3where l1.id + 1 = l2.id and l2.id + 1 = l3.id and l1.num=l2.num and l2.num=l3.num;
Employee and Manage from same tableSELECT E.first_name AS "Employee Name", (SELECT M.first_name FROM employees M WHERE E.manager_id = M.employee_id) AS "Manager"FROM employees E;

SELECT E.first_name AS "Employee Name", M.first_name AS "Manager"FROM employees EJOIN employees M ON E.manager_id = M.employee_id;Employees Earning More Than Their Managershttps://leetcode.com/problems/employees-earning-more-than-their-managers/description/?envType=list&envId=e97a9e5mselect e.name as Employee from Employee e JOIN Employee m on e.managerId = m.id and e.salary > m.salary
Duplicate Emailshttps://leetcode.com/problems/duplicate-emails/?envType=list&envId=e97a9e5mselect email from (select email, count(email) as count from Person group by email having count >=2) as e;select email from (select email, count(email) as count from Person group by email) as e where count >= 2Customers who never orderedhttps://leetcode.com/problems/customers-who-never-order/?envType=list&envId=e97a9e5mselect name as Customers from Customers where id not in(select distinct customerId from Orders)Department Top Three Salariehttps://leetcode.com/problems/department-top-three-salaries/?envType=list&envId=e97a9e5mSELECT d.name as Department, e.name as Employee, e.salary from Employee e JOIN Department d on e.departmentId = d.id where (select count(distinct salary) from Employee e1 where e1.departmentId = e.departmentId and  e1.salary > e.salary) < 3 order by e.DepartmentId, e.salary DESC;Delete Duplicate Emailshttps://leetcode.com/problems/delete-duplicate-emails/?envType=list&envId=e97a9e5mdelete from Person where id not in (select min(id) from Person group by email)
delete p1 from Person p1, Person p2 where p1.email=p2.email and p1.id > p2.idRaising Temperatureshttps://leetcode.com/problems/rising-temperature/?envType=list&envId=e97a9e5mselect w1.id from Weather w1, Weather  w2 where w1.temperature  > w2.temperature  and TO_DAYS(w1.recordDate) - TO_DAYS(w2.recordDate) = 1Trips and usershttps://leetcode.com/problems/trips-and-users/?envType=list&envId=e97a9e5mselect t.request_at as Day, round(sum(case when t.status='completed' then 0 else 1 end)/count(*), 2) as 'Cancellation Rate' from Trips t join Users u on t.client_id = u.users_id  and u.banned='No' where t.request_at between '2013-10-01' and '2013-10-03' group by t.request_at;Find Customer Refereehttps://leetcode.com/problems/find-customer-referee/?envType=list&envId=e97a9e5mselect name from customer where id not in (select id from Customer where referee_id =2)Customers Placing the Largest Numbers of Ordershttps://leetcode.com/problems/customer-placing-the-largest-number-of-orders/?envType=list&envId=e97a9e5m
# Write your MySQL query statement belowSELECT customer_number FROM ordersGROUP BY customer_numberORDER BY COUNT(customer_number) DESC LIMIT 1;


Big Countrieshttps://leetcode.com/problems/big-countries/?envType=list&envId=e97a9e5m
SELECT name, population, areaFROM WorldWHERE area >= 3000000 OR population >= 25000000;
Classes More than 5 Studentshttps://leetcode.com/problems/classes-more-than-5-students/?envType=list&envId=e97a9e5m

SELECT classFROM CoursesGROUP BY classHAVING count(class) >= 5
Human Traffic of Stadiumhttps://leetcode.com/problems/human-traffic-of-stadium/?envType=list&envId=e97a9e5m

SELECT s1.* FROM Stadium s1, Stadium s2, Stadium s3WHERE ((s1.id + 1 = s2.id AND s2.id + 1 = s3.id) OR (s1.id - 1 = s2.id AND s1.id + 1 = s3.id) OR (s1.id - 1 = s2.id AND s1.id - 2 = s3.id))AND s1.people >= 100 and s2.people >= 100 AND s3.people >= 100GROUP BY s1.idORDER BY visit_date
Sales Personshttps://leetcode.com/problems/sales-person/?envType=list&envId=e97a9e5m
SELECT nameFROM SalesPersonWHERE sales_id not in    (SELECT sales_id    FROM Orders where com_id in (SELECT com_id from Company where name like 'RED'))

Tree Nodehttps://leetcode.com/problems/tree-node/?envType=list&envId=e97a9e5m
select distinct a.id,   case when a.p_id is null then 'Root'        when b.id is null then 'Leaf'        else 'Inner'     end as typefrom tree aleft join tree b on a.id = b.p_idorder by a.id

Not Boring Movies https://leetcode.com/problems/not-boring-movies/?envType=list&envId=e97a9e5m

SELECT * from Cinemawhere mod(id, 2)=1 and description!='boring'order by id desc
Exchange SeatsSELECT ( CASE            WHEN id%2 != 0 AND id != counts THEN id+1            WHEN id%2 != 0 AND id = counts THEN id            ELSE id-1        END) AS id, studentFROM seat, (select count(*) as counts from seat) AS seat_countsORDER BY id ASC
Swap Salaryhttps://leetcode.com/problems/swap-salary/?envType=list&envId=e97a9e5m
UPDATE salary set sex = CASE sex                 WHEN 'm' then 'f'                else 'm'                END;
Actors and Directorshttps://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/?envType=list&envId=e97a9e5m
SELECT actor_id, director_idFROM ActorDirectorGROUP BY actor_id, director_idHAVING count(*) >= 3
Sales Analysis IIIhttps://leetcode.com/problems/sales-analysis-iii/description/?envType=list&envId=e97a9e5m
select product_id, product_name from Product where product_id not in (select distinct product_id from Sales where sale_date not between '2019-01-01' and '2019-03-31')
