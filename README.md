Aplication allows to create book list. User has a opportunity to add, delete or update book list. Entered data is validated by Server.

Technology: Spring, Hibernate, JSP (MVC Model)

Funcionalities
1. Adding, deleting and updating books. (from form)  
2. Adding, deleting and updating list of authors.(from form)
3. Adding, deleting and updating list of publishers.(from form)

Book list (core funcionality)

Controller: Book Controller
Method: BookDao

Entity book is related to entities Author and Publisher. (relation Many to Many - to Author and Many to One - to Publisher)

Book list presents choosen data from all entities. 

Planned developments
1. Improving design using Bootstrap.
2. Adding new funcionality - Searcher. User will have opportunity to find correct book indicating criteria. 
