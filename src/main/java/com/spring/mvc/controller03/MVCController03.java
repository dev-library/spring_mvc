package com.spring.mvc.controller03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {

    // 폼으로 넘겨주는 메서드
    @RequestMapping(value="/foodform", method= RequestMethod.GET)
    public String foodForm(){
        return "chap03/foodform";
    }

    // 폼에서 날려준 데이터를 view단으로 보내주는 메서드
    @RequestMapping(value="/foodorder", method=RequestMethod.POST)
    public ModelAndView foodOrder(String customerName,
                                  int tableNumber,
                                  String orderFoodName){
        // ModelAndView 객체 준비
         ModelAndView mv = new ModelAndView();
        // 데이터 적재
        mv.addObject("customerName", customerName);
        mv.addObject("tableNumber", tableNumber);
        mv.addObject("orderFoodName", orderFoodName);
        // 결과 view 파일 지정
        mv.setViewName("chap03/foodresult");

        return mv;
    }

}
