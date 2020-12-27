FROM tomcat:8
COPY target/*.war /usr/local/tomcat/webapps/myweb.war
RUN sed -i 's/port="8080"/port="80"/' /usr/local/tomcat/conf/server.xml
# Added to test webhook
