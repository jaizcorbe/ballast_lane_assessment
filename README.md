# Ballast Lane assessment project
## Run project
* This project has integrated the springboot service which also serves the static content with the angular front end
* To run the service to the project folder and run with
```mvn spring-boot:run```

## Project Use
* Only students can be created from the UI.
* The application runs with an In memory sql db.  All the data is lost when the service is stopped
* An admin user and a student user are bootstrapped when the application starts
  * Admin user: admin@ballastlane.com
  * Student user: student@ballastlane.com
* The admin APIs receive the admin id to secure its access
* The UI hides the admin functionality when a Student is logged in

## missing features from assessment spec
* Task Category is implemented as a java enum instead of a lookup table
* worklog update UI is not implemented (the API is available)
* the worklog is accessible when clicking on a course registration but the worklog list shows items for any registration

## features to consider
* Login is implemented as a simple id in the initial application view.  It would be much better to be implemented with 
* An authentication schema available with spring security (e.g. BasicAuth, JWT, etc).
* The UI should be improved.  Bootstrap might be used for this
* Student and Admin should be refactored to have a User and Student and Admin might be modelled as authorization roles
