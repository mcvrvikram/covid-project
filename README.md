# Simple Covid Tracker

## Developer 

**Vikram C**

A passionate developer from India

***Connect me on*** [LinkedIn](https://www.linkedin.com/in/mcvrvikram/)

## Overview
Covid Tracker project tracks all the covid active cases and deaths all around the world.
## Tools Used
1. Eclipse: An IDE to code for the application 

2. Java: A programming language to develop the prototype 

3. Thymeleaf: To create view layer

4. Maven: A build tool for adding all the external dependencies

5. Git: To connect and push files from the local system to GitHub 

6. GitHub: To store the application code and track its versions 

7. Jenkins: To build CI/CD pipelines

8. Docker: To deploy jar in a container to access it from EC2

9. AWS: To deploy the application

## Data Structures & Techniques Used
1. Spring Boot : Popular Java Framework to acheive inversion of control and dependency injection

2. Spring MVC : Model View Controller by Spring

3. Thymeleaf : A popular template engine to design view layer

## Application Flow Chart

![Flow Chart](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/Flowchart.PNG)

## Step by Step Build Process

### 1. Create a Java Project
Create a simple Spring project using Eclipse and Maven and push it to GitHub

#### Sample Output
![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/run-java-in-aws-ec2.PNG)

### 2. Configure Jenkins
 Create a new task and use Git repository as source code management
 
![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/jenkins-git-configure.PNG)

  Select Poll SCM option in order to let jenkins start a new build whenever there is a change in git repository
  
![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/Jenkins-CI-config.PNG)

Then add Docker configuration, to build and publish the image to docker hub

![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/jenkins-docker-config.PNG)

### 3. Jenkins Build Application

After all the configuration is done, click build now and wait the magic

![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/jenkins-build-success.PNG)


![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/jenkins-build-success-2.PNG)

We can also see that Jenkins has build our jar and pushed it as a docker image to the docker hub

![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/jenkins-docker-success.PNG)

### 4. Deploy Application in Amazon EC2
* Create a linux EC2 instance and launch it
* Then pull the docker image from docker hub using command 'docker pull userid/imageid'
* Run the docker image using command 'docker run -p portnumber:portnumber imageid
![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/deploy-docker-image-jar-file-ec2.PNG)

### Run Jar in AWS EC2
* Once our application is launched in linux EC2 instance, we can go to our EC2 instance and copy the public IP
* Launch our application using the URL publicIP:portnumber and That's it!

![output page1](https://github.com/mcvrvikram/sporty-shoes/blob/main/SportyShoes/run-java-in-aws-ec2.PNG)

