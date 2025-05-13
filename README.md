## Starting the app:

1. Make sure port 8080 is available on your machine
2. Load project in Intellij Idea
3. Right click Application class in project
4. select run/debug option
5. Open link http://localhost:8080/v1/test to check if app is running

## Endpoints logic
### GET /v1/person
має поверати всі записи з бази даних

### GET /v1/person/{Id}
має поверати персону за номером personId з бази даних. Якщо людини з таким id не існує, має повернути 404: No person with such id is present in database.

### PUT /v1/person/{id}
має оновлювати дані людини з цим id . Всі поля мають містити тільки стандартні латинські символи. Якщо будь-яке поле містить цифри чи нетипові латинські символи, сервіс має відповісти 400 bad request. Поле "gender" може містити тільки male або female. Довжина будь якого поля не має перевищувати 30 символів.

### POST /v1/person
має створювати записи в БД, з тими ж обмеження що і PUT ендпоїнт. Якщо post запит містить id особи, цей id має бути проігноровано, і база даних сама має надати id для нового запису.

### DELETE /v1/person/{id}
має видаляти запис з бази даних за його id . Якщо запису з таким id не існує, має все одно поверати 200 OK