
# Problem domain:
Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals.
One of customer stories is to accept deals details from and persist them into DB.

## Run Server:
1. Clone project from github using `` git@github.com:Bader-eng/progressSoft.git``
2. go to ``src/main/resources/application.properties``  inside repo and change the
* ``spring.datasource.url=jdbc:postgresql://localhost:5432/(name for database)``
* ``spring.datasource.username=`` put your username using with database
* ``spring.datasource.password=`` your password
* using ``sudo service postgresql start`` to run database inside terminal
* for logging file go to ``spring.log``

