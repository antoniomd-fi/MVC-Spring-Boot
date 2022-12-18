package com.bedu.jmsconsumer.controller;

import com.bedu.jmsconsumer.model.Persona;
import com.bedu.jmsconsumer.service.ConsumerService;
import com.bedu.jmsconsumer.util.PdfGenerator;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/listaPersonas/download")
    public void downloadFile(HttpServletResponse response) throws DocumentException, IOException {

        List<Persona> list = consumerService.getPersonaList();

        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);


        PdfGenerator exporter = new PdfGenerator(list);
        exporter.export(response);

    }
}
