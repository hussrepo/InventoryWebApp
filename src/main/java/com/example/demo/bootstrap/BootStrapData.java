package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean onStartEmptyInv = outsourcedPartRepository.count() == 0 && productRepository.count() == 0;

        if(onStartEmptyInv) {
            //Add CPU
            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setCompanyName("WGU");
            cpu.setName("AMD CPU");
            cpu.setInv(5);
            cpu.setMin(1);
            cpu.setMax(100);
            cpu.setPrice(300.0);
            cpu.setId(101L);
            outsourcedPartRepository.save(cpu);
            //Add Motherboard
            OutsourcedPart motherboard = new OutsourcedPart();
            motherboard.setCompanyName("WGU");
            motherboard.setName("ASUS Motherboard");
            motherboard.setInv(5);
            motherboard.setMin(1);
            motherboard.setMax(100);
            motherboard.setPrice(300.0);
            motherboard.setId(102L);
            outsourcedPartRepository.save(motherboard);
            //Add RAM
            OutsourcedPart ram = new OutsourcedPart();
            ram.setCompanyName("WGU");
            ram.setName("HyperX 2x16GB RAM");
            ram.setInv(5);
            ram.setMin(1);
            ram.setMax(100);
            ram.setPrice(200.0);
            ram.setId(103L);
            outsourcedPartRepository.save(ram);
            //Add GPU
            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setCompanyName("WGU");
            gpu.setName("NVIDIA RTX 3060ti GPU");
            gpu.setInv(5);
            gpu.setMin(1);
            gpu.setMax(100);
            gpu.setPrice(700.0);
            gpu.setId(104L);
            outsourcedPartRepository.save(gpu);
            //Add PSU
            OutsourcedPart psu = new OutsourcedPart();
            psu.setCompanyName("WGU");
            psu.setName("EVGA 1000w PSU");
            psu.setInv(5);
            psu.setMin(1);
            psu.setMax(100);
            psu.setPrice(200.0);
            psu.setId(105L);
            outsourcedPartRepository.save(psu);
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if(onStartEmptyInv) {
            Product tier1 = new Product("Tier 1 Desktop DIY Kit", 500.0, 5);
            Product tier2 = new Product("Tier 2 Desktop DIY Kit",600.0,5);
            Product tier3 = new Product("Tier 3 Desktop DIY Kit",800.0,5);
            Product tier4 = new Product("Tier 4 Desktop DIY Kit",1500.0,5);
            Product tier5 = new Product("Tier 5 Desktop DIY Kit",1700.0,5);
            productRepository.save(tier1);
            productRepository.save(tier2);
            productRepository.save(tier3);
            productRepository.save(tier4);
            productRepository.save(tier5);
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
