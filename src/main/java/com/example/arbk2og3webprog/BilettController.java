package com.example.arbk2og3webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BilettController {

    @Autowired
    BilettRepository rep;

    @GetMapping("/hentBiletter")
    public List<Bilett> hentBiletter(){
        return rep.hentAlleBiletter();
    }

    @PostMapping("/lagreBilett")
    public void lagreEnBilett(Bilett bilett){
        rep.lagreBilett(bilett);
    }

    @GetMapping("/slettBilett")
    public void slettEnBilett(int id){
        rep.slettBilett(id);
    }
    @GetMapping("/slettAlleBiletter")
    public void slettAlleBiletterCon(){
        rep.slettAlleBiletter();
    }
}
