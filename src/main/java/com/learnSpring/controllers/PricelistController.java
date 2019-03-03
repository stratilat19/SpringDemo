package com.learnSpring.controllers;

import com.learnSpring.db.entities.Pricelist;
import com.learnSpring.db.repositories.PricelistRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@Log4j2
public class PricelistController {

    @Autowired
    PricelistRepository pricelistRepository;

    @GetMapping("/pricelist")
    public String list(@RequestParam(name="id", required=false, defaultValue="") String id,
                       Model model) throws IOException {
        log.error("id="+id);
        Optional<Pricelist> goods;
        if (id.isEmpty()){
            goods = Optional.empty();
        }
        else{
            goods = pricelistRepository.findById(Integer.valueOf(id));
        }
        model.addAttribute("goods", goods);// object 'goods' is used by pricelist.html
        model.addAttribute("pricelist", pricelistRepository.findAll());// object 'pricelist' is used by pricelist.html

        return "pricelist";
    }

    @PostMapping("/pricelist")
    public String add(@RequestParam String pricelistId,
                      @RequestParam String name,
                      @RequestParam String description,
                      @RequestParam String price,
                      @RequestParam MultipartFile file){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Pricelist pricelist;
            if (pricelistId==null || pricelistId.isEmpty()){
                pricelist = new Pricelist();
            }
            else {
                Optional<Pricelist> goods = pricelistRepository.findById(Integer.valueOf(pricelistId));
                pricelist = goods.get();
            }

            pricelist.setName(name);
            pricelist.setDescription(description);

            if (price.isEmpty()){
                pricelist.setPrice(0);
            }
            else{
                pricelist.setPrice(Integer.valueOf(price));
            }

            if (!fileName.isEmpty()){
                // Check if the file's name contains invalid characters
                if(fileName.contains("..")) {
                    throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                pricelist.setFileName(fileName);
                pricelist.setFileType(file.getContentType());
                pricelist.setFile(file.getBytes());
            }

            pricelistRepository.save(pricelist);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }

        return "redirect:/pricelist";
    }

//    @DeleteMapping("/pricelist/{id}")// RESTful web service
    @GetMapping("/pricelist/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pricelistRepository.deleteById(id);
        return "redirect:/pricelist";
    }

}
