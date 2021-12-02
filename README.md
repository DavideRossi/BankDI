# BankDI
This is a simple example of the application of the Dependency Injection Pattern.
A few branches are provided to show the “evolution” of the basic code presented in the main branch (select “view all branches” from the drop down menu in the main project page to see all available branches).
* interfaces - shows the extraction of interfaces for the concrete dependencies
* constructor_di - shows the use of “Pure” Dependency Injection by using constructor injection.
* guice - shows the use of guice to manage the binding in the composition root (BankModule class)
* guice_factory - shows the use of factory injection to solve runtime bindings.

The exercise is not about advanced use of Guice and its features, the proposed solutions are meant to be good-but-basic and applicable to different frameworks.
