package atlassian.cloud.tutorial.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/helloworld")
    //@IgnoreJwt
    public String helloworld() {
        return "helloworld";
    }

    @ResponseBody
    @RequestMapping(consumes="application/json",
            produces="application/json", value = "/issue_created", method = RequestMethod.POST)
    public String issue_created(@RequestBody String json){
        logger.info(json);

        JSONObject json1 = new JSONObject(json);
        logger.info(json1.getJSONObject("changelog").getJSONArray("items").getJSONObject(4).getString("toString"));


        return "helloworld";
    }
}