# AmazonTest
Basic configuration for Web Automation Framework
# Assumptions
###### Client: www.amazon.com

###### Summary:
_Search a specific Topic and navigate using the above criteria_

###### Test Scenario:
``Given`` I launch the web browser\
``And`` I go to "www.amazon.com" website\
``When`` I search **"Software Test Design"** on the text box\
``And`` press Enter\
``Then`` I should see the results for the **"Software Test Design"** search\
``And`` I should see the Product **"A Practitioner's Guide to Software Test Design"**\
``When`` I go to the product **"A Practitioner's Guide to Software Test Design"**\
``Then`` I should see Displayed the Paperback tab option\
``And`` I should see the Title **"A Practitioner's Guide to Software Test Design"**\
``And`` I should see the **"Add to Cart"** button exist\
``And`` I should see the **"Buy Now"** button exist\
 
 # Run the Test
 The test is running using java 8, maven and testng.
 - [x] make sure you have set the MAVEN and JAVA_HOME environment variables
 ##
 Via maven
 Go to your repository path and run the following command
 ``mvn clean`` and then
 ``mvn test``
