# Run project
* This project has integrated the springboot service which also serves the static content with the angular front end
* To run the service to the project folder and run with
```mvn spring-boot:run```

## missing features from assessment spec
* Task Category is implemented as a java enum instead of a lookup table
* worklog update UI is not implemented (the API is available)
* the worklog is accessible when clicking on a course registration but the worklog list shows items for any registration

## features to consider
* Login is implemented as a simple id in the initial application view.  It would be much better to be implemented with 
* An authentication schema available with spring security (e.g. BasicAuth, JWT, etc).
* The UI should be improved.  Bootstrap might be used for this
