CREATE TABLE flashcards (

   id serial PRIMARY KEY,
   question VARCHAR (1000) NOT NULL,
   answer VARCHAR (1000) NOT NULL
   
);

INSERT INTO flashcards (question, answer) 
VALUES ('What are the benefits to Object Oriented Programming?', 
        '1.) Modular development of code, which leads to easy maintenance and modification. 2.) Reusability of code. 3.) Improved reliability and flexibility of code. 4.)Increased understanding of code.');
INSERT INTO flashcards (question, answer) 
VALUES ('Define encapsulation', 
        'Encapsulation provides objects with the ability to hide their internal characteristics and behavior. Each object provides a number of methods, which can be accessed by other objects and change its internal data. In Java, there are three access modifiers: public, private, and protected');
