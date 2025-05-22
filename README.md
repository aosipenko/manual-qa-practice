## Starting the app:

1. Make sure port 8080 is available on your machine
2. Load project in Intellij Idea
3. Right click Application class in project
4. select run/debug option
5. Open link http://localhost:8080/v1/test to check if app is running

## Endpoints logic
### GET /v1/person
list all entries in Persons table

### GET /v1/person/{id}
Returns person by ID as json data. If no such id present - 404: No person with such id is present in database.

### PUT /v1/person/{id}
Updates Perons record by id . May contain only latin characters, no numerics, no null values;

### POST /v1/person
Create Perons. ay contain only latin characters, no numerics, no null values. Id is autoassigned by DB.

### DELETE /v1/person/{id}
Removes record by id
