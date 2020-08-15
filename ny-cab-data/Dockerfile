FROM mysql

#Env variables
#ENV MYSQL_DATABASE=ny_cab_data
#ENV MYSQL_PASSWORD=root
#ENV MYSQL_ROOT_PASSWORD=root


#Copy script file containing data
#into container
COPY ny_cab_data_cab_trip_data_full.sql /docker-entrypoint-initdb.d/

#EXPOSE 3306