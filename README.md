
# Proje Başlığı

Bu projenin ne yaptığı ve kimin için olduğu hakkında kısa bir açıklama


# Project Title


How to do Api Automation Tests with RestAssured, Java 1.8, testNg
## Badges


![image](https://user-images.githubusercontent.com/72494835/181259544-2a68bb5c-88bf-4a6d-8dab-fcf0ffe1b930.png) ![Rest-assured](https://user-images.githubusercontent.com/72494835/181260300-9d82f658-df23-42ae-aa66-98fe1aaf40e6.jpeg)


```java

@Test (priority=1)
    public void getUserFirstPage(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("posts");
        System.out.println("Sayfa 1" +":"+response.prettyPrint());
        System.out.println("Status Code"+ ":"+ response.statusCode());

        Assert.assertEquals(response.statusCode(),200,"Correct status...");

        if (response.statusCode() == 200){
            System.out.println("Success");
        }
        else {
            System.out.println("Failed");
        }


    }





```terminal
  To run your tests via terminal;
Open terminal in project home directory and run mvn clean install command.
Then run your test with the mvn test command.

create maven project

macOS with 

mvn archetype:generate  

run with project tests

mvn clean install

after 

mvn test
```

  

  
