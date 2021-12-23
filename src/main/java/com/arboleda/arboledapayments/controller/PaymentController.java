package com.arboleda.arboledapayments.controller;

import com.arboleda.arboledapayments.dto.CreatePaymentDto;
import com.arboleda.arboledapayments.dto.ListCompaniesDto;
import com.arboleda.arboledapayments.dto.ListPendingPaymentsDto;
import com.arboleda.arboledapayments.dto.ListServicesDto;
import com.arboleda.arboledapayments.model.Company;
import com.arboleda.arboledapayments.model.Payment;
import com.arboleda.arboledapayments.model.PendingPayment;
import com.arboleda.arboledapayments.model.Service;
import com.arboleda.arboledapayments.service.PaymentService;
import com.arboleda.arboledapayments.service.PendingPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping//("/payments")
public class PaymentController {
    @Autowired
    private PendingPaymentService pendingPaymentService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public @ResponseBody List<Company> getCompanies(@Valid ListCompaniesDto listCompaniesDto) {
        return pendingPaymentService.listCompanies(listCompaniesDto);
    }

    @RequestMapping(value = "/companies/{companyId}/services", method = RequestMethod.GET)
    public @ResponseBody List<Service> getServices(@Valid ListServicesDto listServicesDto) {
        return pendingPaymentService.listServices(listServicesDto);
    }

    @RequestMapping(value = "/services/{serviceId}/pending-payments", method = RequestMethod.GET)
    public @ResponseBody List<PendingPayment> getPendingPayments(@Valid ListPendingPaymentsDto listPendingPaymentsDto) {
        return pendingPaymentService.listPendingPayments(listPendingPaymentsDto);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST, headers = "Content-type=application/json")
    public @ResponseBody Payment pay(@RequestBody CreatePaymentDto createPaymentDto) throws Exception {
        return paymentService.createPayment(createPaymentDto);
    }

}
