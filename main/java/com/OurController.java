package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OurController {

    @Autowired
    private Route route;
    @Autowired
    private Service service;
    @Autowired
    private Step step;


    private void initRandomValues() {
        route.setId("1");
        List<Step> steps = new ArrayList();
        route.setSteps(steps);

        Step step1 = new Step();
        Step step2 = new Step();
        Step step3 = new Step();
        Step step4 = new Step();

        step1.setId(1L);
        step2.setId(2L);
        step3.setId(3L);
        step4.setId(4L);


        List paramsToCall = new ArrayList();

        Service serviceFrom = new Service(1, "Mozir", paramsToCall);
        Service serviceFrom2 = new Service(2, "Harkov", paramsToCall);
        Service serviceFrom3 = new Service(3, "Lipezk", paramsToCall);
        Service serviceFrom4 = new Service(4, "SNBO", paramsToCall);

        paramsToCall.add("paramToCall1");
        paramsToCall.add("paramToCall2");
        paramsToCall.add("paramToCall3");
        paramsToCall.add("paramToCall4");

        Service serviceTo = new Service(5, "Yagotin", paramsToCall);
        Service serviceTo2 = new Service(6, "Kyiv", paramsToCall);
        Service serviceTo3 = new Service(7, "Paris", paramsToCall);
        Service serviceTo4 = new Service(8, "Moskow", paramsToCall);

        Map paramsServiceFrom = new HashMap();
        Map paramsServiceTo = new HashMap();

        Map paramsServiceFrom2 = new HashMap();
        Map paramsServiceTo2 = new HashMap();

        Map paramsServiceFrom3 = new HashMap();
        Map paramsServiceTo3 = new HashMap();

        Map paramsServiceFrom4 = new HashMap();
        Map paramsServiceTo4 = new HashMap();

        paramsServiceFrom.put(1, serviceFrom);
        paramsServiceTo.put(1, serviceTo);

        paramsServiceFrom.put(2, serviceFrom2);
        paramsServiceTo.put(2, serviceTo2);

        paramsServiceFrom.put(3, serviceFrom3);
        paramsServiceTo.put(3, serviceTo3);

        paramsServiceFrom.put(4, serviceFrom4);
        paramsServiceTo.put(4, serviceTo4);

        step1.setServiceFrom(serviceFrom);
        step1.setServiceTo(serviceTo);
        step1.setParamsServiceFrom(paramsServiceFrom);
        step1.setParamsServiceTo(paramsServiceTo);

        step2.setServiceFrom(serviceFrom2);
        step2.setServiceTo(serviceTo2);
        step2.setParamsServiceFrom(paramsServiceFrom2);
        step2.setParamsServiceTo(paramsServiceTo2);

        step3.setServiceFrom(serviceFrom3);
        step3.setServiceTo(serviceTo3);
        step3.setParamsServiceFrom(paramsServiceFrom3);
        step3.setParamsServiceTo(paramsServiceTo3);

        step4.setServiceFrom(serviceFrom4);
        step4.setServiceTo(serviceTo4);
        step4.setParamsServiceFrom(paramsServiceFrom4);
        step4.setParamsServiceTo(paramsServiceTo4);

        steps.add(step1);
        steps.add(step2);
        steps.add(step3);
        steps.add(step4);

        step = step1;
        service = serviceFrom;
        System.out.println("init complete");
    }


    @RequestMapping(value = "/callByBean", method = RequestMethod.GET, produces = "text/plain")
    public @ResponseBody
    String callByBean() {
        System.out.println("Call by bean ");
        initRandomValues();
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println(route.getId());
        System.out.println(route.getSteps().toString());
        System.out.println("~~~~~~~~~~~~~~~~~");

        System.out.println(service.getId());
        System.out.println(service.getName());
        System.out.println(service.getParamsToCall());
        System.out.println("~~~~~~~~~~~~~~~~~~");

        System.out.println(step.getId());
        System.out.println(step.getServiceFrom());
        System.out.println(step.getServiceTo());
        System.out.println(step.getParamsServiceFrom());
        System.out.println(step.getParamsServiceTo());

        return "Ok";
    }
}
