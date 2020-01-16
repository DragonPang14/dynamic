package space.dynamicprogram.dynamic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import space.dynamicprogram.test.DynamicTest;

import java.util.ArrayList;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/knapSack")
    public @ResponseBody ResultDto calKnapSack(@RequestBody KnapSackDto knapSackDto){
        System.out.println(knapSackDto.toString());
        String[] vlist = knapSackDto.getVlist().split(",");
        String[] wlist = knapSackDto.getWlist().split(",");
        ArrayList<Integer> vArray = new ArrayList<>();
        ArrayList<Integer> wArray = new ArrayList<>();
        vArray.add(0);
        wArray.add(0);

        for (String s : vlist) {
            vArray.add(Integer.parseInt(s));
        }
        for (String s : wlist) {
            wArray.add(Integer.parseInt(s));
        }
        Solution solution = new Solution();
        solution.setVl(vArray);
        solution.setWl(wArray);
        int num = DynamicTest.knapsack(solution,knapSackDto.getCap() + 1);
        ResultDto resultDto = new ResultDto();
        resultDto.setFlag(true);
        resultDto.setResultNum(num);
        return resultDto;
    }
}
