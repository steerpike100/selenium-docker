FROM openjdk:8u191-jre-alpine3.8

#Workspace
WORKDIR /udemy/seleniumdocker

# ADD .jar under target location from host
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
#In case of any other dependency like .csv .json .xls, 
#ADD here using ADD

#ADD suite files
ADD search-module.xml search-module.xml

#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE