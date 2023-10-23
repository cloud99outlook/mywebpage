FROM tomcat:9
ADD webpage.jar /usr/local/tomcat/webapps
CMD ["catalina.sh", "run"]
EXPOSE 8080