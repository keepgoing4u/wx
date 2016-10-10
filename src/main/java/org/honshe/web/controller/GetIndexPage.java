package org.honshe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
@Controller
@RequestMapping("get")
public class GetIndexPage {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "test";
    }
}
