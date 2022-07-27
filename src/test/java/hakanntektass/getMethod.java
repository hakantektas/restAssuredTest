package hakanntektass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getMethod {

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

    @Test (priority = 2)
    public void getUserSecondPage(){

        RestAssured.baseURI="https://reqres.in/api/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("users?page=2");
        System.out.println("Sayfa 2" +":"+response.prettyPrint());

    }

    @Test (priority = 3)
    public void postMethod(){

        RestAssured.baseURI="https://reqres.in/api/";

        RequestSpecification httpRequest = RestAssured.given();


        JSONObject reqParams = new JSONObject();
        reqParams.put("name","Ahmet");
        reqParams.put("job","QA Tester");

        httpRequest.body(reqParams.toJSONString());
        Response response = httpRequest.post("users");
        ResponseBody body = response.getBody();

        System.out.println("Post method Create user"+":" + response.statusCode());
        System.out.println("Post method Create user" + response.prettyPrint());

    }

    @Test (priority = 4)
    public void assertMethod(){

        RestAssured.baseURI="https://reqres.in/api/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("users/4");
        JsonPath jsonP = response.jsonPath();

        String name = jsonP.get("data.first_name");
        System.out.println("Name bilgisi" +":"+ name);

        Assert.assertEquals(name,"Eve","Beklediğim user geldi");

        System.out.println("Sayfa 2" +":"+response.prettyPrint());

        ResponseBody body = response.getBody();

        String bodyAsstring = body.asString();

        Assert.assertEquals(bodyAsstring.contains("holt"),true);

    }
    @Test (priority = 5)
    public void postMethod_1(){

        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";

        RequestSpecification httpRequest = RestAssured.given();


        JSONObject reqParams = new JSONObject();
        reqParams.put("title","fss");
        reqParams.put("body","dede");
        reqParams.put("userId","1");

        httpRequest.body(reqParams.toJSONString());
        Response response = httpRequest.post("posts");
        ResponseBody body = response.getBody();

        System.out.println("Post method Create user"+":" + response.statusCode());
        System.out.println("Post method Create user" + response.prettyPrint());

    }

}
