@echo ON

REM Creates the resources for the Glassfish server

REM The server must be running for the script to run

REM create the JDBC connection pool
asadmin create-jdbc-connection-pool --datasourceclassname=org.apache.derby.jdbc.ClientDataSource --restype=javax.sql.DataSource --property=portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=dishwareStoreDB:connectionAttributes=;create\=true DishwareStorePool

REM ping the connection pool
asadmin ping-connection-pool DishwareStorePool

REM create the data source
asadmin create-jdbc-resource --connectionpoolid DishwareStorePool jdbc/dishwareStoreDS

REM list the data sources
asadmin list-jdbc-resources
