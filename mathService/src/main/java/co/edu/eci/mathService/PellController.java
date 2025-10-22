package co.edu.eci.mathService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorge.gamboa-s
 */
@RestController
public class PellController {

    @GetMapping("/pell")
    public Map<String, Object> pellService(@RequestParam int value) {

        
        Map<String, Object> res = new LinkedHashMap<>();

        res.put("opetarion", "Secuencia de Pell");
        res.put("input", value);
        res.put("output", pellseq(value));

        return res;
    }

    private List<Integer> pellseq(int value) {
        List<Integer> sec = new ArrayList<>();
        
        for(int i = 0; i<=value; i++){
            sec.add(pellNumber(i));
        }
        return sec;
    }

    private int pellNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return 2*pellNumber(n-1)+pellNumber(n-2);
        
    }

}
    