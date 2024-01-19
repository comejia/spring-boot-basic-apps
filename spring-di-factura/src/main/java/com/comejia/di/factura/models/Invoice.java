package com.comejia.di.factura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Getter
@Setter
@Component
//@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;
    @Autowired
//    @Qualifier("invoiceOfficeItems")
    private List<Item> items;

    public Integer getTotal() {
        return items.stream()
                .mapToInt(Item::getImporte)
                .sum();
    }

    @PostConstruct
    public void init() { // Se ejecuta despues del new del objeto
        System.out.println("CREANDO el componente de la factura");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente o bean invoice");
    }
}
