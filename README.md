# PerScholasProject
This is an online pharmacy store for ordering antidepressants, ADHD and Anti anxiety meds.It is a full stack web application.

This is a dynamic website Spring MVC project built using the following technologies:

Java 8 Spring MVC Spring Security using BCrypt password encryption Servlets/JSP HTML5/CSS3/Bootstrap JavaScript jQuery SQL utilizing a MySQL database Hibernate ORM JSTL

The website was built using the Spring MVC framework utilizing controllers and DAO patterns that communicate with a MySQL backend using a Hibernate ORM framework. The website is secured using Spring Security authentication and authorization functionality utilizing user roles. The view layer consists of JSP pages that are styled using CSS3.

A user is initially presented with a landing page where they can login or register for access. If registering, they are given a default role of "USER" which is the role with the least access.Spring Security functionality restricts access to parts of the website and specific functionality based on the user's role. If a user attempts to access a restricted resource, they are presented with a custom access denied error page.

USER STORIES

As a user I want to be able to log in so that I can view the products avalable.

As a user I want to be able to Sign Up so I can have an account to sign in and order products.

As an I would like to log into my account so I can add new products.

As a user I want to be able to check the status of my order.

TECHNICAL CHALLENGES AND STEPS TO OVERCOME IT 1. 2.
