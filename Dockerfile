FROM tomcat:8
COPY target/*.war /usr/local/tomcat/webapps/myweb.war
RUN value=`cat conf/server.xml` && echo "${value//8080/8081}" >| conf/server.xml
# Added to test webhook
