Main types of paginations:

1. Offset pagination
   - This us the simplest approach, using OFFSET and LIMIT clauses in SQL to retieve data in batches.
   - Inefficient for large data sets as it requires the database to scan through all previous rows.
   - SELECT * FROM users LIMIT 10 OFFSET 20 - retrieves 10 users starting from the 21'st user.
     
2. Keyset pagination(also called cursor pagination)
   - This technique uses a "cursor" or "keyset"  - a unique identifier(like an ID or timestamp)
     to track the last item of the previous page.
   - It's most efficient as it avoids scanning through all previous rows.
    
3. Numbered pagination
   - This represnts the data in serious of pages with page numbers, allowing useers to navigate to specific pages.
   - It's user freindly but may not be as efficient as offset or keyset paginations fopr very large datasets.
